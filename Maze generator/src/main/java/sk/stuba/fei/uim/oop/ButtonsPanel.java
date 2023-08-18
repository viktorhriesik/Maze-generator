package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {

    public Controls controls;
    public JButton[] arrowKeysButons = new JButton[6];
    public ScoreLabel scoreLabel;

    public ButtonsPanel(Controls controls) {
        this.controls =controls;
        this.setLayout(new GridLayout(2,3));
        this.setPreferredSize(new Dimension(600,100));
        scoreLabel = new ScoreLabel(SwingConstants.CENTER,controls.player.score);
        fillButtonsPanel();
    }

    public void fillButtonsPanel(){
            arrowKeysButons[0] = new Button("RESTART",this.controls,"Restart");
            arrowKeysButons[1] = new Button("↑",this.controls,"Up");
            arrowKeysButons[2] = new Button("←",this.controls,"Left");
            arrowKeysButons[3] = new Button("↓",this.controls,"Down");
            arrowKeysButons[4] = new Button("→",this.controls,"Right");

            this.add(arrowKeysButons[0]);
            this.add(arrowKeysButons[1]);
            this.add(scoreLabel);
            this.add(arrowKeysButons[2]);
            this.add(arrowKeysButons[3]);
            this.add(arrowKeysButons[4]);

            for(int i=0;i<5;i++){
                arrowKeysButons[i].setFocusable(false);
            }
    }
}
