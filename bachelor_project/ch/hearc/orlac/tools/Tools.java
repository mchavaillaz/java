
package ch.hearc.orlac.tools;

import java.util.List;

import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Hand;

/**
 * Static class with usefull Math tools
 * @author chavailm
 */
public class Tools
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Converts a number in range [a,b] in range [a',b'].
	 * @param _oldBoundaryA old boundary min
	 * @param _oldBoundaryB old boundary max
	 * @param _newBoundaryA new boundary min
	 * @param _newBoundaryB new boundary max
	 * @param _x value to convert
	 * @return double newValue
	 */
	static public double convertNumberInRangeABToRangeCD(double _oldBoundaryA, double _oldBoundaryB, double _newBoundaryA, double _newBoundaryB, double _x)
		{
		double newValue;

		if (_x <= _oldBoundaryA)
			{
			newValue = _newBoundaryA;
			}
		else if (_x >= _oldBoundaryB)
			{
			newValue = _newBoundaryB;
			}
		else
			{
			double scale = (_newBoundaryB - _newBoundaryA) / (_oldBoundaryB - _oldBoundaryA);
			newValue = _newBoundaryA + ((_x - _oldBoundaryA) * scale);
			}

		return newValue;
		}

	/**
	 * Computes the new max value for the axis X.
	 * @param _yPalmPos the current palm position on Y axis
	 * @return new X axis max value
	 */
	public static double computeNewXAxisMax(double _yPalmPos)
		{
		return (_yPalmPos - Settings.H_X_AXIS) / Settings.M_X_AXIS;
		}

	/**
	 * Computes the new max value for the axis Z.
	 * @param _yPalmPos the current palm position on Y axis
	 * @return new Z axis max value
	 */
	public static double computeNewZAxisMax(double _yPalmPos)
		{
		return (_yPalmPos - Settings.H_Z_AXIS) / Settings.M_Z_AXIS;
		}

	/**
	 * Counts the total of finger detected in a HandList.
	 * @return totalFinger
	 */
	public static int computeTotalFinger(List<Hand> handListWithFingers)
		{
		int totalFinger = 0;

		for(Hand h:handListWithFingers)
			{
			totalFinger += h.fingers().count();
			}

		return totalFinger;
		}

	/**
	 * Computes the swept angle in degrees between two circles.
	 * @param _circlePrevious circle in the last frame
	 * @param _circleCurrent circle in the current frame
	 * @return angle swept between two two circles in degrees
	 */
	public static double computeAngleDegreesSweptBetweenCircles(CircleGesture _circlePrevious, CircleGesture _circleCurrent)
		{
		return (_circleCurrent.progress() - _circlePrevious.progress()) * 2 * Math.PI;
		}

	/**
	 * Computes the arc length with a specific angle and radius.
	 * @param _angle in degrees
	 * @param _radius in mm
	 * @return arc length in mm
	 */
	public static double computeArcLength(double _angle, double _radius)
		{
		return (_angle * Math.PI * _radius) / 180.0;
		}

	/**
	 * Converts a radian value to degree value.
	 * @param _radian
	 * @return degreeValue
	 */
	public static double convertRadianToDegree(double _radian)
		{
		return (_radian * 180.0) / Math.PI;
		}

	/*------------------------------*\
	|*				Is Method		*|
	\*------------------------------*/
	/**
	 * Returns if the CircleGesture direction is clockwise or counterclockwise.</br>
	 * Computes the rotation direction (clockwise or counterclockwise) using the angle between circle normal vector and the pointable(finger performing the circle gesture) vector.</br>
	 * If the angle between these two vectors is <= Pi/4 --> clockwise </br>
	 * Else --> counterclockwise </br>
	 * @param _circle
	 * @return true = clockwise direction, false = counterclockwise direction
	 */
	public static boolean isCircleGestureClockwiseDirection(CircleGesture _circle)
		{
		return _circle.pointable().direction().angleTo(_circle.normal()) <= Math.PI / 4;
		}

	/**
	 * Checks if a String is numeric.
	 * @param _str String to check
	 * @return isDigit
	 */
	public static boolean isNumeric(String _str)
		{
		boolean isDigit = false;

		try
			{
			Integer.parseInt(_str);
			isDigit = true;
			}
		catch (NumberFormatException e)
			{
			isDigit = false;
			}

		return isDigit;
		}
	}
