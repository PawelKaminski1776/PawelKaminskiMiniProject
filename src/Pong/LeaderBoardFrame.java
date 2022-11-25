package Pong;

import javax.swing.*;
import java.awt.*;

public class LeaderBoardFrame extends JFrame {

    LeaderBoardPanel panel = new LeaderBoardPanel();

    public LeaderBoardFrame(){
        this.setTitle("Pong");
        this.add(panel);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
