package Pong;

public class Ball {
    int Ballx;
    int Bally;
    int diameter;


    public Ball(int diameter){
        this.diameter=diameter;
    }

    public void setBallx(int ballx) {
        Ballx = ballx;
    }

    public void setBally(int bally) {
        Bally = bally;
    }

    public int getBallx() {
        return Ballx;
    }

    public int getBally() {
        return Bally;
    }
}
