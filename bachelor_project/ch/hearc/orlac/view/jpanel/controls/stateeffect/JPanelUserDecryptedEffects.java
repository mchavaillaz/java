
package ch.hearc.orlac.view.jpanel.controls.stateeffect;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.data.effect.DataEffectUserDecrypted;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.effect.JPanelColors;
import ch.hearc.orlac.view.jpanel.controls.effect.JPanelEncrypt;
import ch.hearc.orlac.view.jpanel.controls.effect.JPanelSpeed;

/**
 * {@link JPanel} to configure the effects for the STATE_USER_DECRYPTED.
 * @author chavailm
 */
public class JPanelUserDecryptedEffects extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelUserDecryptedEffects()
		{
		createComponents();
		addComponents();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the {@link DataEffectUserDecrypted} to the {@link JPanelColors}, {@link JPanelSpeed} and {@link JPanelEncrypt}.
	 * @param _dataEffectCurrent
	 * @param _dataEffectUserDecrypted
	 */
	public void setDataEffectUserDecrypted(DataEffectCurrent _dataEffectCurrent, DataEffectUserDecrypted _dataEffectUserDecrypted)
		{
		this.jPanelColors.setDataEffect(_dataEffectCurrent, _dataEffectUserDecrypted);
		this.jPanelSpeed.setDataEffect(_dataEffectCurrent, _dataEffectUserDecrypted);
		this.jPanelEncrypt.setDataEffect(_dataEffectCurrent, _dataEffectUserDecrypted);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute {@link JPanelColors}.
	 * @return jPanelColors
	 */
	public JPanelColors getjPanelColors()
		{
		return this.jPanelColors;
		}

	/**
	 * Gets the attribute {@link JPanelSpeed}.
	 * @return jPanelSpeed
	 */
	public JPanelSpeed getjPanelSpeed()
		{
		return this.jPanelSpeed;
		}

	/**
	 * Gets the attribute {@link JPanelEncrypt}.
	 * @return jPanelEncrypt
	 */
	public JPanelEncrypt getjPanelEncrypt()
		{
		return this.jPanelEncrypt;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelUserDecryptedEffects}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.jPanelColors = new JPanelColors(Settings.JSLIDER_USER_DECRYPTED_COLOR_MIN, Settings.JSLIDER_USER_DECRYPTED_COLOR_MAX, Settings.JSLIDER_USER_DECRYPTED_RED_INIT, Settings.JSLIDER_USER_DECRYPTED_GREEN_INIT, Settings.JSLIDER_USER_DECRYPTED_BLUE_INIT);
		this.jPanelSpeed = new JPanelSpeed(Settings.JSLIDER_SPEED_MIN, Settings.JSLIDER_SPEED_MAX, Settings.JSLIDER_USER_DECRYPTED_SPEED_INIT);
		this.jPanelEncrypt = new JPanelEncrypt(Settings.JSLIDER_ENCRYPT_MIN, Settings.JSLIDER_ENCRYPT_MAX, Settings.JSLIDER_USER_DECRYPTED_ENCRYPT_INIT);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelUserDecryptedEffects} Layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelColors);
		this.vBox.add(this.jPanelSpeed);
		this.vBox.add(this.jPanelEncrypt);

		this.add(this.vBox, BorderLayout.NORTH);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelColors jPanelColors;
	private JPanelSpeed jPanelSpeed;
	private JPanelEncrypt jPanelEncrypt;

	private Box vBox;
	}
