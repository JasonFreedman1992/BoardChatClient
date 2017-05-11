public class ClientFriendsList
{
	public ClientData clientData;

    private javax.swing.JLabel addButtonLabel;
    private javax.swing.JLabel boardsInfoLabel;
    private javax.swing.JLabel friendsInfoLabel;
    private javax.swing.JLabel setButtonLabel;
    private javax.swing.JLabel subButtonLabel;

    public javax.swing.JPanel borderPanel;
    public javax.swing.JPanel infoPanel;
    private javax.swing.JPanel boardsInfoPanel;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JPanel friendsInfoPanel;

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTree jTree1;
    public javax.swing.JTree jTree2;

    private javax.swing.JPopupMenu addPopup;
    private javax.swing.JPopupMenu subPopup;
    private javax.swing.JPopupMenu setPopup;

    // End of variables declaration//GEN-END:variables

	ClientFriendsList(javax.swing.GroupLayout p_layout)
	{
		clientData = new ClientData();
        borderPanel = new javax.swing.JPanel();
        commandPanel = new javax.swing.JPanel();
        addButtonLabel = new javax.swing.JLabel();
        subButtonLabel = new javax.swing.JLabel();
        setButtonLabel = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        friendsInfoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        friendsInfoLabel = new javax.swing.JLabel();
        boardsInfoPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        boardsInfoLabel = new javax.swing.JLabel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //setMinimumSize(new java.awt.Dimension(280, 750));
        //setSize(new java.awt.Dimension(280, 750));

        borderPanel.setBackground(new java.awt.Color(255, 255, 255));
        borderPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        borderPanel.setLayout(new java.awt.BorderLayout());

        commandPanel.setBackground(new java.awt.Color(0, 153, 153));
        commandPanel.setLayout(new java.awt.GridBagLayout());

        addButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        addButtonLabel.addMouseListener(new addListen());
        commandPanel.add(addButtonLabel, new java.awt.GridBagConstraints());

        subButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sub.png"))); // NOI18N
        subButtonLabel.addMouseListener(new subListen());
        commandPanel.add(subButtonLabel, new java.awt.GridBagConstraints());

        setButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/set.png"))); // NOI18N
        setButtonLabel.addMouseListener(new setListen());
        commandPanel.add(setButtonLabel, new java.awt.GridBagConstraints());

        borderPanel.add(commandPanel, java.awt.BorderLayout.CENTER);

        infoPanel.setBackground(new java.awt.Color(0, 102, 153));
        infoPanel.setMaximumSize(new java.awt.Dimension(0, 0));
        infoPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        infoPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        friendsInfoPanel.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.JPopupMenu friendMenu = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem inviteItem = new javax.swing.JMenuItem("Invite");
        javax.swing.JMenuItem removeItem = new javax.swing.JMenuItem("Remove");

        friendMenu.add(inviteItem);
        friendMenu.add(removeItem);
        
        //
        // jtree1 is for friends, jtree2 is for boards
        //
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setRootVisible(false);  
        java.awt.event.MouseListener friendTreeListen = new java.awt.event.MouseAdapter() 
        {
            public void mousePressed(java.awt.event.MouseEvent e) 
            {
                if(javax.swing.SwingUtilities.isRightMouseButton(e))
                {
                    int row = jTree1.getClosestRowForLocation(e.getX(), e.getY());
                    jTree1.setSelectionRow(row);
                    javax.swing.tree.DefaultMutableTreeNode node = (javax.swing.tree.DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
                    Object nodeInfo = node.getUserObject();
                    System.out.println(node.getParent());
                    if(node.isLeaf())
                    {
                        if(!node.toString().equals("Online") && !node.toString().equals("Offline"))
                        {
                            if(node.getParent().toString().equals("Online"))
                            {
                                inviteItem.setEnabled(true);
                                friendMenu.show(e.getComponent(), e.getX(), e.getY());
                            }
                            else
                            {
                                inviteItem.setEnabled(false);
                                friendMenu.show(e.getComponent(), e.getX(), e.getY());
                            }
                        }
                    }
                }
            }
        };
        jTree1.addMouseListener(friendTreeListen);

        jScrollPane1.setViewportView(jTree1);

        javax.swing.JPopupMenu boardMenu = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem joinItem = new javax.swing.JMenuItem("Join");
        javax.swing.JMenuItem infoItem = new javax.swing.JMenuItem("Information");
        boardMenu.add(joinItem);
        boardMenu.add(infoItem);

        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree2.setModel(new javax.swing.tree.DefaultTreeModel(treeNode2));
        jTree2.setRootVisible(false);

        java.awt.event.MouseListener boardTreeListen = new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent e)
            {
                if(javax.swing.SwingUtilities.isRightMouseButton(e))
                {
                    int row = jTree2.getClosestRowForLocation(e.getX(), e.getY());
                    jTree2.setSelectionRow(row);
                    javax.swing.tree.DefaultMutableTreeNode node = (javax.swing.tree.DefaultMutableTreeNode) jTree2.getLastSelectedPathComponent();
                    //Object nodeInfo = node.getUserObject();

                    if(node != null)
                    {
                        if(node.isLeaf())
                        {
                            if(!node.toString().equals("Public"))
                            {
                                System.out.println(node.toString());
                                boardMenu.show(e.getComponent(), e.getX(), e.getY());
                            }
                        }
                    }
                }
            }
        };
        jTree2.addMouseListener(boardTreeListen);

        jScrollPane2.setViewportView(jTree2);

        //
        //
        //
        friendsInfoLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 36)); // NOI18N
        friendsInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        friendsInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        friendsInfoLabel.setText("Friends");
        friendsInfoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout friendsInfoPanelLayout = new javax.swing.GroupLayout(friendsInfoPanel);
        friendsInfoPanel.setLayout(friendsInfoPanelLayout);
        friendsInfoPanelLayout.setHorizontalGroup(
            friendsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
            .addComponent(friendsInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        friendsInfoPanelLayout.setVerticalGroup(
            friendsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendsInfoPanelLayout.createSequentialGroup()
                .addComponent(friendsInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        boardsInfoPanel.setBackground(new java.awt.Color(0, 153, 153));

        boardsInfoLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 36)); // NOI18N
        boardsInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        boardsInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boardsInfoLabel.setText("Boards");
        boardsInfoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout boardsInfoPanelLayout = new javax.swing.GroupLayout(boardsInfoPanel);
        boardsInfoPanel.setLayout(boardsInfoPanelLayout);
        boardsInfoPanelLayout.setHorizontalGroup(
            boardsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardsInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boardsInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        boardsInfoPanelLayout.setVerticalGroup(
            boardsInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boardsInfoPanelLayout.createSequentialGroup()
                .addComponent(boardsInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friendsInfoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boardsInfoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(infoPanelLayout.createSequentialGroup().addContainerGap().addComponent(friendsInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(boardsInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));

        //
        //
        //
        javax.swing.GroupLayout layout = p_layout;
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(borderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE).addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(19, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(borderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(50, Short.MAX_VALUE)));
	}



    class addListen implements java.awt.event.MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {
            javax.swing.JPopupMenu addMenu = new javax.swing.JPopupMenu();
            javax.swing.JMenuItem addFriendItem = new javax.swing.JMenuItem("Add Friend");
            javax.swing.JMenuItem joinBoardItem = new javax.swing.JMenuItem("Join/Create Board");
            javax.swing.JMenuItem inviteFriendItem = new javax.swing.JMenuItem("Invite Friend to Board");
            addMenu.add(addFriendItem);
            addMenu.add(joinBoardItem);
            addMenu.add(inviteFriendItem);
            if(!clientData.boardCurrentlyOpen)
            {
                inviteFriendItem.setEnabled(false);
                System.out.println("invite friend to board");

            }
            if(clientData.boardWindowOpen)
            {
                joinBoardItem.setEnabled(false);
            }
            

            addFriendItem.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent ev) 
                {
                    String friend = javax.swing.JOptionPane.showInputDialog("Enter the Friend you would like to Add:");
                    StringBuilder s = new StringBuilder();
                    s.append(clientData.addFriendCommand);
                    s.append(friend);
                    clientData.output = s.toString();
                    clientData.addFriendPressed = true;
                }
            });

            joinBoardItem.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent ev) 
                {
                    Thread BoardThread;
                    BoardThread = new Thread(new BoardThread());
                    BoardThread.start();
                    clientData.boardWindowOpen = true;
                }
            });

            inviteFriendItem.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent ev) 
                {
                    //
                    // invite friend response commands
                    //
                    String friend = javax.swing.JOptionPane.showInputDialog("Enter the Friend you would like to Invite: ");
                    StringBuilder s = new StringBuilder();
                    s.append(clientData.addtoBoardCommand);
                    s.append(friend);
                    clientData.output = s.toString();
                    clientData.inviteBoardPressed = true;
                }
            });

            addMenu.show(e.getComponent(), e.getX(), e.getY());
        }
        public void mouseEntered(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseExited(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseReleased(java.awt.event.MouseEvent e) 
        {

        }

        public void mousePressed(java.awt.event.MouseEvent e) 
        {

        }
    }

    class subListen implements java.awt.event.MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {
            javax.swing.JPopupMenu subMenu = new javax.swing.JPopupMenu();
            javax.swing.JMenuItem subFriendItem = new javax.swing.JMenuItem("Remove Friend");
            javax.swing.JMenuItem exitBoardItem = new javax.swing.JMenuItem("Exit Board");
            subMenu.add(subFriendItem);
            subMenu.add(exitBoardItem);
            if(!clientData.boardCurrentlyOpen)
            {
                exitBoardItem.setEnabled(false);
            }
            subMenu.show(e.getComponent(), e.getX(), e.getY());

            subFriendItem.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent ev) 
                {
                    //
                    // remove friend
                    //
                    String friend = javax.swing.JOptionPane.showInputDialog("Enter the Friend you would like to Remove:");

                    //
                    // add info for checking if friend exists
                    //
                    System.out.println("sub friend");
                    StringBuilder s = new StringBuilder();
                    s.append(clientData.subFriendCommand);
                    s.append(friend);
                    clientData.output = s.toString();
                    clientData.removeFriendPressed = true;
                }
            });

            exitBoardItem.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent ev) 
                {
                    System.out.println("exit Board");
                    clientData.usersInBoard.clear();
                    
                    clientData.boardClosePressed = true;
                    clientData.boardWindowOpen = false;
                    clientData.boardCurrentlyOpen = false;

                }
            });
        }
        public void mouseEntered(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseExited(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseReleased(java.awt.event.MouseEvent e) 
        {

        }

        public void mousePressed(java.awt.event.MouseEvent e) 
        {

        }
    }

    class setListen implements java.awt.event.MouseListener
    {
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {
            javax.swing.JPopupMenu setMenu = new javax.swing.JPopupMenu();
            javax.swing.JMenuItem saveImageItem = new javax.swing.JMenuItem("Save Image");
            javax.swing.JMenuItem aboutItem = new javax.swing.JMenuItem("About");
            javax.swing.JMenuItem logoutItem = new javax.swing.JMenuItem("Log Out");
            javax.swing.JMenuItem exitItem = new javax.swing.JMenuItem("Exit");
            setMenu.add(saveImageItem);
            setMenu.add(aboutItem);
            setMenu.add(logoutItem);
            setMenu.add(exitItem);

            if(!clientData.boardCurrentlyOpen)
            {
                saveImageItem.setEnabled(false);
            }

            saveImageItem.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent ev) 
                {
                    clientData.saveImgPressed = true;
                    //
                    // write dialogue where image saving happens.
                    //
                    System.out.println("save Image");
                }
            });

            aboutItem.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent ev) 
                {
                    javax.swing.JOptionPane.showMessageDialog(null, "Developed in April and May 2017 by Software Engineer Jason Freedman. \nTo find out more, please visit www.jasonfreedmancode.com");
                    System.out.println("about");
                }
            });

            logoutItem.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent ev) 
                {
                    if(clientData.boardCurrentlyOpen)
                    {
                        clientData.boardCurrentlyOpen = false;
                        clientData.boardClosePressed = true;
                    }
                    clientData.onlineBoards.clear();
                    clientData.loginSuccess = false;
                    clientData.boardWindowOpen = false;
                    
                    clientData.usersInBoard.clear();
                    clientData.onlineFriends.clear();
                    clientData.offlineFriends.clear();
                    clientData.loginSuccess = false;
                    while(clientData.boardClosePressed)
                    {

                    }
                    clientData.networkRunning = false;
                    System.out.println("logout");
                }
            });

            exitItem.addActionListener(new java.awt.event.ActionListener() 
            {
                public void actionPerformed(java.awt.event.ActionEvent ev) 
                {

                    System.exit(0);
                }
            });

            setMenu.show(e.getComponent(), e.getX(), e.getY());
        }
        public void mouseEntered(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseExited(java.awt.event.MouseEvent e) 
        {

        }

        public void mouseReleased(java.awt.event.MouseEvent e) 
        {

        }

        public void mousePressed(java.awt.event.MouseEvent e) 
        {

        }
    }
}