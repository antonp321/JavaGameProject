package javagameproject.Game.InputHandlers;

import javagameproject.Display.Display;
import javagameproject.Models.Menus.Menuu;

import java.awt.event.KeyEvent;

public class MenuInputHandler extends InputHandler {


    private Menuu menu;

    public MenuInputHandler(Menuu menu){
        super();
        this.menu = menu;
    }


    @Override
    public void keyPressed(KeyEvent pressedKey) {
        int keyCode = pressedKey.getKeyCode();
        if(keyCode == KeyEvent.VK_DOWN){
            this.menu.setCurrentRow(this.menu.getCurrentRow() + 1);
        }

        if(keyCode == KeyEvent.VK_UP){
            this.menu.setCurrentRow(this.menu.getCurrentRow() - 1);
        }

        if(keyCode == KeyEvent.VK_ENTER){
            Display.getInstance().getCanvas().removeKeyListener(this);
            this.menu.enter();
        }
    }

    @Override
    public void keyTyped(KeyEvent pressedKey) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
