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

    DrawPanel()
    {
    	try
    	{
    		save();
    		load();
    	}
    	catch(IOException e)
    	{

    	}
    }

    protected void paintComponent(Graphics g)
    {
        g.drawImage(paintImage, 0, 0, null);
    }

    // draw painting
    public void updatePaint() throws IOException
    {
        Graphics g = paintImage.createGraphics();
        g.setColor(Color.yellow);
     	g.fillOval(clientData.mouseX-10, clientData.mouseY-10, 20, 20);
        g.dispose();
        save();
        load();
        repaint();
    }

    public void save() throws IOException
    {
        ImageIO.write(paintImage, "JPG", new File("fart.jpg"));
    }

    public void load() throws IOException 
    {
        paintImage = ImageIO.read(new File("fart.jpg"));
    }

	public BufferedImage createImageFromBytes() 
	{
		System.out.println("position: " + clientData.receiveImg.position());
		byte[] arr = new byte[clientData.receiveImg.position()];
		clientData.receiveImg.flip();
		clientData.receiveImg.get(arr);
		//clientData.receiveImg.flip();
		System.out.println("arr " + arr[0] + " " + arr[1] + " " + arr[50] + " " + arr[100]);
		System.out.println(arr.toString());
		System.out.println(arr.length);
		ByteArrayInputStream bais = new ByteArrayInputStream(arr);
		//clientData.receiveImg.rewind();
	    try 
	    {
	        return ImageIO.read(bais);
	    }
	    catch(IOException e) 
	    {
	        throw new RuntimeException(e);
	    }
	}

	// public void createImageFromBytes() throws IOException
	// {
	// 	System.out.println("position: " + clientData.receiveImg.position());
	// 	byte[] arr = new byte[clientData.receiveImg.position()];
	// 	clientData.receiveImg.flip();
	// 	clientData.receiveImg.get(arr);
	// 	clientData.receiveImg.flip();
	// 	System.out.println("arr " + arr[0] + " " + arr[1] + " " + arr[50] + " " + arr[100]);
	// 	System.out.println(arr.toString());
	// 	System.out.println(arr.length);
	// 	ByteArrayInputStream bais = new ByteArrayInputStream(arr);
	// 	//clientData.receiveImg.rewind();
	//     // try 
	//     // {
	//     //     return ImageIO.read(bais);
	//     // }
	//     // catch(IOException e) 
	//     // {
	//     //     throw new RuntimeException(e);
	//     // }
	//     paintImage = ImageIO.read(bais);

	// }
}