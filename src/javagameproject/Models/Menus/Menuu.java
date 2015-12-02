package javagameproject.Models.Menus;

import javagameproject.Game.InputHandlers.MenuInputHandler;
import javagameproject.Phase.PhaseManager;
import javagameproject.Phase.PhaseMenu;
import javagameproject.Phase.PhaseOfDeath;
import javagameproject.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Menuu {
    private int currentRow;
    private String title;
    private MenuInputHandler inputHandler;
    protected ArrayList<String> rows;

    protected Menuu (String title){
        this.currentRow = 1;
        this.rows = new ArrayList<>();
        this.title = title;
        this.inputHandler = new MenuInputHandler(this);
    }

    public int getCurrentRow(){
        return this.currentRow;
    }

    public void setCurrentRow(int currentRow) {
        boolean isOutOfBounds = currentRow > this.rows.size() || currentRow < 1;
        if(!isOutOfBounds) {
            //AudioEffects
            this.currentRow = currentRow;
        }
    }

    public String getTitle(){
        return this.title;
    }

    public ArrayList<String> getRows(){
        return this.rows;
    }

    public void addRows(String element){
        this.rows.add(element);
    }

    public abstract void enter();
    public abstract void update();
    public abstract void render(Graphics graphics);
    protected abstract void init();
}
