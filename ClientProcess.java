import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.util.*;

public class ClientProcess
{
	public String line = "";
	public Scanner console = new Scanner(System.in);
	DataOutputStream streamOut = null;
	DataInputStream streamIn = null;
	Thread outThread = new Thread();
	Thread inThread = new Thread();

	output output = new output();
	input input = new input();

	public ClientProcess(Socket p_socket) throws IOException
	{
		streamOut = new DataOutputStream(p_socket.getOutputStream());
		streamIn = new DataInputStream(new BufferedInputStream(p_socket.getInputStream()));
	    try
	    {
	    	outThread = new Thread(output);
	    	outThread.start();

	    	inThread = new Thread(input);
	    	inThread.start();
	    }
	    catch(Exception e)
	    {
	    	outThread.stop();
	    	inThread.stop();
	    }
	}

	class output implements Runnable
	{
		public void run()
		{
			while(true)
			{
				try
				{
					streamOut.writeUTF(console.nextLine());
	        		streamOut.flush();
	        	}
	        	catch(IOException e)
	        	{
	        		break;
	        	}
			}
		}
	}

	class input implements Runnable
	{
		public void run()
		{
			while(true)
			{
				try
				{
					String input = streamIn.readUTF();
	            	System.out.println(input);
				}
	            catch(IOException e)
	            {
	            	break;
	            }
			}
		}
	}
}