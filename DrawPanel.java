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
    public BufferedImage paintImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);

    DrawPanel()
    {
        setBackground(Color.white);
    }

    protected void paintComponent(Graphics g)
    {
        if(clientData.newMouse)
        {
            g.setColor(Color.black);
            g.drawLine(clientData.preMouseX, clientData.preMouseY, clientData.incMouseX, clientData.incMouseY);
            clientData.preMouseX = clientData.incMouseX;
            clientData.preMouseY = clientData.incMouseY;
        }
        if(clientData.newClick)
        {
            g.setColor(Color.black);
            g.drawLine(clientData.preClientMouseX, clientData.preClientMouseY, clientData.mouseX, clientData.mouseY);
            clientData.preClientMouseX = clientData.mouseX;
            clientData.preClientMouseY = clientData.mouseY;
        }
        if(clientData.clearDraw)
        {
            g.setColor(Color.white);
            g.fillRect(0,0, 200, 200);
            clientData.clearDraw = false;
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
}