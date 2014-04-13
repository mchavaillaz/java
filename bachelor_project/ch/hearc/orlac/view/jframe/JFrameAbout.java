
package ch.hearc.orlac.view.jframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

import ch.hearc.orlac.view.jpanel.information.JPanelAuthor;
import ch.hearc.orlac.view.jpanel.information.JPanelLogo;

/**
 * JFrame contains {@link JPanelLogo} for the He-Arc Logo and a {@link JPanelAuthor} for informations about the Author.
 * @author chavailm
 *
 */
public class JFrameAbout extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * Constructor of {@link JFrameAbout}.</br>
	 * Creates the components.</br>
	 * Adds the components in the layout.</br>
	 * Adds listeners.
	 * Sets the {@link JFrame} properties.
	 */
	public JFrameAbout()
		{
		createComponents();
		addComponents();
		addListeners();
		setProperties();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	 * Creates all the components of the {@link JFrameAbout}.
	 */
	private void createComponents()
		{
		this.setLayout(new BorderLayout());

		this.vBox = Box.createVerticalBox();

		this.jPanelLogo = new JPanelLogo();
		this.jPanelAuthor = new JPanelAuthor();

		this.btnExit = new JButton("Exit");
		}

	/**
	 * Adds the components in the {@link JFrameAbout} layout.
	 */
	private void addComponents()
		{
		this.vBox.add(this.jPanelLogo);
		this.vBox.add(this.jPanelAuthor);

		this.add(this.vBox, BorderLayout.NORTH);
		this.add(this.btnExit, BorderLayout.SOUTH);
		}

	/**
	 * Adds listener to the attribute.
	 */
	private void addListeners()
		{
		this.btnExit.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent arg0)
					{
					// Close the JFrameAbout but not the Orlac application.
					dispose();
					}
			});
		}

	/**
	 * Sets the {@link JFrameAbout} informations.
	 */
	private void setProperties()
		{
		this.setAlwaysOnTop(true);
		this.setLocation(10, 10);
		this.setTitle("Orlac Application's About Informations");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// Tools
	private JPanelLogo jPanelLogo;
	private JPanelAuthor jPanelAuthor;

	private Box vBox;

	private JButton btnExit;
	}
