
package ch.hearc.orlac.view.jpanel.controls.stateeffect;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.data.effect.DataEffectNoUser;
import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.effect.JPanelColors;
import ch.hearc.orlac.view.jpanel.controls.effect.JPanelEncrypt;
import ch.hearc.orlac.view.jpanel.controls.effect.JPanelSpeed;

/**
 * {@link JPanel} to configure the effects for the STATE_NO_USER.
 * @author chavailm
 */
public class JPanelNoUserEffects extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelNoUserEffects()
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
	 * Sets the {@link DataEffectNoUser} to the {@link JPanelColors}, {@link JPanelSpeed} and the {@link JPanelEncrypt}.
	 * @param _dataEffectCurrent
	 * @param _dataEffectNoUser
	 */
	public void setDataEffectNoUser(DataEffectCurrent _dataEffectCurrent, DataEffectNoUser _dataEffectNoUser)
		{
		this.jPanelColors.setDataEffect(_dataEffectCurrent, _dataEffectNoUser);
		this.jPanelSpeed.setDataEffect(_dataEffectCurrent, _dataEffectNoUser);
		this.jPanelEncrypt.setDataEffect(_dataEffectCurrent, _dataEffectNoUser);
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
	 * Creates all the components containted in the {@link JPanelNoUserEffects}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.jPanelColors = new JPanelColors(Settings.JSLIDER_NO_USER_COLOR_MIN, Settings.JSLIDER_NO_USER_COLOR_MAX, Settings.JSLIDER_NO_USER_RED_INIT, Settings.JSLIDER_NO_USER_GREEN_INIT, Settings.JSLIDER_NO_USER_BLUE_INIT);
		this.jPanelSpeed = new JPanelSpeed(Settings.JSLIDER_SPEED_MIN, Settings.JSLIDER_SPEED_MAX, Settings.JSLIDER_NO_USER_SPEED_INIT);
		this.jPanelEncrypt = new JPanelEncrypt(Settings.JSLIDER_ENCRYPT_MIN, Settings.JSLIDER_ENCRYPT_MAX, Settings.JSLIDER_NO_USER_ENCRYPT_INIT);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelNoUserEffects} Layout.
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
