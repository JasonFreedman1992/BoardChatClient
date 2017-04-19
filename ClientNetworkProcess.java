import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.IOException;
import java.util.Iterator;

public class ClientNetworkProcess
{
	Thread loginThread = new Thread();
	input input = null;
	ByteBuffer buffer = ByteBuffer.allocate(25600);

	public ClientNetworkProcess(SocketChannel p_socket) throws IOException
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
		public byte[] bytes;

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
					Thread.sleep(100);
					SelectionKey key;
					Iterator<SelectionKey> iter;
					selector.select();
					iter = selector.selectedKeys().iterator();

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
				System.out.println(clientData.receiveImg.remaining());
			}
		}
		
		void handleRead(SelectionKey key) throws IOException
		{
			//ByteBuffer buffer = ByteBuffer.allocate(25600);
			buffer.clear();
			SocketChannel ch = (SocketChannel) key.channel();
			StringBuilder sb = new StringBuilder();
			int read = 0;
			while((read = ch.read(buffer)) > 0)
			{
				buffer.flip();
				bytes = new byte[buffer.limit()];
				buffer.get(bytes);
				buffer.flip();
				sb.append(new String(bytes));
			}
			String msg;
			if(read < 0)
			{
				msg = key.attachment() + " left the chat. \n";
				ch.close();
			}
			else
			{
				//System.out.println(sb.toString() + " sb = ??");
				msg = sb.toString();
				//clientData.input = msg;
				System.out.println(msg);
				if(msg.equals("Password matches the Username."))
				{
					clientData.loginSuccess = true;
				}
				else if(msg.equals("Username not found."))
				{
					clientData.loginResult = "No User Found";
				}
				else if(msg.equals("Password doesnt match the Username."))
				{
					clientData.loginResult = "Wrong Password";
				}
				else if(msg.equals("Board Found"))
				{
					clientData.input = "";
					clientData.joinBoardSuccess = true;
				}
				else if(msg.equals("Board Not Found"))
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Board not Found.");
				}
				else if(msg.equals("off"))
				{
					clientData.imgInc = false;
				}
				else if(msg.equals("img"))
				{
					clientData.imgInc = true;
					System.out.println(clientData.imgInc);
				}
				else
				{
					System.out.println("else");
					if(clientData.imgInc == true)
					{
						System.out.println("in imgInc true");
						System.out.println(clientData.receiveImg.remaining());
						clientData.receiveImg.put(buffer);
						//clientData.imgInc = false;
					}
					else
					{

					}
				}
			}
		}

		ByteBuffer commandBuffer;
		ByteBuffer usernameBuffer;
		ByteBuffer passwordBuffer;
		ByteBuffer createUsernameBuffer;
		ByteBuffer createPasswordBuffer;
		ByteBuffer msgBuffer;
		ByteBuffer joinBoardBuffer;
		ByteBuffer createBoardBuffer;
		ByteBuffer imgBuffer;


		void handleWrite(SelectionKey key) throws IOException, InterruptedException
		{
			if(clientData.loginPressed)
			{
				commandBuffer = ByteBuffer.wrap(clientData.loginCommand.getBytes());
				usernameBuffer = ByteBuffer.wrap(clientData.username.getBytes());
				passwordBuffer = ByteBuffer.wrap(clientData.password.getBytes());
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
				commandBuffer = ByteBuffer.wrap(clientData.createCommand.getBytes());
				createUsernameBuffer = ByteBuffer.wrap(clientData.createUsername.getBytes());
				createPasswordBuffer = ByteBuffer.wrap(clientData.createPassword.getBytes());
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
			if(clientData.msgPressed)
			{
				commandBuffer = ByteBuffer.wrap(clientData.msgCommand.getBytes());
				msgBuffer = ByteBuffer.wrap(clientData.output.getBytes());
				socket.write(commandBuffer);
				socket.write(msgBuffer);
				commandBuffer.rewind();
				msgBuffer.rewind();
				clientData.msgPressed = false;
			}
			else
			{

			}
			if(clientData.createBoardPressed)
			{
				commandBuffer = ByteBuffer.wrap(clientData.cBrdCommand.getBytes());
				createBoardBuffer = ByteBuffer.wrap(clientData.boardName.getBytes());
				socket.write(commandBuffer);
				socket.write(createBoardBuffer);
				commandBuffer.rewind();
				createBoardBuffer.rewind();
				clientData.createBoardPressed = false;
			}
			else
			{

			}
			if(clientData.joinBoardPressed)
			{
				System.out.println("join pressed");
				commandBuffer = ByteBuffer.wrap(clientData.jBrdCommand.getBytes());
				joinBoardBuffer = ByteBuffer.wrap(clientData.boardName.getBytes());
				socket.write(commandBuffer);
				socket.write(joinBoardBuffer);
				commandBuffer.rewind();
				joinBoardBuffer.rewind();
				clientData.joinBoardPressed = false;
			}
			else
			{

			}
			if(clientData.imgPressed)
			{
				commandBuffer = ByteBuffer.wrap(clientData.imgCommand.getBytes());
				imgBuffer = ByteBuffer.wrap(clientData.imgArray);

				socket.write(commandBuffer);
				System.out.println("commandBuffer sent");

				try{Thread.sleep(200);}catch(InterruptedException f){}

				socket.write(imgBuffer);
				System.out.println("imgBuffer sent");

				commandBuffer.rewind();
				imgBuffer.rewind();
				clientData.imgPressed = false;
			}
			else
			{

			}
		}
	}
}