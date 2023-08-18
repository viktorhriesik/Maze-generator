package sk.stuba.fei.uim.oop;

import javax.swing.*;


public class Player extends JPanel {

    public int cordX = 0;
    public int cordY = 0;
    public int score = 0;
    public boolean playerReachedGoal = false;
    public boolean playerIsSelected = false;

    public void resetCord() {
        this.cordX = 0;
        this.cordY = 0;
    }

    public void setCoordinates(int cordX, int cordY){
        this.cordX = cordX;
        this.cordY = cordY;
    }
    public void addScore() {
        this.score++;
    }

    public int getScore() {
        return score;
    }

    public void setPlayerReachedGoal(boolean playerReachedGoal) {
        this.playerReachedGoal = playerReachedGoal;
    }
}
