import javax.swing.*;
import net.miginfocom.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

public class ClientFriendList
{
	public ClientPanel panel = new ClientPanel();
	public ClientData clientData = new ClientData();

	public JLabel friendsLabel = new JLabel("Friends List");
	public JLabel boardsLabel = new JLabel("Open Boards");

	ClientFriendList()
	{
		panel.setBackground(Color.lightGray);
		panel.setLayout(new MigLayout(""));
		panel.setLayout(new MigLayout("alignx center"));

		panel.add(new addButton());
		panel.add(new subButton());
		panel.add(new setButton(), "wrap");
		//panel.

		//friendsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		//panel.add(friendsLabel, "wrap, center");
		//friendsLabel.setVisible(true);

		//boardsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		//panel.add(boardsLabel, "wrap, center");
		//boardsLabel.setVisible(true);
	}	
	class addButton extends JLabel
	{
		ImageIcon add = new ImageIcon("add.png");
		addButton()
		{
			setIcon(add);
		}
	}

	class subButton extends JLabel
	{
		ImageIcon sub = new ImageIcon("sub.png");
		subButton()
		{
			setIcon(sub);
		}
	}

	class setButton extends JLabel
	{
		ImageIcon set = new ImageIcon("set.png");
		setButton()
		{
			setIcon(set);
		}
	}
}