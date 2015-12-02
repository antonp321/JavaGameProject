package javagameproject.Models.Gifts;

import javagameproject.Models.Weapons.Bullets.Bullet;
import javagameproject.Models.Weapons.Bullets.FireBullet;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class FireBulletBonus extends Gift {

    private static final int bonus = 0;
    private static final int giftWidth = 40;
    private static final int giftHeight = 40;
    private static final boolean isItBullet = true;
    private static final boolean isItArmor = false;
    private static final Bullet bulletType = new FireBullet(PhaseManager.getCurrentLevel().getPlayer().getCurrentWidthPos() + 45, 493, ImageLoader.loadImage("/images/NormalBullet.png"));
    private static final int giftNumber = 2;

    public FireBulletBonus(int x, int y){
        super(bonus, x, y, giftWidth, giftHeight, isItBullet, isItArmor, bulletType, giftNumber);
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }
}
