
package ch.hearc.orlac.leapmotion;

import java.util.ArrayList;
import java.util.List;

import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Gesture.State;
import com.leapmotion.leap.Gesture.Type;
import com.leapmotion.leap.GestureList;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Vector;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.network.CommunicationWithPureData;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.tools.Tools;
import ch.hearc.orlac.transitionmachine.ApplicationStateEnum;
import ch.hearc.orlac.transitionmachine.TransitionMachine;
import ch.hearc.orlac.view.jframe.JFrameApplication;

/**
 * Recognizes the hand patterns and the gestures.
 * @author chavailm
 */
public class GestureAnalysis
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public GestureAnalysis()
		{
		this.isPureDataConnected = false;
		this.isLeapMotionConnected = false;
		this.isHandDetected = false;

		this.handListWithFingers = new ArrayList<Hand>();

		this.velocityCurrent = 0.0;
		this.numberOfHand = 0;

		this.allColorAreaVectorA = new Vector();
		this.allColorAreaVectorB = new Vector();
		this.redAreaVectorA = new Vector();
		this.redAreaVectorB = new Vector();
		this.greenAreaVectorA = new Vector();
		this.greenAreaVectorB = new Vector();
		this.blueAreaVectorA = new Vector();
		this.blueAreaVectorB = new Vector();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Start sending messages OSC to Pure Data.
	 */
	public void playMovie()
		{
		if (isPureDataConnected && isLeapMotionConnected)
			{
			this.transitionMachine.startTransitionMachine();
			this.communicationWithPureData.startSendingMessages();
			}
		}

	/**
	 * Connects to Pure Data and updates the JFrameApplication with the state of the connection.
	 * @param _ipAddressPureData
	 * @param _portNumberPureDataAudio
	 * @param _portNumberPureDataVideo
	 */
	public void connectToPureData(String _ipAddressPureData, int _portNumberPureDataAudio, int _portNumberPureDataVideo)
		{
		this.isPureDataConnected = this.communicationWithPureData.connectToPureData(_ipAddressPureData, _portNumberPureDataAudio, _portNumberPureDataVideo);
		this.jFrameApplication.updateJPanelApplicaitonStatePureData(this.isPureDataConnected);
		this.jFrameApplication.enableBtnPlayMovie(this.isPureDataConnected, this.isLeapMotionConnected);
		}

	/**
	 * Updates the JFrameApplication with the connection state of the Leap Motion.
	 * @param _isLeapMotionConnected
	 */
	public void setLeapMotionConnected(boolean _isLeapMotionConnected)
		{
		this.isLeapMotionConnected = _isLeapMotionConnected;

		this.jFrameApplication.updateJPanelApplicaitonStateLeapMotion(this.isLeapMotionConnected);
		this.jFrameApplication.enableBtnPlayMovie(this.isPureDataConnected, this.isLeapMotionConnected);

		this.transitionMachine.setHandDetected(_isLeapMotionConnected);
		}

	/**
	 * Removes the Leap Motion listener and free ressources.
	 */
	public void removeLeapMotionListener()
		{
		if (this.isLeapMotionConnected)
			{
			this.controller.removeListener(leapMotionListener);
			}

		}

	/**
	 * Closes the connection with Pure Data and free ressources.
	 */
	public void closeConnectionWithPureData()
		{
		if (this.isPureDataConnected)
			{
			this.communicationWithPureData.closePureDataConnection();
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the attribute handList.
	 * @param _handList list of hands detected
	 */
	public void setHandList(HandList _handList)
		{
		this.handList = _handList;
		computeHandListWithFingers();
		computeVelocity();
		updateTransitionMachine();
		computeGestureWithHands();
		}

	/**
	 * Sets the attribute gestureList.
	 * @param _gestureList list of gesture detected
	 */
	public void setGestureList(GestureList _gestureList)
		{
		this.gestureList = _gestureList;
		computeGestureSpeed();
		}

	/**
	 * Sets the attribute leapMotionListener.
	 * @param _leapMotionListener
	 */
	public void setLeapMotionListener(LeapMotionListener _leapMotionListener)
		{
		this.leapMotionListener = _leapMotionListener;
		this.controller = new Controller();
		this.controller.addListener(leapMotionListener);
		}

	/**
	 * Sets the attribute communicationWithPureData.
	 * @param _communicationWithPureData
	 */
	public void setCommunicationWithPureData(CommunicationWithPureData _communicationWithPureData)
		{
		this.communicationWithPureData = _communicationWithPureData;
		}

	/**
	 * Sets the attribute jFrameApplication.
	 * @param _jFrameApplication
	 */
	public void setJFrameApplication(JFrameApplication _jFrameApplication)
		{
		this.jFrameApplication = _jFrameApplication;
		}

	/**
	 * Sets the attribute dataEffectCurrent.
	 * @param _dataEffectCurrent
	 */
	public void setDataEffect(DataEffectCurrent _dataEffectCurrent)
		{
		this.dataEffectCurrent = _dataEffectCurrent;
		}

	/**
	 * Sets the attribute transitionMachine.
	 * @param _transitionMachine
	 */
	public void setTransitionMachine(TransitionMachine _transitionMachine)
		{
		this.transitionMachine = _transitionMachine;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Computes the current gesture using the attribute gestureList.
	 */
	private void computeGestureSpeed()
		{
		// Check if the transition state is STATE_USER_DECRYPTED to allow the user to change speed
		if (this.transitionMachine.getCurrentState() == ApplicationStateEnum.STATE_USER_DECRYPTED)
			{
			// Take the first gesture detected.
			Gesture gesture = this.gestureList.get(0);

			// If the gesture is a circle.
			if (gesture.type() == Type.TYPE_CIRCLE)
				{
				CircleGesture circleCurrent = new CircleGesture(gesture);

				if (circleCurrent.state() == State.STATE_UPDATE)
					{
					// Take the same circle detected in the stage 20 frames later.
					CircleGesture circlePrevious = new CircleGesture(controller.frame(20).gesture(circleCurrent.id()));

					// Computes the angle between the current circle position and the previous circle.
					double angle = Tools.computeAngleDegreesSweptBetweenCircles(circlePrevious, circleCurrent);
					double radius = circleCurrent.radius();
					double arcLength = Tools.computeArcLength(angle, radius);

					if (Tools.isCircleGestureClockwiseDirection(circleCurrent))
						{
						this.dataEffectCurrent.addArcLength(arcLength);
						}
					else
						{
						this.dataEffectCurrent.subArcLength(arcLength);
						}
					}
				}
			}
		}

	/**
	 * Computes the current gesture using the attribute handList.
	 */
	private void computeGestureWithHands()
		{
		int nbFinger = Tools.computeTotalFinger(this.handListWithFingers);

		// Check if the transition state is STATE_USER_DECRYPTED to allow the user to change the colors
		if (this.transitionMachine.getCurrentState() == ApplicationStateEnum.STATE_USER_DECRYPTED)
			{
			switch(this.numberOfHand)
				{
				// Case without hand detected
				case 0:
					// Nothing to do.
					break;

				// Case with one hand detected --> action update RGB Area.
				case 1:
					if (nbFinger >= 3)
						{
						updateAxisMinMax();
						updateColorAreaPosition();
						updateColorHandInColoredArea();
						updateRotationHand();
						}
					break;

				// Case with two hands detected --> action encrypt
				case 2:
					if (nbFinger >= 6)
						{
						computeDistanceBetweenHands();
						}
					break;
				default:
					break;
				}
			}
		}

	/**
	 * Updates the rotation roll and pitch attributes using the palm position.
	 */
	private void updateRotationHand()
		{
		this.rollAngleDegree = Tools.convertRadianToDegree(this.handOne.palmNormal().roll());
		this.pitchAngleDegree = Tools.convertRadianToDegree(this.handOne.palmNormal().pitch());

		this.rollAngleDegree = Tools.convertNumberInRangeABToRangeCD(Settings.ROLL_CAPTURED_MIN, Settings.ROLL_CAPTURED_MAX, Settings.ROLL_PURE_DATA_MIN, Settings.ROLL_PURE_DATA_MAX, this.rollAngleDegree);
		this.pitchAngleDegree = Tools.convertNumberInRangeABToRangeCD(Settings.PITCH_CAPTURED_MIN, Settings.PITCH_CAPTURED_MAX, Settings.PITCH_PURE_DATA_MIN, Settings.PITCH_PURE_DATA_MAX, this.pitchAngleDegree);

		this.dataEffectCurrent.setRollValue(this.rollAngleDegree);
		this.dataEffectCurrent.setPitchValue(this.pitchAngleDegree);
		}

	/**
	 * Updates the color of the movie in function of the position of the palm.
	 */
	private void updateColorHandInColoredArea()
		{
		this.currentHandPositionVector = this.handOne.palmPosition();

		isHandInRedArea();
		isHandInGreenArea();
		isHandInBlueArea();

		// Updates the color values if the hand is in a certain area.
		if (isHandInAllColorArea())
			{
			this.dataEffectCurrent.setRedValue(1.0);
			this.dataEffectCurrent.setGreenValue(1.0);
			this.dataEffectCurrent.setBlueValue(1.0);
			}
		else if (isHandInRedArea())
			{
			this.dataEffectCurrent.setRedValue(1.0);
			this.dataEffectCurrent.setGreenValue(0.2);
			this.dataEffectCurrent.setBlueValue(0.2);
			}
		else if (isHandInGreenArea())
			{
			this.dataEffectCurrent.setRedValue(0.2);
			this.dataEffectCurrent.setGreenValue(1.0);
			this.dataEffectCurrent.setBlueValue(0.2);
			}
		else if (isHandInBlueArea())
			{
			this.dataEffectCurrent.setRedValue(0.5);
			this.dataEffectCurrent.setGreenValue(0.5);
			this.dataEffectCurrent.setBlueValue(1.0);
			}
		}

	/**
	 * Fills the attribute handListWithFingers with all detected hands having fingers.
	 */
	private void computeHandListWithFingers()
		{
		this.handListWithFingers.clear();

		for(int i = 0; i < this.handList.count(); i++)
			{
			Hand currentHand = this.handList.get(i);
			int nbFingers = currentHand.fingers().count();

			// If the hand detected has more than two fingers --> I consider that is a valid hand
			if (nbFingers >= 3)
				{
				this.handListWithFingers.add(currentHand);
				}
			}

		this.numberOfHand = this.handListWithFingers.size();

		if (this.numberOfHand == 0)
			{
			this.isHandDetected = false;
			}
		else if (this.numberOfHand == 1)
			{
			this.isHandDetected = true;
			this.handOne = this.handListWithFingers.get(0);
			}
		else if (this.numberOfHand == 2)
			{
			this.isHandDetected = true;
			this.handOne = this.handListWithFingers.get(0);
			this.handTwo = this.handListWithFingers.get(1);
			}
		}

	/**
	 * Computes the velocity of the hands contained handListWithFingers. </br>
	 * For each hand, computes the velocity of each finger.</br>
	 * The velocity of the fingers is the rate of change in millimeters / second.
	 */
	private void computeVelocity()
		{
		double xVelocity = 0.0;
		double yVelocity = 0.0;
		double zVelocity = 0.0;

		for(Hand h:this.handListWithFingers)
			{
			for(Finger f:h.fingers())
				{
				xVelocity += Math.abs(f.tipVelocity().getX());
				yVelocity += Math.abs(f.tipVelocity().getY());
				zVelocity += Math.abs(f.tipVelocity().getZ());
				}
			}

		this.velocityCurrent = xVelocity + yVelocity + zVelocity;
		}

	/**
	 * Computes the distance between the two hands detected.
	 */
	private void computeDistanceBetweenHands()
		{
		if (this.numberOfHand == 2)
			{
			this.distanceBetweenHands = this.handOne.palmPosition().distanceTo(this.handTwo.palmPosition());
			double newValue = Tools.convertNumberInRangeABToRangeCD(Settings.DISTANCE_CAPTURED_MIN, Settings.DISTANCE_CAPTURED_MAX, Settings.DISTANCE_MIN, Settings.DISTANCE_MAX, this.distanceBetweenHands);
			this.dataEffectCurrent.setDistanceValue(newValue);
			}
		}

	/**
	 * Notify the transition machine to know if the Leap Motion has detected hands and the velocity of hands.
	 */
	private void updateTransitionMachine()
		{
		this.transitionMachine.updateIsHandDetected(this.isHandDetected, this.velocityCurrent);
		}

	/**
	 * Updates the min and max value for the axes X and Z in function of the palm position in Y.
	 * Necessary because the detection area of the LeapMotion is an truncated inverted pyramid.
	 */
	private void updateAxisMinMax()
		{
		// Get the first hand with fingers detected.
		this.handOne = this.handList.get(0);
		this.yPalmCurrent = this.handOne.palmPosition().getY();

		this.xAxisMax = Tools.computeNewXAxisMax(this.yPalmCurrent);
		this.xAxisMin = (-1) * this.xAxisMax;

		this.zAxisMax = Tools.computeNewZAxisMax(this.yPalmCurrent);
		this.zAxisMin = (-1) * this.zAxisMax;
		}

	/**
	 * Updates the position (x,y,z) of the attributes redAreaVector, greenAreaVector and blueAreaVector in function of the Y current position of the hand.
	 */
	private void updateColorAreaPosition()
		{
		double offsetX = (Math.abs(this.xAxisMin) + Math.abs(this.xAxisMax)) / 3.0;
		double offsetZ = (Math.abs(this.zAxisMin) + Math.abs(this.zAxisMax)) / 2.0;

		// Red area.
		this.redAreaVectorA.setX(new Float(this.xAxisMin));
		this.redAreaVectorA.setY(new Float(this.yPalmCurrent));
		this.redAreaVectorA.setZ(new Float(this.zAxisMin));

		this.redAreaVectorB.setX(new Float(this.xAxisMin + offsetX));
		this.redAreaVectorB.setY(new Float(this.yPalmCurrent));
		this.redAreaVectorB.setZ(new Float(this.zAxisMax));

		// Green area.
		this.greenAreaVectorA.setX(new Float(this.xAxisMin + offsetX));
		this.greenAreaVectorA.setY(new Float(this.yPalmCurrent));
		this.greenAreaVectorA.setZ(new Float(this.zAxisMin));

		this.greenAreaVectorB.setX(new Float(this.xAxisMax - offsetX));
		this.greenAreaVectorB.setY(new Float(this.yPalmCurrent));
		this.greenAreaVectorB.setZ(new Float(this.zAxisMin + offsetZ));

		// Blue area.
		this.blueAreaVectorA.setX(new Float(this.xAxisMax - offsetX));
		this.blueAreaVectorA.setY(new Float(this.yPalmCurrent));
		this.blueAreaVectorA.setZ(new Float(this.zAxisMin));

		this.blueAreaVectorB.setX(new Float(this.xAxisMax));
		this.blueAreaVectorB.setY(new Float(this.yPalmCurrent));
		this.blueAreaVectorB.setZ(new Float(this.zAxisMax));

		// All color area.
		this.allColorAreaVectorA.setX(new Float(this.xAxisMin + offsetX));
		this.allColorAreaVectorA.setY(new Float(this.yPalmCurrent));
		this.allColorAreaVectorA.setZ(new Float(this.zAxisMin + offsetZ));

		this.allColorAreaVectorB.setX(new Float(this.xAxisMax - offsetX));
		this.allColorAreaVectorB.setY(new Float(this.yPalmCurrent));
		this.allColorAreaVectorB.setZ(new Float(this.zAxisMax));
		}

	/**
	 * Computes if the hand is in the all colors area.
	 * @return is the hand contained in the all color area
	 */
	private boolean isHandInAllColorArea()
		{
		return isVectorGreaterThan(this.currentHandPositionVector, this.allColorAreaVectorA) && isVectorLowerThan(this.currentHandPositionVector, this.allColorAreaVectorB);
		}

	/**
	 * Computes if the hand is in the blue area.
	 * @return is the hand contained in the blue area
	 */
	private boolean isHandInBlueArea()
		{
		return isVectorGreaterThan(this.currentHandPositionVector, this.blueAreaVectorA) && isVectorLowerThan(this.currentHandPositionVector, this.blueAreaVectorB);
		}

	/**
	 * Computes if the hand is in the green area.
	 * @return is the hand contained in the green area
	 */
	private boolean isHandInGreenArea()
		{
		return isVectorGreaterThan(this.currentHandPositionVector, this.greenAreaVectorA) && isVectorLowerThan(this.currentHandPositionVector, this.greenAreaVectorB);
		}

	/**
	 * Computes if the hand is in the red area.
	 * @return is the hand contained in the red area
	 */
	private boolean isHandInRedArea()
		{
		return isVectorGreaterThan(this.currentHandPositionVector, this.redAreaVectorA) && isVectorLowerThan(this.currentHandPositionVector, this.redAreaVectorB);
		}

	/**
	 * Computes if the vector1 (x,z) is greater or equal than vector2 (x,z).
	 * @param _vector1
	 * @param _vector2
	 * @return vector1 >= vector2
	 */
	private boolean isVectorGreaterThan(Vector _vector1, Vector _vector2)
		{
		return _vector1.getX() >= _vector2.getX() && _vector1.getZ() >= _vector2.getZ();
		}

	/**
	 * Computes if the vector1 (x,z) is lower or equal than vector2 (x,z).
	 * @param _vector1
	 * @param _vector2
	 * @return vector1 <= vector2
	 */
	private boolean isVectorLowerThan(Vector _vector1, Vector _vector2)
		{
		return _vector1.getX() <= _vector2.getX() && _vector1.getZ() <= _vector2.getZ();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private LeapMotionListener leapMotionListener;

	private Controller controller;
	private DataEffectCurrent dataEffectCurrent;

	private HandList handList;
	private GestureList gestureList;

	private CommunicationWithPureData communicationWithPureData;

	private JFrameApplication jFrameApplication;

	private TransitionMachine transitionMachine;

	//Outputs
	private boolean isHandDetected;

	private double velocityCurrent;
	private double distanceBetweenHands;
	private double pitchAngleDegree;
	private double rollAngleDegree;

	//Tools
	private List<Hand> handListWithFingers;

	private Hand handOne;
	private Hand handTwo;

	private Vector currentHandPositionVector;
	private Vector allColorAreaVectorA;
	private Vector allColorAreaVectorB;
	private Vector redAreaVectorA;
	private Vector redAreaVectorB;
	private Vector greenAreaVectorA;
	private Vector greenAreaVectorB;
	private Vector blueAreaVectorA;
	private Vector blueAreaVectorB;

	private boolean isPureDataConnected;
	private boolean isLeapMotionConnected;

	private int numberOfHand;

	private double xAxisMin;
	private double xAxisMax;
	private double zAxisMin;
	private double zAxisMax;

	private double yPalmCurrent;
	}
