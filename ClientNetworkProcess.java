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
			while(clientData.networkRunning)
			{
				try
				{
					Thread.sleep(15);
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
			try
			{
				socket.close();
			}
			catch(IOException f)
			{
				
			}
		}
		
		void handleRead(SelectionKey key) throws IOException
		{
			System.out.println("reading");
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
				System.out.println(key.attachment() + " left the chat. \n");
				ch.close();
			}
			else
			{
				System.out.println("parsing " + sb.toString());
				if(sb.toString().startsWith(commandtag))
				{
					type = sb.toString().substring(4);
					//
					// img data from users, passed directly from server, appended with username
					//
					if(type.startsWith("img"))
					{
						String msgDestination = type.substring(3);
						String [] split = new String[2];
						split[0] = "";
						split[1] = "";
						split = msgDestination.split("=/", -1);
						//
						// use boardFrom
						//
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
							clientData.usernameToXY.put(boardFrom, new int[]{clientData.incMouseX, clientData.incMouseY});
							clientData.usernameTonewMouse.put(boardFrom, true);
							for(int i = 0; i < 2; i++)
							{
								System.out.println("usernameToXY #" + i + " " + clientData.usernameToXY.get(boardFrom)[i]);
							}
						}
						catch(NumberFormatException f)
						{

						}
						clientData.newMouse = true;
					}
					//
					// msg from users, origin from server but just passed along messages
					//
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
							clientData.usernameTofirstInc.put(boardFrom, true);
							clientData.usernameTonewMouse.put(boardFrom, false);
							clientData.input = "";
						}
						else if(boardData.startsWith("$color$"))
						{
							boardData = boardData.substring(7);
							switch(boardData)
							{
								case "0": // red
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(255, 51, 51));
									break;
								case "1": // orange
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(255, 153, 0));
									break;
								case "2": // yellow
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(255, 255, 51));
									break;
								case "3": // green
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(153, 255, 102));
									break;
								case "4": // light blue
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(0, 204, 255));
									break;
								case "5": // dark blue
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(0, 51, 255));
									break;
								case "6": // purple
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(102, 0, 153));
									break;
								case "7": // pink
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(255, 102, 204));
									break;
								case "8": // black
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(0, 0, 0));
									break;
								case "9": // white
									clientData.usernameToColor.put(boardFrom, new java.awt.Color(255, 255, 255));
									break;
							}
						}
						else if(boardData.startsWith("$brush$"))
						{
							boardData = boardData.substring(7);
							switch(boardData)
							{
								case "0": // 4 pixel brush size
									clientData.usernameToStroke.put(boardFrom, new java.awt.BasicStroke(4));
									break;
								case "1": // 8 pixel brush size
									clientData.usernameToStroke.put(boardFrom, new java.awt.BasicStroke(8));
									break;
								case "2": // 12 pixel brush size
									clientData.usernameToStroke.put(boardFrom, new java.awt.BasicStroke(12));
									break;
								case "3": // 16 pixel brush size
									clientData.usernameToStroke.put(boardFrom, new java.awt.BasicStroke(16));
									break;
							}
						}
						else if(boardData.startsWith("$clear$"))
						{
							clientData.clearDraw = true;
						}
						else
						{
							//
							// possible get rid of .input?
							//
							clientData.input = boardData;
							clientData.inputFrom = boardFrom;
							String[] inputArray = new String[2];
							inputArray[0] = boardFrom;
							inputArray[1] = boardData;
							if(clientData.chatLog.size() > 39)
							{
								clientData.chatLog.remove(0);
							}
							clientData.chatLog.add(inputArray);
							clientData.newInput = true;
						}
					}
					//
					// resp = response directly from server
					//
					else if(type.startsWith("resp"))
					{
						msg = type.substring(4);
						//System.out.println("in resp");
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
							if(!clientData.boardWindowOpen)
							{
                    			Thread BoardThread;
                    			BoardThread = new Thread(new BoardThread());
                    			BoardThread.start();
							}
							System.out.println("join board success true");
							try{Thread.sleep(100);}catch(InterruptedException f){}
							clientData.joinBoardSuccess = true;
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
						else if(msg.equals("User Online"))
						{
							clientData.loginResult = "User Online";
							clientData.loginSuccess = false;
						}
						else if(msg.startsWith("$f")) // code for people in board lobby
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
									if(msg.contains("=/")) // get new user from in between delimiters
									{
										String user = msg.substring(0, msg.indexOf("=/"));
										clientData.usersInBoard.add(user);
										clientData.usernameTonewMouse.put(user, false);
										clientData.usernameToColor.put(user, java.awt.Color.black);
										clientData.usernameToStroke.put(user, new java.awt.BasicStroke(4));
										clientData.usernameToXY.put(user, new int[2]);clientData.usernameToXY.get(user)[0] = 0;clientData.usernameToXY.get(user)[1] = 0;
										clientData.usernameToPreXY.put(user, new int[2]);clientData.usernameToPreXY.get(user)[0] = 0;clientData.usernameToPreXY.get(user)[1] = 0;										
										clientData.usernameTofirstInc.put(user, true);
										msg = msg.substring(msg.indexOf("=/"));
										System.out.println("3: " + msg);
									}
									else // last person at end of string being parsed
									{
										clientData.usersInBoard.add(msg);
										clientData.usernameTonewMouse.put(msg, false);
										clientData.usernameToColor.put(msg, java.awt.Color.black);
										clientData.usernameToStroke.put(msg, new java.awt.BasicStroke(4));
										clientData.usernameToXY.put(msg, new int[2]);clientData.usernameToXY.get(msg)[0] = 0;clientData.usernameToXY.get(msg)[1] = 0;
										clientData.usernameToPreXY.put(msg, new int[2]);clientData.usernameToPreXY.get(msg)[0] = 0;clientData.usernameToPreXY.get(msg)[1] = 0;										
										clientData.usernameTofirstInc.put(msg, true);
										msg = "";
									}
								}
								else
								{
									System.out.println("Error in packets for People in Board");
								}
							}
							clientData.incUser = true;
						}
						else if(msg.startsWith("$i")) // code for board info
						{
							msg = msg.substring(2);
							String[] split = new String[2]; 
							split = msg.split("=/");
							clientData.joinBoardNameID = split[1];
							clientData.joinBoardName = split[0];
						}
						else if(msg.startsWith("$o")) // code for returned list of offline and online friends
						{
							msg = msg.substring(2);
							clientData.onlineFriends.clear();
							clientData.offlineFriends.clear();
							while(!msg.equals(""))
							{

								if(msg.startsWith("=/"))
								{
									msg = msg.substring(2);

									//
									// if message still contains another user to parse
									//
									if(msg.contains("=/"))
									{
										if(msg.charAt(0)=='0')
										{
											msg = msg.substring(1);
											String user = msg.substring(0, msg.indexOf("=/"));
											clientData.offlineFriends.add(user);
											msg = msg.substring(msg.indexOf("=/"));

											System.out.println("found an offie!");
										}
										else
										{
											msg = msg.substring(1);
											String user = msg.substring(0, msg.indexOf("=/"));
											clientData.onlineFriends.add(user);
											msg = msg.substring(msg.indexOf("=/"));
											System.out.println("found an onnie!");
										}
									}
									//
									// last user in end of parsing chain
									// 
									else
									{
										if(msg.charAt(0)=='0')
										{
											msg = msg.substring(1);
											clientData.offlineFriends.add(msg);
											msg = "";
											System.out.println("last ones an offie!");
											clientData.newFriends = true;
										}
										else
										{
											msg = msg.substring(1);
											clientData.onlineFriends.add(msg);
											msg = "";
											System.out.println("last ones an onnie!");
											clientData.newFriends = true;
										}
									}
								}
								else
								{
									//System.out.println("Error in packets for Online Friends");
								}
							}
						}
						else if(msg.startsWith("$l")) // code for when friend logs on
						{
							msg = msg.substring(2);
							clientData.onlineFriends.add(msg);
							for(int i = 0; i < clientData.offlineFriends.size(); i++)
							{
								if(clientData.offlineFriends.get(i).equals(msg))
								{
									clientData.offlineFriends.remove(i);
								}
							}
							clientData.newFriends = true;
						}
						else if(msg.startsWith("$e")) // code for when friend signs off/exits
						{
							msg = msg.substring(2);
							for(int i = 0; i < clientData.onlineFriends.size(); i++)
							{
								if(clientData.onlineFriends.get(i).equals(msg))
								{
									clientData.onlineFriends.remove(i);
								}
							}
							clientData.offlineFriends.add(msg);
							clientData.newFriends = true;
						}
						else if(msg.startsWith("$b")) // code for returned list of all boards
						{
							msg = msg.substring(2);
							while(!msg.equals(""))
							{
								if(msg.startsWith("=/"))
								{
									msg = msg.substring(2);
									if(msg.contains("=/")) // get new board from in between delimiters
									{
										String board = msg.substring(0, msg.indexOf("=/"));
										clientData.onlineBoards.add(board);
										msg = msg.substring(msg.indexOf("=/"));
									}
									else // last board at end of string being parsed
									{
										clientData.onlineBoards.add(msg);
										msg = "";
										clientData.newBoards = true;
									}
								}
							}
						}
						else if(msg.startsWith("$n")) // code for new board created
						{
							msg = msg.substring(2);
							clientData.onlineBoards.add(msg);

							clientData.newBoards = true;
						}
						else if(msg.startsWith("$x")) // code for close board, subs from list
						{
							msg = msg.substring(2);
							for(int i = 0; i < clientData.onlineBoards.size(); i++)
							{
								if(clientData.onlineBoards.get(i).equals(msg))
								{
									clientData.onlineBoards.remove(i);
									clientData.newBoards = true;
								}
							}
						}
						else if(msg.startsWith("$j"))
						{
							msg = msg.substring(2);
							String[] split = new String[2];
							split[0] = "";
							split[1] = "";
							split = msg.split("=/", -1);
							clientData.joinBoardRequested = split[0];
							clientData.joinBoardFrom = split[1];
							clientData.joinBoardRequest = true;
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
		ByteBuffer addFriendBuffer;
		ByteBuffer addBoardBuffer;
		ByteBuffer removeFriendBuffer;

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
				//
				// append 0-10 or w/e board id
				//
				s.append(clientData.joinBoardNameID);
				s.append("=/");
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
			else
			{

			}
			if(clientData.addFriendPressed)
			{
				addFriendBuffer = ByteBuffer.wrap(clientData.output.getBytes());
				socket.write(addFriendBuffer);
				addFriendBuffer.rewind();
				clientData.addFriendPressed = false;
			}
			else
			{

			}
			if(clientData.inviteBoardPressed)
			{
				addBoardBuffer = ByteBuffer.wrap(clientData.output.getBytes());
				socket.write(addBoardBuffer);
				addBoardBuffer.rewind();
				clientData.inviteBoardPressed = false;
			}
			else
			{

			}
			if(clientData.removeFriendPressed)
			{
				removeFriendBuffer = ByteBuffer.wrap(clientData.output.getBytes());
				socket.write(removeFriendBuffer);
				removeFriendBuffer.rewind();
				clientData.removeFriendPressed = false;
			}
		}
	}
}