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
		// appends the chatReceive box on Panel if input comes in
		while(true)
		{
			try
			{
				Thread.sleep(10);
				if(clientData.newMouse || clientData.newClick)
				{	
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
			}
			catch(InterruptedException e)
			{

			}
		}
	}
}