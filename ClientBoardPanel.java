import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import net.miginfocom.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import java.util.List;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ClientBoardPanel extends JPanel
{
	String boardName = "";
	String boardNumS = "";
	int boardNumI = 0;
	JTextField chatSend = new JTextField(12);
	public JTextArea chatReceive = new JTextArea(10, 20);
	JTextArea instanceInfo = new JTextArea(10, 20);
	ClientData clientData = new ClientData();
	boolean first = true;
	DrawPanel drawPanel = new DrawPanel();
	JButton send = new JButton("Send");
	JButton clear = new JButton("Clear");;
	ClientBoardPanel()
	{
		chatReceive.setBackground(Color.white);
		chatReceive.setLineWrap(true);
		chatReceive.setEditable(false);
		instanceInfo.setEditable(false);
		setBackground(Color.lightGray);
		setLayout(new MigLayout(""));
		chatReceive.setPreferredSize(new Dimension(40, 40));
		chatReceive.setMaximumSize(new Dimension(200, 100));
		JScrollPane scrollpane = new JScrollPane(chatReceive);
		scrollpane.setPreferredSize(new Dimension(200, 100));
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollpane, "center, wrap 5px");
		add(chatSend, "center, wrap");
		add(send, "center, wrap");
		add(clear, "center");
		drawPanel.setMinimumSize(new Dimension(200, 200));
	    MouseListen listen = new MouseListen();
		drawPanel.addMouseListener(listen);
		MouseMotion motion = new MouseMotion();
		drawPanel.addMouseMotionListener(motion);
		drawPanel.setSize(200, 200);
		add(drawPanel, "cell 1 0 1 2, grow");
		add(instanceInfo, "cell 2 0 1 2, grow");
		send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				StringBuilder s = new StringBuilder();
				// later will append based on Board ID
				//s.append(boardNumI);
				s.append("0=/");
				s.append(chatSend.getText());
				clientData.output = s.toString();
				clientData.msgPressed = true;
				chatSend.setText("");
			}
		});
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				clientData.clearDraw = true;
				if(clientData.clearDraw)
				{
					chatReceive.setText("");
				}
			}
		});
	}
	
	class MouseMotion implements MouseMotionListener
	{
		ClientData clientData = new ClientData();
		public void mouseMoved(MouseEvent e)
	    {
	    	clientData.mouseX = e.getX();
	    	clientData.mouseY = e.getY();
	    }

	    public void mouseDragged(MouseEvent e)
	    {
	    	clientData.mouseX = e.getX();
        	clientData.mouseY = e.getY();
	    }
	}

    class MouseListen implements MouseListener
    {
    	ClientData clientData = new ClientData();
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
        	System.out.println("false");

        	clientData.mousePressed = false;
        	clientData.imgPressed = false;
        	clientData.newClick = false;
        	clientData.output = "0=/$closing$";
        	clientData.msgPressed = true;
        }

        public void mousePressed(java.awt.event.MouseEvent me) 
        {
        	first = true;
			if(first)
	    	{
	    		clientData.mouseX = clientData.mouseX;
	    		clientData.mouseY = clientData.mouseY;
	    		clientData.preClientMouseX = clientData.mouseX;
	    		clientData.preClientMouseY = clientData.mouseY;
	    		first = false;
	    	}
        	clientData.mousePressed = true;
        	clientData.imgPressed = true;
        	clientData.newClick = true;
        }
    }
}