import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClientWindow extends JFrame
{
	public JButton connectChat = new JButton("Connect");
	public JButton sendMessage = new JButton("Send");
	public JTextField sendText = new JTextField();
	public JTextField chatText = new JTextField();

    public void init(int p_width, int p_height) throws IOException
    {
        setTitle("ChaBtchatroard");
        setSize(p_width, p_height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        initFields();
    }

    private void initFields() throws IOException
    {
    	connectChat.setSize(125, 40);
    	connectChat.setLocation(125, 30);
    	connectChat.setText("Connect");
    	connectChat.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a machine that is \n" + "running the date service on port 49152:");
    			try
    			{
    				Socket s = new Socket(serverAddress, 49152);
					BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String answer = input.readLine();
					chatText.setText(answer);
    			}
    			catch(IOException f)
    			{

    			}
    		}
    	});
    	add(connectChat);
    	connectChat.setVisible(true);

    	sendMessage.setSize(125, 40);
    	sendMessage.setLocation(125, 80);
    	sendMessage.setText("Send");
    	add(sendMessage);
    	sendMessage.setVisible(true);

    	sendText.setSize(200, 25);
    	sendText.setLocation(25, 350);
    	add(sendText);
    	sendText.setVisible(true);

    	chatText.setSize(200, 175);
    	chatText.setLocation(25, 130);
    	chatText.setEditable(false);
    	add(chatText);
    	chatText.setVisible(true);
    }
}
