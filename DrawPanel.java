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
    public BufferedImage paintImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
	ClientData clientData = new ClientData();
    public boolean firstDraw = false;
    int width = 942;
    int height = 605;

    protected void paintComponent(Graphics g)
    {
        //draw();
        // setBackground(Color.white);
        //             g.setColor(Color.white);
        //     g.fillRect(0,0, width, height);
        // System.out.println("painting");
        // System.out.println(this.getSize());
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
            g.fillRect(0,0, width, height);
            clientData.clearDraw = false;
        }
        if(firstDraw)
        {
            System.out.println("firstdraw");
            g.setColor(Color.white);
            g.fillRect(0,0,width,height);
            firstDraw = false;
        }
        if(clientData.resize)
        {
            try
            {
                load();
            }
            catch(IOException e)
            {
                
            }
        }
    }
    public void save() throws IOException
    {
        //ImageIO.write()
    }

    public void load() throws IOException
    {

    }
}