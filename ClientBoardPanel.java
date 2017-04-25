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
	BufferedImage paintImage = new BufferedImage(200,200,BufferedImage.TYPE_3BYTE_BGR);
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
				if(chatReceive.getText().equals(""))
				{
					// //
					// // testing image sending at the moment
					// //
					// // /1z=img
					// byte b = 47; // /
					// clientData.sendImg.put(b);
					// b = 49; // 1
					// clientData.sendImg.put(b);
					// b = 122; // z
					// clientData.sendImg.put(b);
					// b = 61; // =
					// clientData.sendImg.put(b);
					// b = 105; // i
					// clientData.sendImg.put(b);
					// b = 109; // m
					// clientData.sendImg.put(b);
					// b = 103; // g
					// clientData.sendImg.put(b);
					// //  Board 0 then =/
					// b = 48; // 0
					// clientData.sendImg.put(b);
					// b = 61; // =
					// clientData.sendImg.put(b);
					// b = 47; // /
					// clientData.sendImg.put(b);
					// // =/ ---> past this point is img data
					// // <----- beyond this point is byte img data
					// try
					// {
					// 	ByteArrayOutputStream stream = new ByteArrayOutputStream();
					// 	ImageIO.write( drawPanel.paintImage, "jpg", stream);
					// 	stream.flush();
					// 	clientData.imgArray = stream.toByteArray();
					// 	stream.close();
					// 	System.out.println(clientData.imgArray.length);
					// 	clientData.sendImg.put(clientData.imgArray);
					// 	System.out.println("posi : " + clientData.sendImg.position());
					// 	System.out.println("rema : " + clientData.sendImg.remaining());
					// 	System.out.println("limi : " + clientData.sendImg.limit());
					// 	System.out.println("capa : " + clientData.sendImg.capacity());

					// 	System.out.println(Charset.defaultCharset());
					// 	clientData.imgPressed = true;
					// }
					// catch(IOException f)
					// {

					// }				
				}
				else
				{

				}
			}
		});
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				StringBuilder s = new StringBuilder();
				// later will append based on Board ID
				s.append("0=/");
				s.append(chatSend.getText());
				clientData.output = s.toString();
				clientData.msgPressed = true;
				chatReceive.setText("");
				if(chatReceive.getText().equals(""))
				{
					
				}
				else
				{	

				}
			}
		});
	}
	
	class MouseMotion implements MouseMotionListener
	{
		ClientData clientData = new ClientData();
		public void mouseMoved(MouseEvent e)
	    {
	    	//first = true;
	    	clientData.mouseX = e.getX();
	    	clientData.mouseY = e.getY();
	    	clientData.preMouseX = clientData.mouseX;
	    	clientData.preMouseY = clientData.mouseY;
	    	//System.out.println("X: " + clientData.mouseX);
	    	//System.out.println("Y: " + clientData.mouseY);
	    }

	    public void mouseDragged(MouseEvent e)
	    {
	    	System.out.println("mouse dragging");
	    	clientData.mouseX = e.getX();
        	clientData.mouseY = e.getY();
        	//System.out.println("clicked");
	    	if(clientData.mousePressed)
			{
				//drawPanel.repaint();
			}
			else
			{
				
				
			}
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
        }

        public void mousePressed(java.awt.event.MouseEvent me) 
        {
        	first = true;
			if(first)
	    	{
	    		clientData.mouseX = clientData.mouseX;
	    		clientData.mouseY = clientData.mouseY;
	    		System.out.println("client mouseX: " + clientData.mouseX);
	    		System.out.println("client mouseY: " + clientData.mouseY);
	    		clientData.preClientMouseX = clientData.mouseX;
	    		clientData.preClientMouseY = clientData.mouseY;
	    		first = false;
	    	}
        	System.out.println("true");
        	clientData.mousePressed = true;
        	clientData.imgPressed = true;
        	clientData.newClick = true;
        }
    }
}