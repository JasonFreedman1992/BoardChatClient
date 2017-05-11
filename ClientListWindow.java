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
            try
            {
                if(clientData.boardCurrentlyOpen)
                {
                    clientData.boardClosePressed = true;
                }
                Thread.sleep(300);
            }
            catch(InterruptedException f)
            {

            }
            System.exit(0);
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

            while(clientData.loginSuccess)
            {
                try
                {
                    Thread.sleep(10);
                    //
                    // info feed from server about boards and friends data
                    //
                    if(clientData.newFriends)
                    {
                        javax.swing.tree.DefaultMutableTreeNode online = new javax.swing.tree.DefaultMutableTreeNode("Online");
                        javax.swing.tree.DefaultMutableTreeNode offline = new javax.swing.tree.DefaultMutableTreeNode("Offline");
                        javax.swing.tree.DefaultTreeModel model = (javax.swing.tree.DefaultTreeModel) friendsList.jTree1.getModel();
                        javax.swing.tree.DefaultMutableTreeNode root = (javax.swing.tree.DefaultMutableTreeNode) model.getRoot();
                        root.removeAllChildren();
                        root.add(online);
                        root.add(offline);
                        if(!clientData.onlineFriends.isEmpty())
                        {
                            for(int i = 0; i < clientData.onlineFriends.size(); i++)
                            {
                                javax.swing.tree.DefaultMutableTreeNode onlineFriend = new javax.swing.tree.DefaultMutableTreeNode(clientData.onlineFriends.get(i));
                                online.add(onlineFriend);
                            }
                        }
                        if(!clientData.offlineFriends.isEmpty())
                        {
                            for(int i = 0; i < clientData.offlineFriends.size(); i++)
                            {
                                offline.add(new javax.swing.tree.DefaultMutableTreeNode(clientData.offlineFriends.get(i)));
                            }
                        }
                        model.reload(root);
                        clientData.newFriends = false;
                    }

                    if(clientData.newBoards)
                    {
                        javax.swing.tree.DefaultMutableTreeNode Public = new javax.swing.tree.DefaultMutableTreeNode("Public");
                        javax.swing.tree.DefaultTreeModel model1 = (javax.swing.tree.DefaultTreeModel) friendsList.jTree2.getModel();
                        javax.swing.tree.DefaultMutableTreeNode root1 = (javax.swing.tree.DefaultMutableTreeNode) model1.getRoot();
                        root1.removeAllChildren();
                        root1.add(Public);
                        if(!clientData.onlineBoards.isEmpty())
                        {
                            for(int i = 0; i < clientData.onlineBoards.size(); i++)
                            {
                                Public.add(new javax.swing.tree.DefaultMutableTreeNode(clientData.onlineBoards.get(i)));
                            }
                        }
                        //root1.removeAllChildren();
                        model1.reload(root1);
                        clientData.newBoards = false;
                    }

                    if(clientData.joinBoardRequest)
                    {
                        String incMsg = "You have been invited to join " + clientData.joinBoardRequested + " by " + clientData.joinBoardFrom + ", would you like to accept?";
                        int result = javax.swing.JOptionPane.showConfirmDialog((java.awt.Component) null, incMsg, "alert", JOptionPane.OK_CANCEL_OPTION);
                        System.out.println(result);
                        if(result == 0)
                        {
                            // ok
                            // remember to add password functions
                            System.out.println("ok");
                            clientData.boardName = clientData.joinBoardRequested;
                            clientData.joinBoardPressed = true;
                        }
                        else // 2 is cancel
                        {
                            System.out.println("cancel");
                            // cancel
                        }
                        clientData.joinBoardRequest = false;
                    }
                }
                catch(InterruptedException e)
                {

                }
                //System.out.println("logged in loop");
            }
            //
            // 
            //
            this.dispose();
            try
            {
                Thread.sleep(200);
                clientData.networkRunning = true;
                ClientListWindow win = new ClientListWindow();
                win.init(280,750);
            }
            catch(Exception f)
            {

            }

            
        }
        else
        {
            setVisible(true);
            System.out.println("Unsuccessful Connection to server!");
            JOptionPane.showMessageDialog(null, "Sorry! Servers are under Maintenance right now.");
        }
    }
}

