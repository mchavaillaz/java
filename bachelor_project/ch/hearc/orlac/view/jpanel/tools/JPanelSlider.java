
package ch.hearc.orlac.view.jpanel.tools;

import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.data.effect.DataEffect_A;
import ch.hearc.orlac.data.transition.TransitionSettings_A;

/**
 * {@link JPanel} contains a {@link JSlider} and informations about it, name, min and max value and current value.
 * @author chavailm
 */
public class JPanelSlider extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of {@link JPanelSlider}.
	 * @param _sliderName slider's name
	 * @param _minValue min value the le slider
	 * @param _maxValue max value of the slider
	 * @param _initValue initial value of the slider
	 * @param _labelHashTable label for the slider's scale
	 * @param _isLabelValueVisible enable/disable the visibility of the lblValue
	 */
	public JPanelSlider(String _sliderName, int _minValue, int _maxValue, int _initValue, Hashtable<Integer, JLabel> _labelHashTable, boolean _isLabelValueVisible)
		{
		this.sliderTitle = _sliderName;
		this.minValue = _minValue;
		this.maxValue = _maxValue;
		this.initValue = _initValue;
		this.labelHashTable = _labelHashTable;
		this.isLabelValueVisible = _isLabelValueVisible;

		createComponents();
		addComponents();
		addListeners();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the attributes {@link DataEffectCurrent} and {@link DataEffect_A}.
	 * @param _dataEffectCurrent
	 * @param _dataEffect
	 */
	public void setDataEffect(DataEffectCurrent _dataEffectCurrent, DataEffect_A _dataEffect)
		{
		this.dataEffectCurrent = _dataEffectCurrent;
		this.dataEffect = _dataEffect;
		}

	/**
	 * Sets the attribute {@link DataEffectCurrent}.
	 * @param _dataEffectCurrent
	 */
	public void setDataEffectCurrent(DataEffectCurrent _dataEffectCurrent)
		{
		this.dataEffectCurrent = _dataEffectCurrent;
		}

	/**
	 * Sets the attribute {@link TransitionSettings_A}.
	 * @param _transitionSettings
	 */
	public void setTransitionSettings(TransitionSettings_A _transitionSettings)
		{
		this.transitionSettings = _transitionSettings;
		}

	/**
	 * Sets the current value of the {@link JSlider} attribute.</br>
	 * @param _currentValue
	 */
	public void setjSliderCurrentValue(int _currentValue)
		{
		this.jSlider.setValue(_currentValue);

		// Updates the DataEffectCurrent attribute wit the current value.
		updateDataWithRestoredValue(_currentValue);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the {@link JSlider} current value.
	 * @return jSliderCurrentValue
	 */
	public int getjSliderCurrentValue()
		{
		return this.jSlider.getValue();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Creates all the components containted in the {@link JPanelSlider}.
	 */
	private void createComponents()
		{
		this.jSlider = new JSlider();
		this.lblSliderTitle = new JLabel(this.sliderTitle);
		this.lblSliderValue = new JLabel("Value=" + String.valueOf(this.initValue) + "%");

		configureComponents();
		}

	/**
	 * Configure the attribute {@link JSlider} with minor and major tick spacing.
	 * Configure the visibility of the attribute {@link JLabel}.
	 */
	private void configureComponents()
		{
		this.jSlider.setMinimum(this.minValue);
		this.jSlider.setMaximum(this.maxValue);
		this.jSlider.setValue(this.initValue);
		this.jSlider.setMajorTickSpacing(this.maxValue / 4);
		this.jSlider.setMinorTickSpacing(5);
		this.jSlider.setLabelTable(this.labelHashTable);
		this.jSlider.setPaintLabels(true);
		this.jSlider.setPaintTicks(true);

		this.lblSliderValue.setVisible(this.isLabelValueVisible);
		}

	/**
	 * Adds the components in the {@link JPanelSlider} Layout.
	 */
	private void addComponents()
		{
		this.add(this.lblSliderTitle);
		this.add(this.jSlider);
		this.add(this.lblSliderValue);
		}

	/**
	 * Adds listeners for the attributes.
	 */
	private void addListeners()
		{
		this.jSlider.addChangeListener(new ChangeListener()
			{

				@Override
				public void stateChanged(ChangeEvent e)
					{
					double newValue = jSlider.getValue() / 100.0;

					if (transitionSettings != null)
						{
						transitionSettings.setTransitionVelocityMin(newValue);
						}
					else if (dataEffect != null)
						{
						if (sliderTitle.equals("Red"))
							{
							dataEffectCurrent.setRedValue(newValue);
							dataEffect.setRedValue(newValue);
							}
						else if (sliderTitle.equals("Green"))
							{
							dataEffectCurrent.setGreenValue(newValue);
							dataEffect.setGreenValue(newValue);
							}
						else if (sliderTitle.equals("Blue"))
							{
							dataEffectCurrent.setBlueValue(newValue);
							dataEffect.setBlueValue(newValue);
							}
						else if (sliderTitle.equals("Speed"))
							{
							dataEffectCurrent.setSpeedValueUnconverted(newValue);
							dataEffect.setSpeedValue(newValue);
							}
						else if (sliderTitle.equals("Encrypt"))
							{
							dataEffectCurrent.setEncryptValue(newValue);
							dataEffect.setEncryptValue(newValue);
							}
						}
					lblSliderValue.setText("Value=" + String.valueOf(jSlider.getValue()) + "%");

					}
			});
		}

	/**
	 * * Updates the current values in {@link DataEffect_A} and {@link TransitionSettings_A} with the restored value.
	 * @param _currentValue
	 */
	private void updateDataWithRestoredValue(int _currentValue)
		{
		double newValue = _currentValue / 100.0;

		if (transitionSettings != null)
			{
			transitionSettings.setTransitionVelocityMin(newValue);
			}
		else if (dataEffect != null)
			{
			if (sliderTitle.equals("Red"))
				{
				dataEffectCurrent.setRedValue(newValue);
				dataEffect.setRedValue(newValue);
				}
			else if (sliderTitle.equals("Green"))
				{
				dataEffectCurrent.setGreenValue(newValue);
				dataEffect.setGreenValue(newValue);
				}
			else if (sliderTitle.equals("Blue"))
				{
				dataEffectCurrent.setBlueValue(newValue);
				dataEffect.setBlueValue(newValue);
				}
			else if (sliderTitle.equals("Speed"))
				{
				dataEffectCurrent.setSpeedValueUnconverted(newValue);
				dataEffect.setSpeedValue(newValue);
				}
			else if (sliderTitle.equals("Encrypt"))
				{
				dataEffectCurrent.setEncryptValue(newValue);
				dataEffect.setEncryptValue(newValue);
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private String sliderTitle;

	private int minValue;
	private int maxValue;
	private int initValue;

	private boolean isLabelValueVisible;

	//Outputs
	private TransitionSettings_A transitionSettings;
	private DataEffect_A dataEffect;
	private DataEffectCurrent dataEffectCurrent;

	//Tools
	private JLabel lblSliderTitle;
	private JLabel lblSliderValue;

	private JSlider jSlider;

	Hashtable<Integer, JLabel> labelHashTable;
	}
