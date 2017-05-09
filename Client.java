import java.io.IOException;
import javax.swing.JOptionPane;


public class Client
{
	public static void main(String[] args) throws IOException
	{
		ClientListWindow win = new ClientListWindow();
		win.init(280,750);
	}
}