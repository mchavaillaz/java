
package ch.hearc.orlac.view.jpanel.information;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * {@link JPanel} to notify the states of the application: connection state with Pure Data, connection state with the Leap Motion
 * @author chavailm
 */
public class JPanelApplicationState extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelApplicationState()
		{
		createComponents();
		addComponents();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Update the color of {@link JPanelColoredState} with the current state of the connection with Pure Data
	 * @param _isConnected
	 */
	public void updateJPanelColoredStateConnectionWithPureData(boolean _isConnected)
		{
		if (_isConnected)
			{
			this.jPanelColoredStateConnectionPureData.setColoredStateOK();
			}
		else
			{
			this.jPanelColoredStateConnectionPureData.setColoredStateKO();
			}
		}

	/**
	 * Update the color of {@link JPanelColoredState} with the current state of the connection with the Leap Motion
	 * @param _isLeapMotionConnected
	 */
	public void updateJPanelColoredStateConnectionWithLeapMotion(boolean _isLeapMotionConnected)
		{
		if (_isLeapMotionConnected)
			{
			this.jPanelColoredStateConnectionLeapMotion.setColoredStateOK();
			}
		else
			{
			this.jPanelColoredStateConnectionLeapMotion.setColoredStateKO();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the {@link JPanelApplicationState}.
	 */
	private void createComponents()
		{
		this.lblConnectionWithPureDataState = new JLabel("Connection with Pure Data");
		this.lblConnectionWithLeapMotionState = new JLabel("Connection with the Leap Motion");
		this.jPanelColoredStateConnectionPureData = new JPanelColoredState();
		this.jPanelColoredStateConnectionLeapMotion = new JPanelColoredState();
		}

	/**
	 * Adds the components in the {@link JPanelApplicationState} Layout.
	 */
	private void addComponents()
		{
		this.add(this.lblConnectionWithPureDataState);
		this.add(this.jPanelColoredStateConnectionPureData);
		this.add(this.lblConnectionWithLeapMotionState);
		this.add(this.jPanelColoredStateConnectionLeapMotion);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JLabel lblConnectionWithPureDataState;
	private JLabel lblConnectionWithLeapMotionState;

	private JPanelColoredState jPanelColoredStateConnectionPureData;
	private JPanelColoredState jPanelColoredStateConnectionLeapMotion;
	}
