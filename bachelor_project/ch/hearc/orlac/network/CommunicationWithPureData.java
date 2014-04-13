
package ch.hearc.orlac.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPortOut;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.tools.Settings;

/**
 * Creates a communication with Pure Data using TCP protocol.
 * @author chavailm
 */
public class CommunicationWithPureData extends Thread
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public CommunicationWithPureData()
		{
		this.updateRate = Settings.NETWORK_UPDATE_RATE;
		this.isRunning = false;
		this.isPureDataConnected = false;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Connection to Pure Data using the attributes ipAdressPureData and portPureData.
	 * @param _portNumberPureDataAudio
	 * @param _portNumberPureDataVideo
	 * @param _ipAddressPureData
	 * @return isConnected, true = success, false = failed
	 */
	public boolean connectToPureData(String _ipAddressPureData, int _portNumberPureDataAudio, int _portNumberPureDataVideo)
		{
		try
			{
			if (_portNumberPureDataAudio <= 0)
				{
				JOptionPane.showMessageDialog(null, "Error: invalid port number:" + _portNumberPureDataAudio + "!");
				this.isPureDataConnected = false;
				}
			else if (_portNumberPureDataVideo <= 0)
				{
				JOptionPane.showMessageDialog(null, "Error: invalid port number:" + _portNumberPureDataVideo + "!");
				this.isPureDataConnected = false;
				}
			else
				{
				this.inetAddressPureData = InetAddress.getByName(_ipAddressPureData);
				this.senderAudio = new OSCPortOut(this.inetAddressPureData, _portNumberPureDataAudio);
				this.senderVideo = new OSCPortOut(this.inetAddressPureData, _portNumberPureDataVideo);
				this.isPureDataConnected = true;
				}
			}
		catch (UnknownHostException e1)
			{
			this.isPureDataConnected = false;
			JOptionPane.showMessageDialog(null, "Error: unknown host address:port " + _ipAddressPureData + ":" + _portNumberPureDataAudio + "!");
			}
		catch (Exception e2)
			{
			this.isPureDataConnected = false;
			JOptionPane.showMessageDialog(null, "Error: " + e2.toString());
			}

		return this.isPureDataConnected;
		}

	/**
	 * This method sends messages to Pure Data every updateRate.
	 * updateRate is in [ms]
	 */
	@Override
	public void run()
		{
		while(isRunning)
			{
			sendMessageOSC();
			try
				{
				sleep(this.updateRate);
				}
			catch (Exception e)
				{
				System.err.println("CommunicationWithPureData run() failed: " + e.toString());
				}
			}
		}

	/**
	 * Starts the thread that sends messages to Pure Data.
	 */
	public void startSendingMessages()
		{
		if (this.isPureDataConnected && !this.isRunning)
			{
			this.isRunning = true;
			this.start();
			}
		}

	/**
	 * Closes the connection with Pure Data and free ressources.
	 */
	public void closePureDataConnection()
		{
		this.isPureDataConnected = false;
		this.isRunning = false;

		if (this.senderAudio != null && this.senderVideo != null)
			{
			this.senderAudio.close();
			this.senderVideo.close();
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the attribute dataEffect.
	 * @param _dataEffectCurrent
	 */
	public void setDataEffect(DataEffectCurrent _dataEffectCurrent)
		{
		this.dataEffectCurrent = _dataEffectCurrent;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Sends a message OSC to Pure Data using OSCPortOut sender attribute.
	 */
	private void sendMessageOSC()
		{
		try
			{
			for(OSCMessage msg:buildMessages())
				{
				senderAudio.send(msg);
				senderVideo.send(msg);
				}
			}
		catch (Exception e)
			{
			System.err.println("CommunicationWithPureData sendMessageOSC() failed: " + e.toString());
			}
		}

	/**
	 * Creates a List that contains all the OSCMessage for the audio and video effects.
	 * @return ArrayList &ltOSCMessage &gt
	 */
	private ArrayList<OSCMessage> buildMessages()
		{
		ArrayList<OSCMessage> listMessages = new ArrayList<OSCMessage>();

		listMessages.add(buildMessageAudioSpeed());

		listMessages.add(buildMessageVideoColor());

		listMessages.add(buildMessageVideoEncrypt());

		listMessages.add(buildMessageVideoDistance());

		listMessages.add(buildMessageVideoRotation());

		return listMessages;
		}

	/**
	 * Creates OSCMessage for the video color RGB. </br>
	 * The format of the message is /video/color red green blue.</br>
	 * @return OSCMessage for the color RGB.
	 */
	private OSCMessage buildMessageVideoColor()
		{
		Object argsRGB[] = new Object[3];
		argsRGB[0] = new Float(this.dataEffectCurrent.getRedValue());
		argsRGB[1] = new Float(this.dataEffectCurrent.getGreenValue());
		argsRGB[2] = new Float(this.dataEffectCurrent.getBlueValue());

		return new OSCMessage("/video/color", argsRGB);
		}

	/**
	 * Creates OSCMessage for the video encrypt effect. </br>
	 * The format of the message is /video/encrypt encryptValue. </br>
	 * @return OSCMessage for the encrypt effect value.
	 */
	private OSCMessage buildMessageVideoEncrypt()
		{
		Object argEncrypt[] = new Object[1];
		argEncrypt[0] = new Float(this.dataEffectCurrent.getEncryptValue());

		return new OSCMessage("/video/encrypt", argEncrypt);
		}

	/**
	 * Creates OSCMessage for the distance. </br>
	 * The format is /video/distance distanceValue.
	 * @return OSCMessage
	 */
	private OSCMessage buildMessageVideoDistance()
		{
		Object argDistance[] = new Object[1];
		argDistance[0] = new Float(this.dataEffectCurrent.getDistanceValue());

		return new OSCMessage("/video/distance", argDistance);
		}

	/**
	 * Creates OSCMessage for the speed. </br>
	 * The format is /audio/speed SPEED_MIN SPEED_MAX currentSpeed. </br>
	 * @return OSCMessage for the speed
	 */
	private OSCMessage buildMessageAudioSpeed()
		{
		Object argSpeed[] = new Object[3];
		argSpeed[0] = new Float(Settings.SPEED_ARC_LENGTH_MIN);
		argSpeed[1] = new Float(Settings.SPEED_ARC_LENGTH_MAX);
		argSpeed[2] = new Float(this.dataEffectCurrent.getSpeedValue());

		return new OSCMessage("/audio/speed", argSpeed);
		}

	/**
	 * Creates OSCMessage for the rotation. </br>
	 * The format is /video/rotation rollValue pitchValue.
	 * @return OSCMessage for the rotation
	 */
	private OSCMessage buildMessageVideoRotation()
		{
		Object argRotation[] = new Object[2];
		argRotation[0] = new Float(this.dataEffectCurrent.getRollValue());
		argRotation[1] = new Float(this.dataEffectCurrent.getPitchValue());

		return new OSCMessage("/video/rotation", argRotation);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Input
	private InetAddress inetAddressPureData;

	private OSCPortOut senderAudio;
	private OSCPortOut senderVideo;

	private int updateRate;

	private DataEffectCurrent dataEffectCurrent;

	//Tools
	private boolean isRunning;
	private boolean isPureDataConnected;
	}
