public class ClientLogin
{
    public ClientData clientData;
    private javax.swing.JPanel CreateButtonPanel;
    public javax.swing.JPanel FramePanel;
    private javax.swing.JPanel LoginButtonPanel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JLabel createLabel;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JSeparator passwordSeparator;
    public javax.swing.JLabel resultsLabel;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JSeparator usernameSeparator;
    
	ClientLogin()
	{
        clientData = new ClientData();
        FramePanel = new javax.swing.JPanel();
        LoginPanel = new javax.swing.JPanel();
        LoginPanel.setLayout(new java.awt.BorderLayout());
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameSeparator = new javax.swing.JSeparator();
        passwordSeparator = new javax.swing.JSeparator();
        CreateButtonPanel = new javax.swing.JPanel();
        createLabel = new javax.swing.JLabel();
        LoginButtonPanel = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        resultsLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        FramePanel.setBackground(new java.awt.Color(0, 102, 153));
        FramePanel.setMinimumSize(new java.awt.Dimension(280, 750));
        FramePanel.setPreferredSize(new java.awt.Dimension(280, 750));
        FramePanel.setLayout(new java.awt.GridBagLayout());

        LoginPanel.setBackground(new java.awt.Color(0, 102, 153));
        LoginPanel.setPreferredSize(new java.awt.Dimension(225, 225));

        usernameLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18));
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18));
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");

        usernameSeparator.setForeground(new java.awt.Color(255, 255, 255));
        usernameSeparator.setMinimumSize(new java.awt.Dimension(200, 10));
        usernameSeparator.setPreferredSize(new java.awt.Dimension(200, 10));

        passwordSeparator.setForeground(new java.awt.Color(255, 255, 255));

        CreateButtonPanel.setBackground(new java.awt.Color(0, 153, 153));
        CreateButtonPanel.setPreferredSize(new java.awt.Dimension(100, 40));

        createLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14));
        createLabel.addMouseListener(new createListen());
        createLabel.setForeground(new java.awt.Color(255, 255, 255));
        createLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createLabel.setText("Create");
        createLabel.setFocusable(true);
        createLabel.addFocusListener(new createFocusListen());
        createLabel.addKeyListener(new keyListen());

        LoginButtonPanel.setBackground(new java.awt.Color(0, 153, 153));
        LoginButtonPanel.setPreferredSize(new java.awt.Dimension(100, 40));

        loginLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14));
        loginLabel.addMouseListener(new loginListen());
        loginLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("Login");
        loginLabel.setFocusable(true);
        loginLabel.addFocusListener(new loginFocusListen());
        loginLabel.addKeyListener(new keyListen());

        username.setBackground(new java.awt.Color(0, 102, 153));
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setBorder(null);
        username.setCaretColor(new java.awt.Color(255, 255, 255));
        username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        username.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        username.addFocusListener(new loginFocusListen());
        username.addKeyListener(new keyListen());

        resultsLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 15));
        resultsLabel.setForeground(new java.awt.Color(255, 255, 255));
        resultsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // resultsLabel.setMinimumSize(new java.awt.Dimension(200, 10));
        // resultsLabel.setMaximumSize(new java.awt.Dimension(200, 10));
        resultsLabel.setText("");

        password.setBackground(new java.awt.Color(0, 102, 153));
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(null);
        password.setCaretColor(new java.awt.Color(255, 255, 255));
        password.addFocusListener(new loginFocusListen());
        password.addKeyListener(new keyListen());

        javax.swing.GroupLayout LoginButtonPanelLayout = new javax.swing.GroupLayout(LoginButtonPanel);
        LoginButtonPanel.setLayout(LoginButtonPanelLayout);
        LoginButtonPanelLayout.setHorizontalGroup(LoginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE));
        LoginButtonPanelLayout.setVerticalGroup(LoginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

        javax.swing.GroupLayout CreateButtonPanelLayout = new javax.swing.GroupLayout(CreateButtonPanel);
        CreateButtonPanel.setLayout(CreateButtonPanelLayout);
        CreateButtonPanelLayout.setHorizontalGroup(CreateButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(createLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE));
        CreateButtonPanelLayout.setVerticalGroup(CreateButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(createLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup().addComponent(LoginButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE).addComponent(CreateButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(LoginPanelLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(resultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(LoginPanelLayout.createSequentialGroup().addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(passwordSeparator).addComponent(usernameSeparator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE).addComponent(username).addComponent(password)).addComponent(passwordLabel).addComponent(usernameLabel)).addGap(0, 0, Short.MAX_VALUE)));
        LoginPanelLayout.setVerticalGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(LoginPanelLayout.createSequentialGroup().addContainerGap().addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(usernameSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(passwordLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(passwordSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(LoginButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(CreateButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(resultsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(7, 7, 7)));
        FramePanel.add(LoginPanel, new java.awt.GridBagConstraints());
    }

    class loginListen implements java.awt.event.MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {
            clientData.loginPressed = true;
            System.out.println("login listen clicked!");
            attemptLogin();
        }
        public void mouseEntered(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseExited(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseReleased(java.awt.event.MouseEvent me) 
        {

        }

        public void mousePressed(java.awt.event.MouseEvent me) 
        {

        }
    }

    class createListen implements java.awt.event.MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {
            clientData.createPressed = true;
            System.out.println("create listen clicked!");
            createLogin();
        }
        public void mouseEntered(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseExited(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseReleased(java.awt.event.MouseEvent me) 
        {

        }

        public void mousePressed(java.awt.event.MouseEvent me) 
        {

        }
    }

    class loginFocusListen implements java.awt.event.FocusListener
    {
        public void focusGained(java.awt.event.FocusEvent e) 
        {
            clientData.loginFocused = true;
            System.out.println("login focus = " + clientData.loginFocused);
        }

        public void focusLost(java.awt.event.FocusEvent e) 
        {
            clientData.loginFocused = false;
            System.out.println("login focus = " + clientData.loginFocused);
        }
    }

    class createFocusListen implements java.awt.event.FocusListener
    {
        public void focusGained(java.awt.event.FocusEvent e) 
        {
            clientData.createFocused = true;
            System.out.println("create focus = " + clientData.createFocused);
        }

        public void focusLost(java.awt.event.FocusEvent e) 
        {
            clientData.createFocused = false;
            System.out.println("create focus = " + clientData.createFocused);
        }
    }

    class keyListen implements java.awt.event.KeyListener
    {     
        public void keyPressed(java.awt.event.KeyEvent e)
        {
            if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            {
                if(clientData.createFocused == true)
                {
                    System.out.println("create pressed");
                    clientData.createPressed = true;
                    createLogin();
                }
                else if(clientData.loginFocused == true)
                {
                    System.out.println("login pressed");
                    clientData.loginPressed = true;
                    attemptLogin();
                }
            }
        }

        public void keyReleased(java.awt.event.KeyEvent e)
        {

        }

        public void keyTyped(java.awt.event.KeyEvent e)
        {

        }
    }

    void attemptLogin()
    {
        clientData.username = username.getText() + "=";
        clientData.password = password.getText();
    }

    void createLogin()
    {
        clientData.createUsername = username.getText() + "=";
        clientData.createPassword = password.getText();
    }
}
