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
    //BorderLayout border = new BorderLayout();


    public void init(int p_width, int p_height) throws IOException
    {
        setTitle("ChatBoard");
        setSize(p_width, p_height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(280, 750));
        //setPreferredSize(new java.awt.Dimension(280, 750));
        initConnection connect = new initConnection();
        //setLayout(border);
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
                    //System.out.println("login unsuccessful!");
                }
                catch(InterruptedException e)
                {

                }
            }

            GroupLayout layout = new GroupLayout(getContentPane());
            friendsList = new ClientFriendsList(layout);
            getContentPane().setLayout(layout);
            //setLayout(null);
            getContentPane().remove(login.FramePanel);
            add(friendsList.borderPanel);
            add(friendsList.infoPanel);
            getContentPane().setBackground(new Color(0, 102, 153));
            getContentPane().validate();
            System.out.println("58");
            //
            // start BoardWindow after login successfull? or wait til button pressed?
            //

            BoardThread = new Thread(new BoardThread(this));
            BoardThread.start();
            
            System.out.println("login successfull!");
        }
        else
        {
            setVisible(true);
            System.out.println("Unsuccessful Connection to server!");
            JOptionPane.showMessageDialog(null, "Sorry! Servers are under Maintenance right now.");
        }
    }
    class BoardThread implements Runnable
    {
        JFrame frame;
        public BoardThread(JFrame p_frame)
        {
            frame = p_frame;
        }
        public void run()
        {
            System.out.println("running");
            ClientBoardWindow BoardWindow = new ClientBoardWindow();
            BoardWindow.init(1000, 748, frame);
            BoardWindow.setMinimumSize(new java.awt.Dimension(1024,768));
            System.out.println("past");
        }
    }
}

