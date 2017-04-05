import java.awt.event.*;
import java.sql.*;

public class ClientLoginWindowController implements KeyListener
{
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			System.out.println("enter hit");
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://54.70.172.148:3306/ChatBoard?useSSL=false", "root", "313m3n7!");
				Statement statement = conn.createStatement();
				String query = "SELECT * FROM Accounts";

				ResultSet rs = statement.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				while(rs.next())
				{
					for(int i = 1; i <= columnsNumber; i++)
					{
						String columnValue = rs.getString(i);
						String columnName = rsmd.getColumnName(i);
						System.out.println(columnValue + " " + columnName);
					}
					System.out.println("");
				}
			}
			catch(SQLException f)
			{
				System.out.println("no connection");
			}
			catch(ClassNotFoundException f)
			{
				System.out.println("not found class");
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_F)
		{
			System.out.println("f hit ");
		}
	}

	public void keyReleased(KeyEvent e)
	{

	}

	public void keyTyped(KeyEvent e)
	{
		
	}
}