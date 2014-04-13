
package ch.hearc.orlac.view.jpanel.controls.effect;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.data.effect.DataEffect_A;
import ch.hearc.orlac.view.jpanel.tools.JPanelSlider;

/**
 * {@link JPanel} to configure the speed effect.
 * @author chavailm
 */
public class JPanelSpeed extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of the {@link JPanelSpeed}.
	 * @param _minValue for the speed {@link JPanelSlider}.
	 * @param _maxValue fo the speed {@link JPanelSlider}.
	 * @param _speedInitValue fot the speed {@link JPanelSlider}.
	 */
	public JPanelSpeed(int _minValue, int _maxValue, int _speedInitValue)
		{
		createComponents(_minValue, _maxValue, _speedInitValue);
		addComponents();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the {@link DataEffect_A} to the {@link JPanelSlider} attribute.
	 * @param _dataEffectCurrent
	 * @param _dataEffect
	 */
	public void setDataEffect(DataEffectCurrent _dataEffectCurrent, DataEffect_A _dataEffect)
		{
		this.jPanelSliderSpeed.setDataEffect(_dataEffectCurrent, _dataEffect);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute {@link JPanelSlider} for the speed effect.
	 * @return jPanelSliderSpeed
	 */
	public JPanelSlider getjPanelSliderSpeed()
		{
		return this.jPanelSliderSpeed;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelSpeed}.
	 * @param _speedInitValue for the speed {@link JPanelSlider}.
	 * @param _maxValue for the speed {@link JPanelSlider}.
	 * @param _minValue for the speed {@link JPanelSlider}.
	 */
	private void createComponents(int _minValue, int _maxValue, int _speedInitValue)
		{
		this.setLayout(new BorderLayout());

		this.setBorder(BorderFactory.createTitledBorder("Speed settings"));

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(-200), new JLabel("-200%"));
		labelTable.put(new Integer(-100), new JLabel("-100%"));
		labelTable.put(new Integer(0), new JLabel("0%"));
		labelTable.put(new Integer(100), new JLabel("100%"));
		labelTable.put(new Integer(200), new JLabel("200%"));

		this.jPanelSliderSpeed = new JPanelSlider("Speed", _minValue, _maxValue, _speedInitValue, labelTable, true);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelSpeed} Layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelSliderSpeed);

		this.add(this.vBox);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelSlider jPanelSliderSpeed;

	private Box vBox;
	}
