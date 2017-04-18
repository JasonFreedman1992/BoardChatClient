import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics2D;

public class DrawPanel extends JPanel
{
	ClientData clientData = new ClientData();
    public BufferedImage paintImage = new BufferedImage(200, 200, BufferedImage.TYPE_3BYTE_BGR);
    protected void paintComponent(Graphics g)
    {
        g.drawImage(paintImage, 0, 0, null);
    }

    // draw painting
    public void updatePaint()
    {
        Graphics g = paintImage.createGraphics();
        g.setColor(Color.yellow);
     	g.fillOval(clientData.mouseX-10, clientData.mouseY-10, 20, 20);
        g.dispose();
        try
	    {
	        save();
	        load();
	        repaint();
	    }
	    catch(IOException e)
	    {

	    }
    }

    public void save() throws IOException
    {
        ImageIO.write(paintImage, "JPG", new File("fart.jpg"));
    }

    public void load() throws IOException 
    {
        paintImage = ImageIO.read(new File("fart.jpg"));
    }

	// public BufferedImage createImageFromBytes() 
	// {
	// 	byte[] arr = new byte[clientData.receiveImg.remaining()];
	// 	clientData.receiveImg.get(arr);
	// 	ByteArrayInputStream bais = new ByteArrayInputStream(arr);
	// 	clientData.receiveImg.rewind();
	//     try 
	//     {
	//         return ImageIO.read(bais);
	//     }
	//     catch(IOException e) 
	//     {
	//         throw new RuntimeException(e);
	//     }
	// }
}