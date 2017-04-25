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
    }

    // draw painting
    public void updatePaint() throws IOException
    {
        Graphics g = paintImage.createGraphics();
        g.setColor(Color.yellow);
     	g.fillOval(clientData.mouseX-10, clientData.mouseY-10, 20, 20);
        g.dispose();
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
}