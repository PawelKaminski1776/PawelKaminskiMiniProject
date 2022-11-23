package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paddle {

    int x;
    int y;
    int width;
    int height;

    public Paddle( int width, int height){
        this.width = width;
        this.height = height;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
