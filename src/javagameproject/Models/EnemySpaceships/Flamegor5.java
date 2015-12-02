package javagameproject.Models.EnemySpaceships;


import javagameproject.Models.Weapons.Bullets.FireBoltBullet;
import javagameproject.Models.Weapons.Bullets.LightingBullet;
import javagameproject.Models.Weapons.Bullets.MissleBullet;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class Flamegor5 extends Spaceship {
    private static final String name = "Flamegor";
    private static final int health = 1300;
    private static final int armor = 250;
    private static final int width = 100;
    private static final int height = 100;
    private static final Image firemawImg = ImageLoader.loadImage("/images/Flamegor.png");


    public Flamegor5(int x, int y) {
        super(name, width, height, x, y, firemawImg, health, armor, new LightingBullet(x, y, ImageLoader.loadImage("/images/LightingBullet.png")));
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }
}
