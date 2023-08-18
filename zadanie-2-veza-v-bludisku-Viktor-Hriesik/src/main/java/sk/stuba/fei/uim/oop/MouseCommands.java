package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseCommands implements MouseListener{

    public Controls controls;
    public Tile highlighedTile;
    private int click =0;

    public MouseCommands(Controls controls) {
        this.controls = controls;
    }

    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
        Tile currentTile = (Tile) e.getSource();

        if(currentTile.cordX == controls.player.cordX && currentTile.cordY == controls.player.cordY){
            if(click == 1){
                controls.unhightlightDirections();
                click = 0;
            }else{
                controls.highlightDirections(controls.player.cordX,controls.player.cordY);
                click=1;
                controls.player.playerIsSelected = true;
            }
        }
        if(controls.player.playerIsSelected == true && currentTile.highlighted == true){
            controls.table[controls.player.cordX][controls.player.cordY].removePlayerFromTile();
            controls.table[currentTile.cordX][currentTile.cordY].setPlayerOnTile();
            controls.player.setCoordinates(currentTile.cordX, currentTile.cordY);
            controls.checkReachingGoal();
            controls.unhightlightDirections();
            click = 0;
            controls.player.playerIsSelected = false;
        }
        }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {
        highlighedTile = (Tile) e.getSource();
        if(highlighedTile != null && highlighedTile.highlighted ==true) {
            highlighedTile.setBackground(Color.CYAN);
        }
    }
    public void mouseExited(MouseEvent e) {
        if(highlighedTile.highlighted == true && highlighedTile.isGoal ==false){
            highlighedTile.setBackground(Color.lightGray);
        }else if(highlighedTile.highlighted == true && highlighedTile.isGoal ==true){
            highlighedTile.setBackground(Color.red);
        }
    }
}

