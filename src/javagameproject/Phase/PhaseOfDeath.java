package javagameproject.Phase;


import javagameproject.Models.Levels.Level;
import javagameproject.Models.Menus.MenuOfDeath;
import javagameproject.Models.Menus.Menuu;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class PhaseOfDeath extends Phase {

    private Menuu menu;

    public PhaseOfDeath(){
        this.menu = new MenuOfDeath();
    }


    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        this.menu.render(graphics);
    }
}
