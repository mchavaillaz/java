
package ch.hearc.orlac.preferences.network;

import java.util.prefs.Preferences;

import ch.hearc.orlac.tools.Settings;
import ch.hearc.orlac.view.jpanel.controls.connection.JPanelConnection;
import ch.hearc.orlac.view.jpanel.controls.connection.JPanelIpAddressPureData;
import ch.hearc.orlac.view.jpanel.controls.connection.JPanelPortNumberPureData;

/**
 * Saves and restores {@link Preferences} of the attributes in {@link JPanelConnection}.
 * @author chavailm
 */
public class PreferencesNetwork
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of NetworkPreferences.
	 * @param _jPanelIpAddressPureData
	 * @param _jPanelPortNumberAudioPureData
	 * @param _jPanelPortNumberVideoPureData
	 */
	public PreferencesNetwork(JPanelIpAddressPureData _jPanelIpAddressPureData, JPanelPortNumberPureData _jPanelPortNumberAudioPureData, JPanelPortNumberPureData _jPanelPortNumberVideoPureData)
		{
		this.networkPreferences = Preferences.userRoot().node(this.getClass().getName());

		this.jPanelIpAddressPureData = _jPanelIpAddressPureData;
		this.jPanelPortNumberAudioPureData = _jPanelPortNumberAudioPureData;
		this.jPanelPortNumberVideoPureData = _jPanelPortNumberVideoPureData;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public void savePreferences()
		{
		this.networkPreferences.put(this.paraIpAddress, this.jPanelIpAddressPureData.getIpAddressPureData());
		this.networkPreferences.put(this.paraPortNumberAudio, this.jPanelPortNumberAudioPureData.getPortNumberPureDataString());
		this.networkPreferences.put(this.paraPortNumberVideo, this.jPanelPortNumberVideoPureData.getPortNumberPureDataString());
		}

	public void restorePreferences()
		{
		String idAddress = this.networkPreferences.get(this.paraIpAddress, Settings.IP_ADDRESS_PURE_DATA);
		String portNumberAudio = this.networkPreferences.get(this.paraPortNumberAudio, Settings.PORT_NUMBER_PURE_DATA_AUDIO);
		String portNumberVideo = this.networkPreferences.get(this.paraPortNumberVideo, Settings.PORT_NUMBER_PURE_DATA_VIDEO);

		this.jPanelIpAddressPureData.setIpAddress(idAddress);
		this.jPanelPortNumberAudioPureData.setPortNumberPureData(portNumberAudio);
		this.jPanelPortNumberVideoPureData.setPortNumberPureData(portNumberVideo);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Inputs
	private JPanelIpAddressPureData jPanelIpAddressPureData;
	private JPanelPortNumberPureData jPanelPortNumberAudioPureData;
	private JPanelPortNumberPureData jPanelPortNumberVideoPureData;

	//Tools
	private Preferences networkPreferences;

	private final String paraIpAddress = "ipAddress";
	private final String paraPortNumberAudio = "portNumberAudio";
	private final String paraPortNumberVideo = "portNumberVideo";
	}
