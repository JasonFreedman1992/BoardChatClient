import javax.swing.*;
import java.awt.event.*;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import net.miginfocom.swing.*;

public class ClientWindow extends JFrame
{
	public JButton connectChat = new JButton("Connect");
	public JButton sendMessage = new JButton("Send");

	public JTextField sendText = new JTextField();
	public JTextField chatText = new JTextField();

    public JLabel usernameLabel = new JLabel("Username");
    public JLabel passwordLabel = new JLabel("Password");

	public JTextField username = new JTextField(15);
	public JTextField password = new JTextField(15);

    public JLabel createUsernameLabel = new JLabel("Create Username");
    public JLabel createPasswordLabel = new JLabel("Create Password");

    public JTextField createUsername = new JTextField();
    public JTextField createPassword = new JTextField();

	public ClientPanel panel = new ClientPanel();

	public int width;
	public int height;

    public void init(int p_width, int p_height) throws IOException
    {
        setTitle("ChatBoard");
        setSize(p_width, p_height);
        width = p_width;
        height = p_height;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(Color.lightGray);
        add(panel);
        panel.setLayout(new MigLayout("aligny center, alignx center"));
        initConnection();
        setVisible(true);
    }

    private void initSignIn()
    {
        panel.add(usernameLabel, "wrap, center");
        usernameLabel.setVisible(true);
    	username.setSize(225, 25);
    	panel.add(username, "wrap");
    	username.setVisible(true);

        panel.add(passwordLabel, "wrap, center");
        passwordLabel.setVisible(true);
    	password.setSize(225, 25);
    	panel.add(password, "wrap");
    	password.setVisible(true);
    }

    private void initCreateAccount()
    {

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
		}
		catch(ConnectException e)
		{
			initOffline();
		}		
    }
}
