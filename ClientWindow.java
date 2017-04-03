import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;

public class ClientWindow extends JFrame
{
	public JButton connectChat = new JButton("Connect");
	public JButton sendMessage = new JButton("Send");
	public JTextField sendText = new JTextField();
	public JTextField chatText = new JTextField();

	public JTextField username = new JTextField();
	public JTextField password = new JTextField();

	public JPanel panel = new JPanel();


    public void init(int p_width, int p_height) throws IOException
    {
        setTitle("ChatBoard");
        setSize(p_width, p_height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        add(panel);
        initConnection();
        panel.setSize(p_width, p_height);
        
        //initFields();
        
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

    		}
    	});
    	add(connectChat);
    	connectChat.setVisible(true);

    	sendMessage.setSize(125, 40);
    	sendMessage.setLocation(125, 80);
    	sendMessage.setText("Send");
    	panel.add(sendMessage);
    	sendMessage.setVisible(true);

    	sendText.setSize(200, 25);
    	sendText.setLocation(25, 350);
    	panel.add(sendText);
    	sendText.setVisible(true);

    	chatText.setSize(200, 175);
    	chatText.setLocation(25, 130);
    	chatText.setEditable(false);
    	panel.add(chatText);
    	chatText.setVisible(true);
    }

    private void initSignIn()
    {
    	username.setSize(200, 25);
    	username.setLocation(38, 350);
    	panel.add(username);
    	username.setVisible(true);

    	password.setSize(200, 25);
    	password.setLocation(38, 390);
    	panel.add(password);
    	password.setVisible(true);
    }

    private void initOffline()
    {
    	JOptionPane.showMessageDialog(null, "Sorry! Servers are under Maintenance right now.");
    }

    private void initConnection() throws IOException
    {
    	try
    	{
    		String serverAddress = "54.70.172.148";
    		Socket s = new Socket(serverAddress, 49152);
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String answer = input.readLine();
			initSignIn();
			username.setText(answer);
		}
		catch(ConnectException e)
		{
			initOffline();
		}		
    }
}
