import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.*;
import java.io.IOException;

public class ClientListWindow extends JFrame
{
    ClientLogin login;
    ClientFriendsList friendsList;
    ClientData clientData = new ClientData();
    ClientNetworkProcess networkProcess;
    Thread BoardThread = new Thread();

    public void init(int p_width, int p_height) throws IOException
    {
        setTitle("ChatBoard");
        setSize(p_width, p_height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(280, 750));
        initConnection connect = new initConnection();
        if(connect.success)
        {
            System.out.println("Successful Connection to server!");
            login = new ClientLogin();
            add(login.FramePanel);
            setLocation(this.getX() + 600, this.getY());
            setVisible(true);
            networkProcess = new ClientNetworkProcess(connect.socket);
            while(!clientData.loginSuccess)
            {
                try
                {
                    Thread.sleep(100);
                    login.resultsLabel.setText(clientData.loginResult);
                }
                catch(InterruptedException e)
                {

                }
            }

            GroupLayout layout = new GroupLayout(getContentPane());
            friendsList = new ClientFriendsList(layout);
            getContentPane().setLayout(layout);
            getContentPane().remove(login.FramePanel);
            add(friendsList.borderPanel);
            add(friendsList.infoPanel);
            getContentPane().setBackground(new Color(0, 102, 153));
            getContentPane().validate();
            clientData.listWindowX = this.getX();
            clientData.listWindowY = this.getY();
            
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

