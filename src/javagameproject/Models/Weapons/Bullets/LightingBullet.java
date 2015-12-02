package javagameproject.Models.Weapons.Bullets;

import java.awt.*;

public class LightingBullet extends Bullet {
    private static final int damage = 120;
    private static final int height = 70;
    private static final int width = 35;
    private static final int bulletNumber = 4;

    public LightingBullet(int x, int y, Image bulletImg) {
        super(damage, bulletImg, x, y, height, width, bulletNumber);
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }
}
