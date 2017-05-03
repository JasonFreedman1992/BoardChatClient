import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.IOException;
import java.util.Iterator;

public class ClientNetworkProcess
{
	Thread loginThread = new Thread();
	input input = null;
	ByteBuffer buffer = ByteBuffer.allocate(51200);
	final String commandtag = "/1z=";
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
					Thread.sleep(2);
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
			}
		}
		
		void handleRead(SelectionKey key) throws IOException
		{
			SocketChannel ch = (SocketChannel) key.channel();
			StringBuilder sb = new StringBuilder();
			int read = 0;
			String type = "";
			while((read = ch.read(buffer)) > 0)
			{
				buffer.flip();
				bytes = new byte[buffer.limit()];
				//System.out.println(bytes[0]);
				buffer.get(bytes);
				buffer.rewind();
				sb.append(new String(bytes));
			}
			String msg;
			if(read < 0)
			{
				//msg = key.attachment() + " left the chat. \n";
				ch.close();
			}
			else
			{
				System.out.println("parsing " + sb.toString());
				if(sb.toString().startsWith(commandtag))
				{
					type = sb.toString().substring(4);
					//System.out.println(type);
					if(type.startsWith("img"))
					{
						String msgDestination = type.substring(3);
						String [] split = new String[2];
						split[0] = "";
						split[1] = "";
						split = msgDestination.split("=/", -1);
						String boardFrom = split[0];
						String mouseInf = split[1];
						String [] split1 = new String[2];
						split1[0] = "";
						split1[1] = "";
						split1 = mouseInf.split("=", -1);
						//
						// if packets come in separated this causes number format exception
						//
						try
						{
							clientData.incMouseX = Integer.parseInt(split1[0]);
							clientData.incMouseY = Integer.parseInt(split1[1]);
						}
						catch(NumberFormatException f)
						{

						}
						clientData.newMouse = true;
					}
					else if(type.startsWith("msg"))
					{
						String msgDestination = type.substring(3);
						String[] split = new String[2];
						split[0] = "";
						split[1] = "";
						split = msgDestination.split("=/", -1);
						String boardFrom = split[0];
						String boardData = split[1];
						if(boardData.equals("$closing$"))
						{
							clientData.newMouse = false;
							clientData.firstInc = true;
							clientData.input = "";
						}
						else
						{
							clientData.input = boardData;
							clientData.inputFrom = boardFrom;
							System.out.println("input from: " + clientData.inputFrom);
						}
					}
					else if(type.startsWith("resp"))
					{
						msg = type.substring(4);
						//System.out.println(msg);
						if(msg.equals("Password matches the Username."))
						{
							clientData.loginSuccess = true;
						}
						else if(msg.equals("Username not found."))
						{
							clientData.loginResult = "No User Found";
							clientData.loginSuccess = false;
						}
						else if(msg.equals("Password doesnt match the Username."))
						{
							clientData.loginResult = "Wrong Password";
							clientData.loginSuccess = false;
						}
						else if(msg.equals("Board Found"))
						{
							clientData.input = "";
							clientData.joinBoardSuccess = true;
							System.out.println("join board success true");
							msg = "";
						}
						else if(msg.equals("Board Not Found"))
						{
							javax.swing.JOptionPane.showMessageDialog(null, "Board not Found.");
						}
						else if(msg.equals("Username already exists."))
						{
							clientData.createBoardSuccess = false;
						}
						else if(msg.startsWith("$f"))
						{
							clientData.usersInBoard.clear();
							msg = msg.substring(2);
							System.out.println("1: " + msg);
							while(!msg.equals(""))
							{
								if(msg.startsWith("=/"))
								{
									msg = msg.substring(2);
									System.out.println("2: " + msg);
									if(msg.contains("=/"))
									{
										String user = msg.substring(0, msg.indexOf("=/"));
										clientData.usersInBoard.add(user);
										msg = msg.substring(msg.indexOf("=/"));
										System.out.println("3: " + msg);
									}
									else
									{
										clientData.usersInBoard.add(msg);
										msg = "";
									}
								}
							}
							clientData.incUser = true;
						}
						else if(msg.startsWith("$i"))
						{
							msg = msg.substring(2);
							String[] split = new String[2]; 
							split = msg.split("=/");
							clientData.joinBoardNameID = split[1];
							clientData.joinBoardName = split[0];
						}
					}
				}
				else
				{
					
				}
			}
		}

		ByteBuffer loginBuffer;
		ByteBuffer createBuffer;
		ByteBuffer msgBuffer;
		ByteBuffer joinBoardBuffer;
		ByteBuffer createBoardBuffer;
		ByteBuffer imgBuffer;
		ByteBuffer quitBuffer;


		void handleWrite(SelectionKey key) throws IOException, InterruptedException
		{
			if(clientData.loginPressed)
			{
				StringBuilder s = new StringBuilder();
				s.append(clientData.loginCommand);
				s.append(clientData.username);
				s.append(clientData.password);
				String s0 = s.toString();
				loginBuffer = ByteBuffer.wrap(s0.getBytes());
				socket.write(loginBuffer);
				loginBuffer.rewind();
				clientData.loginPressed = false;
			}
			else
			{

			}
			if(clientData.createPressed)
			{
				StringBuilder s = new StringBuilder();
				s.append(clientData.createCommand);
				s.append(clientData.createUsername);
				s.append(clientData.createPassword);
				String s0 = s.toString();
				createBuffer = ByteBuffer.wrap(s0.getBytes());
				socket.write(createBuffer);
				createBuffer.rewind();
				clientData.createPressed = false;
			}
			else
			{

			}
			if(clientData.msgPressed)
			{
				StringBuilder s = new StringBuilder();
				s.append(clientData.msgCommand);
				s.append(clientData.output);
				String s0 = s.toString();
				msgBuffer = ByteBuffer.wrap(s0.getBytes());
				socket.write(msgBuffer);
				msgBuffer.rewind();
				clientData.msgPressed = false;
			}
			else
			{

			}
			if(clientData.createBoardPressed)
			{
				StringBuilder s = new StringBuilder();
				s.append(clientData.cBrdCommand);
				s.append(clientData.boardName);
				String s0 = s.toString();
				createBoardBuffer = ByteBuffer.wrap(s0.getBytes());
				socket.write(createBoardBuffer);
				createBoardBuffer.rewind();
				clientData.createBoardPressed = false;
			}
			else
			{

			}
			if(clientData.joinBoardPressed)
			{
				StringBuilder s = new StringBuilder();
				s.append(clientData.jBrdCommand);
				s.append(clientData.boardName);
				String s0 = s.toString();
				joinBoardBuffer = ByteBuffer.wrap(s0.getBytes());
				socket.write(joinBoardBuffer);
				joinBoardBuffer.rewind();
				clientData.joinBoardPressed = false;
			}
			else
			{

			}
			if(clientData.imgPressed)
			{
				StringBuilder s = new StringBuilder();
				s.append(clientData.imgCommand);
				s.append("0=/");
				String s0 = String.valueOf(clientData.mouseX);
				s.append(s0);
				s.append("=");
				s0 = String.valueOf(clientData.mouseY);
				s.append(s0);
				String s1 = s.toString();
				System.out.println("sending " + s1);
				Thread.sleep(100);
				imgBuffer = ByteBuffer.wrap(s1.getBytes());
				socket.write(imgBuffer);
				imgBuffer.rewind();
			}
			else
			{

			}
			if(clientData.boardClosePressed)
			{
				StringBuilder s = new StringBuilder();
				s.append(clientData.quitCommand);
				s.append(clientData.joinBoardNameID);
				String s0 = s.toString();
				quitBuffer = ByteBuffer.wrap(s0.getBytes());
				socket.write(quitBuffer);
				quitBuffer.rewind();
				clientData.boardClosePressed = false;
			}
		}
	}
}