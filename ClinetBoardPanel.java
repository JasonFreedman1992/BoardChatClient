import javax.swing.JPanel;

public class ClientBoardPanel
{


    public ClientBoardPanel() 
    {
        initComponents();
    }


    private void initComponents() 
    {
        java.awt.GridBagConstraints gridBagConstraints;

        framePanel = new javax.swing.JPanel();
        drawPanel = new javax.swing.JPanel();
        chatSend = new javax.swing.JTextField();
        red = new javax.swing.JPanel();
        blue = new javax.swing.JPanel();
        orange = new javax.swing.JPanel();
        yellow = new javax.swing.JPanel();
        green = new javax.swing.JPanel();
        lightBlue = new javax.swing.JPanel();
        darkBlue = new javax.swing.JPanel();
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

        //setBackground(new java.awt.Color(0, 102, 153));
        //getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        framePanel.setBackground(new java.awt.Color(0, 102, 153));

        drawPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawPanel.setPreferredSize(new java.awt.Dimension(900, 625));

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        red.setBackground(new java.awt.Color(255, 51, 51));
        red.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout redLayout = new javax.swing.GroupLayout(red);
        red.setLayout(redLayout);
        redLayout.setHorizontalGroup(
            redLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        redLayout.setVerticalGroup(
            redLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        blue.setBackground(new java.awt.Color(0, 51, 255));
        blue.setPreferredSize(new java.awt.Dimension(25, 30));

        javax.swing.GroupLayout blueLayout = new javax.swing.GroupLayout(blue);
        blue.setLayout(blueLayout);
        blueLayout.setHorizontalGroup(
            blueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        blueLayout.setVerticalGroup(
            blueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        orange.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout orangeLayout = new javax.swing.GroupLayout(orange);
        orange.setLayout(orangeLayout);
        orangeLayout.setHorizontalGroup(
            orangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        orangeLayout.setVerticalGroup(
            orangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        yellow.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout yellowLayout = new javax.swing.GroupLayout(yellow);
        yellow.setLayout(yellowLayout);
        yellowLayout.setHorizontalGroup(
            yellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        yellowLayout.setVerticalGroup(
            yellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        green.setBackground(new java.awt.Color(153, 255, 102));

        javax.swing.GroupLayout greenLayout = new javax.swing.GroupLayout(green);
        green.setLayout(greenLayout);
        greenLayout.setHorizontalGroup(
            greenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        greenLayout.setVerticalGroup(
            greenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lightBlue.setBackground(new java.awt.Color(0, 204, 255));
        lightBlue.setPreferredSize(new java.awt.Dimension(53, 25));

        javax.swing.GroupLayout lightBlueLayout = new javax.swing.GroupLayout(lightBlue);
        lightBlue.setLayout(lightBlueLayout);
        lightBlueLayout.setHorizontalGroup(
            lightBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        lightBlueLayout.setVerticalGroup(
            lightBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        darkBlue.setBackground(new java.awt.Color(102, 0, 153));

        javax.swing.GroupLayout darkBlueLayout = new javax.swing.GroupLayout(darkBlue);
        darkBlue.setLayout(darkBlueLayout);
        darkBlueLayout.setHorizontalGroup(
            darkBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        darkBlueLayout.setVerticalGroup(
            darkBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pink.setBackground(new java.awt.Color(255, 102, 204));
        pink.setPreferredSize(new java.awt.Dimension(53, 25));

        javax.swing.GroupLayout pinkLayout = new javax.swing.GroupLayout(pink);
        pink.setLayout(pinkLayout);
        pinkLayout.setHorizontalGroup(
            pinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        pinkLayout.setVerticalGroup(
            pinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        white.setBackground(new java.awt.Color(255, 255, 255));
        white.setPreferredSize(new java.awt.Dimension(53, 25));

        javax.swing.GroupLayout whiteLayout = new javax.swing.GroupLayout(white);
        white.setLayout(whiteLayout);
        whiteLayout.setHorizontalGroup(
            whiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        whiteLayout.setVerticalGroup(
            whiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        black.setBackground(new java.awt.Color(0, 0, 0));
        black.setPreferredSize(new java.awt.Dimension(53, 25));

        javax.swing.GroupLayout blackLayout = new javax.swing.GroupLayout(black);
        black.setLayout(blackLayout);
        blackLayout.setHorizontalGroup(
            blackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        blackLayout.setVerticalGroup(
            blackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        clearPanel.setBackground(new java.awt.Color(0, 153, 153));
        clearPanel.setPreferredSize(new java.awt.Dimension(100, 25));

        clearLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        clearLabel.setForeground(new java.awt.Color(255, 255, 255));
        clearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clearLabel.setText("Clear");

        javax.swing.GroupLayout clearPanelLayout = new javax.swing.GroupLayout(clearPanel);
        clearPanel.setLayout(clearPanelLayout);
        clearPanelLayout.setHorizontalGroup(
            clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );
        clearPanelLayout.setVerticalGroup(
            clearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        sendPanel.setBackground(new java.awt.Color(0, 153, 153));
        sendPanel.setPreferredSize(new java.awt.Dimension(57, 23));

        sendLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        sendLabel.setForeground(new java.awt.Color(255, 255, 255));
        sendLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sendLabel.setText("Send");

        javax.swing.GroupLayout sendPanelLayout = new javax.swing.GroupLayout(sendPanel);
        sendPanel.setLayout(sendPanelLayout);
        sendPanelLayout.setHorizontalGroup(
            sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sendLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );
        sendPanelLayout.setVerticalGroup(
            sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sendLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        infoPanel.setBackground(new java.awt.Color(0, 153, 153));

        infoLabel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 17)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel.setText("Board Information");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sizeSlider.setMaximum(16);
        sizeSlider.setMinimum(4);
        sizeSlider.setMinorTickSpacing(4);
        sizeSlider.setPaintLabels(true);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setSnapToTicks(true);
        sizeSlider.setToolTipText("0");

        javax.swing.GroupLayout framePanelLayout = new javax.swing.GroupLayout(framePanel);
        framePanel.setLayout(framePanelLayout);
        framePanelLayout.setHorizontalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(framePanelLayout.createSequentialGroup()
                        .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chatSend, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(framePanelLayout.createSequentialGroup()
                                .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(green, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lightBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blue, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(darkBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(black, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(white, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(framePanelLayout.createSequentialGroup()
                                .addComponent(sendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(framePanelLayout.createSequentialGroup()
                                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))))
                    .addComponent(drawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        framePanelLayout.setVerticalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(drawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(red, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(blue, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(orange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(yellow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(green, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lightBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(darkBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(white, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(black, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatSend, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        //getContentPane().add(framePanel);

        //pack();
    }

    public javax.swing.JPanel black;
    public javax.swing.JPanel blue;
    public javax.swing.JTextField chatSend;
    public javax.swing.JLabel clearLabel;
    private javax.swing.JPanel clearPanel;
    public javax.swing.JPanel darkBlue;
    public javax.swing.JPanel drawPanel;
    public javax.swing.JPanel framePanel;
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
}
