import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import net.miginfocom.swing.*;

public class ClientBoardStartPanel extends JPanel
{
	//
	//        Board Name:                            *Note*
	//        _______________    Entering a password will Join or Create the
	//                          Board as private.  Leave Blank if you want
	//        Board Password:    your Board to be open to the world!  Don't worry
	//        ______________    though, Boards can be made private after creation.
	//
	//        Join      Create
	//
	public ClientData clientData;
	public JTextField boardName = new JTextField(15);
	public JTextField boardPassword = new JTextField(15);
	public JLabel boardNameLabel = new JLabel("Board Name");
	public JLabel boardPassLabel = new JLabel("Board Password");

	public JButton joinButton = new JButton("Join");
	public JButton createButton = new JButton("Create");

	ClientBoardStartPanel()
	{
		clientData = new ClientData();
		setBackground(Color.lightGray);
		setLayout(new MigLayout("aligny center, alignx center"));

		add(boardNameLabel, "wrap, center");

		boardName.setSize(225, 25);
		add(boardName, "wrap");

		add(boardPassLabel, "wrap, center");

		boardPassword.setSize(225, 25);
		add(boardPassword, "wrap, center");

		//
		// join button, actionlistener and key listener
		//
		add(joinButton, "wrap, center");
		joinButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				clientData.joinBoardPressed = true;
				clientData.boardName = boardName.getText();
				clientData.boardPassword = boardPassword.getText();
				System.out.println("click!");
			}
		});
		joinButton.addKeyListener(new java.awt.event.KeyListener()
		{
			public void keyPressed(java.awt.event.KeyEvent e)
			{
				if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
				{
					System.out.println("enter pressed on login");
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e)
			{

			}
			public void keyTyped(java.awt.event.KeyEvent e)
			{

			}
		});

		//
		// create button, actionlistener and key listener
		//
		add(createButton, "center");
		createButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				clientData.createBoardPressed = true;
				clientData.boardName = boardName.getText();
				clientData.boardPassword = boardPassword.getText();
				System.out.println("click!");
			}
		});
		createButton.addKeyListener(new java.awt.event.KeyListener()
		{
			public void keyPressed(java.awt.event.KeyEvent e)
			{
				System.out.println("enter pressed on create");
			}
			public void keyReleased(java.awt.event.KeyEvent e)
			{

			}
			public void keyTyped(java.awt.event.KeyEvent e)
			{

			}
		});
	}
}