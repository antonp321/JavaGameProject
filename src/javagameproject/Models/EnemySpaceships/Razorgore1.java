package javagameproject.Models.EnemySpaceships;

import javagameproject.Models.Weapons.Bullets.Bullet;
import javagameproject.Models.Weapons.Bullets.FireBullet;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class Razorgore1 extends Spaceship {

    private static final String name = "Razorgore";
    private static final int health = 450;
    private static final int armor = 150;
    private static final int width = 100;
    private static final int height = 100;
    private static final Image razorgoreImg = ImageLoader.loadImage("/images/razorgore.png");


    public Razorgore1(int x, int y) {
        super(name, width, height, x, y, razorgoreImg, health, armor, new FireBullet(x, y, ImageLoader.loadImage("/images/ReversedNormalBullet.png")));
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }

}
