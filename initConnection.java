import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class initConnection
{
	public Socket socket;
	public boolean success = false;
	public initConnection() throws IOException
	{
		init();
	}

	private void initOffline()
    {
    	JOptionPane.showMessageDialog(null, "Sorry! Servers are under Maintenance right now.");
    }

    private void init() throws IOException
    {
    	try
    	{
    		socket = new Socket("54.70.172.148", 49152);
    		success = true;
		}
		catch(ConnectException e)
		{
			success = false;
			initOffline();
		}		
    }	
}