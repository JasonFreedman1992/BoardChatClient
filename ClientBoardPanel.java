import javax.swing.JPanel;

public class ClientBoardPanel extends JPanel
{
    public ClientBoardPanel() 
    {
        initComponents();
    }

    public java.awt.image.BufferedImage popupImage = new java.awt.image.BufferedImage(180, 280, java.awt.image.BufferedImage.TYPE_INT_RGB);
    public boolean popupOn = false;

    private void initComponents() 
    {
        ClientData clientData = new ClientData();
        setVisible(true);
        chatSend = new javax.swing.JTextField();
        red = new javax.swing.JPanel();
        blue = new javax.swing.JPanel();
        orange = new javax.swing.JPanel();
        yellow = new javax.swing.JPanel();
        green = new javax.swing.JPanel();
        lightBlue = new javax.swing.JPanel();
        purple = new javax.swing.JPanel();
        pink = new javax.swing.JPanel();
        white = new javax.swing.JPanel();
        black = new javax.swing.JPanel();
        clearPanel = new javax.swing.JPanel();
        clearLabel = new javax.swing.JLabel();
        sendPanel = new javax.swing.JPanel();
        sendLabel = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        sizeSlider = new javax.swing.JSlider();
        popup = new javax.swing.JPanel();
        popupDraw = new javax.swing.JPanel()
        {
            public void paintComponent(java.awt.Graphics g) 
            {
                g.drawImage(popupImage, 0, 0, null);
            }
        };
        setBackground(new java.awt.Color(0, 102, 153));

        chatSend.addKeyListener(new java.awt.event.KeyListener()
        {
            public void keyPressed(java.awt.event.KeyEvent e)
            {
                if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
                {
                    if(!chatSend.getText().equals(""))
                    {
                        StringBuilder s = new StringBuilder();
                        s.append(clientData.joinBoardNameID);
                        s.append("=/");
                        s.append(chatSend.getText());
                        clientData.output = s.toString();
                        clientData.msgPressed = true;
                        chatSend.setText("");
                    }
                }
            }

            public void keyReleased(java.awt.event.KeyEvent e)
            {

            }

            public void keyTyped(java.awt.event.KeyEvent e)
            {

            }
        });

        drawPanel = new DrawPanel();
        drawPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawPanel.setPreferredSize(new java.awt.Dimension(920, 625));
        drawPanel.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                
            }
            public void mousePressed(java.awt.event.MouseEvent e)
            {
                boolean first = true;
                if(first)
                {
                    clientData.mouseX = clientData.mouseX;
                    clientData.mouseY = clientData.mouseY;
                    clientData.preClientMouseX = clientData.mouseX;
                    clientData.preClientMouseY = clientData.mouseY;
                    first = false;
                }
                clientData.mousePressed = true;
                clientData.imgPressed = true;
                clientData.newClick = true;
            }

