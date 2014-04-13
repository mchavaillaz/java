
package ch.hearc.orlac.transitionmachine;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.data.effect.DataEffectNoUser;
import ch.hearc.orlac.data.effect.DataEffectUserCrypted;
import ch.hearc.orlac.data.effect.DataEffectUserDecrypted;
import ch.hearc.orlac.data.effect.DataEffect_A;
import ch.hearc.orlac.data.transition.TransitionSettingsNoUserToUserCrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsToNoUser;
import ch.hearc.orlac.data.transition.TransitionSettingsUserCryptedToUserDecrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedInactiv;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedToUserCrypted;
import ch.hearc.orlac.data.transition.TransitionSettings_A;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.tools.Tools;

/**
 * Handle the transition effects between the application states. </br>
 * This transition machine is a Thread and computes the transition effects in function of the application state.
 * @author chavailm
 */
public class TransitionMachine implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TransitionMachine()
		{
		this.isEnable = false;
		this.isHandDetected = false;
		this.isTransitionRunning = false;

		this.updateRate = Settings.TRANSITION_MACHINE_UPDATE_RATE;

		this.currentState = ApplicationStateEnum.STATE_NO_USER;

		this.velocityCurrent = 0.0;
		this.velocityMinDecrypt = Tools.convertNumberInRangeABToRangeCD(Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_MIN, Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_MAX, Settings.VELOCITY_MIN, Settings.VELOCITY_MAX, Settings.JSLIDER_ENERGY_USER_CRYPTED_TO_USER_DECRYPTED_INIT);
		this.velocityMinInactiv = Tools.convertNumberInRangeABToRangeCD(Settings.JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_MIN, Settings.JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_MAX, Settings.VELOCITY_MIN, Settings.VELOCITY_MAX, Settings.JSLIDER_ENERGY_USER_DECRYPTED_INACTIV_INIT);

		this.durationToNoUserSeconds = Settings.TRANSITION_DURATION_TO_NO_USER;
		this.durationNoUserToUserCryptedSeconds = Settings.TRANSITION_DURATION_NO_USER_TO_USER_CRYPTED;
		this.durationUserCryptedToUserDecryptedSeconds = Settings.TRANSITION_DURATION_USER_CRYPTED_TO_USER_DECRYPTED;
		this.durationUserDecryptedToUserCryptedSeconds = Settings.TRANSITION_DURATION_USER_DECRYPTED_TO_USER_CRYPTED;
		this.durationUserDecryptedInactivSeconds = Settings.TRANSITION_DURATION_USER_DECRYPTED_INACTIV_INIT;

		this.work = new Thread(this);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Contains the logic of the state machine. </br>
	 * Check the presence of the user's hands and computes the right state.
	 */
	@Override
	public void run()
		{
		updateTransitionDurationAndVelocity();
		updateTransitionStep();

		while(this.isEnable)
			{
			try
				{
				Thread.sleep(this.updateRate);
				}
			catch (InterruptedException e)
				{
				System.err.println("TransitionMachine run():" + e.toString());
				}

			// User's hand detected
			if (this.isHandDetected)
				{
				// If user's hand is detected while transition STATE_NO_USER_ENCRYPT is running
				if (this.currentState == ApplicationStateEnum.STATE_NO_USER_ENCRYPT)
					{
					this.currentState = ApplicationStateEnum.STATE_NO_USER;
					this.isTransitionRunning = false;

					// Computes the step values of all effects for the transition.
					computeStepValueForAllEffect();
					}

				// Transition STATE_NO_USER -> STATE_USER_CRYPTED
				if (this.currentState == ApplicationStateEnum.STATE_NO_USER)
					{
					if (!this.isTransitionRunning)
						{
						this.durationNoUserToUserCryptedMillis = initDuration(this.durationNoUserToUserCryptedSeconds);

						// Turns on the transition.
						this.isTransitionRunning = true;

						// Computes the step values of all effects for the transition.
						computeStepValueForAllEffect();
						}

					// Handles the transition.
					else
						{
						long timeLeftInMillis = computeTimeleft(this.durationNoUserToUserCryptedMillis);

						// Transition is running.
						if (timeLeftInMillis >= 0)
							{
							// Updates the data effect values using the TransitionSettingsNoUserToUserCrypted values.
							updateDataEffectCurrent(this.transitionSettingsNoUserToUserCrypted);
							}

						// Transition ends.
						else
							{
							// Switch to the STATE_USER_CRYPTED.
							this.currentState = ApplicationStateEnum.STATE_USER_CRYPTED;
							this.isTransitionRunning = false;
							updateDataEffectCurrentTransitionEnded(this.dataEffectUserCrypted);
							}
						}
					}

				// Transition STATE_USER_CRYPTED -> STATE_USER_DECRYPT
				if (this.currentState == ApplicationStateEnum.STATE_USER_CRYPTED)
					{

					// If the user's hand moves enough, switch to the next state.
					if (this.velocityCurrent >= this.velocityMinDecrypt)
						{
						// Switch to the STATE_USER_DECRYPT.
						this.currentState = ApplicationStateEnum.STATE_USER_DECRYPT;
						}
					}

				// Transition STATE_USER_DECRYPT -> STATE_USER_DECRYPTED
				if (this.currentState == ApplicationStateEnum.STATE_USER_DECRYPT)
					{
					if (!this.isTransitionRunning)
						{
						this.durationUserDecryptToUserDecryptedMillis = initDuration(this.durationUserCryptedToUserDecryptedSeconds);

						// Turns on the transition.
						this.isTransitionRunning = true;

						// Computes the step values of all effects for the transition.
						computeStepValueForAllEffect();
						}

					// Handles the transition.
					else
						{
						// If the user's hand moves enough, continues to decrypt.
						if (this.velocityCurrent >= this.velocityMinDecrypt)
							{
							long timeLeftInMillis = computeTimeleft(this.durationUserDecryptToUserDecryptedMillis);

							// Transition is running.
							if (timeLeftInMillis >= 0)
								{
								// Updates the data effect values using the TransitionSettingsUserCryptedToUserDecrypted values.
								updateDataEffectCurrent(this.transitionSettingsUserCryptedToUserDecrypted);
								}
							// Transition ends.
							else
								{
								this.currentState = ApplicationStateEnum.STATE_USER_DECRYPTED;
								this.isTransitionRunning = false;
								updateDataEffectCurrentTransitionEnded(this.dataEffectUserDecrypted);
								}
							}
						// If the user's hand doesn't move enough, switch to the STATE_USER_ENCRYPT
						else
							{
							// Switches to the STATE_USER_ENCRYPT.
							this.currentState = ApplicationStateEnum.STATE_USER_ENCRYPT;
							this.isTransitionRunning = false;
							}
						}
					}

				// Transition STATE_USER_DECRYPTED -> STATE_USER_ENCRYPT
				if (this.currentState == ApplicationStateEnum.STATE_USER_DECRYPTED)
					{
					// If the user's hand doesn't move enough, start a countdown.
					if (this.velocityCurrent < this.velocityMinInactiv)
						{
						if (!this.isTransitionRunning)
							{
							this.durationUserDecryptedInactiveMillis = initDuration(this.durationUserDecryptedInactivSeconds);

							// Turns on the countdown.
							this.isTransitionRunning = true;
							}
						// Countdown is running.
						else
							{
							long timeLeftInMillis = computeTimeleft(this.durationUserDecryptedInactiveMillis);

							if (timeLeftInMillis >= 0)
								{
								// Nothing to do.
								}
							// Transition ends
							else
								{
								// Switch to the next STATE_USER_ENCRYPT.
								this.currentState = ApplicationStateEnum.STATE_USER_ENCRYPT;
								this.isTransitionRunning = false;
								}
							}
						}
					else
						{
						this.isTransitionRunning = false;
						}
					}

				// Transition STATE_USER_ENCRYPT -> STATE_USER_CRYPTED
				if (this.currentState == ApplicationStateEnum.STATE_USER_ENCRYPT)
					{
					if (!this.isTransitionRunning)
						{
						this.durationUserEncryptToUserCryptedMillis = initDuration(this.durationUserDecryptedToUserCryptedSeconds);

						// Turns on the transition.
						this.isTransitionRunning = true;

						// Computes the step values of all effects for the transition.
						computeStepValueForAllEffect();
						}
					// Handles the transition.
					else
						{
						// If the user doesn't move enough
						if (this.velocityCurrent < this.velocityMinDecrypt)
							{
							long timeLeftInMillis = computeTimeleft(this.durationUserEncryptToUserCryptedMillis);

							// Transition is running.
							if (timeLeftInMillis >= 0)
								{
								// Updates the data effect values using the TransitionUserDecryptedToUserCrypted values.
								updateDataEffectCurrent(this.transitionUserDecryptedToUserCrypted);
								}
							// Transition ends.
							else
								{
								// Switch to the STATE_USER_CRYPTED.
								this.currentState = ApplicationStateEnum.STATE_USER_CRYPTED;
								this.isTransitionRunning = false;
								updateDataEffectCurrentTransitionEnded(this.dataEffectUserCrypted);
								}
							}
						// If the user's hand moves enough.
						else
							{
							// Switch to the STATE_USER_CRYPTED.
							this.currentState = ApplicationStateEnum.STATE_USER_CRYPTED;
							this.isTransitionRunning = false;
							}
						}
					}
				}

			// No hands detected.
			else
				{
				// If the user removes his hand while transitionning.
				if (this.isTransitionRunning && this.currentState != ApplicationStateEnum.STATE_NO_USER_ENCRYPT)
					{
					this.isTransitionRunning = false;
					this.currentState = ApplicationStateEnum.STATE_NO_USER_ENCRYPT;
					}

				// If the user removes his hand and no transition is running.
				if (this.currentState != ApplicationStateEnum.STATE_NO_USER && this.currentState != ApplicationStateEnum.STATE_NO_USER_ENCRYPT)
					{
					this.currentState = ApplicationStateEnum.STATE_NO_USER_ENCRYPT;
					}

				// Transition STATE_NO_USER_ENCRYPT -> STATE_NO_USER
				if (this.currentState == ApplicationStateEnum.STATE_NO_USER_ENCRYPT)
					{

					if (!this.isTransitionRunning)
						{
						this.durationNoUserEncryptToNoUserMillis = initDuration(this.durationToNoUserSeconds);

						// Turns on the transition.
						this.isTransitionRunning = true;

						// Computes the step values of all effects for the transition.
						computeStepValueForAllEffect();
						}
					// Handles the transition.
					else
						{
						long timeLeftInMillis = computeTimeleft(this.durationNoUserEncryptToNoUserMillis);

						// Transition is running.
						if (timeLeftInMillis >= 0)
							{
							updateDataEffectCurrent(this.transitionToNoUser);
							}
						// Transition ends.
						else
							{
							this.currentState = ApplicationStateEnum.STATE_NO_USER;
							this.isTransitionRunning = false;

							updateDataEffectCurrentTransitionEnded(this.dataEffectNoUser);
							}
						}
					}

				// State STATE_NO_USER, waiting for a user
				if (this.currentState == ApplicationStateEnum.STATE_NO_USER)
					{
					// Nothing to do.
					}
				}
			}
		}

	/**
	 * Updates the values of the attributes isHandDetected and newVelocity.
	 * @param _isHandDetected
	 * @param _newVelocity
	 */
	public void updateIsHandDetected(boolean _isHandDetected, double _newVelocity)
		{
		this.setHandDetected(_isHandDetected);
		this.setVelocityCurrent(_newVelocity);
		}

	/**
	 * Starts the transition machine.
	 */
	public void startTransitionMachine()
		{
		if (!this.isEnable)
			{
			this.isEnable = true;
			this.work.start();
			}
		}

	/**
	 * Updates the attributes for the transition duration and the velocity.
	 */
	public void updateTransitionDurationAndVelocity()
		{
		this.durationNoUserToUserCryptedSeconds = this.transitionSettingsNoUserToUserCrypted.getTransitionDurationInSeconds();
		this.durationToNoUserSeconds = this.transitionToNoUser.getTransitionDurationInSeconds();
		this.durationUserCryptedToUserDecryptedSeconds = this.transitionSettingsUserCryptedToUserDecrypted.getTransitionDurationInSeconds();
		this.durationUserDecryptedToUserCryptedSeconds = this.transitionUserDecryptedToUserCrypted.getTransitionDurationInSeconds();
		this.durationUserDecryptedInactivSeconds = this.transitionSettingsUserDecryptedInactiv.getTransitionDurationInSeconds();

		this.velocityMinDecrypt = this.transitionSettingsUserCryptedToUserDecrypted.getTransitionVelocityMin();
		this.velocityMinInactiv = this.transitionSettingsUserDecryptedInactiv.getTransitionVelocityMin();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/**
	 * Sets the attribute isHandDetected.
	 * @param _isHandDetected
	 */
	public void setHandDetected(boolean _isHandDetected)
		{
		this.isHandDetected = _isHandDetected;
		}

	/**
	 * Sets the attribute velocityCurrent.
	 * @param _newVelocity
	 */
	public void setVelocityCurrent(double _newVelocity)
		{
		this.velocityCurrent = _newVelocity;
		}

	/**
	 * Sets the attribute dataEffectCurrent.
	 * @param _dataEffectCurrent
	 */
	public void setDataEffectCurrent(DataEffectCurrent _dataEffectCurrent)
		{
		this.dataEffectCurrent = _dataEffectCurrent;
		}

	/**
	 * Sets the attribute dataEffectNoUser.
	 * @param _dataEffectNoUser
	 */
	public void setDataEffectNoUser(DataEffectNoUser _dataEffectNoUser)
		{
		this.dataEffectNoUser = _dataEffectNoUser;
		}

	/**
	 * Sets the attribute dataEffectUserCrypted.
	 * @param _dataEffectUserCrypted
	 */
	public void setDataEffectUserCrypted(DataEffectUserCrypted _dataEffectUserCrypted)
		{
		this.dataEffectUserCrypted = _dataEffectUserCrypted;
		}

	/**
	 * Sets the attribute dataEffectDecrypted.
	 * @param _dataEffectUserDecrypted
	 */
	public void setDataEffectUserDecrypted(DataEffectUserDecrypted _dataEffectUserDecrypted)
		{
		this.dataEffectUserDecrypted = _dataEffectUserDecrypted;
		}

	/**
	 * Sets the attribute transitionSettingsNoUserToUserCrypted.
	 * @param _transitionSettingsNoUserToUserCrypted
	 */
	public void setTransitionSettingsNoUserToUserCrypted(TransitionSettingsNoUserToUserCrypted _transitionSettingsNoUserToUserCrypted)
		{
		this.transitionSettingsNoUserToUserCrypted = _transitionSettingsNoUserToUserCrypted;
		}

	/**
	 * Sets the attribute transitionSettingsUserCryptedToUserDecrypted.
	 * @param _transitionSettingsUserCryptedToUserDecrypted
	 */
	public void setTransitionSettingsUserCryptedToUserDecrypted(TransitionSettingsUserCryptedToUserDecrypted _transitionSettingsUserCryptedToUserDecrypted)
		{
		this.transitionSettingsUserCryptedToUserDecrypted = _transitionSettingsUserCryptedToUserDecrypted;
		}

	/**
	 * Sets the attribute transitionSettingsUserDecryptedInactiv.
	 * @param _transitionSettingsUserDecryptedInactiv
	 */
	public void setTransitionSettingsUserDecryptedInactiv(TransitionSettingsUserDecryptedInactiv _transitionSettingsUserDecryptedInactiv)
		{
		this.transitionSettingsUserDecryptedInactiv = _transitionSettingsUserDecryptedInactiv;
		}

	/**
	 * Sets the attribute transitionUserDecryptedToUserCrypted.
	 * @param _transitionUserDecryptedToUserCrypted
	 */
	public void setTransitionUserDecryptedToUserCrypted(TransitionSettingsUserDecryptedToUserCrypted _transitionUserDecryptedToUserCrypted)
		{
		this.transitionUserDecryptedToUserCrypted = _transitionUserDecryptedToUserCrypted;
		}

	/**
	 * Sets the attribute transitionToNoUser.
	 * @param _transitionToNoUser
	 */
	public void setTransitionToNoUser(TransitionSettingsToNoUser _transitionToNoUser)
		{
		this.transitionToNoUser = _transitionToNoUser;
		}

	/**
	 * Sets the attribute durationNoUserToUserCryptedSeconds.
	 * @param _durationNoUserToUserCryptedSeconds
	 */
	public void setDurationNoUserToUserCryptedSeconds(double _durationNoUserToUserCryptedSeconds)
		{
		this.durationNoUserToUserCryptedSeconds = _durationNoUserToUserCryptedSeconds;
		}

	/**
	 * Sets the attribute durationNoUserEncryptToNoUserSeconds.
	 * @param _durationNoUserEncryptToNoUserSeconds
	 */
	public void setDurationNoUserEncryptToNoUserSeconds(double _durationNoUserEncryptToNoUserSeconds)
		{
		this.durationToNoUserSeconds = _durationNoUserEncryptToNoUserSeconds;
		}

	/**
	 * Sets the attribute durationUserDecryptToUserDecryptedSeconds.
	 * @param _durationUserDecryptToUserDecryptedSeconds
	 */
	public void setDurationUserDecryptToUserDecryptedSeconds(double _durationUserDecryptToUserDecryptedSeconds)
		{
		this.durationUserCryptedToUserDecryptedSeconds = _durationUserDecryptToUserDecryptedSeconds;
		}

	/**
	 * Sets the attribute durationUserEncryptToUserCryptedSeconds.
	 * @param _durationUserEncryptToUserCryptedSeconds
	 */
	public void setDurationUserEncryptToUserCryptedSeconds(double _durationUserEncryptToUserCryptedSeconds)
		{
		this.durationUserDecryptedToUserCryptedSeconds = _durationUserEncryptToUserCryptedSeconds;
		}

	/**
	 * Sets the attribute durationUserDecryptedInactivSeconds.
	 * @param _durationUserDecryptedInactivSeconds
	 */
	public void setDurationUserDecryptedInactiveSeconds(double _durationUserDecryptedInactivSeconds)
		{
		this.durationUserDecryptedInactivSeconds = _durationUserDecryptedInactivSeconds;
		}

	/**
	 * Sets the attribute velocityMinDecrypt.
	 * @param _velocityMinDecrypt
	 */
	public void setVelocityMinDecrypt(double _velocityMinDecrypt)
		{
		this.velocityMinDecrypt = _velocityMinDecrypt;
		}

	/**
	 * Sets the attribute velocityMinInactiv.
	 * @param _velocityMinInactiv
	 */
	public void setVelocityMinInactiv(double _velocityMinInactiv)
		{
		this.velocityMinInactiv = _velocityMinInactiv;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the current state of the transition.
	 * @return currentState
	 */
	public ApplicationStateEnum getCurrentState()
		{
		return this.currentState;
		}

	/**
	 * Gets the attribute updateRate
	 * @return updateRate
	 */
	public int getUpdateRate()
		{
		return this.updateRate;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Initialize the duration in milliseconds with the current time.
	 * @param _durationInSeconds
	 * @return duration in millis
	 */
	private long initDuration(double _durationInSeconds)
		{
		return (long)(_durationInSeconds * 1000.0 + System.currentTimeMillis());
		}

	/**
	 * Computes the timeleft with a specific duration.
	 * @param _durationInMillis
	 * @return timeleft in millis
	 */
	private long computeTimeleft(long _durationInMillis)
		{
		long timeLeftInMillis = _durationInMillis - System.currentTimeMillis();

		if (timeLeftInMillis >= 0)
			{
			return timeLeftInMillis;
			}
		else
			{
			return -1;
			}
		}

	/**
	 * Updatse the transition step in every {@link TransitionSettings_A} attributes.
	 */
	private void updateTransitionStep()
		{
		this.transitionSettingsNoUserToUserCrypted.computeNumberOfStep();
		this.transitionSettingsUserCryptedToUserDecrypted.computeNumberOfStep();
		this.transitionToNoUser.computeNumberOfStep();
		this.transitionUserDecryptedToUserCrypted.computeNumberOfStep();
		}

	/**
	 * Computes the step value for all the {@link TransitionSettings_A} attributes in function of the current state.
	 */
	private void computeStepValueForAllEffect()
		{
		switch(this.currentState)
			{
			case STATE_NO_USER:
				this.transitionSettingsNoUserToUserCrypted.computeStepRedValue(this.dataEffectUserCrypted.getRedValue(), this.dataEffectCurrent.getRedValue());
				this.transitionSettingsNoUserToUserCrypted.computeStepGreenValue(this.dataEffectUserCrypted.getGreenValue(), this.dataEffectCurrent.getGreenValue());
				this.transitionSettingsNoUserToUserCrypted.computeStepBlueValue(this.dataEffectUserCrypted.getBlueValue(), this.dataEffectCurrent.getBlueValue());
				this.transitionSettingsNoUserToUserCrypted.computeStepSpeedValue(this.dataEffectUserCrypted.getSpeedValue(), this.dataEffectCurrent.getSpeedValue());
				this.transitionSettingsNoUserToUserCrypted.computeStepEncryptValue(this.dataEffectUserCrypted.getEncryptValue(), this.dataEffectCurrent.getEncryptValue());
				this.transitionSettingsNoUserToUserCrypted.computeStepDistanceValue(this.dataEffectUserCrypted.getDistanceValue(), this.dataEffectCurrent.getDistanceValue());
				this.transitionSettingsNoUserToUserCrypted.computeStepRollValue(this.dataEffectUserCrypted.getRollValue(), this.dataEffectCurrent.getRollValue());
				this.transitionSettingsNoUserToUserCrypted.computeStepPitchValue(this.dataEffectUserCrypted.getPitchValue(), this.dataEffectCurrent.getPitchValue());
				break;

			case STATE_USER_DECRYPT:
				this.transitionSettingsUserCryptedToUserDecrypted.computeStepRedValue(this.dataEffectUserDecrypted.getRedValue(), this.dataEffectCurrent.getRedValue());
				this.transitionSettingsUserCryptedToUserDecrypted.computeStepGreenValue(this.dataEffectUserDecrypted.getGreenValue(), this.dataEffectCurrent.getGreenValue());
				this.transitionSettingsUserCryptedToUserDecrypted.computeStepBlueValue(this.dataEffectUserDecrypted.getBlueValue(), this.dataEffectCurrent.getBlueValue());
				this.transitionSettingsUserCryptedToUserDecrypted.computeStepSpeedValue(this.dataEffectUserDecrypted.getSpeedValue(), this.dataEffectCurrent.getSpeedValue());
				this.transitionSettingsUserCryptedToUserDecrypted.computeStepEncryptValue(this.dataEffectUserDecrypted.getEncryptValue(), this.dataEffectCurrent.getEncryptValue());
				this.transitionSettingsUserCryptedToUserDecrypted.computeStepDistanceValue(this.dataEffectUserDecrypted.getDistanceValue(), this.dataEffectCurrent.getDistanceValue());
				this.transitionSettingsUserCryptedToUserDecrypted.computeStepRollValue(this.dataEffectUserDecrypted.getRollValue(), this.dataEffectCurrent.getRollValue());
				this.transitionSettingsUserCryptedToUserDecrypted.computeStepPitchValue(this.dataEffectUserDecrypted.getPitchValue(), this.dataEffectCurrent.getPitchValue());
				break;

			case STATE_USER_ENCRYPT:
				this.transitionUserDecryptedToUserCrypted.computeStepRedValue(this.dataEffectUserCrypted.getRedValue(), this.dataEffectCurrent.getRedValue());
				this.transitionUserDecryptedToUserCrypted.computeStepGreenValue(this.dataEffectUserCrypted.getGreenValue(), this.dataEffectCurrent.getGreenValue());
				this.transitionUserDecryptedToUserCrypted.computeStepBlueValue(this.dataEffectUserCrypted.getBlueValue(), this.dataEffectCurrent.getBlueValue());
				this.transitionUserDecryptedToUserCrypted.computeStepSpeedValue(this.dataEffectUserCrypted.getSpeedValue(), this.dataEffectCurrent.getSpeedValue());
				this.transitionUserDecryptedToUserCrypted.computeStepEncryptValue(this.dataEffectUserCrypted.getEncryptValue(), this.dataEffectCurrent.getEncryptValue());
				this.transitionUserDecryptedToUserCrypted.computeStepDistanceValue(this.dataEffectUserCrypted.getDistanceValue(), this.dataEffectCurrent.getDistanceValue());
				this.transitionUserDecryptedToUserCrypted.computeStepRollValue(this.dataEffectUserCrypted.getRollValue(), this.dataEffectCurrent.getRollValue());
				this.transitionUserDecryptedToUserCrypted.computeStepPitchValue(this.dataEffectUserCrypted.getPitchValue(), this.dataEffectCurrent.getPitchValue());
				break;

			case STATE_NO_USER_ENCRYPT:
				this.transitionToNoUser.computeStepRedValue(this.dataEffectNoUser.getRedValue(), this.dataEffectCurrent.getRedValue());
				this.transitionToNoUser.computeStepGreenValue(this.dataEffectNoUser.getGreenValue(), this.dataEffectCurrent.getGreenValue());
				this.transitionToNoUser.computeStepBlueValue(this.dataEffectNoUser.getBlueValue(), this.dataEffectCurrent.getBlueValue());
				this.transitionToNoUser.computeStepSpeedValue(this.dataEffectNoUser.getSpeedValue(), this.dataEffectCurrent.getSpeedValue());
				this.transitionToNoUser.computeStepEncryptValue(this.dataEffectNoUser.getEncryptValue(), this.dataEffectCurrent.getEncryptValue());
				this.transitionToNoUser.computeStepDistanceValue(this.dataEffectNoUser.getDistanceValue(), this.dataEffectCurrent.getDistanceValue());
				this.transitionToNoUser.computeStepRollValue(this.dataEffectNoUser.getRollValue(), this.dataEffectCurrent.getRollValue());
				this.transitionToNoUser.computeStepPitchValue(this.dataEffectNoUser.getPitchValue(), this.dataEffectCurrent.getPitchValue());
				break;
			default:
				// Nothing to do
				break;
			}
		}

	/**
	 * Updates all the effect while the transition is running.
	 * @param _transitionSettings
	 */
	private void updateDataEffectCurrent(TransitionSettings_A _transitionSettings)
		{
		this.dataEffectCurrent.updateRedValue(_transitionSettings.getStepRedValue());
		this.dataEffectCurrent.updateGreenValue(_transitionSettings.getStepGreenValue());
		this.dataEffectCurrent.updateBlueValue(_transitionSettings.getStepBlueValue());
		this.dataEffectCurrent.updateSpeedValue(_transitionSettings.getStepSpeedValue());
		this.dataEffectCurrent.updateEncryptValue(_transitionSettings.getStepEncryptValue());
		this.dataEffectCurrent.updateDistanceValue(_transitionSettings.getStepDistanceValue());
		this.dataEffectCurrent.updateRollValue(_transitionSettings.getStepRollValue());
		this.dataEffectCurrent.updatePitchValue(_transitionSettings.getStepPitchValue());
		}

	/**
	 * Updates the {@link DataEffectCurrent} values with the values at the end of the transition.
	 * @param _dataEffect
	 */
	private void updateDataEffectCurrentTransitionEnded(DataEffect_A _dataEffect)
		{
		this.dataEffectCurrent.setRedValue(_dataEffect.getRedValue());
		this.dataEffectCurrent.setGreenValue(_dataEffect.getGreenValue());
		this.dataEffectCurrent.setBlueValue(_dataEffect.getBlueValue());
		this.dataEffectCurrent.setSpeedValue(_dataEffect.getSpeedValue());
		this.dataEffectCurrent.setEncryptValue(_dataEffect.getEncryptValue());
		this.dataEffectCurrent.setDistanceValue(_dataEffect.getDistanceValue());
		this.dataEffectCurrent.setRollValue(_dataEffect.getRollValue());
		this.dataEffectCurrent.setPitchValue(_dataEffect.getPitchValue());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private boolean isHandDetected;

	private double velocityCurrent;

	private TransitionSettingsNoUserToUserCrypted transitionSettingsNoUserToUserCrypted;
	private TransitionSettingsUserCryptedToUserDecrypted transitionSettingsUserCryptedToUserDecrypted;
	private TransitionSettingsUserDecryptedInactiv transitionSettingsUserDecryptedInactiv;
	private TransitionSettingsUserDecryptedToUserCrypted transitionUserDecryptedToUserCrypted;
	private TransitionSettingsToNoUser transitionToNoUser;

	//Outputs
	private DataEffectCurrent dataEffectCurrent;

	//Tools
	private boolean isTransitionRunning;
	private boolean isEnable;

	private double durationNoUserToUserCryptedSeconds;

	private double durationToNoUserSeconds;
	private double durationUserCryptedToUserDecryptedSeconds;
	private double durationUserDecryptedToUserCryptedSeconds;
	private double durationUserDecryptedInactivSeconds;

	private double velocityMinDecrypt;
	private double velocityMinInactiv;

	private int updateRate;

	private long durationNoUserToUserCryptedMillis;
	private long durationNoUserEncryptToNoUserMillis;
	private long durationUserDecryptToUserDecryptedMillis;
	private long durationUserEncryptToUserCryptedMillis;
	private long durationUserDecryptedInactiveMillis;

	private DataEffectNoUser dataEffectNoUser;
	private DataEffectUserCrypted dataEffectUserCrypted;
	private DataEffectUserDecrypted dataEffectUserDecrypted;

	private Thread work;

	private ApplicationStateEnum currentState;
	}
