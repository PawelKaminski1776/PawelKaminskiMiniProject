package Pong;

import java.io.*;
import java.util.ArrayList;

public class PlayerSerialization implements Serializable {
    private ArrayList<Player> nameList;

    Player player;

    public void PlayerSerialization(Player player){
        LoadPlayers();
        nameList.add(player);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Players.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(nameList);
            out.flush();
            out.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public ArrayList<Player> LoadPlayers(){
        File file;
        try{
            FileInputStream fileInputStream = new FileInputStream("Players.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            nameList = (ArrayList<Player>) objectInputStream.readObject();
            objectInputStream.close();

        }
        catch(Exception e){
            file = new File("Players.txt");
            try{
                file.createNewFile();
                nameList = new ArrayList<>();
            }
            catch (IOException Ignored){
            }
        }
        return nameList;
    }

}
