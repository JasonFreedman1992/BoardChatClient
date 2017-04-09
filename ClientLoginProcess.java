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
							// key is readable
						}
						else
						{
							// key is not readable
						}
						if(key.isWritable())
						{
							// key is writable
							handleWrite(key);
						}
						else
						{
							// key is not writeable
							
						}
					}
				}
				catch(IOException e)
				{

				}
				catch(InterruptedException e)
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
				System.out.println(msg);
			}
		}

		void handleWrite(SelectionKey key) throws IOException, InterruptedException
		{
			//Thread.sleep(1000);
			ByteBuffer commandBuffer;
			if(clientData.loginPressed)
			{
				ByteBuffer usernameBuffer = ByteBuffer.wrap(clientData.username.getBytes());
				ByteBuffer passwordBuffer = ByteBuffer.wrap(clientData.password.getBytes());
				commandBuffer = ByteBuffer.wrap(clientData.loginCommand.getBytes());
				socket.write(commandBuffer);
				socket.write(usernameBuffer);
				socket.write(passwordBuffer);
				commandBuffer.rewind();
				usernameBuffer.rewind();
				passwordBuffer.rewind();
				clientData.loginPressed = false;
			}
			else
			{

			}
			if(clientData.createPressed)
			{
				ByteBuffer createUsernameBuffer = ByteBuffer.wrap(clientData.createUsername.getBytes());
				ByteBuffer createPasswordBuffer = ByteBuffer.wrap(clientData.createPassword.getBytes());
				commandBuffer = ByteBuffer.wrap(clientData.createCommand.getBytes());
				socket.write(commandBuffer);
				socket.write(createUsernameBuffer);
				socket.write(createPasswordBuffer);
				commandBuffer.rewind();
				createUsernameBuffer.rewind();
				createPasswordBuffer.rewind();
				clientData.createPressed = false;
			}
			else
			{

			}
		}
	}
}