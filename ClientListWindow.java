import javax.swing.*;
import java.io.*;
import java.io.IOException;

public class ClientListWindow extends JFrame
{
    ClientLogin login;

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
            login.process = new ClientLoginProcess(connect.socket);
        }
        else
        {
            setVisible(true);
            System.out.println("Unsuccessful Connection to server!");
            JOptionPane.showMessageDialog(null, "Sorry! Servers are under Maintenance right now.");
        }
    }
}

