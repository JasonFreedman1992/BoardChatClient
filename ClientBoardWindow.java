import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;

public class ClientBoardWindow extends JFrame
{
	ClientData clientData = new ClientData();
	BorderLayout border = new BorderLayout();
	public JTabbedPane tabbedpane = new JTabbedPane();
	ImageIcon icon;
	public void init(int p_width, int p_height, JFrame p_listwindow)
	{		
		icon = new ImageIcon("icon.png");
		JLabel hello = new JLabel("Tab");
		hello.setIcon(icon);
		JPanel hello1 = new JPanel();
		ClientBoardStartPanel panel2 = new ClientBoardStartPanel();
		tabbedpane.addTab("Tab 1", panel2);
		tabbedpane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedpane.setTabComponentAt(0, hello);
		//tabbedpane.getComponentAt(0) = hello;
		//ClientBoardPanel panel2 = new ClientBoardPanel();
		//tabbedpane.addTab("Tab 2", icon, panel2);
		//tabbedpane.setMnemonicAt(0, KeyEvent.VK_2);

		//ClientBoardPanel panel3 = new ClientBoardPanel();
		//tabbedpane.addTab("Tab 3", icon, panel3);
		//tabbedpane.setMnemonicAt(0, KeyEvent.VK_3);

		setTitle("ChatBoard");
		setSize(p_width, p_height);
		setLocationRelativeTo(null);
		setLocation(p_listwindow.getX() - 1074, p_listwindow.getY());
		setMinimumSize(new Dimension(1024, 768));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(border);
		add(tabbedpane);
		setVisible(true);
		while(!clientData.joinBoardSuccess)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				
			}
		}
		clientData.joinBoardSuccess = false;
		tabbedpane.remove(panel2);
		ClientBoardPanel panel1 = new ClientBoardPanel();
		tabbedpane.add(panel1);
		tabbedpane.setTabComponentAt(0, hello);
		boolean first = true;
		// appends the chatReceive box on Panel if input comes in
		while(true)
		{
			try
			{
				Thread.sleep(10);
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
					if(first)
					{
						panel1.instanceInfo.setText("");
						first = false;
					}
					System.out.println(clientData.incUser.indexOf("=/"));
					clientData.incUser = clientData.incUser.substring(clientData.incUser.indexOf("=/") + 2);
					System.out.println(clientData.incUser);
					if(clientData.incUser.contains("=/"))
					{
						String user = clientData.incUser.substring(0, clientData.incUser.indexOf("=/"));
						System.out.println("user: " + user);
						if(panel1.instanceInfo.getText().equals(""))
						{
							panel1.instanceInfo.setText(user);
							//panel1.instanceInfo.setText(clientData.incUser);
						}
						else
						{
							panel1.instanceInfo.setText(panel1.instanceInfo.getText() + "\n" + user);
							//panel1.instanceInfo.setText(panel1.instanceInfo.getText() + "\n" + clientData.incUser);
						}
						int x = clientData.incUser.indexOf("=/");
						clientData.incUser = clientData.incUser.substring(x);
					}
					else if(!clientData.incUser.contains("=/"))
					{
						String user = clientData.incUser;
						if(panel1.instanceInfo.getText().equals(""))
						{
							panel1.instanceInfo.setText(user);
							//panel1.instanceInfo.setText(clientData.incUser);
						}
						else
						{
							panel1.instanceInfo.setText(panel1.instanceInfo.getText() + "\n" + user);
							//panel1.instanceInfo.setText(panel1.instanceInfo.getText() + "\n" + clientData.incUser);
						}
						clientData.incUser = "";
						first = true;
					}
					System.out.println("end of loop: " + clientData.incUser);
				}
			}
			catch(InterruptedException e)
			{

			}
		}
	}
}