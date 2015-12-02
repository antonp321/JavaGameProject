package javagameproject.Models.Weapons.Bullets;

import java.awt.*;

public class MissleBullet extends Bullet {

    private static final int damage = 65;
    private static final int height = 35;
    private static final int width = 45;
    private static final int bulletNumber = 2;

    public MissleBullet(int x, int y, Image bulletImg) {
        super(damage, bulletImg, x, y, height, width, bulletNumber);
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }
}
