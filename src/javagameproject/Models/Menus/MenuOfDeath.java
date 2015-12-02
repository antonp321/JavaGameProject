package javagameproject.Models.Menus;


import javagameproject.Models.Levels.LevelOne;
import javagameproject.Models.Levels.LevelTwo;
import javagameproject.Models.Player;
import javagameproject.Phase.PhaseForLevels;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class MenuOfDeath extends Menuu {
    private final static String title = "TheDeathIsHere";
    private final static String firstLine = "Try Again";
    private final static String secondLine = "Exit";
    private Image bloodImg;

    public MenuOfDeath(){
        super(title);
        this.bloodImg = ImageLoader.loadImage("/images/playerDead.png");
        this.init();
    }

    @Override
    public void enter() {
        switch(this.getCurrentRow()) {
            case 1:
//                int levelNumber = PhaseManager.getCurrentLevel().getLevelNumber();
//                if(levelNumber == 1){
                PhaseManager.setCurrentPhase(new PhaseForLevels(new LevelOne()));
//                }
//                if(levelNumber == 2){
//                    PhaseManager.setCurrentPhase(new PhaseForLevels(new LevelTwo()));
//                }
                PhaseManager.getCurrentLevel().setPlayer(new Player("SG8"));
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics){
        graphics.drawImage(PhaseManager.getCurrentLevel().getBackgroundOfDeathImg(), 0, 0, null);
        graphics.drawImage(this.bloodImg, 40, 3, 700, 700, null);

        int menuLineSized = 40;
        Font menuItemsFont = new Font("Bold", 0, 28);
        graphics.setFont(menuItemsFont);
        int linePosition = 280;
        for(int i = 0; i < this.rows.size(); i++){
            String lineText = this.rows.get(i);
            if(i + 1 == getCurrentRow()){
                graphics.setColor(Color.WHITE);
                if(this.rows.get(i).equals("Exit")){
                    graphics.drawString(lineText, 360, linePosition);
                }
                else{
                    graphics.drawString(lineText, 300, linePosition);
                }
            }
            else {
                graphics.setColor(Color.RED);
                if(this.rows.get(i).equals("Exit")){
                    graphics.drawString(lineText, 360, linePosition);
                }
                else{
                    graphics.drawString(lineText, 300, linePosition);
                }
            }
            linePosition += menuLineSized + 30;
        }

    }

    @Override
    protected void init() {
        super.addRows(firstLine);
        super.addRows(secondLine);
    }

}
