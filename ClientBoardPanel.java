import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;

public class ClientBoardPanel extends JPanel
{
	JTextField chatSend = new JTextField(12);
	JTextField chatReceive = new JTextField(17);
	JButton send = new JButton("Send");
	ClientBoardPanel()
	{
		setBackground(Color.lightGray);
		setLayout(new MigLayout("alignx center, aligny center"));
		chatReceive.setPreferredSize(new Dimension(0, 96));
		add(chatReceive, "center, wrap 5px");
		add(chatSend, "left, dock south");
		add(send,"right, dock south");
		MouseListen listen = new MouseListen();
		addMouseMotionListener(listen);
	}
	class MouseListen implements MouseMotionListener
	{
		public void mouseMoved(MouseEvent e)
	    {
	    	System.out.println(e.getX());
	    	System.out.println(e.getY());
	    }

	    public void mouseDragged(MouseEvent e)
	    {

	    }
	}
}