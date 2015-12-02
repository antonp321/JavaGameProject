package javagameproject.Models.Gifts;

import javagameproject.Models.Weapons.Bullets.Bullet;
import javagameproject.Phase.PhaseManager;

import java.awt.*;

public class HealthMinus extends Gift {

    private static final int bonusHP = -60;
    private static final int giftWidth = 40;
    private static final int giftHeight = 40;
    private static final boolean isItBullet = false;
    private static final boolean isItArmor = false;
    private static final Bullet bulletType = PhaseManager.getCurrentLevel().getPlayer().getBulletType();
    private static final int giftNumber = 4;

    public HealthMinus(int x, int y){
        super(bonusHP, x, y, giftWidth, giftHeight, isItBullet, isItArmor, bulletType, giftNumber);
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }
}
