package javagameproject.Models.Menus;

import javagameproject.Models.Levels.LevelOne;
import javagameproject.Models.Player;
import javagameproject.Phase.PhaseForLevels;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EndMenu extends Menuu {

    private final static String title = "TheEnd";
    private final static String firstLine = "Congratulations !";
    private final static String thirdLine = "Press Enter To Exit";

    public EndMenu(){
        super(title);
        this.init();
    }
    @Override
    public void enter() {
        switch(this.getCurrentRow()) {
            case 1:
                System.exit(0);
                break;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        BufferedImage img = ImageLoader.loadImage("/images/BossLevelBackgroundOfDeath.jpg");
        graphics.drawImage(img, 0, 0, 800, 600, null );

        graphics.setColor(Color.YELLOW);
        Font titleFont = new Font("Serif", 1, 55);
        graphics.setFont(titleFont);
        graphics.drawString(this.firstLine, 210, 190);

        //change this var when make constants
        int menuLineSized = 40;

        Font menuItemsFont = new Font("Bold", 0, menuLineSized);
        graphics.setFont(menuItemsFont);
        int linePosition = 300;
        for(int i = 0; i < this.rows.size(); i++){
            String lineText = this.rows.get(i);
            if(i + 1 == getCurrentRow()){
                graphics.setColor(Color.RED);
                if(this.rows.get(i).equals("Play") || this.rows.get(i).equals("Exit")){
                    graphics.drawString(lineText, 400, linePosition);
                }
                else{
                    graphics.drawString(lineText, 250, linePosition);
                }
            }
            else {
                graphics.setColor(Color.red);
                if(this.rows.get(i).equals("Play") || this.rows.get(i).equals("Exit")){
                    graphics.drawString(lineText, 400, linePosition);
                }
                else{
                    graphics.drawString(lineText, 210, linePosition);
                }
            }
            linePosition += menuLineSized + 30;
        }
    }

    @Override
    protected void init() {
        super.addRows(thirdLine);
    }
}
