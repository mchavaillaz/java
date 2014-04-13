
package ch.hearc.orlac.view.jpanel.controls.stateeffect;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.data.effect.DataEffectUserCrypted;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.effect.JPanelColors;
import ch.hearc.orlac.view.jpanel.controls.effect.JPanelEncrypt;
import ch.hearc.orlac.view.jpanel.controls.effect.JPanelSpeed;

/**
 * {@link JPanel} to configure the effects for the STATE_USER_CRYPTED.
 * @author chavailm
 */
public class JPanelUserCryptedEffects extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelUserCryptedEffects()
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
	 * Sets the {@link DataEffectUserCrypted} to the {@link JPanelColors}, {@link JPanelSpeed} and {@link JPanelEncrypt}.
	 * @param _dataEffectCurrent
	 * @param _dataEffectUserCrypted
	 */
	public void setDataEffectUserCrypted(DataEffectCurrent _dataEffectCurrent, DataEffectUserCrypted _dataEffectUserCrypted)
		{
		this.jPanelColors.setDataEffect(_dataEffectCurrent, _dataEffectUserCrypted);
		this.jPanelSpeed.setDataEffect(_dataEffectCurrent, _dataEffectUserCrypted);
		this.jPanelEncrypt.setDataEffect(_dataEffectCurrent, _dataEffectUserCrypted);
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
	 * Creates all the components containted in the {@link JPanelUserCryptedEffects}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.jPanelColors = new JPanelColors(Settings.JSLIDER_USER_CRYPTED_COLOR_MIN, Settings.JSLIDER_USER_CRYPTED_COLOR_MAX, Settings.JSLIDER_USER_CRYPTED_RED_INIT, Settings.JSLIDER_USER_CRYPTED_GREEN_INIT, Settings.JSLIDER_USER_CRYPTED_BLUE_INIT);
		this.jPanelSpeed = new JPanelSpeed(Settings.JSLIDER_SPEED_MIN, Settings.JSLIDER_SPEED_MAX, Settings.JSLIDER_USER_CRYPTED_SPEED_INIT);
		this.jPanelEncrypt = new JPanelEncrypt(Settings.JSLIDER_ENCRYPT_MIN, Settings.JSLIDER_ENCRYPT_MAX, Settings.JSLIDER_USER_CRYPTED_ENCRYPT_INIT);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelUserCryptedEffects} Layout.
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
