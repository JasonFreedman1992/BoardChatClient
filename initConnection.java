import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.io.IOException;

public class initConnection
{
	public SocketChannel socket;
	public boolean success = false;
	InetSocketAddress serverAddress = new InetSocketAddress("54.70.172.148", 49152);
	public initConnection() throws IOException
	{
    	try
    	{
    		socket.open(serverAddress);
    		socket.connect(serverAddress);
    		success = true;
		}
		catch(ConnectException e)
		{
			success = false;
		}		
	}
}