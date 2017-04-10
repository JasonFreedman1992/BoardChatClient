import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.IOException;

public class ClientBoardWindow extends JFrame
{
	ClientData clientData = new ClientData();
	BorderLayout border = new BorderLayout();

	public void init(int p_width, int p_height, JFrame p_listwindow)
	{
		setTitle("ChatBoard");
		setSize(p_width, p_height);
		setLocationRelativeTo(null);
		setLocation(p_listwindow.getX() - 1074, p_listwindow.getY());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(border);
		setVisible(true);
	}
}