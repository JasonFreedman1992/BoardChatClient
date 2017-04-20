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
import javax.imageio.ImageIO;
import java.util.List;

public class ClientBoardPanel extends JPanel
{
	BufferedImage paintImage = new BufferedImage(200,200,BufferedImage.TYPE_3BYTE_BGR);
	JTextField chatSend = new JTextField(12);
	public JTextArea chatReceive = new JTextArea(10, 20);
	JTextArea instanceInfo = new JTextArea(10, 20);
	ClientData clientData = new ClientData();

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
					try
					{
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						ImageIO.write(drawPanel.paintImage, "jpg", baos);
						clientData.imgSize = baos.size();
						//System.out.println(clientData.imgSize);
						byte[] bytes = baos.toByteArray();
						System.out.println(bytes.length);
						//System.out.println(clientData.receiveImg.remaining());
						clientData.imgArray = bytes;
					}
					catch(IOException f)
					{

					}
					clientData.imgPressed = true;
				}
				else
				{
					clientData.msgPressed = true;
					clientData.output = chatSend.getText();
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

					System.out.println(clientData.receiveImg.remaining());
					//System.out.println(clientData.receiveImg.position());
					drawPanel.paintImage = drawPanel.createImageFromBytes();
					//try{drawPanel.createImageFromBytes();}catch(IOException f){}
					try
					{
						System.out.println(drawPanel.paintImage.toString());
						drawPanel.save();
						drawPanel.load();
						drawPanel.repaint();
						clientData.receiveImg.clear();
						drawPanel.paintImage = new BufferedImage(200, 200, BufferedImage.TYPE_3BYTE_BGR);
					}
					catch(IOException f)
					{

					}
				}
				else
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
	    	//System.out.println("X: " + clientData.mouseX);
	    	//System.out.println("Y: " + clientData.mouseY);
	    }

	    public void mouseDragged(MouseEvent e)
	    {
	    	clientData.mouseX = e.getX();
        	clientData.mouseY = e.getY();
        	System.out.println("clicked");
	    	if(clientData.mousePressed)
			{
				try
				{
					drawPanel.updatePaint();
				}
				catch(IOException f)
				{

				}
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
        }

        public void mousePressed(java.awt.event.MouseEvent me) 
        {
        	System.out.println("true");
        	clientData.mousePressed = true;
        }
    }
}