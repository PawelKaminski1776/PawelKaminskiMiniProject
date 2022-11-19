package Pong;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    GamePanel panel = new GamePanel();

    public GameFrame() {
        setTitle("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setBackground(Color.black);
        setVisible(true);
    }

}

