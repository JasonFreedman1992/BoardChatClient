import javax.swing.*;
import java.awt.BorderLayout;

import java.io.*;
import java.io.IOException;

public class ClientListWindow extends JFrame
{
    ClientLogin login;
    ClientFriendList friendlist;
    ClientData clientData = new ClientData();
    ClientNetworkProcess networkProcess;
    BorderLayout border = new BorderLayout();

    public void init(int p_width, int p_height) throws IOException
    {
        setTitle("ChatBoard");
        setSize(p_width, p_height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initConnection connect = new initConnection();
        setLayout(border);
        if(connect.success)
        {
            System.out.println("Successful Connection to server!");
            login = new ClientLogin();
            add(login.panel);
            setLocation(this.getX() + 600, this.getY());
            setVisible(true);
            networkProcess = new ClientNetworkProcess(connect.socket);
            while(!clientData.loginSuccess)
            {
                try
                {
                    Thread.sleep(2000);
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
            ClientBoardWindow BoardWindow = new ClientBoardWindow();
            BoardWindow.init(1024, 768, this);
            

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

