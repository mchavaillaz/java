
package ch.hearc.orlac.view.jpanel.controls.connection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import ch.hearc.orlac.leapmotion.GestureAnalysis;

/**
 * JPanel contains JPanels to configure ip address and port number and connect to Pure Data
 * @author chavailm
 */
public class JPanelConnection extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelConnection()
		{
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
	 * Sets the attribute {@link GestureAnalysis}.
	 * @param _gestureAnalysis
	 */
	public void setGestureAnalysis(GestureAnalysis _gestureAnalysis)
		{
		this.gestureAnalysis = _gestureAnalysis;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute {@link JPanelIpAddressPureData}.
	 * @return jPanelIpAddressPureData
	 */
	public JPanelIpAddressPureData getjPanelIpAddressPureData()
		{
		return this.jPanelIpAddressPureData;
		}

	/**
	 * Gets the audio attribute {@link JPanelPortNumberPureData}.
	 * @return jPanelPortNumberPureDataAudio
	 */
	public JPanelPortNumberPureData getjPanelPortNumberPureDataAudio()
		{
		return this.jPanelPortNumberPureDataAudio;
		}

	/**
	 * Gets the video attribute {@link JPanelPortNumberPureData}.
	 * @return jPanelPortNumberPureDataVideo
	 */
	public JPanelPortNumberPureData getjPanelPortNumberPureDataVideo()
		{
		return this.jPanelPortNumberPureDataVideo;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the JPanelTabbedPane
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.jPanelIpAddressPureData = new JPanelIpAddressPureData();
		this.jPanelPortNumberPureDataAudio = new JPanelPortNumberPureData("Pure Data audio patch port number", "Default 9001", "9001");
		this.jPanelPortNumberPureDataVideo = new JPanelPortNumberPureData("Pure Data video patch port number", "Default 9002", "9002");

		this.btnConnectToPureData = new JButton("Connect to Pure Data");

		this.vBox = Box.createVerticalBox();
		}

	/**
	 * Adds the components in the JPanelTabbedPane Layout
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelIpAddressPureData);
		this.vBox.add(this.jPanelPortNumberPureDataAudio);
		this.vBox.add(this.jPanelPortNumberPureDataVideo);

		Box boxH1 = Box.createHorizontalBox();
		boxH1.add(Box.createHorizontalGlue());
		boxH1.add(this.btnConnectToPureData);
		boxH1.add(Box.createHorizontalGlue());

		this.vBox.add(boxH1);

		this.add(this.vBox, BorderLayout.NORTH);
		}

	/**
	 * Adds listeners for the attributes
	 */
	private void addListeners()
		{
		this.btnConnectToPureData.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					String ipAddressPureData = jPanelIpAddressPureData.getIpAddressPureData();
					int portNumberPureDataAudio = jPanelPortNumberPureDataAudio.getPortNumberPureDataInteger();
					int portNumberPureDataVideo = jPanelPortNumberPureDataVideo.getPortNumberPureDataInteger();

					gestureAnalysis.connectToPureData(ipAddressPureData, portNumberPureDataAudio, portNumberPureDataVideo);
					}
			});
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JPanelIpAddressPureData jPanelIpAddressPureData;

	private JPanelPortNumberPureData jPanelPortNumberPureDataAudio;
	private JPanelPortNumberPureData jPanelPortNumberPureDataVideo;

	private JButton btnConnectToPureData;

	private Box vBox;

	private GestureAnalysis gestureAnalysis;
	}
