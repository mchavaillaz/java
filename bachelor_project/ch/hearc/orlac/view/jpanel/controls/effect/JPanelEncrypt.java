
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
 * {@link JPanel} to configure the encrypt effect.
 * @author chavailm
 */
public class JPanelEncrypt extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of the {@link JPanelEncrypt}.
	 * @param _minValue for the encrypt {@link JPanelEncrypt}.
	 * @param _maxValue for the encrypt {@link JPanelEncrypt}.
	 * @param _encryptInitValue for the encrypt {@link JPanelEncrypt}.
	 */
	public JPanelEncrypt(int _minValue, int _maxValue, int _encryptInitValue)
		{
		createComponents(_minValue, _maxValue, _encryptInitValue);
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
		this.jPanelSliderEncrypt.setDataEffectCurrent(_dataEffectCurrent);
		this.jPanelSliderEncrypt.setDataEffect(_dataEffectCurrent, _dataEffect);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute {@link JPanelSlider} for the encrypt effect.
	 * @return jPanelSliderEncrypt
	 */
	public JPanelSlider getjPanelSliderEncrypt()
		{
		return this.jPanelSliderEncrypt;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelEncrypt}.
	 * @param _encryptInitValue
	 * @param _maxValue
	 * @param _minValue
	 */
	private void createComponents(int _minValue, int _maxValue, int _encryptInitValue)
		{
		this.setLayout(new BorderLayout());

		this.setBorder(BorderFactory.createTitledBorder("Encrypt settings"));

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(new Integer(0), new JLabel("0%"));
		labelTable.put(new Integer(25), new JLabel("25%"));
		labelTable.put(new Integer(50), new JLabel("50%"));
		labelTable.put(new Integer(75), new JLabel("75%"));
		labelTable.put(new Integer(100), new JLabel("100%"));

		this.jPanelSliderEncrypt = new JPanelSlider("Encrypt", _minValue, _maxValue, _encryptInitValue, labelTable, true);

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the {@link JPanelEncrypt} Layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelSliderEncrypt);

		this.add(this.vBox);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelSlider jPanelSliderEncrypt;

	private Box vBox;
	}
