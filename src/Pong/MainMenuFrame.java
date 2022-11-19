package Pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenuFrame extends JFrame {
    public MainMenuFrame(){
        this.setTitle("Pong");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
        JButton play = new JButton("Play");
        play.setBounds(300,100,300,150);
        play.setBackground(Color.WHITE);
        add(play);
        JButton exit = new JButton("Exit");
        exit.setBounds(300,300,300,150);
        exit.setBackground(Color.WHITE);
        add(exit);


        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameFrame();
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