            public void mouseReleased(java.awt.event.MouseEvent e)
            {
                clientData.mousePressed = false;
                clientData.imgPressed = false;
                clientData.newClick = false;
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$closing$");
                clientData.output = s.toString();
                clientData.msgPressed = true;
            }
        });
        drawPanel.addMouseMotionListener(new java.awt.event.MouseAdapter()
        {
            public void mouseMoved(java.awt.event.MouseEvent e)
            {
                clientData.mouseX = e.getX();
                clientData.mouseY = e.getY();
            }

            public void mouseDragged(java.awt.event.MouseEvent e)
            {
                clientData.mouseX = e.getX();
                clientData.mouseY = e.getY();
            }
        });

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 942, Short.MAX_VALUE));
        drawPanelLayout.setVerticalGroup(drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 605, Short.MAX_VALUE));

        red.setBackground(new java.awt.Color(255, 51, 51));
        red.setPreferredSize(new java.awt.Dimension(25, 25));
        red.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$0");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(255, 51, 51);
            }
        });

        javax.swing.GroupLayout redLayout = new javax.swing.GroupLayout(red);
        red.setLayout(redLayout);
        redLayout.setHorizontalGroup(redLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        redLayout.setVerticalGroup(redLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 25, Short.MAX_VALUE));

        orange.setBackground(new java.awt.Color(255, 153, 0));
        orange.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$1");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(255, 153, 0);
            }
        });

        javax.swing.GroupLayout orangeLayout = new javax.swing.GroupLayout(orange);
        orange.setLayout(orangeLayout);
        orangeLayout.setHorizontalGroup(
        orangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        orangeLayout.setVerticalGroup(orangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

        yellow.setBackground(new java.awt.Color(255, 255, 51));
        yellow.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$2");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(255, 255, 51);
            }
        });

        javax.swing.GroupLayout yellowLayout = new javax.swing.GroupLayout(yellow);
        yellow.setLayout(yellowLayout);
        yellowLayout.setHorizontalGroup(
        yellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        yellowLayout.setVerticalGroup(yellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

        green.setBackground(new java.awt.Color(153, 255, 102));
        green.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$3");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(153, 255, 102);
            }
        });

        javax.swing.GroupLayout greenLayout = new javax.swing.GroupLayout(green);
        green.setLayout(greenLayout);
        greenLayout.setHorizontalGroup(
        greenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        greenLayout.setVerticalGroup(greenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

        lightBlue.setBackground(new java.awt.Color(0, 204, 255));
        lightBlue.setPreferredSize(new java.awt.Dimension(53, 25));
        lightBlue.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$4");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(0, 204, 255);
            }
        });

        javax.swing.GroupLayout lightBlueLayout = new javax.swing.GroupLayout(lightBlue);
        lightBlue.setLayout(lightBlueLayout);
        lightBlueLayout.setHorizontalGroup(
        lightBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        lightBlueLayout.setVerticalGroup(lightBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 25, Short.MAX_VALUE));

        blue.setBackground(new java.awt.Color(0, 51, 255));
        blue.setPreferredSize(new java.awt.Dimension(25, 30));
        blue.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$5");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(0, 51, 255);
            }
        });

        javax.swing.GroupLayout blueLayout = new javax.swing.GroupLayout(blue);
        blue.setLayout(blueLayout);
        blueLayout.setHorizontalGroup(
        blueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        blueLayout.setVerticalGroup(blueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

        purple.setBackground(new java.awt.Color(102, 0, 153));
        purple.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$6");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(102, 0, 153);
            }
        });

        javax.swing.GroupLayout purpleLayout = new javax.swing.GroupLayout(purple);
        purple.setLayout(purpleLayout);
        purpleLayout.setHorizontalGroup(purpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        purpleLayout.setVerticalGroup(purpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

        pink.setBackground(new java.awt.Color(255, 102, 204));
        pink.setPreferredSize(new java.awt.Dimension(53, 25));
        pink.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$7");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(255, 102, 204);
            }
        });

        javax.swing.GroupLayout pinkLayout = new javax.swing.GroupLayout(pink);
        pink.setLayout(pinkLayout);
        pinkLayout.setHorizontalGroup(pinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        pinkLayout.setVerticalGroup(pinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 25, Short.MAX_VALUE));

        black.setBackground(new java.awt.Color(0, 0, 0));
        black.setPreferredSize(new java.awt.Dimension(53, 25));
        black.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$8");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(0, 0, 0);
            }
        });

        javax.swing.GroupLayout blackLayout = new javax.swing.GroupLayout(black);
        black.setLayout(blackLayout);
        blackLayout.setHorizontalGroup(blackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        blackLayout.setVerticalGroup(blackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 25, Short.MAX_VALUE));

        white.setBackground(new java.awt.Color(255, 255, 255));
        white.setPreferredSize(new java.awt.Dimension(53, 25));
        white.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$color$9");
                clientData.output = s.toString();
                clientData.msgPressed = true;
                clientData.currentColor = new java.awt.Color(255, 255, 255);
            }
        });

        javax.swing.GroupLayout whiteLayout = new javax.swing.GroupLayout(white);
        white.setLayout(whiteLayout);
        whiteLayout.setHorizontalGroup(whiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, Short.MAX_VALUE));
        whiteLayout.setVerticalGroup(whiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 25, Short.MAX_VALUE));

        clearPanel.setBackground(new java.awt.Color(0, 153, 153));
        clearPanel.setPreferredSize(new java.awt.Dimension(90, 25));

        clearLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        clearLabel.setForeground(new java.awt.Color(255, 255, 255));
        clearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clearLabel.setText("Clear");
        clearLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                StringBuilder s = new StringBuilder();
                s.append(clientData.joinBoardNameID);
                s.append("=/$clear$");
                clientData.output = s.toString();
                clientData.msgPressed = true;
            }
        });

        javax.swing.GroupLayout clearPanelLayout = new javax.swing.GroupLayout(clearPanel);
        clearPanel.setLayout(clearPanelLayout);
        clearPanelLayout.setHorizontalGroup(clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(clearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE));
        clearPanelLayout.setVerticalGroup(clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(clearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE));

        sendPanel.setBackground(new java.awt.Color(0, 153, 153));
        sendPanel.setPreferredSize(new java.awt.Dimension(57, 23));

        sendLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        sendLabel.setForeground(new java.awt.Color(255, 255, 255));
        sendLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sendLabel.setText("Send");
        sendLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                if(!chatSend.getText().equals(""))
                {
                    StringBuilder s = new StringBuilder();
                    s.append(clientData.joinBoardNameID);
                    s.append("=/");
                    s.append(chatSend.getText());
                    clientData.output = s.toString();
                    clientData.msgPressed = true;
                    chatSend.setText("");
                }
            }
        });

        javax.swing.GroupLayout sendPanelLayout = new javax.swing.GroupLayout(sendPanel);
        sendPanel.setLayout(sendPanelLayout);
        sendPanelLayout.setHorizontalGroup(sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(sendLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE));
        sendPanelLayout.setVerticalGroup(sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(sendLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE));

        //
        // information for Board popup
        //
        popup.setLayout(new java.awt.GridBagLayout());
        popup.setBackground(new java.awt.Color(0, 102, 153));
        popup.setSize(200,300);
        popup.setLocation(drawPanel.width-220,drawPanel.height-320);
        popupDraw.setPreferredSize(new java.awt.Dimension(180, 280));
        popupDraw.setLocation(10, 10);           
        popup.add(popupDraw);
        drawPanel.add(popup);
        popup.setVisible(false);

        infoPanel.setBackground(new java.awt.Color(0, 153, 153));
        infoPanel.setPreferredSize(new java.awt.Dimension(80, 23));
        infoPanel.setMaximumSize(new java.awt.Dimension(80, 23));
        infoLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 17)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel.setText("Board Information");
        infoLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                if(popupOn == false)
                {
                    
                    java.awt.Graphics g = popupImage.getGraphics();
                    popup.setVisible(true);
                    popupDraw.setVisible(true);
                    g.setColor(java.awt.Color.white);
                    g.fillRect(0,0, 180, 280);
                    g.setColor(java.awt.Color.black);
                    g.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
                    g.drawString("Board: " + clientData.joinBoardName, 0, 14);
                    for(int j = 0; j < clientData.usersInBoard.size(); j++)
                    {
                        g.drawString(clientData.usersInBoard.get(j), 0, 14+((j+1)*14));
                    }
                    popupOn = true;
                }
                else
                {
                    popup.setVisible(false);
                    popupDraw.setVisible(false);
                    popupOn = false;
                }
                
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        infoPanelLayout.setVerticalGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        sizeSlider.setMaximum(16);
        sizeSlider.setMinimum(4);
        sizeSlider.setMinorTickSpacing(4);
        sizeSlider.setValue(4);
        sizeSlider.setPaintLabels(true);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setSnapToTicks(true);
        sizeSlider.setToolTipText("0");
        sizeSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent e)
            {
                javax.swing.JSlider slider = (javax.swing.JSlider)e.getSource();
                if(!slider.getValueIsAdjusting())
                {
                    int n = slider.getValue();
                    System.out.println("slider value : " + n);
                    clientData.currentStroke = new java.awt.BasicStroke(slider.getValue());
                    StringBuilder s = new StringBuilder();
                    s.append(clientData.joinBoardNameID);
                    s.append("=/$brush$");
                    switch(n)
                    {
                        case 4:
                            s.append("0");
                            break;
                        case 8:
                            s.append("1");
                            break;
                        case 12:
                            s.append("2");
                            break;
                        case 16:
                            s.append("3");
                            break;
                    }
                    clientData.output = s.toString();
                    clientData.msgPressed = true;
                }
            }
        });

        javax.swing.GroupLayout framePanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(framePanelLayout);
        framePanelLayout.setHorizontalGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(framePanelLayout.createSequentialGroup().addContainerGap(19, Short.MAX_VALUE).addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(framePanelLayout.createSequentialGroup().addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(chatSend, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(framePanelLayout.createSequentialGroup().addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(orange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(yellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(green, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lightBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(blue, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(purple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(black, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(white, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(framePanelLayout.createSequentialGroup().addComponent(sendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(clearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(framePanelLayout.createSequentialGroup().addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(2, 2, 2)))).addComponent(drawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(20, Short.MAX_VALUE)));
        framePanelLayout.setVerticalGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(framePanelLayout.createSequentialGroup().addContainerGap(29, Short.MAX_VALUE).addComponent(drawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(11, 11, 11).addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(red, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(blue, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE).addComponent(orange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(yellow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(green, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lightBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(purple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(pink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(white, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addComponent(black, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(11, 11, 11).addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(chatSend, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(clearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(sendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(29, Short.MAX_VALUE)));
    }

    public javax.swing.JPanel black;
    public javax.swing.JPanel blue;
    public javax.swing.JTextField chatSend;
    public javax.swing.JLabel clearLabel;
    private javax.swing.JPanel clearPanel;
    public javax.swing.JPanel purple;
    public DrawPanel drawPanel;
    public javax.swing.JPanel green;
    public javax.swing.JLabel infoLabel;
    private javax.swing.JPanel infoPanel;
    public javax.swing.JPanel lightBlue;
    public javax.swing.JPanel orange;
    public javax.swing.JPanel pink;
    public javax.swing.JPanel red;
    public javax.swing.JLabel sendLabel;
    private javax.swing.JPanel sendPanel;
    public javax.swing.JSlider sizeSlider;
    public javax.swing.JPanel white;
    public javax.swing.JPanel yellow;

    public javax.swing.JPanel popup;
    public javax.swing.JPanel popupDraw;
}
