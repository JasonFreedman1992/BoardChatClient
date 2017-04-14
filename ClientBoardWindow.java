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
		ClientBoardPanel panel1 = new ClientBoardPanel();
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
	}
}