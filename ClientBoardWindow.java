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
		ClientBoardStartPanel panel2 = new ClientBoardStartPanel();
		tabbedpane.addTab("Tab 1", icon, panel2);
		tabbedpane.setMnemonicAt(0, KeyEvent.VK_1);
		
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(border);
		add(tabbedpane);
		setVisible(true);
		while(!clientData.joinBoardSuccess)
		{
			System.out.println("inside while");
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				
			}
		}
		tabbedpane.remove(panel2);
		ClientBoardPanel panel1 = new ClientBoardPanel();
		tabbedpane.add(panel1);
		while(true)
		{
			try
			{
				Thread.sleep(1000);
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