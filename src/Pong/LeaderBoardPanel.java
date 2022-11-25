package Pong;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderBoardPanel extends JPanel {
    final int LEADERBOARD_HEIGHT=700;
    final int LEADERBOARD_WIDTH=LEADERBOARD_HEIGHT/2;
    final Dimension LEADERBOARD_SCREEN = new Dimension(LEADERBOARD_WIDTH, LEADERBOARD_HEIGHT);

    PlayerSerialization BestPlayers;

    JLabel display;

    ArrayList<Player> players;
    public LeaderBoardPanel(){
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(LEADERBOARD_SCREEN);
        BestPlayers = new PlayerSerialization();
        players = new ArrayList<>();
        players=BestPlayers.LoadPlayers();
        display = new JLabel("LeaderBoard:"+"\n");
        add(display);
        display.setForeground(Color.WHITE);
        for(int i=0;i<players.size();i++){
            display.setText(players.get(i).getName()+"\n");
        }
    }
}
