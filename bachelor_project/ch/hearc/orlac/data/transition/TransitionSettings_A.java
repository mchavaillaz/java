
package ch.hearc.orlac.data.transition;

import ch.hearc.orlac.transitionmachine.TransitionMachine;

/**
 * Abstract class for the TransitionSettings concrete classes.</br>
 * @author chavailm
 */
public abstract class TransitionSettings_A
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Computes the transition number of step attribute.</br>
	 * This method uses the transition duration and the updateRate of the transition machine Thread to compute the number of step.
	 */
	public abstract void computeNumberOfStep();

	/**
	 * Computes the step red value attribute to add or remove to the effect during a transition.
	 * @param _endTransitionValue value of the effect at the end of the transition.
	 * @param _currentValue current value of the effect.
	 */
	public abstract void computeStepRedValue(double _endTransitionValue, double _currentValue);

	/**
	 * Computes the step green value attribute to add or remove to the effect during a transition.
	 * @param _endTransitionValue value of the effect at the end of the transition.
	 * @param _currentValue current value of the effect.
	 */
	public abstract void computeStepGreenValue(double _endTransitionValue, double _currentValue);

	/**
	 * Computes the step blue value attribute to add or remove to the effect during a transition.
	 * @param _endTransitionValue value of the effect at the end of the transition.
	 * @param _currentValue current value of the effect.
	 */
	public abstract void computeStepBlueValue(double _endTransitionValue, double _currentValue);

	/**
	 * Computes the step speed value attribute to add or remove to the effect during a transition.
	 * @param _endTransitionValue value of the effect at the end of the transition.
	 * @param _currentValue current value of the effect.
	 */
	public abstract void computeStepSpeedValue(double _endTransitionValue, double _currentValue);

	/**
	 * Computes the step zoom effect step value attribute to add or remove to the effect during a transition.
	 * @param _endTransitionValue value of the effect at the end of the transition.
	 * @param _currentValue current value of the effect.
	 */
	public abstract void computeStepEncryptValue(double _endTransitionValue, double _currentValue);

	/**
	 * Computes the distance effect effet value attribute to add or remove to the effect durin a transition.
	 * @param _endTransitionValue value of the effect at the end of the transition.
	 * @param _currentValue current value of the effect.
	 */
	public abstract void computeStepDistanceValue(double _endTransitionValue, double _currentValue);

	/**
	 * Computes the roll effect step value attribute to add or remove to the effect during a transition.
	 * @param _endTransitionValue value of the effect at the end of the transition.
	 * @param _currentValue current value of the effect.
	 */
	public abstract void computeStepRollValue(double _endTransitionValue, double _currentValue);

	/**
	 * Computes the pitch effect step value attribute to add or remove to the effect during a transition.
	 * @param _endTransitionValue value of the effect at the end of the transition.
	 * @param _currentValue current value of the effect.
	 */
	public abstract void computeStepPitchValue(double _endTransitionValue, double _currentValue);

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the attribute transitionDurationInSeconds.
	 * @param _transitionDurationInSeconds in seconds
	 */
	public abstract void setTransitionDurationInSeconds(double _transitionDurationInSeconds);

	/**
	 * Sets the attribute transitionVelocityMin.
	 * @param newValue must be in range [0;1]
	 */
	public abstract void setTransitionVelocityMin(double newValue);

	/**
	 * Sets the attribute transitionMachine.
	 * @param _transitionMachine
	 */
	public abstract void setTransitionMachine(TransitionMachine _transitionMachine);

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute transitionDurationInSeconds.
	 * @return transitionDurationInSeconds in seconds
	 */
	public abstract double getTransitionDurationInSeconds();

	/**
	 * Gets the attribute velocityMin.
	 * @return velocitymin is in range [Settings.VELOCITY_MIN; Settings.VELOCITY_MAX]
	 */
	public abstract double getTransitionVelocityMin();

	/**
	 * Gets the attribute stepRedValue.
	 * @return stepRedValue
	 */
	public abstract double getStepRedValue();

	/**
	 * Gets the attribute stepGreenValue.
	 * @return stepGreenValue
	 */
	public abstract double getStepGreenValue();

	/**
	 * Gets the attribute stepBlueValue.
	 * @return stepBlueValue
	 */
	public abstract double getStepBlueValue();

	/**
	 * Gets the attribute stepSpeedValue.
	 * @return stepSpeedValue
	 */
	public abstract double getStepSpeedValue();

	/**
	 * Gets the attribute stepEncryptValue.
	 * @return stepEncryptValue
	 */
	public abstract double getStepEncryptValue();

	/**
	 * Gets the attribute stepDistanceValue.
	 * @return stepDistanceValue
	 */
	public abstract double getStepDistanceValue();

	/**
	 * Gets the attribute stepRollValue.
	 * @return stepRollValue
	 */
	public abstract double getStepRollValue();

	/**
	 * Gets the attribute stepPitchValue.
	 * @return stepPitchValue
	 */
	public abstract double getStepPitchValue();
	}
