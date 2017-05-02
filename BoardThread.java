public class BoardThread implements Runnable
{
    public BoardThread()
    {
        
    }
    public void run()
    {
        ClientBoardWindow BoardWindow = new ClientBoardWindow();
        BoardWindow.init(1000, 768);
        BoardWindow.setMinimumSize(new java.awt.Dimension(1000,768));
    }
}