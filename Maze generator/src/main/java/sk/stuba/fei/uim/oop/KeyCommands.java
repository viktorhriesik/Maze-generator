package sk.stuba.fei.uim.oop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyCommands implements KeyListener{

    public Controls controls;

    public KeyCommands(Controls controls) {
        this.controls = controls;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    controls.checkBottomTileWall();
                    break;
                case KeyEvent.VK_UP:
                    controls.checkTopTileWall();
                    break;
                case KeyEvent.VK_LEFT:
                    controls.checkLeftTileWall();
                    break;
                case KeyEvent.VK_RIGHT:
                    controls.checkRightTileWall();
                    break;
            }

    }

    public void keyReleased(KeyEvent e) {

    }

}
