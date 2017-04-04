import javax.swing.*;
import net.miginfocom.swing.*;
import java.awt.Color;

public class ClientLogin
{
	public JLabel usernameLabel = new JLabel("Username");
    public JLabel passwordLabel = new JLabel("Password");
	public JTextField username = new JTextField(15);
	public JTextField password = new JTextField(15);
    public JLabel createUsernameLabel = new JLabel("Create Username");
    public JLabel createPasswordLabel = new JLabel("Create Password");
    public JTextField createUsername = new JTextField(15);
    public JTextField createPassword = new JTextField(15);
	public ClientPanel panel = new ClientPanel();
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
    	panel.add(password, "wrap 50px");
    	password.setVisible(true);

        panel.add(createUsernameLabel, "wrap, center");
        createUsernameLabel.setVisible(true);
        createUsername.setSize(225, 25);
        panel.add(createUsername, "wrap");
        createUsername.setVisible(true);

        panel.add(createPasswordLabel, "wrap, center");
        createPasswordLabel.setVisible(true);
        createPassword.setSize(225, 25);
        panel.add(createPassword, "wrap");
        createPassword.setVisible(true);
	}
}