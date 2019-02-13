import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.io.IOException;

public class initConnection
{
	public SocketChannel socket;
	public boolean success = false;
	InetSocketAddress serverAddress = new InetSocketAddress("35.203.148.186", 49152);
	public initConnection() throws IOException
	{
    	try
    	{
    		socket = SocketChannel.open();
    		socket.connect(serverAddress);
    		socket.configureBlocking(false);
    		success = true;
		}
		catch(ConnectException e)
		{
			success = false;
		}		
	}
}