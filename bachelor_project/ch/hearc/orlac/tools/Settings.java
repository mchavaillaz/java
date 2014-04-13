
package ch.hearc.orlac.tools;

/**
 * This class contains only static final settings values for all classes.
 * @author chavailm
 */
public class Settings
	{

	/*------------------------------------------------------------------*\
	|*						NoUser State Settings						*|
	\*------------------------------------------------------------------*/
	public static final int JSLIDER_NO_USER_COLOR_MIN = 0;
	public static final int JSLIDER_NO_USER_COLOR_MAX = 100;

	public static final int JSLIDER_NO_USER_RED_INIT = 25;
	public static final int JSLIDER_NO_USER_GREEN_INIT = 25;
	public static final int JSLIDER_NO_USER_BLUE_INIT = 25;

	public static final int JSLIDER_NO_USER_SPEED_INIT = 15;

	public static final int JSLIDER_NO_USER_ENCRYPT_INIT = 80;

	public static final double DISTANCE_NO_USER_INIT = 0.0;

	/**
	 * Gets the initial red value for the state NO_USER.
	 * @return redValue in range [0;1]
	 */
	public static double getNoUserRedInitValue()
		{
		return JSLIDER_NO_USER_RED_INIT / 100.0;
		}

	/**
	 * Gets the initial green value for the state NO_USER.
	 * @return greenValue in range [0;1]
	 */
	public static double getNoUserGreenInitValue()
		{
		return JSLIDER_NO_USER_GREEN_INIT / 100.0;
		}

	/**
	 * Gets the initial blue value for the state NO_USER.
	 * @return blueValue in range [0;1]
	 */
	public static double getNoUserBlueInitValue()
		{
		return JSLIDER_NO_USER_BLUE_INIT / 100.0;
		}

	/**
	 * Gets the initial encrypt value for the state NO_USER.
	 * @return encryptValue in range [0;1]
	 */
	public static double getNoUserEncryptInitValue()
		{
		return JSLIDER_NO_USER_ENCRYPT_INIT / 100.0;
		}

	/**
	 * Gets the initial speed for the state NO_USER.
	 * @return speedValue in range [Settings.SPEED_ARC_LENGTH_MIN;Settings.SPEED_ARC_LENGTH_MAX]
	 */
	public static double getNoUserSpeedInitValue()
		{
		computeSpeedArcLengthMinMax(JSPINNER_CIRCLE_RADIUS_VALUE_INIT, JSPINNER_CIRCLE_NUMBER_VALUE_INIT);
		return Tools.convertNumberInRangeABToRangeCD(JSLIDER_SPEED_MIN, JSLIDER_SPEED_MAX, SPEED_ARC_LENGTH_MIN, SPEED_ARC_LENGTH_MAX, JSLIDER_NO_USER_SPEED_INIT);
		}

	/*------------------------------------------------------------------*\
	|*						UserCrypted State Settings					*|
	\*------------------------------------------------------------------*/
	public static final int JSLIDER_USER_CRYPTED_COLOR_MIN = 0;
	public static final int JSLIDER_USER_CRYPTED_COLOR_MAX = 100;

	public static final int JSLIDER_USER_CRYPTED_RED_INIT = 50;
	public static final int JSLIDER_USER_CRYPTED_GREEN_INIT = 50;
	public static final int JSLIDER_USER_CRYPTED_BLUE_INIT = 50;

	public static final int JSLIDER_USER_CRYPTED_SPEED_INIT = 40;

	public static final int JSLIDER_USER_CRYPTED_ENCRYPT_INIT = 50;

	public static final double DISTANCE_USER_CRYPTED_INIT = 0.0;

	/**
	 * Gets the red value for the state USER_CRYPTED.
	 * @return redValue in range [0;1]
	 */
	public static double getUserCryptedRedInitValue()
		{
		return JSLIDER_USER_CRYPTED_RED_INIT / 100.0;
		}

	/**
	 * Gets the green value for the state USER_CRYPTED.
	 * @return greenValue in range [0;1]
	 */
	public static double getUserCryptedGreenInitValue()
		{
		return JSLIDER_USER_CRYPTED_GREEN_INIT / 100.0;
		}

	/**
	 * Gets the blue value for the state USER_CRYPTED.
	 * @return blueValue in range [0;1]
	 */
	public static double getUserCryptedBlueInitValue()
		{
		return JSLIDER_USER_CRYPTED_BLUE_INIT / 100.0;
		}

	/**
	 * Gets the encrypt value for the state USER_CRYPTED.
	 * @return encryptValue in range [0;1]
	 */
	public static double getUserCryptedEncryptInitValue()
		{
		return JSLIDER_USER_CRYPTED_ENCRYPT_INIT / 100.0;
		}

	/**
	 * Gets the initial speed for the state NO_USER.
	 * @return speedValue in range [Settings.SPEED_ARC_LENGTH_MIN;Settings.SPEED_ARC_LENGTH_MAX]
	 */
	public static double getUserCryptedSpeedInitValue()
		{
		return Tools.convertNumberInRangeABToRangeCD(JSLIDER_SPEED_MIN, JSLIDER_SPEED_MAX, SPEED_ARC_LENGTH_MIN, SPEED_ARC_LENGTH_MAX, JSLIDER_USER_CRYPTED_SPEED_INIT);
		}

	/*------------------------------------------------------------------*\
	|*						UserDecrypted State Settings				*|
	\*------------------------------------------------------------------*/
	public static final int JSLIDER_USER_DECRYPTED_COLOR_MIN = 0;
	public static final int JSLIDER_USER_DECRYPTED_COLOR_MAX = 100;

	public static final int JSLIDER_USER_DECRYPTED_RED_INIT = 100;
	public static final int JSLIDER_USER_DECRYPTED_GREEN_INIT = 100;
	public static final int JSLIDER_USER_DECRYPTED_BLUE_INIT = 100;

	public static final int JSLIDER_USER_DECRYPTED_SPEED_INIT = 100;

	public static final int JSLIDER_USER_DECRYPTED_ENCRYPT_INIT = 0;

	public static final double DISTANCE_DECRYPTED_INIT = 0.0;

	/**
	 * Gets the initial red value for the state USER_DECRYPTED.
	 * @return redValue in range [0;1]
	 */
	public static double getUserDecryptedRedInitValue()
		{
		return JSLIDER_USER_DECRYPTED_RED_INIT / 100.0;
		}

	/**
	 * Gets the initial green value for the state USER_DECRYPTED.
	 * @return greenValue in range [0;1]
	 */
	public static double getUserDecryptedGreenInitValue()
		{
		return JSLIDER_USER_DECRYPTED_GREEN_INIT / 100.0;
		}

	/**
	 * Gets the initial blue value for the state USER_DECRYPTED.
	 * @return blueValue in range [0;1]
	 */
	public static double getUserDecryptedBlueInitValue()
		{
		return JSLIDER_USER_DECRYPTED_BLUE_INIT / 100.0;
		}

	/**
	 * Gets the initial encrypt value for the state USER_DECRYPTED.
	 * @return encryptValue in range [0;1]
	 */
	public static double getUserDecryptedEncryptInitValue()
		{
		return JSLIDER_USER_DECRYPTED_ENCRYPT_INIT / 100.0;
		}

	/**
	 * Gets the initial speed for the state USER_DECRYPTED.
	 * @return speedValue in range [Settings.SPEED_ARC_LENGTH_MIN;Settings.SPEED_ARC_LENGTH_MAX]
	 */
	public static double getUserDecryptedSpeedInitValue()
		{
		return Tools.convertNumberInRangeABToRangeCD(JSLIDER_SPEED_MIN, JSLIDER_SPEED_MAX, SPEED_ARC_LENGTH_MIN, SPEED_ARC_LENGTH_MAX, JSLIDER_USER_DECRYPTED_SPEED_INIT);
		}

	/*------------------------------------------------------------------*\
	|*					Transition NoUser -> UserCrypted				*|
	\*------------------------------------------------------------------*/
	public static final double TRANSITION_DURATION_NO_USER_TO_USER_CRYPTED = 1.0;

	/*------------------------------------------------------------------*\
	|*					Transition UserCrypted -> UserDecrypted			*|
	\*------------------------------------------------------------------*/
	public static final double TRANSITION_DURATION_USER_CRYPTED_TO_USER_DECRYPTED = 1.5;

	public static final int JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_MIN = 0;
	public static final int JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_MAX = 100;
	public static final int JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_INIT = 25;

	/*------------------------------------------------------------------*\
	|*					Transition UserDecrypted -> UserCrypted			*|
	\*------------------------------------------------------------------*/
	public static final double TRANSITION_DURATION_USER_DECRYPTED_TO_USER_CRYPTED = 2.0;

	/*------------------------------------------------------------------*\
	|*					Transition UserDecryptedInactiv					*|
	\*------------------------------------------------------------------*/
	public static final double TRANSITION_DURATION_USER_DECRYPTED_INACTIV_INIT = 3.0;

	public static final int JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_MIN = 0;
	public static final int JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_MAX = 100;
	public static final int JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_INIT = 10;

	/*------------------------------------------------------------------*\
	|*					Transition XXXState -> NoUser					*|
	\*------------------------------------------------------------------*/
	public static final double TRANSITION_DURATION_TO_NO_USER = 2.5;

	/*------------------------------------------------------------------*\
	|*					Transition JSpinner Settings					*|
	\*------------------------------------------------------------------*/
	public static final double JSPINNER_TRANSITION_DURATION_STEP = 0.25;
	public static final double JSPINNER_TRANSITION_DURATION_VALUE_MIN = 0.0;
	public static final double JSPINNER_TRANSITION_DURATION_VALUE_MAX = 60.0;

	/*------------------------------------------------------------------*\
	|*							Detection Settings						*|
	\*------------------------------------------------------------------*/
	public static final double Y_AXIS_MIN = 100.0;
	public static final double Y_AXIS_MAX = 400.0;

	public static final double M_X_AXIS = 1.076;
	public static final double H_X_AXIS = 19.62;

	public static final double M_Z_AXIS = 1.75;
	public static final double H_Z_AXIS = 12.25;

	public static final double JSPINNER_CIRCLE_NUMBER_STEP = 1.0;
	public static final double JSPINNER_CIRCLE_NUMBER_VALUE_MIN = 1.0;
	public static final double JSPINNER_CIRCLE_NUMBER_VALUE_MAX = 50.0;
	public static final double JSPINNER_CIRCLE_NUMBER_VALUE_INIT = 10.0;

	public static final double JSPINNER_CIRCLE_RADIUS_STEP = 0.25;
	public static final double JSPINNER_CIRCLE_RADIUS_VALUE_MIN = 10.0;
	public static final double JSPINNER_CIRCLE_RADIUS_VALUE_MAX = 75.0;
	public static final double JSPINNER_CIRCLE_RADIUS_VALUE_INIT = 25.0;

	public static double SPEED_ARC_LENGTH_MIN;
	public static double SPEED_ARC_LENGTH_MAX;

	public static double CIRCLE_NUMBER_CURRENT = JSPINNER_CIRCLE_NUMBER_VALUE_INIT;
	public static double CIRCLE_RADIUS_CURRENT = JSPINNER_CIRCLE_RADIUS_VALUE_INIT;

	/**
	 * Gets the normal speed.
	 * @return normalSpeedArcLength
	 */
	public static double getSpeedArcLengthNormal()
		{
		return (SPEED_ARC_LENGTH_MAX * 100.0) / JSLIDER_SPEED_MAX;
		}

	/**
	 * Sets the attribute CIRCLE_NUMBER_CURRENT.
	 * @param _newCircleNumber
	 */
	public static void setCircleNumber(double _newCircleNumber)
		{
		CIRCLE_NUMBER_CURRENT = _newCircleNumber;
		computeSpeedArcLengthMinMax(CIRCLE_RADIUS_CURRENT, _newCircleNumber);
		}

	/**
	 * Sets the attribute CIRCLE_RADIUS_CURRENT.
	 * @param _newCircleRadius
	 */
	public static void setCircleRadius(double _newCircleRadius)
		{
		CIRCLE_RADIUS_CURRENT = _newCircleRadius;
		computeSpeedArcLengthMinMax(_newCircleRadius, CIRCLE_NUMBER_CURRENT);
		}

	/**
	 * Computes the attributes SPEED_ARC_LENGTH_MIN and SPEED_ARC_LENGTH_MAX in function of the circle radius and the number of circle.
	 * @param _circleRadius
	 * @param _numberOfCircle
	 */
	public static void computeSpeedArcLengthMinMax(double _circleRadius, double _numberOfCircle)
		{
		double newMax = 2 * Math.PI * _circleRadius * _numberOfCircle;

		SPEED_ARC_LENGTH_MIN = (-1) * newMax;
		SPEED_ARC_LENGTH_MAX = newMax;
		}

	/*------------------------------------------------------------------*\
	|*							JSLIDER 	Settings					*|
	\*------------------------------------------------------------------*/
	public static final int JSLIDER_SPEED_MIN = -200;
	public static final int JSLIDER_SPEED_MAX = 200;

	public static final int JSLIDER_ENCRYPT_MIN = 0;
	public static final int JSLIDER_ENCRYPT_MAX = 100;

	/*------------------------------------------------------------------*\
	|*							DataEffect Settings						*|
	\*------------------------------------------------------------------*/
	public static final double RED_MIN = 0.0;
	public static final double RED_MAX = 1.0;

	public static final double GREEN_MIN = 0.0;
	public static final double GREEN_MAX = 1.0;

	public static final double BLUE_MIN = 0.0;
	public static final double BLUE_MAX = 1.0;

	public static final double DISTANCE_MIN = 0.0;
	public static final double DISTANCE_MAX = 1.0;

	public static final double VELOCITY_MIN = 0.0;
	public static final double VELOCITY_MAX = 600.0;

	public static final double DISTANCE_CAPTURED_MIN = 200.0;
	public static final double DISTANCE_CAPTURED_MAX = 600.0;

	public static final double PITCH_CAPTURED_MIN = -135.0;
	public static final double PITCH_CAPTURED_MAX = -35.0;
	public static final double PITCH_PURE_DATA_MIN = -60.0;
	public static final double PITCH_PURE_DATA_MAX = 60.0;
	public static final double PITCH_PURE_DATA_VALUE_INIT = 0.0;

	public static final double ROLL_CAPTURED_MIN = -50.0;
	public static final double ROLL_CAPTURED_MAX = 50.0;
	public static final double ROLL_PURE_DATA_MIN = -60.0;
	public static final double ROLL_PURE_DATA_MAX = 60.0;
	public static final double ROLL_PURE_DATA_VALUE_INIT = 0.0;

	/*------------------------------------------------------------------*\
	|*							Update Rate Settings					*|
	\*------------------------------------------------------------------*/
	public static final int TRANSITION_MACHINE_UPDATE_RATE = 10;
	public static final int NETWORK_UPDATE_RATE = 10;

	/*------------------------------------------------------------------*\
	|*							Network Settings						*|
	\*------------------------------------------------------------------*/
	public static final String IP_ADDRESS_PURE_DATA = "127.0.0.1";
	public static final String PORT_NUMBER_PURE_DATA_AUDIO = "9001";
	public static final String PORT_NUMBER_PURE_DATA_VIDEO = "9002";

	/*------------------------------------------------------------------*\
	|*							JSpinner Settings						*|
	\*------------------------------------------------------------------*/
	public static final int JSPINNER_WIDTH = 35;
	public static final int JSPINNER_HEIGHT = 20;

	}
