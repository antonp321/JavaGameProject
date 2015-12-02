package javagameproject.Phase;


import javagameproject.Models.Menus.EndMenu;
import javagameproject.Models.Menus.MenuOfDeath;
import javagameproject.Models.Menus.Menuu;

import java.awt.*;

public class EndPhase extends Phase  {
    private Menuu menu;

    public EndPhase(){
        this.menu = new EndMenu();
    }


    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        this.menu.render(graphics);
    }
}

