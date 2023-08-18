package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MazeGraphic extends JFrame{

    public JPanel panel = new JPanel();
    public JPanel gamePanel =  new JPanel();
    public ButtonsPanel buttonsPanel;
    int size;
    public MouseListener mouseListener;

    public MazeGraphic(int size,Controls controls) throws HeadlessException{
        super();
        this.size = size;
        this.buttonsPanel = new ButtonsPanel(controls);
        this.setSize(600,700);
        this.setVisible(true);
        this.add(panel);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        gamePanel.setPreferredSize(new Dimension(600,600));
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(gamePanel);
        panel.add(buttonsPanel);
        this.gamePanel.setLayout(new GridLayout(size,size));
        mouseListener = new MouseCommands(controls);
    }

    public void addTilesToGrid(Tile[][] table){
    for(int i=0;i<size;i++){
        for(int j=0;j<size;j++){
        table[j][i] = new Tile();
        table[j][i].setCordinates(j,i);
        this.gamePanel.add(table[j][i]);
        table[j][i].addMouseListenerToTile(mouseListener);
        }
      }
    }

    public void resetTilesAndScore(Tile[][] table,Player player){
        buttonsPanel.scoreLabel.setScore(player.getScore());
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                table[j][i].resetTile();
            }
        }
    }

}
