
package ch.hearc.orlac.data.transition;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.transitionmachine.TransitionMachine;

/**
 * Contains the settings of the transition from STATE_NO_USER to STATE_USER_CRYPTED.
 * @author chavailm
 */
public class TransitionSettingsNoUserToUserCrypted extends TransitionSettings_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TransitionSettingsNoUserToUserCrypted()
		{
		this.transitionDurationInSeconds = Settings.TRANSITION_DURATION_NO_USER_TO_USER_CRYPTED;
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
		this.transitionMachine.setDurationNoUserToUserCryptedSeconds(this.transitionDurationInSeconds);

		computeNumberOfStep();
		}

	@Override
	public void setTransitionVelocityMin(double _transitionVelocityMin)
		{
		//No velocity min for this transition.
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
		//No velocity min for this transition.
		return -1.0;
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
