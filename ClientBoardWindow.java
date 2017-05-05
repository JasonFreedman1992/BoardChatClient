import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.awt.event.WindowListener;

public class ClientBoardWindow extends JFrame
{
	ClientData clientData = new ClientData();
	ClientBoardPanel boardPanel;
	ClientBoardStartPanel startPanel;
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
				clientData.usersInBoard.clear();
				clientData.boardWindowOpen = false;
				if(clientData.boardCurrentlyOpen)
				{
					clientData.boardClosePressed = true;
				}
				clientData.boardCurrentlyOpen = false;
				frame = (JFrame) e.getSource();
				frame.dispose();
			}
			else
			{

			}
		}
	}
	//
	// called when java frame resizes
	//
	// public void paint(Graphics g)
	// {	
	// 	System.out.println("frame paint");
	// 	super.paint(g);
	// }
	public void init(int p_width, int p_height)
	{		
		setTitle("ChatBoard");
		setSize(p_width, p_height);
		setLocationRelativeTo(null);
		setLocation(clientData.listWindowX - 1074, clientData.listWindowY);
		setMinimumSize(new Dimension(1000, 768));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		startPanel = new ClientBoardStartPanel();
		add(startPanel);
		setVisible(true);
		addWindowListener(new ExitListener(this));
		clientData.boardWindowOpen = true;
		//
		// loops over for panel info distribution.
		//
		while(clientData.boardWindowOpen)
		{
			try
			{
				Thread.sleep(10);
				if(clientData.joinBoardSuccess)
				{
					System.out.println("clientdata.joinBoardSuccess!!!!");
					setTitle(clientData.joinBoardName);
					clientData.joinBoardSuccess = false;
					remove(startPanel);
					boardPanel = new ClientBoardPanel();
					add(boardPanel);
					validate();
					repaint();
					//pack();
					clientData.boardCurrentlyOpen = true;
					boardPanel.drawPanel.firstDraw = true;
				}

				//
				//
				//
				if(clientData.boardCurrentlyOpen)
				{
					if(clientData.newMouse || clientData.newClick || clientData.clearDraw || boardPanel.drawPanel.firstDraw)
					{	
						for(int i = 0; i < clientData.usersInBoard.size(); i++)
						{
							String user = clientData.usersInBoard.get(i);
							if(!user.equals(clientData.currentUser))
							{
								if(clientData.usernameTofirstInc.containsKey(user))
								{
									if(clientData.usernameTofirstInc.get(user) && clientData.usernameTonewMouse.get(user))
									{
										if(clientData.usernameToPreXY.containsKey(user))
										{
											clientData.usernameToPreXY.get(user)[0] = clientData.usernameToXY.get(user)[0];
											clientData.usernameToPreXY.get(user)[1] = clientData.usernameToXY.get(user)[1];

											clientData.usernameTofirstInc.put(user, false);
										}
									}
								}
							}
						}
					}
					boardPanel.drawPanel.updatePaint();
					clientData.newMouse = checkClientNewMouse();
				}
				// 	if(!clientData.input.equals(""))
				// 	{
				// 		panel1.chatReceive.setText(panel1.chatReceive.getText() + "\n" + clientData.input);
				// 		clientData.input = "";
				// 	}
				// 	else
				// 	{
			}
			catch(InterruptedException e)
			{

			}
		}
	}
	private boolean checkClientNewMouse()
	{
		boolean newMouse = false;
		for(int i = 0; i < clientData.usersInBoard.size(); i++)
		{
			String user = clientData.usersInBoard.get(i);
			if(!user.equals(clientData.currentUser))
			{
				//System.out.println("user : " + user);
				if(clientData.usernameTonewMouse.containsKey(user))
				{
					if(clientData.usernameTonewMouse.get(user))
					{
						newMouse = true;
					}
				}
			}
		}
		return newMouse;
	}
}