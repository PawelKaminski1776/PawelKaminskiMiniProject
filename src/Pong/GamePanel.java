package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    Paddle p1;
    Paddle p2;
    public GamePanel(){
       newPaddles();
    }

    public void newPaddles(){
        Paddle p1 = new Paddle(25,375,25,125, 1);
        Paddle p2 = new Paddle(25,375,25,125, 2);
    }

    public void move(){
        p1.move();
        p2.move();
    }

    public void run() {
        try{
            while(true){
                move();
                Thread.sleep(4);
            }
        }
        catch(Exception e){
            System.out.print("Error");
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}
