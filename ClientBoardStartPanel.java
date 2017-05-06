public class ClientBoardStartPanel extends javax.swing.JPanel
{
    public ClientData clientData;
    private javax.swing.JPanel CreateButtonPanel;
    private javax.swing.JPanel LoginButtonPanel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JLabel createLabel;
    private javax.swing.JLabel joinLabel;
    private javax.swing.JPasswordField boardpassword;
    private javax.swing.JLabel boardpasswordLabel;
    private javax.swing.JSeparator boardpasswordSeparator;
    public javax.swing.JLabel resultsLabel;
    private javax.swing.JTextField boardname;
    private javax.swing.JLabel boardnameLabel;
    private javax.swing.JSeparator boardnameSeparator;
    private boolean joinFocused = false;
    private boolean createFocused = false;

	ClientBoardStartPanel()
	{
        clientData = new ClientData();
        LoginPanel = new javax.swing.JPanel();
        LoginPanel.setLayout(new java.awt.BorderLayout());
        boardnameLabel = new javax.swing.JLabel();
        boardpasswordLabel = new javax.swing.JLabel();
        boardnameSeparator = new javax.swing.JSeparator();
        boardpasswordSeparator = new javax.swing.JSeparator();
        CreateButtonPanel = new javax.swing.JPanel();
        createLabel = new javax.swing.JLabel();
        LoginButtonPanel = new javax.swing.JPanel();
        joinLabel = new javax.swing.JLabel();
        boardname = new javax.swing.JTextField();
        resultsLabel = new javax.swing.JLabel();
        boardpassword = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(0, 102, 153));
        setMinimumSize(new java.awt.Dimension(280, 750));
        setPreferredSize(new java.awt.Dimension(280, 750));
        setLayout(new java.awt.GridBagLayout());

        LoginPanel.setBackground(new java.awt.Color(0, 102, 153));
        LoginPanel.setPreferredSize(new java.awt.Dimension(225, 225));
        boardnameLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18));
        boardnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        boardnameLabel.setText("Board Name");

        boardpasswordLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18));
        boardpasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        boardpasswordLabel.setText("Board Password");

        boardnameSeparator.setForeground(new java.awt.Color(255, 255, 255));
        boardnameSeparator.setMinimumSize(new java.awt.Dimension(200, 10));
        boardnameSeparator.setPreferredSize(new java.awt.Dimension(200, 10));
        
        boardpasswordSeparator.setForeground(new java.awt.Color(255, 255, 255));

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

        joinLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14));
        joinLabel.addMouseListener(new joinListen());
        joinLabel.setForeground(new java.awt.Color(255, 255, 255));
        joinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joinLabel.setText("Join");
        joinLabel.setFocusable(true);
        joinLabel.addFocusListener(new joinFocusListen());
        joinLabel.addKeyListener(new keyListen());

        boardname.setBackground(new java.awt.Color(0, 102, 153));
        boardname.setForeground(new java.awt.Color(255, 255, 255));
        boardname.setBorder(null);
        boardname.setCaretColor(new java.awt.Color(255, 255, 255));
        boardname.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        boardname.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        boardname.addFocusListener(new joinFocusListen());
        boardname.addKeyListener(new keyListen());

        resultsLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 15));
        resultsLabel.setForeground(new java.awt.Color(255, 255, 255));
        resultsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultsLabel.setText("");

        boardpassword.setBackground(new java.awt.Color(0, 102, 153));
        boardpassword.setForeground(new java.awt.Color(255, 255, 255));
        boardpassword.setBorder(null);
        boardpassword.setCaretColor(new java.awt.Color(255, 255, 255));
        boardpassword.addFocusListener(new joinFocusListen());
        boardpassword.addKeyListener(new keyListen());

        javax.swing.GroupLayout LoginButtonPanelLayout = new javax.swing.GroupLayout(LoginButtonPanel);
        LoginButtonPanel.setLayout(LoginButtonPanelLayout);
        LoginButtonPanelLayout.setHorizontalGroup(LoginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(joinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE));
        LoginButtonPanelLayout.setVerticalGroup(LoginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(joinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

        javax.swing.GroupLayout CreateButtonPanelLayout = new javax.swing.GroupLayout(CreateButtonPanel);
        CreateButtonPanel.setLayout(CreateButtonPanelLayout);
        CreateButtonPanelLayout.setHorizontalGroup(CreateButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(createLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE));
        CreateButtonPanelLayout.setVerticalGroup(CreateButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(createLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE));

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup().addComponent(LoginButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE).addComponent(CreateButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(LoginPanelLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(resultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(LoginPanelLayout.createSequentialGroup().addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(boardpasswordSeparator).addComponent(boardnameSeparator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE).addComponent(boardname).addComponent(boardpassword)).addComponent(boardpasswordLabel).addComponent(boardnameLabel)).addGap(0, 0, Short.MAX_VALUE)));
        LoginPanelLayout.setVerticalGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(LoginPanelLayout.createSequentialGroup().addContainerGap().addComponent(boardnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(boardname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(boardnameSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(boardpasswordLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(boardpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(boardpasswordSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(LoginButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(CreateButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(resultsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(7, 7, 7)));
        //add(LoginPanel, new java.awt.GridBagConstraints());
        add(LoginPanel);
    }

    // JOIN LISTEN
    class joinListen implements java.awt.event.MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {
            attemptJoin();
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

    // CREATE LISTEN
    class createListen implements java.awt.event.MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {
            createBoard();
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
    // JOIN FOCUS LISTEN
    class joinFocusListen implements java.awt.event.FocusListener
    {
        public void focusGained(java.awt.event.FocusEvent e) 
        {
            joinFocused = true;
        }

        public void focusLost(java.awt.event.FocusEvent e) 
        {
            joinFocused = false;
        }
    }
    // CREATE FOCUS LISTEN
    class createFocusListen implements java.awt.event.FocusListener
    {
        public void focusGained(java.awt.event.FocusEvent e) 
        {
            createFocused = true;
        }

        public void focusLost(java.awt.event.FocusEvent e) 
        {
            createFocused = false;
        }
    }

    class keyListen implements java.awt.event.KeyListener
    {     
        public void keyPressed(java.awt.event.KeyEvent e)
        {
            if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            {
                if(createFocused == true)
                {
                    createBoard();
                }
                else if(joinFocused == true)
                {
                    attemptJoin();
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

    // JOIN
    void attemptJoin()
    {
        clientData.joinBoardPressed = true;
        clientData.boardName = boardname.getText();
        clientData.boardPassword = boardpassword.getText();
    }
    // CREATE
    void createBoard()
    {
        clientData.createBoardPressed = true;
        clientData.boardName = boardname.getText();
        clientData.boardPassword = boardpassword.getText();
        try
        {
            Thread.sleep(500);
            clientData.joinBoardPressed = true;
        }
        catch(InterruptedException f)
        {

        }
    }
}