package javagameproject.Models.Weapons.Bullets;


import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class FireBullet extends Bullet{

    private static final int damage = 35;
    private static final int height = 15;
    private static final int width = 25;
    private static final int bulletNumber = 1;

    public FireBullet(int x, int y, Image bulletImg) {
        super(damage, bulletImg, x, y, height, width, bulletNumber);
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }
}
