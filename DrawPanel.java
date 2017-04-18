import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;

public class DrawPanel extends JPanel
{
	ClientData clientData = new ClientData();
    private BufferedImage paintImage = new BufferedImage(500, 400, BufferedImage.TYPE_3BYTE_BGR);
    public Graphics g;
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(paintImage, 0, 0, null);
    }

    // draw painting
    public void updatePaint()
    {
        Graphics g = paintImage.createGraphics();

        // draw on paintImage using Graphics

        g.dispose();
        // repaint panel with new modified paint
        repaint();
    }

    public void save() throws IOException
    {
        ImageIO.write(paintImage, "PNG", new File("fart.png"));
    }

    public void load() throws IOException 
    {
        paintImage = ImageIO.read(new File("fart.png"));
        repaint();
    }
}