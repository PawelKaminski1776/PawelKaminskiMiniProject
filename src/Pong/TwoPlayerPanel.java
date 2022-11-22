package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TwoPlayerPanel extends JPanel implements KeyListener, Runnable{
    final int PONG_WIDTH=1000;
    final int PONG_HEIGHT=PONG_WIDTH*5/9;
    final Dimension PONG_SCREEN = new Dimension(PONG_WIDTH, PONG_HEIGHT);

    final int PADDLE_HEIGHT = 120;

    final int PADDLE_WIDTH = PADDLE_HEIGHT/6;

    Paddle p1,p2;
    Thread game = new Thread(new TwoPlayerPanel());
    public TwoPlayerPanel() {
        newPaddles();
        addKeyListener(this);
        setFocusable(true);
        setPreferredSize(PONG_SCREEN);
        game.start();
    }

    public void newPaddles(){
        p1 = new Paddle(PADDLE_WIDTH,PADDLE_HEIGHT,1);
        p1.setY((PONG_HEIGHT/2)-(PADDLE_HEIGHT/2));
        p1.setX(0);
        p2 = new Paddle(PADDLE_WIDTH,PADDLE_HEIGHT,2);
        p2.setY((PONG_HEIGHT/2)-(PADDLE_HEIGHT/2));
        p2.setX(PONG_WIDTH-PADDLE_WIDTH);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(p1.getX(),p1.getY(),PADDLE_WIDTH,PADDLE_HEIGHT);
        g.fillRect(p2.getX(),p2.getY(),PADDLE_WIDTH,PADDLE_HEIGHT);
    }

    public void run() {
        long firstcheck = System.nanoTime();
        double billion=100000000;
        while (true) {
            long secondcheck = System.nanoTime();
            int delta_time = (int) ((secondcheck - firstcheck) / billion);
            firstcheck =secondcheck;
            if (delta_time >= 1) {
                repaint();
            }
        }
    }

    public void keyTyped(KeyEvent e){
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setY(p1.getY()-10);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setY(p1.getY()+10);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p2.setY(p2.getY()-10);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            p2.setY(p2.getY()+10);
        }
        repaint();
    }

    public void keyReleased(KeyEvent e){}
  /*  public void keyReleased(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setY(0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setY(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p2.setY(0);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            p2.setY(0);

        }
        repaint();
    } */

}
