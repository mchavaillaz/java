
package ch.hearc.orlac.view.jpanel.tools;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hearc.orlac.data.transition.TransitionSettings_A;
import ch.hearc.orlac.tools.Settings;

/**
 * {@link JPanel} contains a {@link JSpinner} and informations such as the name, min and max value and current value of the {@link JSpinner}.
 * @author chavailm
 */
public class JPanelSpinner extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constuctor of {@link JPanelSpinner}.
	 * @param _spinnerTitle spinner's name.
	 * @param _spinnerInformation spinner's information.
	 * @param _minValue min value of the spinner.
	 * @param _maxValue max value of the spinner.
	 * @param _initValue initial value of the spinner.
	 * @param _stepValue step value of the spinner.
	 */
	public JPanelSpinner(String _spinnerTitle, String _spinnerInformation, double _minValue, double _maxValue, double _initValue, double _stepValue)
		{
		this.spinnerTitle = _spinnerTitle;
		this.spinnerInformation = _spinnerInformation;
		this.minValue = _minValue;
		this.maxValue = _maxValue;
		this.initValue = _initValue;
		this.stepValue = _stepValue;

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
	 * Sets the attribute {@link TransitionSettings_A}.
	 * @param _transitionSettings
	 */
	public void setTransitionSettings(TransitionSettings_A _transitionSettings)
		{
		this.transitionSettings = _transitionSettings;
		}

	/**
	 * Sets the current value of the {@link JSpinner} attribute.</br>
	 * @param _currentValue
	 */
	public void setjSpinnerCurrentValue(double _currentValue)
		{
		this.jSpinnerTransitionDuration.setValue(_currentValue);

		updateDataWithRestoredValue(_currentValue);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/**
	 * Gets the current value of the {@link JSpinner}.
	 * @return jSpinnerTransitionDurationCurrentValue
	 */
	public double getjSpinnerCurrentValue()
		{
		return (Double)this.jSpinnerTransitionDuration.getValue();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Creates all the components containted in the {@link JPanelSpinner}.
	 */
	private void createComponents()
		{
		this.jSpinnerTransitionDuration = new JSpinner();
		this.lblSpinnerInformation = new JLabel(this.spinnerInformation);
		this.lblSpinnerTitle = new JLabel(this.spinnerTitle);

		configureJSpinner();
		}

	/**
	 * Configures the {@link JSpinner}.
	 */
	private void configureJSpinner()
		{
		this.spinnerNumberModel = new SpinnerNumberModel(this.initValue, this.minValue, this.maxValue, this.stepValue);
		this.jSpinnerTransitionDuration.setModel(this.spinnerNumberModel);

		JComponent jSpinnerEditor = jSpinnerTransitionDuration.getEditor();
		jSpinnerEditor.setPreferredSize(new Dimension(Settings.JSPINNER_WIDTH, Settings.JSPINNER_HEIGHT));
		}

	/**
	 * Adds the components in the {@link JPanelSpinner} Layout.
	 */
	private void addComponents()
		{
		this.add(this.lblSpinnerTitle);
		this.add(this.jSpinnerTransitionDuration);
		this.add(this.lblSpinnerInformation);
		}

	/**
	 * Adds listeners for the attributes.
	 */
	private void addListeners()
		{
		this.jSpinnerTransitionDuration.addChangeListener(new ChangeListener()
			{

				@Override
				public void stateChanged(ChangeEvent e)
					{
					double newValue = (Double)spinnerNumberModel.getValue();

					if (transitionSettings != null)
						{
						transitionSettings.setTransitionDurationInSeconds(newValue);
						}
					else if (spinnerTitle.equals("Number of circle"))
						{
						Settings.setCircleNumber(newValue);
						}
					else if (spinnerTitle.equals("Circle radius"))
						{
						Settings.setCircleRadius(newValue);
						}
					}
			});
		}

	/**
	 * Updates the current values in {@link TransitionSettings_A} with the restored value.
	 * @param _currentValue
	 */
	private void updateDataWithRestoredValue(double _currentValue)
		{
		if (transitionSettings != null)
			{
			transitionSettings.setTransitionDurationInSeconds(_currentValue);
			}
		else if (spinnerTitle.equals("Number of circle"))
			{
			Settings.setCircleNumber(_currentValue);
			}
		else if (spinnerTitle.equals("Circle radius"))
			{
			Settings.setCircleRadius(_currentValue);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private String spinnerTitle;
	private String spinnerInformation;

	private double minValue;
	private double maxValue;
	private double initValue;
	private double stepValue;

	//Outputs
	private TransitionSettings_A transitionSettings;

	//Tools
	private JSpinner jSpinnerTransitionDuration;

	private JLabel lblSpinnerTitle;
	private JLabel lblSpinnerInformation;

	private SpinnerNumberModel spinnerNumberModel;
	}
