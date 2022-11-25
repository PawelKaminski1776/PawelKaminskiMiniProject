package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class LeaderBoardPanel extends JPanel implements KeyListener {
    private final int LEADERBOARD_HEIGHT=700;
    private final int LEADERBOARD_WIDTH=LEADERBOARD_HEIGHT/2;
    private final Dimension LEADERBOARD_SCREEN = new Dimension(LEADERBOARD_WIDTH, LEADERBOARD_HEIGHT);

    private PlayerSerialization BestPlayers;

    private JLabel display;

    private ArrayList<Player> players;
    public LeaderBoardPanel(){
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(LEADERBOARD_SCREEN);
        addKeyListener(this);
        BestPlayers = new PlayerSerialization();
        players = new ArrayList<>();
        players=BestPlayers.LoadPlayers();
        display = new JLabel("LeaderBoard:"+"\n");
        add(display);
        display.setForeground(Color.WHITE);
        for(int i=0;i<players.size();i++){
            display.setText(players.get(i).getName()+" "+players.get(i).getWins()+"\n");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            setVisible(false);
            new MainMenuFrame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
