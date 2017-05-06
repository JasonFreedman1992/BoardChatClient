import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.BasicStroke;
import java.awt.Color;

public class ClientData
{
	public static HashMap<String, int[]> usernameToXY = new HashMap<String, int[]>();
	public static HashMap<String, int[]> usernameToPreXY = new HashMap<String, int[]>();
	public static HashMap<String, Boolean> usernameTofirstInc = new HashMap<String, Boolean>();
	public static HashMap<String, Boolean> usernameTonewMouse = new HashMap<String, Boolean>();
	public static HashMap<String, BasicStroke> usernameToStroke = new HashMap<String, BasicStroke>();
	public static HashMap<String, Color> usernameToColor = new HashMap<String, Color>();

	public static ArrayList<String[]> chatLog = new ArrayList<String[]>();
	public static ArrayList<String> onlineFriends = new ArrayList<String>();
	public static ArrayList<String> offlineFriends = new ArrayList<String>();
	public static ArrayList<String> onlineBoards = new ArrayList<String>();

	public final String loginCommand = "/1z=login";
	public final String createCommand = "/1z=create";
	public final String cBrdCommand = "/1z=cbrd";
	public final String jBrdCommand = "/1z=jbrd";
	public final String blockCommand = "/1z=block";
	public final String addFriendCommand = "/1z=addf";
	public final String addtoBoardCommand = "/1z=addb";
	public final String msgCommand = "/1z=msg";
	public final String imgCommand = "/1z=img";
	public final String quitCommand = "/1z=quit";

	// currentuser for naming the tops of frames
	public static String currentUser = "";
	public static BasicStroke currentStroke = new BasicStroke(4);
	public static Color currentColor = Color.black;
	// pre and inc for receiving mouse info
	public static int preMouseY;
	public static int preMouseX;
	public static int incMouseX;
	public static int incMouseY;
	// pre and current for local mouse info
	public static int preClientMouseX;
	public static int preClientMouseY;
	public static int mouseX;
	public static int mouseY;

	public static ByteBuffer receiveImg = ByteBuffer.allocate(51200);
	public static ByteBuffer sendImg = ByteBuffer.allocate(51200);

	public static byte[] imgArray = new byte[51200];

	public static String output = "";
	public static String input = "";
	public static String inputFrom = "";
	public static String imgFrom = "";
	public static String loginResult = "";
	public static boolean newFriends = false;
	public static boolean newBoards = false;
	//
	//
	//
	public static boolean newBoardOpen = false;
	//public static boolean newBoardClose = false;
	
	public static boolean newFriendOpen = false;
	public static boolean newFriendClose = false;





	public static boolean newClick = false;
	public static boolean newMouse = false;
	public static boolean newInput = false;
	public static boolean firstInc = true;
	public static boolean boardClosePressed = false;
	public static boolean joinBoardPressed = false;
	public static boolean createBoardPressed = false;

	public static boolean loginPressed = false;
	public static boolean createPressed = false;
	public static boolean msgPressed = false;
	public static boolean imgPressed = false;
	public static boolean imgInc = false;
	public static boolean clearDraw = false;
	public static boolean mousePressed = false;
	public static boolean mouseReleased = false;
	public static boolean loginSuccess = false;
	public static boolean joinBoardSuccess = false;
	public static boolean createBoardSuccess = false;
	
	public static String username = "";
	public static String password = "";
	public static String createUsername = "";
	public static String createPassword = "";

	public static String boardName = "";
	public static String boardPassword = "";

	public static boolean incUser = false;
	public static LinkedList<String> usersInBoard = new LinkedList<String>();

	public static String joinBoardNameID = "";
	public static String joinBoardName = "";
	public static String joinBoardPassword = "";//unused

	public static int listWindowX = 0;
	public static int listWindowY = 0;

	public static boolean boardWindowOpen = false;
	public static boolean boardCurrentlyOpen = false;
}