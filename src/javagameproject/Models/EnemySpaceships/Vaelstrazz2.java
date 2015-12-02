package javagameproject.Models.EnemySpaceships;


import javagameproject.Models.Weapons.Bullets.FireBullet;
import javagameproject.Models.Weapons.Bullets.MissleBullet;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class Vaelstrazz2 extends Spaceship{
    private static final String name = "Vaelstrazz";
    private static final int health = 700;
    private static final int armor = 250;
    private static final int width = 100;
    private static final int height = 100;
    private static final Image vaelstrazzImg = ImageLoader.loadImage("/images/vaelstrazz2.png");


    public Vaelstrazz2(int x, int y) {
        super(name, width, height, x, y, vaelstrazzImg, health, armor, new MissleBullet(x, y, ImageLoader.loadImage("/images/ReversedMissleBullet.png")));
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }

}


