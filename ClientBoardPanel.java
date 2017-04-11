import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import net.miginfocom.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;


public class ClientBoardPanel extends JPanel
{
	JTextField chatSend = new JTextField(12);
	JTextArea chatReceive = new JTextArea(10, 20);
	//JTextField chatReceive = new JTextField(17);
	JButton send = new JButton("Send");
	ClientBoardPanel()
	{
		chatReceive.setBackground(Color.white);
		chatReceive.setLineWrap(true);
		//chatReceive.setEditable(false);
		//chatReceive.setMultipleMode(true);
		setBackground(Color.lightGray);
		setLayout(new MigLayout("alignx center, aligny center"));
		chatReceive.setPreferredSize(new Dimension(40, 40));
		chatReceive.setMaximumSize(new Dimension(200, 100));
		add(chatReceive, "center, wrap 5px");
		add(chatSend, "left, dock south");
		add(send,"right, dock south");
		send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				chatReceive.setText(chatReceive.getText() + "\n" + chatSend.getText());
				chatSend.setText("");
			}
		});
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