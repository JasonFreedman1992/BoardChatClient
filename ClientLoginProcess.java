import java.nio.*;
import java.nio.channels.*;
import java.io.IOException;

public class ClientLoginProcess
{
	public static ClientData clientData = new ClientData();

	SocketChannel socket = null;
	ByteBuffer buffer = ByteBuffer.allocate(1024);

	Thread outThread = new Thread();
	Thread inThread = new Thread();


	public ClientLoginProcess(SocketChannel p_socket)
	{
		socket = p_socket;
		inThread = new Thread(new input());
		inThread.start();
	}


	public void attemptLogin()
	{
		
	}


	class input implements Runnable
	{
		public void run()
		{
			
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