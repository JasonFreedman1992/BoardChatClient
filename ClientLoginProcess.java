import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.*;

public class ClientLoginProcess
{
	public static ClientData clientData = new ClientData();

	public Scanner console = new Scanner(System.in);
	DataOutputStream streamOut = null;
	DataInputStream streamIn = null;

	Thread outThread = new Thread();
	Thread inThread = new Thread();

	//output output = new output();
	input input = new input();
	loginConnect loginConnect = new loginConnect();

	public ClientLoginProcess(Socket p_socket) throws IOException
	{
		streamOut = new DataOutputStream(p_socket.getOutputStream());
		streamIn = new DataInputStream(new BufferedInputStream(p_socket.getInputStream()));
	    try
	    {
	    	inThread = new Thread(input);
	    	inThread.start();
	    }
	    catch(Exception e)
	    {
	    	inThread.stop();
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
			System.out.println("input thread finished");
		}
	}

	public void attemptLogin()
	{
		try
		{
			outThread = new Thread(loginConnect);
			outThread.start();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	class loginConnect implements Runnable
	{
		public void run()
		{
			try
			{
				if(!clientData.username.equals("") && !clientData.password.equals(""))
				{
					streamOut.writeUTF(clientData.username);
					streamOut.flush();
				}
			}
			catch(IOException e)
			{
				System.out.println(e);	
			}
		}
	}
}
	// class output implements Runnable
	// {
	// 	public void run()
	// 	{
	// 		while(true)
	// 		{
	// 			try
	// 			{
	// 				streamOut.writeUTF(console.nextLine());
	//         		streamOut.flush();
	//         	}
	//         	catch(IOException e)
	//         	{
	//         		break;
	//         	}
	// 		}
	// 		System.out.println("output thread finished");
	// 	}
	// }