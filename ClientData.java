import java.nio.ByteBuffer;

public class ClientData
{
	public final String loginCommand = "/1z=login";
	public final String createCommand = "/1z=create";
	public final String cBrdCommand = "/1z=cbrd";
	public final String jBrdCommand = "/1z=jbrd";
	public final String blockCommand = "/1z=block";
	public final String addFriendCommand = "/1z=addf";
	public final String addtoBoardCommand = "/1z=addb";
	public final String msgCommand = "/1z=msg";
	public final String imgCommand = "/1z=img";

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
	public static int imgSize;

	public static String output = "";
	public static String input = "";
	public static String loginResult = "";

	public static boolean newClick = false;
	public static boolean newMouse = false;
	public static boolean firstInc = true;
	public static boolean firstRec = true;

	public static boolean loginPressed = false;
	public static boolean createPressed = false;
	public static boolean msgPressed = false;
	public static boolean imgPressed = false;
	public static boolean imgInc = false;
	public static boolean loginFocused = false;
	public static boolean createFocused = false;
	public static boolean clearDraw = false;
	public static boolean joinBoardPressed = false;
	public static boolean createBoardPressed = false;

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

}