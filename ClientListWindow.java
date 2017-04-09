import javax.swing.*;
import java.io.*;
import java.io.IOException;

public class ClientListWindow extends JFrame
{
    ClientLogin login;
    ClientFriendList friendlist;
    ClientData clientData = new ClientData();
    ClientNetworkProcess networkProcess;

    public void init(int p_width, int p_height) throws IOException
    {
        setTitle("ChatBoard");
        setSize(p_width, p_height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initConnection connect = new initConnection();

        if(connect.success)
        {
            System.out.println("Successful Connection to server!");
            login = new ClientLogin();
            add(login.panel);
            setVisible(true);
            networkProcess = new ClientNetworkProcess(connect.socket);
            while(!clientData.loginSuccess)
            {
                try
                {
                    Thread.sleep(500);
                    System.out.println("login unsuccessful!");
                }
                catch(InterruptedException e)
                {

                }
            }
            getContentPane().remove(login.panel);
            friendlist = new ClientFriendList();
            add(friendlist.panel);
            getContentPane().validate();

            System.out.println("login successfull!");
        }
        else
        {
            setVisible(true);
            System.out.println("Unsuccessful Connection to server!");
            JOptionPane.showMessageDialog(null, "Sorry! Servers are under Maintenance right now.");
        }
    }
}

