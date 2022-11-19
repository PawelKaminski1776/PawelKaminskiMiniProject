package Pong;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    GamePanel panel = new GamePanel();

    public GameFrame() {
        this.add(panel);
        this.setTitle("Pong");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
    }

}

