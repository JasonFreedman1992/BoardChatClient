import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.awt.event.WindowListener;

public class ClientBoardWindow extends JFrame
{
	ClientData clientData = new ClientData();
	Icon addIcon = new ImageIcon("add.png");
	JLabel addButton = new JLabel();
	ClientBoardStartPanel panel2;
	ClientBoardPanel panel1;
	String boardName = "";
	String boardNumS = "";
	int boardNumI = 0;
	class ExitListener extends WindowAdapter
	{
		JFrame frame;
		ExitListener(JFrame p_frame)
		{
			frame = p_frame;
		}

		public void windowClosing(WindowEvent e)
		{
			Object[] options = {"Yes","No"};
			boolean close = false;
			int n = JOptionPane.showOptionDialog(frame,//parent container of JOptionPane
    		"Are you sure you would like to Exit? Exiting will destroy your Board and disconnect you from the room.", 
   		    "ChatBoard",
    		JOptionPane.YES_NO_CANCEL_OPTION,
    		JOptionPane.QUESTION_MESSAGE,
    		null,//do not use a custom Icon
    		options,//the titles of buttons
    		options[1]);//default button title

			switch(n)
			{
				case 0:
					close = true;
					break;
				case 1:
					close = false;
					break;
			}

			//
			// send information to server that you are leaving board
			//
			if(close)
			{
				panel1.instanceInfo.setText("");
				frame.dispose();
				clientData.boardWindowOpen = false;
				clientData.boardClosePressed = true;
			}
			else
			{

			}
		}
	}

	public void init(int p_width, int p_height)
	{		
		setTitle("ChatBoard");
		setSize(p_width, p_height);
		setLocationRelativeTo(null);
		setLocation(clientData.listWindowX - 1074, clientData.listWindowY);
		setMinimumSize(new Dimension(1024, 768));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		panel2 = new ClientBoardStartPanel();
		add(panel2.FramePanel);
		setVisible(true);
		addWindowListener(new ExitListener(this));
		//
		// loops over for panel info distribution.
		//
		while(true)
		{
			try
			{
				//Thread.sleep(5000);
				if(!clientData.joinBoardName.equals(""))
				{
					setTitle(clientData.joinBoardName);
					clientData.joinBoardName = "";
				}
				if(clientData.joinBoardSuccess)
				{
					panel1 = new ClientBoardPanel();
					clientData.joinBoardSuccess = false;
					getContentPane().remove(panel2.FramePanel);
					add(panel1);
					getContentPane().validate();
				}
				Thread.sleep(10);
				if(clientData.boardWindowOpen)
				{
					if(clientData.newMouse || clientData.newClick || clientData.clearDraw)
					{	
						if(clientData.firstInc && clientData.newMouse)
						{
							clientData.preMouseX = clientData.incMouseX;
							clientData.preMouseY = clientData.incMouseY;
							clientData.firstInc = false;
						}
						panel1.drawPanel.repaint();
					}
					if(!clientData.input.equals(""))
					{
						panel1.chatReceive.setText(panel1.chatReceive.getText() + "\n" + clientData.input);
						clientData.input = "";
					}
					else
					{

					}
					if(!clientData.incUser.equals(""))
					{
						panel1.instanceInfo.setText("");
						String user = clientData.incUser;
						while(!user.equals(""))
						{
							if(user.startsWith("=/"))
							{
								System.out.println("127user: " + user);
								user = user.substring(2);
								if(user.contains("=/")) // if data contains another user
								{
									System.out.println("131user: " + user);
									String user1 = user.substring(0, user.indexOf("=/"));
									user = user.substring(user.indexOf("=/"));
									if(panel1.instanceInfo.getText().equals(""))
									{
										System.out.println("137user1: " + user1);
										System.out.println("138user: " + user);
										panel1.instanceInfo.setText(user1);
										user1 = "";
										System.out.println("put as only");
									}
									else
									{
										System.out.println("143user1: " + user1);
										System.out.println("144user: " + user);
										panel1.instanceInfo.setText(panel1.instanceInfo.getText() + "\n" + user1);
										user1 = "";
										System.out.println("new line");
									}
								}
								else // if user doesnt have =/, last user
								{
									if(panel1.instanceInfo.getText().equals(""))
									{
										System.out.println("153user: " + user);
										panel1.instanceInfo.setText(user);
										user = "";
									}
									else
									{
										System.out.println("160user: " + user);
										panel1.instanceInfo.setText(panel1.instanceInfo.getText() + "\n" + user);
										user = "";
									}
								}
							}
							else
							{

							}					
						}
						clientData.incUser = "";
						System.out.println("========");
						System.out.println("========");
						System.out.println("========");
						System.out.println("========");
						System.out.println("========");
						System.out.println("========");
						System.out.println("========");
					}	
				}
			}
			catch(InterruptedException e)
			{

			}
		}
	}
}