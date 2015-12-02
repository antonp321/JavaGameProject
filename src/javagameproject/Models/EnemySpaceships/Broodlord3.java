package javagameproject.Models.EnemySpaceships;


import javagameproject.Models.Weapons.Bullets.MissleBullet;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class Broodlord3 extends Spaceship {

    private static final String name = "Broodlord";
    private static final int health = 900;
    private static final int armor = 250;
    private static final int width = 100;
    private static final int height = 100;
    private static final Image broodLordImg = ImageLoader.loadImage("/images/Broodlord.gif");


    public Broodlord3(int x, int y) {
        super(name, width, height, x, y, broodLordImg, health, armor, new MissleBullet(x, y, ImageLoader.loadImage("/images/ReversedMissleBullet.png")));
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }

}
