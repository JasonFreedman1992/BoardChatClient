import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import net.miginfocom.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;


public class ClientBoardPanel extends JPanel
{
	JTextField chatSend = new JTextField(12);
	JTextArea chatReceive = new JTextArea(10, 20);
	JTextArea instanceInfo = new JTextArea(10, 20);
	JScrollPane scrollpane = new JScrollPane(chatReceive);
	ClientData clientData = new ClientData();
	JPanel drawPanel = new JPanel();
	//JTextField chatReceive = new JTextField(17);
	JButton send = new JButton("Send");
	JButton clear = new JButton("Clear");
	ClientBoardPanel()
	{
		drawPanel.setBackground(Color.white);
		drawPanel.setMinimumSize(new Dimension(200,200));
		chatReceive.setBackground(Color.white);
		chatReceive.setLineWrap(true);
		//chatReceive.setEditable(false);
		//chatReceive.setMultipleMode(true);
		setBackground(Color.lightGray);
		setLayout(new MigLayout(""));
		chatReceive.setPreferredSize(new Dimension(40, 40));
		chatReceive.setMaximumSize(new Dimension(200, 100));
		add(scrollpane, "center, wrap 5px");
		add(chatSend, "center, wrap");
		add(send, "center, wrap");
		add(clear, "center");
		add(drawPanel, "cell 1 0 1 2, grow");
		add(instanceInfo, "cell 2 0 1 2, grow");
		send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(chatReceive.getText().equals(""))
				{
					clientData.msgPressed = true; 
					clientData.output = chatSend.getText();
					chatReceive.setText(chatSend.getText());
					System.out.println("clientData.output = " + clientData.output);

				}
				else
				{
					clientData.msgPressed = true;
					clientData.output = chatSend.getText();
					chatReceive.setText(chatReceive.getText() + "\n" + chatSend.getText());
					chatSend.setText("");
					System.out.println("clientData.output = " + clientData.output);
				}
			}
		});
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(chatReceive.getText().equals(""))
				{

				}
				else
				{
					chatReceive.setText("");
				}
			}
		});
		MouseListen listen = new MouseListen();
		addMouseMotionListener(listen);
		while(true)
		{
			try
			{
				Thread.sleep(1000);
				chatReceive.setText(chatReceive.getText() + "\n" + clientData.input);
			}
			catch(InterruptedException e)
			{

			}
		}
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

    class msgSend implements MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {

        }
        public void mouseEntered(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseExited(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseReleased(java.awt.event.MouseEvent me) 
        {

        }

        public void mousePressed(java.awt.event.MouseEvent me) 
        {

        }
    }
}