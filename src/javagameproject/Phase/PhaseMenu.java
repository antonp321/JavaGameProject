package javagameproject.Phase;

import javagameproject.Models.Menus.*;

import java.awt.*;
import java.awt.Menu;

public class PhaseMenu extends Phase {

   private Menuu menu;

    public PhaseMenu(Menuu menu){
        this.menu = new MainMenu();
    }

    @Override
    public void update() {
        this.menu.update();
    }

    @Override
    public void render(Graphics graphics) {
        this.menu.render(graphics);
    }
}
