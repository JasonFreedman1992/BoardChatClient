import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.IOException;
import java.util.*;

public class ClientLoginProcess
{
	Thread loginThread = new Thread();
	input input = null;

	public ClientLoginProcess(SocketChannel p_socket) throws IOException
	{
		loginThread = new Thread(new input(p_socket));
		loginThread.start();
		input = new input(p_socket);
	}

	class input implements Runnable
	{
		public ClientData clientData = new ClientData();
		public Selector selector = null;
		public SocketChannel socket = null;

		public input(SocketChannel p_socket) throws IOException
		{
			socket = p_socket;
			selector = Selector.open();
			socket.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
		}
		//
		// Key can only write, read, and connect, cant accept.
		//
		public void run()
		{

			while(true)
			{
				try
				{
					SelectionKey key;
					Iterator<SelectionKey> iter;
					selector.select();
					iter = selector.selectedKeys().iterator();

					ByteBuffer buf = ByteBuffer.allocate(256);

					while(iter.hasNext())
					{
						key = iter.next();
						iter.remove();

						if(key.isReadable())
						{
							handleRead(key);
							//System.out.println("readable");
						}
						else
						{
							//System.out.println("not readable");
						}
						if(key.isWritable())
						{
							// way to write
							Thread.sleep(1000);
							ByteBuffer msgBuffer = ByteBuffer.wrap("hello world".getBytes());
							socket.write(msgBuffer);
							msgBuffer.rewind();

						}
						else
						{
							//System.out.println("not writable");
							
						}
					}
				}
				catch(IOException e)
				{

				}
				catch(InterruptedException f)
				{

				}
			}
		}

		void handleRead(SelectionKey key) throws IOException
		{
			ByteBuffer buffer = ByteBuffer.allocate(256);
			SocketChannel ch = (SocketChannel) key.channel();
			StringBuilder sb = new StringBuilder();
			buffer.clear();
			int read = 0;
			while((read = ch.read(buffer)) > 0)
			{
				buffer.flip();
				byte[] bytes = new byte[buffer.limit()];
				buffer.get(bytes);
				sb.append(new String(bytes));
				buffer.clear();
			}
			String msg;
			if(read < 0)
			{
				msg = key.attachment() + " left the chat. \n";
				ch.close();
			}
			else
			{
				msg = key.attachment() + ": " + sb.toString();
			}

			System.out.println(msg);
		}

		void handleWrite(SelectionKey key) throws IOException 
		{

		}
	}
}
/*		void broadcast() throws IOException
		{
			ByteBuffer msgBuffer = ByteBuffer.wrap("hello world".getBytes());
			for(SelectionKey key : selector.keys())
			{
				if(key.isValid() && key.channel() instanceof SocketChannel)
				{
					SocketChannel sch = (SocketChannel) key.channel();
					sch.write(msgBuffer);
					msgBuffer.rewind();
				}
			}
		}*/
			// int nBytes = 0;
			// ByteBuffer buf = ByteBuffer.allocate(256);
			// try
			// {
			// 	while(val)
			// 	{
			// 		while((nBytes = nBytes = socket.read(buf)) > 0)
			// 		{
   //                      buf.flip();
   //                      Charset charset = Charset.forName("us-ascii");
   //                      CharsetDecoder decoder = charset.newDecoder();
   //                      CharBuffer charBuffer = decoder.decode(buf);
   //                      System.out.println(charBuffer.toString());
   //                      buf.flip();
			// 		}
			// 	}
			// }
			// catch(IOException e)
			// {
			// 	e.printStackTrace();
			// }


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