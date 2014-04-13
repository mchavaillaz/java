
package ch.hearc.orlac.data.transition;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.tools.Tools;
import ch.hearc.orlac.transitionmachine.TransitionMachine;

/**
 * Contains the settings in the STATE_USER_DECRYPTED.
 * @author chavailm
 */
public class TransitionSettingsUserDecryptedInactiv extends TransitionSettings_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TransitionSettingsUserDecryptedInactiv()
		{
		this.transitionDurationInSeconds = Settings.TRANSITION_DURATION_USER_DECRYPTED_INACTIV_INIT;
		this.velocityMinValue = Tools.convertNumberInRangeABToRangeCD(Settings.JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_MIN, Settings.JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_MAX, Settings.VELOCITY_MIN, Settings.VELOCITY_MAX, Settings.JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_INIT);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void computeNumberOfStep()
		{
		// No transition step in this transition.
		}

	@Override
	public void computeStepRedValue(double _endTransitionValue, double _currentValue)
		{
		// No step value for this transition.
		}

	@Override
	public void computeStepGreenValue(double _endTransitionValue, double _currentValue)
		{
		// No step value for this transition.
		}

	@Override
	public void computeStepBlueValue(double _endTransitionValue, double _currentValue)
		{
		// No step value for this transition.
		}

	@Override
	public void computeStepSpeedValue(double _endTransitionValue, double _currentValue)
		{
		// No step value for this transition.
		}

	@Override
	public void computeStepEncryptValue(double _endTransitionValue, double _currentValue)
		{
		// No step value for this transition.
		}

	@Override
	public void computeStepDistanceValue(double _endTransitionValue, double _currentValue)
		{
		// No step value for this transition.
		}

	@Override
	public void computeStepRollValue(double _endTransitionValue, double _currentValue)
		{
		// No step value for this transition
		}

	@Override
	public void computeStepPitchValue(double _endTransitionValue, double _currentValue)
		{
		// No step value for this transition
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	@Override
	public void setTransitionDurationInSeconds(double _transitionDurationInSeconds)
		{
		this.transitionDurationInSeconds = _transitionDurationInSeconds;
		this.transitionMachine.setDurationUserDecryptedInactiveSeconds(this.transitionDurationInSeconds);
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
		this.transitionMachine.setVelocityMinInactiv(this.velocityMinValue);
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
	public double getTransitionDurationInSeconds()
		{
		return this.transitionDurationInSeconds;
		}

	@Override
	public double getTransitionVelocityMin()
		{
		return this.velocityMinValue;
		}

	@Override
	public double getStepRedValue()
		{
		// No step value for this transition.
		return -1.0;
		}

	@Override
	public double getStepGreenValue()
		{
		// No step value for this transition.
		return -1.0;
		}

	@Override
	public double getStepBlueValue()
		{
		// No step value for this transition.
		return -1.0;
		}

	@Override
	public double getStepSpeedValue()
		{
		// No step value for this transition.
		return -1.0;
		}

	@Override
	public double getStepEncryptValue()
		{
		// No step value for this transition.
		return -1.0;
		}

	@Override
	public double getStepDistanceValue()
		{
		// No step value for this transition.
		return -1.0;
		}

	@Override
	public double getStepRollValue()
		{
		// No step value for this transition.
		return -1.0;
		}

	@Override
	public double getStepPitchValue()
		{
		// No step value for this transition.
		return -1.0;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private double transitionDurationInSeconds;
	private double velocityMinValue;

	//Tools
	private TransitionMachine transitionMachine;

	}
