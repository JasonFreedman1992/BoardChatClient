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


public class ClientBoardPanel extends JPanel
{
	JTextField chatSend = new JTextField(12);
	public JTextArea chatReceive = new JTextArea(10, 20);
	JTextArea instanceInfo = new JTextArea(10, 20);
	ClientData clientData = new ClientData();
	JPanel drawPanel = new JPanel()
	{
         protected void paintComponent(Graphics g)
         {
     		System.out.println("clicked");
     		g.setColor(Color.black);
     		g.fillOval(mouseX-10, mouseY-10, 20, 20);
            //Graphics2D g2 = (Graphics2D) g;
            //g2.setBackground(Color.white);
 // 			//Graphics2D g2 = (Graphics2D) g;
 // 			//g2.setBackground(Color.white);

         }
	 };
	JButton send = new JButton("Send");
	JButton clear = new JButton("Clear");
	int mouseX;
	int mouseY;
	public static boolean mouseClickedx;
	Timer timer = new Timer(50, new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			if(mouseClickedx)
			{
				drawPanel.repaint();
				drawPanel.setSize(200, 200);
			}
		}
	});

	ClientBoardPanel()
	{

		chatReceive.setBackground(Color.white);
		chatReceive.setLineWrap(true);
		//scrollane.setBounds(10, 101, 742, 276);
		chatReceive.setEditable(false);
		//instanceInfo.setEditable(false);
		//chatReceive.setMultipleMode(true);
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
		//drawPanel.setOpaque(false);
		drawPanel.setMinimumSize(new Dimension(200, 200));
		//drawPanel.setPreferredSize(new Dimension(200, 200));
		//drawPanel.setMinimumSize(new Dimension(200, 200));
		
	    MouseListen listen = new MouseListen();
		drawPanel.addMouseListener(listen);
		MouseMotion motion = new MouseMotion();
		drawPanel.addMouseMotionListener(motion);
		//drawPanel.setSize(200, 200);
		add(drawPanel, "cell 1 0 1 2, grow");
		add(instanceInfo, "cell 2 0 1 2, grow");
		//timer.start();
		send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(chatReceive.getText().equals(""))
				{
					clientData.msgPressed = true; 
					clientData.output = chatSend.getText();
					//chatReceive.setText(chatSend.getText());
					System.out.println("clientData.output = " + clientData.output);

				}
				else
				{
					clientData.msgPressed = true;
					clientData.output = chatSend.getText();
					//chatReceive.setText(chatReceive.getText() + "\n" + chatSend.getText());
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
	}
	class MouseMotion implements MouseMotionListener
	{
		ClientData clientData = new ClientData();
		public void mouseMoved(MouseEvent e)
	    {
	    	mouseX = e.getX();
	    	mouseY = e.getY();
	    	System.out.println("X: " + mouseX);
	    	System.out.println("Y: " + mouseY);
	    }

	    public void mouseDragged(MouseEvent e)
	    {
	    	mouseX = e.getX();
        	mouseY = e.getY();
        	System.out.println("clicked");
	    	if(clientData.mousePressed)
			{
				
				drawPanel.repaint();
				//drawPanel.setSize(200, 200);
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