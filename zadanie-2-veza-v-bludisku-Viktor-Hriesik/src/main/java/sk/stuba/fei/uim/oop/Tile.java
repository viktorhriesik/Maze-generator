package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Tile extends JPanel {

    public boolean passed = false;
    public boolean highlighted = false;
    public int cordX,cordY;
    public boolean isGoal=false;
    public Wall[] walls = new Wall[4];
    public PlayerGraphic playerGraphic = new PlayerGraphic();

    public Tile() {
       super();
       this.setBackground(Color.white);
       addWallsToArray();
       this.setLayout(new BorderLayout());
       this.add(walls[2],BorderLayout.PAGE_START);
       this.add(walls[3],BorderLayout.PAGE_END);
       this.add(walls[1],BorderLayout.LINE_END);
       this.add(walls[0],BorderLayout.LINE_START);
       this.add(playerGraphic,BorderLayout.CENTER);
    }

    public void setCordinates(int cordX, int cordY) {
        this.cordX = cordX;
        this.cordY = cordY;
    }

    public void disableLeftWall(){
        this.walls[0].setVisible(false);
    }
    public void disableRightWall(){
        this.walls[1].setVisible(false);
    }
    public void disableTopWall(){
        this.walls[2].setVisible(false);
    }
    public void disableBottomWall(){
        this.walls[3].setVisible(false);
    }

    public void setPlayerOnTile(){
        this.playerGraphic.setVisible(true);
    }

    public void removePlayerFromTile(){
        this.playerGraphic.setVisible(false);
    }

    public void setGoal(){
        this.setBackground(Color.red);
        this.isGoal = true;
    }

    public void addWallsToArray(){
        this.walls[0]= new Wall();       //leftwall
        this.walls[1]= new Wall();      //rightwall
        this.walls[2]= new Wall();        //topwall
        this.walls[3]= new Wall();     //bottomwall
    }

    public void resetTile(){
        this.passed = false;
        this.walls[1].setVisible(true);
        this.walls[0].setVisible(true);
        this.walls[2].setVisible(true);
        this.walls[3].setVisible(true);
    }

    public void addMouseListenerToTile(MouseListener mouseListener){
        this.addMouseListener(mouseListener);
    }
}
