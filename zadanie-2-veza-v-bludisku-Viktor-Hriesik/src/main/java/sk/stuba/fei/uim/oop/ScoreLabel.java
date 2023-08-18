package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class ScoreLabel extends JLabel {

    public String scoreText;
    public ScoreLabel(int horizontalAlignment,int score) {
        super("Score: " + String.valueOf(score),horizontalAlignment);
        this.setFont(new Font("Arial", Font.PLAIN, 15));
    }

    public void setScore(int score){
        this.setText("Score: " + String.valueOf(score));
    }
}
