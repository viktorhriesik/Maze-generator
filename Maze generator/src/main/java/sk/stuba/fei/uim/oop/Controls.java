package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.net.PortUnreachableException;
import java.util.ArrayList;

public class Controls {

    public Tile[][] table;
    public Player player;
    private ArrayList<Tile> hightlighedTiles = new ArrayList<Tile>();
    public int size;

    public Controls(Tile[][] table, Player player,int size) {
        this.size = size;
        this.table = table;
        this.player = player;
    }

    public void checkBottomTileWall(){
        if(!table[player.cordX][player.cordY].walls[3].isVisible()){
            table[player.cordX][player.cordY].removePlayerFromTile();
            player.cordY++;
            table[player.cordX][player.cordY].setPlayerOnTile();
            checkReachingGoal();
        }
    }

    public void checkTopTileWall(){
        if(!table[player.cordX][player.cordY].walls[2].isVisible()){
            table[player.cordX][player.cordY].removePlayerFromTile();
            player.cordY--;
            table[player.cordX][player.cordY].setPlayerOnTile();
            checkReachingGoal();
        }
    }

    public void checkLeftTileWall(){
        if(!table[player.cordX][player.cordY].walls[0].isVisible()){
            table[player.cordX][player.cordY].removePlayerFromTile();
            player.cordX--;
            table[player.cordX][player.cordY].setPlayerOnTile();
            checkReachingGoal();
        }
    }

    public void checkRightTileWall(){
        if(!table[player.cordX][player.cordY].walls[1].isVisible()){
            table[player.cordX][player.cordY].removePlayerFromTile();
            player.cordX++;
            table[player.cordX][player.cordY].setPlayerOnTile();
            checkReachingGoal();
        }
    }

    public void checkReachingGoal(){
        if(player.cordY==(size-1) && player.cordX == (size-1)){
            player.setPlayerReachedGoal(true);
            player.addScore();
            System.out.println(player.score);
        }
    }

    public void highlightDirections(int curentX,int curentY){
        int localX = 0;
        int localY = 0;
        for(int i=0;i<2;i++){
            while (table[curentX+localX][curentY].walls[i].isVisible() == false) {
                localX = localX-1+(2*i);
                if(table[curentX + localX][curentY].isGoal == false){
                    table[curentX + localX][curentY].setBackground(Color.LIGHT_GRAY);
                }
                hightlighedTiles.add(table[curentX + localX][curentY]);
                table[curentX + localX][curentY].highlighted = true;
            }
            localX = 0;
        }
        for(int i=0;i<2;i++){
            while (table[curentX][curentY+localY].walls[i+2].isVisible() == false) {
                localY = localY-1+(2*i);
                if(table[curentX][curentY+localY].isGoal == false) {
                    table[curentX][curentY + localY].setBackground(Color.LIGHT_GRAY);
                }
                hightlighedTiles.add(table[curentX][curentY+localY]);
                table[curentX][curentY+localY].highlighted = true;
            }
            localY = 0;
        }
    }

    public void unhightlightDirections(){
        for(int i=0;i<hightlighedTiles.size();i++){
            if(hightlighedTiles.get(i).isGoal == false) {
                hightlighedTiles.get(i).highlighted = false;
                hightlighedTiles.get(i).setBackground(Color.white);
            }
        }
    }
}
