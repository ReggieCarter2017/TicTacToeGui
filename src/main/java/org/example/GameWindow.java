package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    static public final int WINDOW_HEIGHT = 640;
    static public final int WINDOW_WIDTH = 720;
    static public final int WINDOW_POS_X = 300;
    static public final int WINDOW_POS_Y = 100;
    static public final String WINDOW_NAME = "Игра в крестики-нолики";
    GameSettings gameSettings;
    GameMap gameMap;
    GameWindow(){
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(WINDOW_NAME);
        setResizable(false);

        gameSettings = new GameSettings(this);
        gameMap = new GameMap(GameSettings.sliderSizeValue, GameSettings.sliderSizeValue);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Exit");
        JPanel controPanel = new JPanel(new GridLayout(1,2));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gameSettings.setVisible(true);
            }
        });


        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        controPanel.add(startButton);
        controPanel.add(stopButton);
        add(controPanel, BorderLayout.PAGE_END);
        add(gameMap);
        gameMap.setVisible(false);
        setVisible(true);

    }
    void startNewGame(boolean mode, int size_x, int size_y, int win_len){
        gameMap.setVisible(true);
        gameMap.startNewGame(mode, size_x, size_y, win_len);
    }
}
