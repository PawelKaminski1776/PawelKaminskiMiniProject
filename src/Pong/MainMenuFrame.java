package Pong;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame {
    static final int width = 1000;
    static final int height = width*5/9;

    static final int Bwidth = 200;
    static final int Bheight = Bwidth/2;

    static final int W_halfway=(width/2)-(Bwidth/2);

    static final int H_halfway=(height/2)-(Bheight/2);
    JButton oneplayer, twoplayer,leaderboard, exit;
    public MainMenuFrame(){
        this.setTitle("Pong");
        this.setSize(width,height);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        oneplayer = new JButton("One Player");
        oneplayer.setBounds(W_halfway,(H_halfway/2)-(Bheight/2),Bwidth,Bheight);
        oneplayer.setBackground(Color.WHITE);
        add(oneplayer);

        twoplayer = new JButton("Two Players");
        twoplayer.setBounds(W_halfway,(H_halfway/2)+(Bheight/2),Bwidth,Bheight);
        twoplayer.setBackground(Color.WHITE);
        add(twoplayer);

        leaderboard = new JButton("Leaderboard");
        leaderboard.setBounds(W_halfway,(H_halfway+(H_halfway/2))-(Bheight/2),Bwidth,Bheight);
        leaderboard.setBackground(Color.WHITE);
        add(leaderboard);

        exit = new JButton("Exit");
        exit.setBounds(W_halfway,(H_halfway+(H_halfway/2))+(Bheight/2),Bwidth,Bheight);
        exit.setBackground(Color.WHITE);
        add(exit);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        oneplayer.addActionListener(e -> {new OnePlayerFrame(); dispose();});

        twoplayer.addActionListener(e ->{new TwoPlayerFrame(); dispose();});

        leaderboard.addActionListener(e -> {new LeaderBoardFrame(); dispose();});

        exit.addActionListener(e -> System.exit(0));
    }



}
