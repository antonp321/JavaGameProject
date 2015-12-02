package javagameproject.Models.Weapons.Bullets;

import java.awt.*;

public class FireBoltBullet extends Bullet {
    private static final int damage = 75;
    private static final int height = 40;
    private static final int width = 50;
    private static final int bulletNumber = 3;

    public FireBoltBullet(int x, int y, Image bulletImg) {
        super(damage, bulletImg, x, y, height, width, bulletNumber);
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }
}
