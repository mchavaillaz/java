
package ch.hearc.orlac.view.jframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ch.hearc.orlac.data.effect.DataEffectCurrent;
import ch.hearc.orlac.data.effect.DataEffectNoUser;
import ch.hearc.orlac.data.effect.DataEffectUserCrypted;
import ch.hearc.orlac.data.effect.DataEffectUserDecrypted;
import ch.hearc.orlac.data.effect.DataEffect_A;
import ch.hearc.orlac.data.transition.TransitionSettingsNoUserToUserCrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsToNoUser;
import ch.hearc.orlac.data.transition.TransitionSettingsUserCryptedToUserDecrypted;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedInactiv;
import ch.hearc.orlac.data.transition.TransitionSettingsUserDecryptedToUserCrypted;
import ch.hearc.orlac.data.transition.TransitionSettings_A;
import ch.hearc.orlac.leapmotion.GestureAnalysis;
import ch.hearc.orlac.tools.OrlacLauncher;
import ch.hearc.orlac.view.jpanel.JPanelTabbedPane;
import ch.hearc.orlac.view.jpanel.information.JPanelApplicationState;

/**
 * Main window of the application.
 * @author chavailm
 */
public class JFrameApplication extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JFrameApplication()
		{
		createComponents();
		addComponents();
		addListeners();
		setProperties();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Updates the {@link JPanelApplicationState} with the current state of the connection with Pure Data.
	 * @param _isConnected
	 */
	public void updateJPanelApplicaitonStatePureData(boolean _isConnected)
		{
		this.jPanelApplicationState.updateJPanelColoredStateConnectionWithPureData(_isConnected);
		}

	/**
	 * Updates the {@link JPanelApplicationState} with the current state of the connection with the Leap Motion.
	 * @param _isConnected
	 */
	public void updateJPanelApplicaitonStateLeapMotion(boolean _isConnected)
		{
		this.jPanelApplicationState.updateJPanelColoredStateConnectionWithLeapMotion(_isConnected);
		}

	/**
	 * Enable the JButton PlayMovie.
	 * @param _isPureDataConnected
	 * @param _isLeapMotionConnected
	 */
	public void enableBtnPlayMovie(boolean _isPureDataConnected, boolean _isLeapMotionConnected)
		{
		if (_isPureDataConnected && _isLeapMotionConnected)
			{
			this.btnLaunchOrlac.setVisible(true);
			this.btnLaunchOrlac.setEnabled(true);
			}
		else
			{
			this.btnLaunchOrlac.setVisible(false);
			this.btnLaunchOrlac.setEnabled(false);
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/**
	 * Sets the attribute gestureAnalysis.
	 * @param _gestureAnalysis
	 */
	public void setGestureAnalysis(GestureAnalysis _gestureAnalysis)
		{
		this.gestureAnalysis = _gestureAnalysis;
		this.jPanelTabbedPane.setGestureAnalysis(_gestureAnalysis);
		}

	/**
	 * Sets all the attributes {@link DataEffect_A} to the {@link JPanel} contained in the {@link JPanelTabbedPane}.
	 * @param _dataEffectCurrent
	 * @param _dataEffectNoUser
	 * @param _dataEffectUserCrypted
	 * @param _dataEffectUserDecrypted
	 */
	public void setDataEffects(DataEffectCurrent _dataEffectCurrent, DataEffectNoUser _dataEffectNoUser, DataEffectUserCrypted _dataEffectUserCrypted, DataEffectUserDecrypted _dataEffectUserDecrypted)
		{
		this.jPanelTabbedPane.setDataEffects(_dataEffectCurrent, _dataEffectNoUser, _dataEffectUserCrypted, _dataEffectUserDecrypted);
		}

	/**
	 * Sets all the attributes {@link TransitionSettings_A} to the {@link JPanel} contained in the {@link JPanelTabbedPane}.
	 * @param _transitionNoUserToUserCrypted
	 * @param _transitionUserCryptedToUserDecrypted
	 * @param _transitionUserDecryptedInactiv
	 * @param _transitionUserDecryptedToUserCrypted
	 * @param _transitionToNoUser
	 */
	public void setTransitionSettings(TransitionSettingsNoUserToUserCrypted _transitionNoUserToUserCrypted, TransitionSettingsUserCryptedToUserDecrypted _transitionUserCryptedToUserDecrypted, TransitionSettingsUserDecryptedInactiv _transitionUserDecryptedInactiv,
			TransitionSettingsUserDecryptedToUserCrypted _transitionUserDecryptedToUserCrypted, TransitionSettingsToNoUser _transitionToNoUser)
		{
		this.jPanelTabbedPane.setTransitionSettings(_transitionNoUserToUserCrypted, _transitionUserCryptedToUserDecrypted, _transitionUserDecryptedInactiv, _transitionUserDecryptedToUserCrypted, _transitionToNoUser);
		}

	/**
	 * Sets the attribute {@link OrlacLauncher}.
	 * @param _orlacLauncher
	 */
	public void setOrlacLauncher(OrlacLauncher _orlacLauncher)
		{
		this.orlacLauncher = _orlacLauncher;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	/**
	 * Gets the attribute {@link JPanelTabbedPane}.
	 * @return jPanelTabbedPane
	 */
	public JPanelTabbedPane getjPanelTabbedPane()
		{
		return this.jPanelTabbedPane;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components containted in the Main Frame.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.menuBar = new JMenuBar();

		this.menuFile = new JMenu("File");
		this.menuHelp = new JMenu("About");

		this.menuItemExit = new JMenuItem("Exit");
		this.menuItemAbout = new JMenuItem("About");

		this.btnLaunchOrlac = new JButton("Launch Orlac");
		this.btnLaunchOrlac.setEnabled(false);
		this.btnLaunchOrlac.setVisible(false);

		this.jPanelTabbedPane = new JPanelTabbedPane(this);
		this.jPanelApplicationState = new JPanelApplicationState();
		}

	/**
	 * Adds the components in the Main Frame Layout.
	 */
	private void addComponents()
		{
		this.menuBar.add(this.menuFile);
		this.menuFile.add(this.menuItemExit);

		this.menuBar.add(this.menuHelp);
		this.menuHelp.add(this.menuItemAbout);

		this.setJMenuBar(this.menuBar);

		this.add(this.jPanelApplicationState, BorderLayout.NORTH);
		this.add(this.jPanelTabbedPane, BorderLayout.CENTER);
		this.add(this.btnLaunchOrlac, BorderLayout.SOUTH);
		}

	/**
	 * Adds listeners for the JMenuItems.
	 */
	private void addListeners()
		{
		this.menuItemExit.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					gestureAnalysis.removeLeapMotionListener();
					gestureAnalysis.closeConnectionWithPureData();

					orlacLauncher.savePreferences();

					System.exit(0);
					}
			});

		this.menuItemAbout.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent arg0)
					{
					jFrameAbout = new JFrameAbout();
					}
			});

		this.btnLaunchOrlac.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					gestureAnalysis.playMovie();
					}
			});
		}

	/**
	 * Sets the properties of the Main Frame.
	 */
	private void setProperties()
		{
		this.setAlwaysOnTop(true);
		this.setLocation(10, 10);
		this.setTitle("Orlac Application");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuHelp;
	private JMenuItem menuItemExit;
	private JMenuItem menuItemAbout;

	private JButton btnLaunchOrlac;

	private JPanelTabbedPane jPanelTabbedPane;

	private JPanelApplicationState jPanelApplicationState;

	private JFrameAbout jFrameAbout;

	private GestureAnalysis gestureAnalysis;
	private OrlacLauncher orlacLauncher;
	}
