import javax.swing.*;
import java.io.*;
import java.io.IOException;

public class ClientListWindow extends JFrame
{
    ClientLogin login;

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

        login = new ClientLogin();
        add(login.panel);
        addKeyListener(login.logincontrol);
        setFocusable(true);
        setVisible(true);
        
        initConnection connect = new initConnection();
        if(connect.success)
        {
            System.out.println("Successful connection to Server!");
            System.out.println("ClientProcess started!");
            ClientProcess process = new ClientProcess(connect.socket);
        }
        else
        {
            System.out.println("Unsuccessful Connection to server!");
        }
        
    }
}
    //public JButton connectChat = new JButton("Connect");
    //public JButton sendMessage = new JButton("Send");

    //public JTextField sendText = new JTextField();
    //public JTextField chatText = new JTextField();

    // private void initFields(JPanel p_panel) throws IOException
    // {
    // 	connectChat.setSize(125, 40);
    // 	connectChat.setLocation(125, 30);
    // 	connectChat.setText("Connect");
    // 	connectChat.addActionListener(new ActionListener()
    // 	{
    // 		public void actionPerformed(ActionEvent e)
    // 		{

    // 		}
    // 	});
    // 	add(connectChat);
    // 	connectChat.setVisible(true);

    // 	sendMessage.setSize(125, 40);
    // 	sendMessage.setLocation(125, 80);
    // 	sendMessage.setText("Send");
    // 	p_panel.add(sendMessage);
    // 	sendMessage.setVisible(true);

    // 	sendText.setSize(200, 25);
    // 	sendText.setLocation(25, 350);
    // 	p_panel.add(sendText);
    // 	sendText.setVisible(true);

    // 	chatText.setSize(200, 175);
    // 	chatText.setLocation(25, 130);
    // 	chatText.setEditable(false);
    // 	p_panel.add(chatText);
    // 	chatText.setVisible(true);
    // }

