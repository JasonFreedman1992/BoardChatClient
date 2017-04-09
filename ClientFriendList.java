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
		//panel.setLayout(new MigLayout("aligny center, alignx center"));

		friendsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(friendsLabel, "wrap, center");
		friendsLabel.setVisible(true);

		boardsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(boardsLabel, "wrap, center");
		boardsLabel.setVisible(true);
	}	
}