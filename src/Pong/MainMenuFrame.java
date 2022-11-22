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
    JButton twoplayer, exit;
    public MainMenuFrame(){
        this.setTitle("Pong");
        this.setSize(width,height);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);

        twoplayer = new JButton("Two Players");
        twoplayer.setBounds(((width/2)-(Bwidth/2)),height-(Bheight*3+20),Bwidth,Bheight);
        twoplayer.setBackground(Color.WHITE);
        add(twoplayer);

        exit = new JButton("Exit");
        exit.setBounds(((width/2)-(Bwidth/2)),height-(Bheight*2),Bwidth,Bheight);
        exit.setBackground(Color.WHITE);
        add(exit);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        twoplayer.addActionListener(e ->{new TwoPlayerFrame(); dispose();});

        exit.addActionListener(e -> System.exit(0));
    }



}
