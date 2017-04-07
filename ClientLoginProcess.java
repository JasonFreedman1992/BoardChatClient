import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.IOException;

public class ClientLoginProcess
{
	public static ClientData clientData = new ClientData();
	public ByteBuffer buffer = ByteBuffer.allocate(256);

	Thread outThread = new Thread();
	Thread inThread = new Thread();


	public ClientLoginProcess(SocketChannel p_socket)
	{
		inThread = new Thread(new input(p_socket));
		inThread.start();
	}


	public void attemptLogin()
	{

	}


	class input implements Runnable
	{
		public SocketChannel socket = null;
		public boolean val = true;

		public input(SocketChannel p_socket)
		{
			socket = p_socket;
		}
		public void run()
		{
			int nBytes = 0;
			ByteBuffer buf = ByteBuffer.allocate(256);
			try
			{
				while(val)
				{
					while((nBytes = nBytes = socket.read(buf)) > 0)
					{
                        buf.flip();
                        Charset charset = Charset.forName("us-ascii");
                        CharsetDecoder decoder = charset.newDecoder();
                        CharBuffer charBuffer = decoder.decode(buf);
                        String result = charBuffer.toString();
                        System.out.println(result);
                        buf.flip();
					}
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
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