import javax.swing.*;
import net.miginfocom.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class ClientFriendList
{
	public ClientPanel panel = new ClientPanel();
	public ClientData clientData = new ClientData();

	public JLabel friendsLabel = new JLabel("Friends List");
	public JLabel boardsLabel = new JLabel("Open Boards");

	ClientFriendList()
	{
		panel.setBackground(Color.lightGray);
		panel.setLayout(new MigLayout("aligny center, alignx center"));

		panel.add(friendsLabel, "wrap, center");
		friendsLabel.setVisible(true);

		panel.add(boardsLabel, "wrap, center");
		boardsLabel.setVisible(true);
	}	
}