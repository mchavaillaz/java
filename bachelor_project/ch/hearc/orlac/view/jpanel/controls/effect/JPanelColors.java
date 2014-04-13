
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
 * {@link JPanel} to configure the colors effects.
 * @author chavailm
 */
public class JPanelColors extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of {@link JPanelColors}.
	 * @param _minValue for the {@link JPanelSlider}.
	 * @param _maxValue for the {@link JPanelSlider}.
	 * @param _redInitValue for the red {@link JPanelSlider}.
	 * @param _greenInitValue for the green {@link JPanelSlider}.
	 * @param _blueInitValue for the blue {@link JPanelSlider}.
	 */
	public JPanelColors(int _minValue, int _maxValue, int _redInitValue, int _greenInitValue, int _blueInitValue)
		{
		createComponents(_minValue, _maxValue, _redInitValue, _greenInitValue, _blueInitValue);
		addComponents();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the {@link DataEffect_A} to the {@link JPanelSlider} attributes.
	 * @param _dataEffectCurrent
	 * @param _dataEffect
	 */
	public void setDataEffect(DataEffectCurrent _dataEffectCurrent, DataEffect_A _dataEffect)
		{
		this.jPanelSliderBlue.setDataEffect(_dataEffectCurrent, _dataEffect);
		this.jPanelSliderGreen.setDataEffect(_dataEffectCurrent, _dataEffect);
		this.jPanelSliderRed.setDataEffect(_dataEffectCurrent, _dataEffect);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute {@link JPanelSlider} for the red color.
	 * @return jPanelSliderRed
	 */
	public JPanelSlider getjPanelSliderRed()
		{
		return this.jPanelSliderRed;
		}

	/**
	 * Gets the attribute {@link JPanelSlider} for the green color.
	 * @return jPanelSliderGreen
	 */
	public JPanelSlider getjPanelSliderGreen()
		{
		return this.jPanelSliderGreen;
		}

	/**
	 * Gets the attribute {@link JPanelSlider} for the blue color.
	 * @return jPanelSliderBlue
	 */
	public JPanelSlider getjPanelSliderBlue()
		{
		return this.jPanelSliderBlue;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelColors}.
	 * @param _minValue value min for the JSlider red, green and blue.
	 * @param _maxValue value max for the JSlider red, green and blue.
	 * @param _redInitValue initial value for the JSlider red.
	 * @param _greenInitValue initial value for the JSlider green.
	 * @param _blueInitValue initial value for the JSlider blue.
	 */
	private void createComponents(int _minValue, int _maxValue, int _redInitValue, int _greenInitValue, int _blueInitValue)
		{
		this.setLayout(new BorderLayout());

		this.setBorder(BorderFactory.createTitledBorder("Color settings"));

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(0), new JLabel("0%"));
		labelTable.put(new Integer(25), new JLabel("25%"));
		labelTable.put(new Integer(50), new JLabel("50%"));
		labelTable.put(new Integer(75), new JLabel("75%"));
		labelTable.put(new Integer(100), new JLabel("100%"));

		this.jPanelSliderRed = new JPanelSlider("Red", _minValue, _maxValue, _redInitValue, labelTable, true);
		this.jPanelSliderGreen = new JPanelSlider("Green", _minValue, _maxValue, _greenInitValue, labelTable, true);
		this.jPanelSliderBlue = new JPanelSlider("Blue", _minValue, _maxValue, _blueInitValue, labelTable, true);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelColors} Layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelSliderRed);
		this.vBox.add(this.jPanelSliderGreen);
		this.vBox.add(this.jPanelSliderBlue);

		this.add(this.vBox, BorderLayout.NORTH);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelSlider jPanelSliderRed;
	private JPanelSlider jPanelSliderGreen;
	private JPanelSlider jPanelSliderBlue;

	private Box vBox;
	}
