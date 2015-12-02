package javagameproject.Models.Menus;

import javagameproject.Models.Levels.*;
import javagameproject.Phase.PhaseForLevels;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenu extends Menuu {

    private final static String title = "Main Menu";
    private final static String firstLine = "Play";
    private final static String fourthLine = "Exit";
    private Level level;

    public MainMenu(){
        super(title);
        this.init();
    }

    @Override
    public void enter() {
        switch(this.getCurrentRow()){
            case 1:
                //enter Play mode
                PhaseManager.setCurrentPhase(new PhaseForLevels(new LevelOne()));
                PhaseManager.setCurrentLevel(new LevelOne());
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics){
        BufferedImage img = ImageLoader.loadImage("/images/backgroundImage.jpg");
        graphics.drawImage(img, 0, 0, 800, 600, null );

        graphics.setColor(Color.BLACK);
        Font titleFont = new Font("Serif", 1, 55);
        graphics.setFont(titleFont);
        graphics.drawString(this.title, 300, 190);

        //change this var when make constants
        int menuLineSized = 40;

        Font menuItemsFont = new Font("Bold", 0, menuLineSized);
        graphics.setFont(menuItemsFont);
        int linePosition = 300;
        for(int i = 0; i < this.rows.size(); i++){
            String lineText = this.rows.get(i);
            if(i + 1 == getCurrentRow()){
                graphics.setColor(Color.YELLOW);
                if(this.rows.get(i).equals("Play") || this.rows.get(i).equals("Exit")){
                    graphics.drawString(lineText, 400, linePosition);
                }
                else{
                    graphics.drawString(lineText, 340, linePosition);
                }
            }
            else {
                graphics.setColor(Color.red);
                if(this.rows.get(i).equals("Play") || this.rows.get(i).equals("Exit")){
                    graphics.drawString(lineText, 400, linePosition);
                }
                else{
                    graphics.drawString(lineText, 340, linePosition);
                }
            }
            linePosition += menuLineSized + 30;
        }
    }

    @Override
    protected void init() {
        super.addRows(firstLine);
        super.addRows(fourthLine);
    }
}
