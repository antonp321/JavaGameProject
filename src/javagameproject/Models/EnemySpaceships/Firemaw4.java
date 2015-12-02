package javagameproject.Models.EnemySpaceships;


import javagameproject.Models.Weapons.Bullets.FireBoltBullet;
import javagameproject.Models.Weapons.Bullets.MissleBullet;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class Firemaw4 extends Spaceship {

    private static final String name = "Firemaw";
    private static final int health = 1100;
    private static final int armor = 250;
    private static final int width = 100;
    private static final int height = 100;
    private static final Image firemawImg = ImageLoader.loadImage("/images/Firemaw.png");


    public Firemaw4(int x, int y) {
        super(name, width, height, x, y, firemawImg, health, armor, new FireBoltBullet(x, y, ImageLoader.loadImage("/images/fireBoltBullet.png")));
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }
}
