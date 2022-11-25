package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TwoPlayerPanel extends JPanel implements Runnable, KeyListener{

    /**
     * Set JFrame Size and Dimension Variables
     */
    private final int PONG_WIDTH=1000;
    private final int PONG_HEIGHT=PONG_WIDTH*5/9;
    private final Dimension PONG_SCREEN = new Dimension(PONG_WIDTH, PONG_HEIGHT);

    /**
     * Set Paddle Size and Ball Size Variables
     */

    private final int PADDLE_HEIGHT = 120;

    private final int PADDLE_WIDTH = PADDLE_HEIGHT/6;

    private final int BALL_DIAMETER = 15;

    /**
     * JLabel size variables
     */

    private final int LABEL_WIDTH=200;
    private final int LABEL_HEIGHT=LABEL_WIDTH/3;

    /**
     * Set x and y direction variables
     */

    private int BallxDirection=-1, BallyDirection=1;

    /**
     * Set score variables
     */
    private int player1score, AIscore;

    /**
     * Set paddle and ball variables
     */

    private Paddle p1,p2;

    private Ball b1;

    /**
     * Set Thread boolean and JLabel variables
     */
    private Thread PongGame;

    private Boolean running;

    private JLabel label;

    public TwoPlayerPanel() {
        newPaddles();
        newBall();

        addKeyListener(this);

        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(PONG_SCREEN);

        PongGame = new Thread(this);
        PongGame.start();
        running=true;
        label = new JLabel("0" + " " + "0");
        label.setBackground(Color.WHITE);
        label.setBounds(PONG_WIDTH-LABEL_WIDTH,PONG_HEIGHT-LABEL_HEIGHT,PONG_WIDTH,PONG_HEIGHT);
        add(label);
    }

    public void newBall(){
        b1 = new Ball(BALL_DIAMETER);
        b1.setBally((PONG_HEIGHT/2)-(BALL_DIAMETER/2));
        b1.setBallx((PONG_WIDTH/2)-(BALL_DIAMETER/2));
    }

    public void newPaddles(){
        p1 = new Paddle(PADDLE_WIDTH,PADDLE_HEIGHT);
        p1.setY((PONG_HEIGHT/2)-(PADDLE_HEIGHT/2));
        p1.setX(0);
        p2 = new Paddle(PADDLE_WIDTH,PADDLE_HEIGHT);
        p2.setY((PONG_HEIGHT/2)-(PADDLE_HEIGHT/2));
        p2.setX(PONG_WIDTH-PADDLE_WIDTH);
    }

    public void SomebodyScored(){
        label.setText(player1score + " " + AIscore);
        if(player1score==10){
            running=false;
            JOptionPane.showMessageDialog(null,"Player 1 Has won");
            setVisible(false);
            new MainMenuFrame();
        }
        if(AIscore==10){
            running=false;
            JOptionPane.showMessageDialog(null,"Player 2 Has won");
            setVisible(false);
            new MainMenuFrame();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(p1.getX(),p1.getY(),PADDLE_WIDTH,PADDLE_HEIGHT);
        g.fillRect(p2.getX(),p2.getY(),PADDLE_WIDTH,PADDLE_HEIGHT);
        g.fillOval(b1.getBallx(), b1.getBally(), BALL_DIAMETER,BALL_DIAMETER);
    }

    public void Collision(){
        //Collision for paddles
       if(p1.getY()<=0){
            p1.setY(0);
        }
        if(p1.getY()+PADDLE_HEIGHT>=PONG_HEIGHT){
            p1.setY(PONG_HEIGHT-PADDLE_HEIGHT);
        }
        if(p2.getY()<=0){
            p2.setY(0);
        }
        if(p2.getY()+PADDLE_HEIGHT>=PONG_HEIGHT){
            p2.setY(PONG_HEIGHT-PADDLE_HEIGHT);
        }
        if(b1.getBally()<=0){
            b1.setBally(0);
        }
        //Collision for scoring
        if(b1.getBallx()<=0){
            newPaddles();
            newBall();
            AIscore++;
        }
        if(b1.getBallx()>=PONG_WIDTH-BALL_DIAMETER){
            newPaddles();
            newBall();
            player1score++;
        }
        //Collision for paddle hits
        if(b1.getBallx()+BALL_DIAMETER==PONG_WIDTH-PADDLE_WIDTH){ //Problem with paddle detection
            if(b1.getBally()>=p2.getY()&&b1.getBally()<=p2.getY()+PADDLE_HEIGHT){
                if (getBallxDirection() == -2)
                    setBallxDirection(2);
                else
                    setBallxDirection(-2);
            }
        }
        if(b1.getBallx()<=PADDLE_WIDTH){
            if(b1.getBally()>p1.getY()&&b1.getBally()<p1.getY()+PADDLE_HEIGHT){
                if (getBallxDirection() == 2)
                    setBallxDirection(-2);
                else
                    setBallxDirection(2);
            }
        }
        //Collision for top and bottom border
        if(b1.getBally()+BALL_DIAMETER>=PONG_HEIGHT){
            setBallyDirection(-2);
        }
        if(b1.getBally()<=0){
            setBallyDirection(2);
        }
        //Collision for top and bottom of paddle
        if(b1.getBally()<PADDLE_WIDTH){
            if(b1.getBally()>p1.getY()&&b1.getBally()<p1.getY()){
                setBallyDirection(2);
            }
        }
    }

    public void setBallxDirection(int ballxDirection) {
        BallxDirection = ballxDirection;
    }

    public void setBallyDirection(int ballyDirection) {
        BallyDirection = ballyDirection;
    }

    public int getBallxDirection() {
        return BallxDirection;
    }

    public int getBallyDirection() {
        return BallyDirection;
    }

    public void Move(){
        b1.setBallx(b1.getBallx()+getBallxDirection());
        b1.setBally(b1.getBally()+getBallyDirection());
        repaint();
    }

    public void run() {
        /**
         * Code from https://github.com/imlakshay08/Java-Pong-Game
         * lines 115 to 131, GamePanel.java
         */
        long lastcheck = System.nanoTime();
        double fpscounter=100;
        double timeBetweenFrames = 1000000000/fpscounter;
        float delta = 0;
        while (running) {
            long secondcheck = System.nanoTime();
            delta+=(secondcheck-lastcheck)/timeBetweenFrames;
            lastcheck=secondcheck;
            if(delta>=1){
                Move();
                Collision();
                SomebodyScored();
                repaint();
                delta--;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     *
     * @param e the event to be processed
     */

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> p1.setY(p1.getY() - 10);
            case KeyEvent.VK_DOWN -> p1.setY(p1.getY() + 10);
            case KeyEvent.VK_W -> p2.setY(p2.getY() - 10);
            case KeyEvent.VK_S -> p2.setY(p2.getY() + 10);
            case KeyEvent.VK_ESCAPE -> {
                setVisible(false);
                new MainMenuFrame();
            }
        }
        Collision();
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
