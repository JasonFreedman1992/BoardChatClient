import javax.swing.*;
import java.io.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class ClientListWindow extends JFrame
{
    ClientLogin login;
	public int width;
	public int height;
    public boolean offline;
    ClientListWindowController control = new ClientListWindowController();
    public void init(int p_width, int p_height) throws IOException
    {
        setTitle("ChatBoard");
        setSize(p_width, p_height);
        width = p_width;
        height = p_height;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initConnection();
        //setVisible(true);
        //initFields();
        
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

    private void initOffline()
    {
    	JOptionPane.showMessageDialog(null, "Sorry! Servers are under Maintenance right now.");
    }

    private void initConnection() throws IOException
    {
    	try
    	{
    		Socket socket = new Socket("54.70.172.148", 49152);
            DataInputStream console = null;
            DataOutputStream streamOut = null;
            DataInputStream streamIn = null;
            login = new ClientLogin();
            add(login.panel);
            addKeyListener(control);
            setVisible(true);
            console = new DataInputStream(System.in);
            streamOut = new DataOutputStream(socket.getOutputStream());
            String line = "";
            while(!line.equals(".bye"))
            {  
                try
                {  
                    line = console.readLine();
                    streamOut.writeUTF(line);
                    streamOut.flush();
                    streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                    String input = streamIn.readUTF();
                    System.out.println(input);
                }
                catch(IOException e)
                {

                }
            }
			//password.setText(answer);
		}
		catch(ConnectException e)
		{
			initOffline();
            offline = true;
		}		
    }
}
