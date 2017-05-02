import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.*;
import java.io.IOException;
import java.awt.event.*;
import java.awt.event.WindowListener;

public class ClientListWindow extends JFrame
{
    ClientLogin login;
    ClientFriendsList friendsList;
    ClientData clientData = new ClientData();
    ClientNetworkProcess networkProcess;
    Thread BoardThread = new Thread();

    class ExitListener extends WindowAdapter
    {
        JFrame frame;
        ExitListener(JFrame p_frame)
        {
            frame = p_frame;
        }

        public void windowClosing(WindowEvent e)
        {
            Object[] options = {"Yes","No"};
            boolean close = false;
            int n = JOptionPane.showOptionDialog(frame,//parent container of JOptionPane
            "Are you sure you would like to Exit? Exiting will destroy your Board and disconnect you from the Server.", 
            "ChatBoard",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,//do not use a custom Icon
            options,//the titles of buttons
            options[1]);//default button title

            switch(n)
            {
                case 0:
                    close = true;
                    break;
                case 1:
                    close = false;
                    break;
            }

            //
            // send information to server that you are leaving board
            //
            if(close)
            {
                if(clientData.boardWindowOpen)
                {
                    clientData.boardWindowOpen = false;
                    if(clientData.boardCurrentlyOpen)
                    {
                        clientData.boardClosePressed = true;
                    }
                }
                System.exit(0);
            }
            else
            {

            }
        }
    }

    public void init(int p_width, int p_height) throws IOException
    {
        setTitle("ChatBoard");
        setSize(p_width, p_height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(280, 750));
        addWindowListener(new ExitListener(this));
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
            
            setTitle(clientData.currentUser);

            //setTitle()


            //
            // open the board window
            //
            Thread BoardThread;
            BoardThread = new Thread(new BoardThread());
            BoardThread.start();
            clientData.boardWindowOpen = true;


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

