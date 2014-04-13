
package ch.hearc.orlac.data.transition;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.tools.Tools;
import ch.hearc.orlac.transitionmachine.TransitionMachine;

/**
 * Contains the settings of the transition from STATE_USER_CRYPTED to STATE_USER_DECRYPTED.
 * @author chavailm
 */
public class TransitionSettingsUserCryptedToUserDecrypted extends TransitionSettings_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TransitionSettingsUserCryptedToUserDecrypted()
		{
		this.transitionDurationInSeconds = Settings.TRANSITION_DURATION_USER_CRYPTED_TO_USER_DECRYPTED;
		this.velocityMinValue = Tools.convertNumberInRangeABToRangeCD(Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_MIN, Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_MAX, Settings.VELOCITY_MIN, Settings.VELOCITY_MAX, Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_INIT);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void computeNumberOfStep()
		{
		this.numberOfStep = (this.transitionDurationInSeconds * 1000.0) / transitionMachine.getUpdateRate();
		}

	@Override
	public void computeStepRedValue(double _endTransitionValue, double _currentValue)
		{
		this.stepRedValue = (_endTransitionValue - _currentValue) / this.numberOfStep;
		}

	@Override
	public void computeStepGreenValue(double _endTransitionValue, double _currentValue)
		{
		this.stepGreenValue = (_endTransitionValue - _currentValue) / this.numberOfStep;
		}

	@Override
	public void computeStepBlueValue(double _endTransitionValue, double _currentValue)
		{
		this.stepBlueValue = (_endTransitionValue - _currentValue) / this.numberOfStep;
		}

	@Override
	public void computeStepSpeedValue(double _endTransitionValue, double _currentValue)
		{
		this.stepSpeedValue = (_endTransitionValue - _currentValue) / this.numberOfStep;
		}

	@Override
	public void computeStepEncryptValue(double _endTransitionValue, double _currentValue)
		{
		this.stepEncryptValue = (_endTransitionValue - _currentValue) / this.numberOfStep;
		}

	@Override
	public void computeStepDistanceValue(double _endTransitionValue, double _currentValue)
		{
		this.stepDistanceValue = (_endTransitionValue - _currentValue) / this.numberOfStep;
		}

	@Override
	public void computeStepRollValue(double _endTransitionValue, double _currentValue)
		{
		this.stepRollValue = (_endTransitionValue - _currentValue) / this.numberOfStep;
		}

	@Override
	public void computeStepPitchValue(double _endTransitionValue, double _currentValue)
		{
		this.stepPitchValue = (_endTransitionValue - _currentValue) / this.numberOfStep;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	@Override
	public void setTransitionDurationInSeconds(double _transitionDurationInSeconds)
		{
		this.transitionDurationInSeconds = _transitionDurationInSeconds;
		this.transitionMachine.setDurationUserDecryptToUserDecryptedSeconds(this.transitionDurationInSeconds);

		computeNumberOfStep();
		}

	@Override
	public void setTransitionVelocityMin(double _transitionVelocityMin)
		{
		if (_transitionVelocityMin <= 0.0)
			{
			_transitionVelocityMin = Settings.VELOCITY_MIN;
			}
		else if (_transitionVelocityMin >= 1.0)
			{
			_transitionVelocityMin = Settings.VELOCITY_MAX;
			}
		else
			{
			_transitionVelocityMin = Tools.convertNumberInRangeABToRangeCD(0.0, 1.0, Settings.VELOCITY_MIN, Settings.VELOCITY_MAX, _transitionVelocityMin);
			}
		this.velocityMinValue = _transitionVelocityMin;
		this.transitionMachine.setVelocityMinDecrypt(this.velocityMinValue);
		}

	@Override
	public void setTransitionMachine(TransitionMachine _transitionMachine)
		{
		this.transitionMachine = _transitionMachine;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	@Override
	public double getTransitionVelocityMin()
		{
		return this.velocityMinValue;
		}

	@Override
	public double getTransitionDurationInSeconds()
		{
		return this.transitionDurationInSeconds;
		}

	@Override
	public double getStepRedValue()
		{
		return this.stepRedValue;
		}

	@Override
	public double getStepGreenValue()
		{
		return this.stepGreenValue;
		}

	@Override
	public double getStepBlueValue()
		{
		return this.stepBlueValue;
		}

	@Override
	public double getStepSpeedValue()
		{
		return this.stepSpeedValue;
		}

	@Override
	public double getStepEncryptValue()
		{
		return this.stepEncryptValue;
		}

	@Override
	public double getStepDistanceValue()
		{
		return this.stepDistanceValue;
		}

	@Override
	public double getStepRollValue()
		{
		return this.stepRollValue;
		}

	@Override
	public double getStepPitchValue()
		{
		return this.stepPitchValue;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private double transitionDurationInSeconds;
	private double velocityMinValue;

	//Outputs
	private double stepRedValue;
	private double stepGreenValue;
	private double stepBlueValue;
	private double stepSpeedValue;
	private double stepEncryptValue;
	private double stepDistanceValue;
	private double stepRollValue;
	private double stepPitchValue;

	//Tools
	private double numberOfStep;

	private TransitionMachine transitionMachine;
	}
