import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.*;

public class ClientLoginProcess
{
	public static ClientData clientData = new ClientData();

	DataOutputStream streamOut = null;
	DataInputStream streamIn = null;

	Thread outThread = new Thread();
	Thread inThread = new Thread();

	//output output = new output();
	input input = new input();

	public ClientLoginProcess(Socket p_socket) throws IOException
	{
		streamOut = new DataOutputStream(p_socket.getOutputStream());
		streamIn = new DataInputStream(new BufferedInputStream(p_socket.getInputStream()));
	}

	public void attemptLogin()
	{
		try
		{
			if(!clientData.username.equals("") && !clientData.password.equals(""))
			{
				streamOut.writeUTF(clientData.username);
				streamOut.writeUTF(clientData.password);
				streamOut.flush();
			}
		}
		catch(IOException e)
		{

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