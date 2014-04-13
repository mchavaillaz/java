
package ch.hearc.orlac.view.jpanel.controls.connection;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.hearc.orlac.tools.Settings;

/**
 * JPanel contains components to configure ip address of Pure Data.
 * @author chavailm
 *
 */
public class JPanelIpAddressPureData extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelIpAddressPureData()
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
	 * Sets the ip address of the txtIpAddressPureData attribute.
	 * @param _ipAddress
	 */
	public void setIpAddress(String _ipAddress)
		{
		this.txtIpAddressPureData.setText(_ipAddress);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the ip address of Pure Data application.
	 * @return ipAddressPureData
	 */
	public String getIpAddressPureData()
		{
		String ipAddressPureData = this.txtIpAddressPureData.getText();

		if (ipAddressPureData.isEmpty())
			{
			ipAddressPureData = "empty";
			}

		return ipAddressPureData;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelIpAddressPureData}.
	 */
	private void createComponents()
		{
		this.lblIpAddressPureData = new JLabel("Ip Address Pure Data");
		this.txtIpAddressPureData = new JTextField(Settings.IP_ADDRESS_PURE_DATA, 10);
		}

	/**
	 * Adds the components in the {@link JPanelIpAddressPureData} Layout.
	 */
	private void addComponents()
		{
		this.add(this.lblIpAddressPureData);
		this.add(this.txtIpAddressPureData);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JLabel lblIpAddressPureData;
	private JTextField txtIpAddressPureData;
	}
