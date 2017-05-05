import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.Random;

public class DrawPanel extends JPanel
{
    int width = 942;
    int height = 605;
    public BufferedImage paintImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
	ClientData clientData = new ClientData();
    public boolean firstDraw = false;

    protected void paintComponent(Graphics g)
    {
        g.drawImage(paintImage, 0, 0, null);
        //draw();
        // setBackground(Color.white);
        //             g.setColor(Color.white);
        //     g.fillRect(0,0, width, height);
        // System.out.println("painting");
        // System.out.println(this.getSize());


        // if(clientData.newMouse)
        // {
        //     g.setColor(Color.black);
        //     g.drawLine(clientData.preMouseX, clientData.preMouseY, clientData.incMouseX, clientData.incMouseY);
        //     clientData.preMouseX = clientData.incMouseX;
        //     clientData.preMouseY = clientData.incMouseY;
        // }
        // if(clientData.newClick)
        // {
        //     g.setColor(Color.black);
        //     g.drawLine(clientData.preClientMouseX, clientData.preClientMouseY, clientData.mouseX, clientData.mouseY);
        //     clientData.preClientMouseX = clientData.mouseX;
        //     clientData.preClientMouseY = clientData.mouseY;
        // }
        // if(clientData.clearDraw)
        // {
        //     g.setColor(Color.white);
        //     g.fillRect(0,0, width, height);
        //     clientData.clearDraw = false;
        // }
        // if(firstDraw)
        // {
        //     System.out.println("firstdraw");
        //     g.setColor(Color.white);
        //     g.fillRect(0,0,width,height);
        //     firstDraw = false;
        // }
        // if(clientData.resize)
        // {
        //     try
        //     {
        //         load();
        //     }
        //     catch(IOException e)
        //     {

        //     }
        // }
    }

    public void updatePaint()
    {
        Graphics g = paintImage.createGraphics();
        g.setColor(Color.white);
        if(clientData.newMouse)
        {
            for(int i = 0; i < clientData.usersInBoard.size(); i++)
            {
                String user = clientData.usersInBoard.get(i);
                if(!user.equals(clientData.currentUser))
                {
                    if(clientData.usernameTonewMouse.containsKey(user))
                    {
                        if(clientData.usernameTonewMouse.get(user))
                        {
                            if(clientData.usernameToPreXY.containsKey(user) && clientData.usernameToXY.containsKey(user))
                            {
                                //
                                // random colorizing
                                //
                                //Random r = new Random();
                                //g.setColor(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
                                
                                g.setColor(clientData.usernameToColor.get(user));
                                Graphics2D g2 = (Graphics2D) g;
                                g2.setStroke(clientData.usernameToStroke.get(user));
                                g2.drawLine(clientData.usernameToPreXY.get(user)[0], clientData.usernameToPreXY.get(user)[1], clientData.usernameToXY.get(user)[0], clientData.usernameToXY.get(user)[1]);
                                clientData.usernameToPreXY.get(user)[0] = clientData.usernameToXY.get(user)[0];
                                clientData.usernameToPreXY.get(user)[1] = clientData.usernameToXY.get(user)[1];
                            }
                        }
                    }
                }
            }

        }
        if(clientData.newClick)
        {
            g.setColor(clientData.currentColor);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(clientData.currentStroke);
            g2.drawLine(clientData.preClientMouseX, clientData.preClientMouseY, clientData.mouseX, clientData.mouseY);
            clientData.preClientMouseX = clientData.mouseX;
            clientData.preClientMouseY = clientData.mouseY;
        }
        if(clientData.newInput)
        {
            g.setColor(Color.black);
            g.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 14));
            for(int i = 0; i < clientData.chatLog.size(); i++)
            {
                if(i == 0)
                {
                    g.drawString(clientData.chatLog.get(i)[0] + ": " + clientData.chatLog.get(i)[1], 0, 14);
                }
                else
                {
                    g.drawString(clientData.chatLog.get(i)[0] + ": " + clientData.chatLog.get(i)[1], 0, (i+2)*15);
                }
            }
            clientData.newInput = false;
        }
        if(clientData.clearDraw)
        {
            g.setColor(Color.white);
            g.fillRect(0,0, width, height);
            clientData.clearDraw = false;
        }
        if(firstDraw)
        {
            g.setColor(Color.white);
            g.fillRect(0,0,width,height);
            firstDraw = false;
        }
        // if(clientData.resize)
        // {
        //     try
        //     {
        //         load();
        //     }
        //     catch(IOException e)
        //     {

        //     }
        // }
        // try
        // {
            // save();
            // load();
            repaint();
        // }
        // catch(IOException e)
        // {

        // }
    }


    public void save() throws IOException
    {
        ImageIO.write(paintImage, "PNG", new File("hello.png"));
        // ImageIO.write(paintImage, "PNG", out);
        //ImageIO.write()
    }

    public void load() throws IOException
    {
        paintImage = ImageIO.read(new File("hello.png"));
        // InputStream in = new ByteArrayInputStream(out.toByteArray());
        // paintImage = ImageIO.read(in);
    }
}