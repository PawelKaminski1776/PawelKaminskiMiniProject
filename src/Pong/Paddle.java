package Pong;

import java.awt.*;
import java.awt.event.*;

public class Paddle{

    int x;
    int y;
    int width;
    int height;
    int id;

    public Paddle( int width, int height, int id){
        this.width = width;
        this.height = height;
        this.id = id;
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
