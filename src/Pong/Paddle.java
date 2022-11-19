package Pong;

import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {

    int x;
    int y;

    int width;

    int height;
    int yDirection;

    int id;

    public Paddle(int x, int y, int width, int height, int id){
        super(x, y, width, height);
        this.id = id;
    }


    public void setyDirection(int yDirection) {
        this.yDirection=yDirection;
    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setyDirection(-1);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setyDirection(1);
                }
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setyDirection(-1);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setyDirection(1);
                }
        }
    }

    public void keyReleased(KeyEvent e){
        switch(id) {
            case 1:
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                setyDirection(0);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                setyDirection(0);
            }
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setyDirection(0);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setyDirection(0);
                }
        }
    }

    public void draw(Graphics g){
        switch(id){
            case 1:
                g.setColor(Color.WHITE);
                g.fillRect(x,y,width,height);
            case 2:
                g.setColor(Color.WHITE);
                g.fillRect(x,y,width,height);
        }
    }

    public void move(){
        y = y+yDirection;
        if(y<=60){
            y=60;
        }
        if(y>=740){
            y=740;
        }
    }

}
