

public class BoardThread implements Runnable
{
    public BoardThread()
    {
        
    }
    public void run()
    {
        ClientBoardWindow BoardWindow = new ClientBoardWindow();
        BoardWindow.init(1000, 748);
        BoardWindow.setMinimumSize(new java.awt.Dimension(1024,768));
    }
}