package Pong;

import javax.swing.*;
import java.awt.*;

public class TwoPlayerFrame extends JFrame {

    TwoPlayerPanel panel = new TwoPlayerPanel();
    public TwoPlayerFrame(){
        this.setTitle("Pong");
        this.add(panel);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
