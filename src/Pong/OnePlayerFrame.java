package Pong;

import javax.swing.*;
import java.awt.*;

public class OnePlayerFrame extends JFrame {

    OnePlayerPanel panel = new OnePlayerPanel();

    public OnePlayerFrame(){
        this.setTitle("Pong");
        this.add(panel);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}