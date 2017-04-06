import javax.swing.*;
import net.miginfocom.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class ClientLogin
{
    public ClientLoginProcess process;
    public ClientPanel panel = new ClientPanel();
    public ClientLoginController logincontrol = new ClientLoginController();
    public ClientCreateLoginController createlogincontrol = new ClientCreateLoginController();
    public ClientData clientData = new ClientData();
	public JLabel usernameLabel = new JLabel("Username");
    public JLabel passwordLabel = new JLabel("Password");
	public static JTextField username = new JTextField(15);
	public static JTextField password = new JTextField(15);
    public JLabel createUsernameLabel = new JLabel("Create Username");
    public JLabel createPasswordLabel = new JLabel("Create Password");
    public static JTextField createUsername = new JTextField(15);
    public static JTextField createPassword = new JTextField(15);

    public JButton login = new JButton("Login");
    public JButton createlogin = new JButton("Create Account");
    
	ClientLogin()
	{
        panel.setBackground(Color.lightGray);
        panel.setLayout(new MigLayout("aligny center, alignx center"));

		panel.add(usernameLabel, "wrap, center");
        usernameLabel.setVisible(true);

    	username.setSize(225, 25);
    	panel.add(username, "wrap");
    	username.setVisible(true);
    	
        panel.add(passwordLabel, "wrap, center");
        passwordLabel.setVisible(true);

    	password.setSize(225, 25);
    	panel.add(password, "wrap, center");
    	password.setVisible(true);

        login.setSize(225, 25);
        panel.add(login, "wrap 50px, center");
        login.setVisible(true);
        login.addKeyListener(logincontrol);
        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                attemptLogin();
            }
        });

        panel.add(createUsernameLabel, "wrap, center");
        createUsernameLabel.setVisible(true);

        createUsername.setSize(225, 25);
        panel.add(createUsername, "wrap");
        createUsername.setVisible(true);

        panel.add(createPasswordLabel, "wrap, center");
        createPasswordLabel.setVisible(true);

        createPassword.setSize(225, 25);
        panel.add(createPassword, "wrap, center");
        createPassword.setVisible(true);

        createlogin.setSize(225, 25);
        panel.add(createlogin, "wrap, center");
        createlogin.setVisible(true);
        createlogin.addKeyListener(createlogincontrol);
        createlogin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                attemptCreateLogin();
            }
        });
	}

    void attemptLogin()
    {
        clientData.username = username.getText();
        clientData.password = password.getText();
        process.attemptLogin();
    }

    class ClientLoginController implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                attemptLogin();
            }
        }

        public void keyReleased(KeyEvent e)
        {

        }

        public void keyTyped(KeyEvent e)
        {
            
        }
    }

    void attemptCreateLogin()
    {

    }

    class ClientCreateLoginController implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                attemptCreateLogin();
            }
        }

        public void keyReleased(KeyEvent e)
        {

        }

        public void keyTyped(KeyEvent e)
        {
            
        }
    }

    public void loginAttempt()
    {

    }

    public void createloginAttempt()
    {

    }
}