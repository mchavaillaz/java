
package ch.hearc.orlac.leapmotion;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.GestureList;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Listener;

/**
 * Listener for the Leap Motion device.
 * @author chavailm
 */
public class LeapMotionListener extends Listener
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public LeapMotionListener()
		{
		// Nothing to do
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void onInit(Controller controller)
		{
		System.out.println("Initialized");
		}

	@Override
	public void onConnect(Controller controller)
		{
		System.out.println("Connected");

		// Enable the circle gesture detection
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		this.gestureAnalysis.setLeapMotionConnected(true);
		}

	@Override
	public void onDisconnect(Controller controller)
		{
		System.out.println("Disconnected");

		this.gestureAnalysis.setLeapMotionConnected(false);
		}

	@Override
	public void onExit(Controller controller)
		{
		System.out.println("Exited");

		this.gestureAnalysis.setLeapMotionConnected(false);
		}

	@Override
	public void onFrame(Controller controller)
		{
		Frame frame = controller.frame();

		this.handList = frame.hands();
		this.gestureList = frame.gestures();

		if (!gestureList.empty())
			{
			this.gestureAnalysis.setGestureList(this.gestureList);
			}
		else if (!handList.empty())
			{
			this.gestureAnalysis.setHandList(this.handList);
			}

		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the attribute gestureAnalysis.
	 * @param _gestureAnalysis
	 */
	public void setGestureAnalysis(GestureAnalysis _gestureAnalysis)
		{
		this.gestureAnalysis = _gestureAnalysis;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Input
	private GestureAnalysis gestureAnalysis;

	//Tools
	private HandList handList;
	private GestureList gestureList;
	}
