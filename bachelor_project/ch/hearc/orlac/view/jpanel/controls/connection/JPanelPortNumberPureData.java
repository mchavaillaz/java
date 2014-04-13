
package ch.hearc.orlac.view.jpanel.controls.connection;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.hearc.orlac.tools.Tools;

/**
 * {@link JPanel} contains components to configure port number of Pure Data
 * @author chavailm
 */
public class JPanelPortNumberPureData extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelPortNumberPureData(String _textLabelPortNumber, String _textLabelPortNumberDefault, String _textPortNumberDefault)
		{
		this.textLabelPortNumber = _textLabelPortNumber;
		this.textLabelPortNumberDefault = _textLabelPortNumberDefault;
		this.textPortNumberDefault = _textPortNumberDefault;

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
	 * Sets the text of the txtPortNumberPureData attribute.
	 * @param _portNumber
	 */
	public void setPortNumberPureData(String _portNumber)
		{
		this.txtPortNumberPureData.setText(_portNumber);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the port number of Pure Data as an Integer.
	 * @return portNumberPureData
	 */
	public int getPortNumberPureDataInteger()
		{
		int portNumber = -1;
		String portNumberString = this.txtPortNumberPureData.getText();

		if (Tools.isNumeric(portNumberString))
			{
			portNumber = new Integer(portNumberString);

			if (portNumber > 65535)
				{
				portNumber = -1;
				}
			}

		return portNumber;
		}

	/**
	 * Gets the port number of Pure Data as a String.
	 * @return portNumber
	 */
	public String getPortNumberPureDataString()
		{
		return this.txtPortNumberPureData.getText();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelPortNumberPureData}.
	 */
	private void createComponents()
		{
		this.lblPortNumberPureData = new JLabel(this.textLabelPortNumber);
		this.lblPortDefaultPureData = new JLabel(this.textLabelPortNumberDefault);

		this.txtPortNumberPureData = new JTextField(this.textPortNumberDefault, 4);
		}

	/**
	 * Adds the components in the {@link JPanelPortNumberPureData} Layout.
	 */
	private void addComponents()
		{
		this.add(this.lblPortNumberPureData);
		this.add(this.txtPortNumberPureData);
		this.add(this.lblPortDefaultPureData);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JLabel lblPortNumberPureData;
	private JLabel lblPortDefaultPureData;

	private JTextField txtPortNumberPureData;

	private String textLabelPortNumber;
	private String textLabelPortNumberDefault;
	private String textPortNumberDefault;
	}
