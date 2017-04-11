public class ClientData
{
	public static String output = "";
	public static String input = "";
	public static String loginResult = "";

	public static boolean loginPressed = false;
	public static boolean createPressed = false;
	public static boolean msgPressed = false;

	public static boolean loginFocused = false;
	public static boolean createFocused = false;

	public final String loginCommand = "/1z=login";
	public final String createCommand = "/1z=create";
	public final String msgCommand = "/1z=msg";

	public static boolean loginSuccess = false;

	public static String username = "";
	public static String password = "";

	public static String createUsername = "";
	public static String createPassword = "";
}