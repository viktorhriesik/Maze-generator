package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener{

    public Controls controls;
    public String direction;

    public Button(String text,Controls controls,String direction) {
        super(text);
        this.direction = direction;
        this.controls = controls;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if(this.direction.equals("Left")){
            controls.checkLeftTileWall();
        }else if(this.direction.equals("Right")){
            controls.checkRightTileWall();
        }else if(this.direction.equals("Up")){
            controls.checkTopTileWall();
        }else if(this.direction.equals("Down")){
            controls.checkBottomTileWall();
        }else if(this.direction.equals("Restart")){
            controls.player.playerReachedGoal = true;
            controls.player.score = 0;
        }
    }
}
