package javagameproject.Models.Gifts;

import javagameproject.Models.Weapons.Bullets.Bullet;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public class HealthBonus extends Gift{

    private static final int bonusHP = 230;
    private static final int giftWidth = 40;
    private static final int giftHeight = 40;
    private static final boolean isItBullet = false;
    private static final boolean isItArmor = false;
    private static final Bullet bulletType = PhaseManager.getCurrentLevel().getPlayer().getBulletType();
    private static final int giftNumber = 3;

    public HealthBonus(int x, int y){
        super(bonusHP, x, y, giftWidth, giftHeight, isItBullet, isItArmor, bulletType, giftNumber);
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }

    public void update(){
        super.update();
    }
}
