package javagameproject.Models.Gifts;

import javagameproject.Models.Weapons.Bullets.Bullet;
import javagameproject.gfx.ImageLoader;

import java.awt.*;

public abstract class Gift {

    private int bonus;
    private int x;
    private int y;
    private int giftWidth;
    private int giftHeight;
    private static final Image giftImg = ImageLoader.loadImage("/images/giftPic.png");
    private boolean isItBullet;
    private boolean isItArmor;
    private Bullet bulletType;
    private int giftNumber;

    public Gift(int bonus, int x, int y, int giftWidth, int giftHeight, boolean isItBullet, boolean isItArmor, Bullet bulletType, int giftNumber){
        this.bonus = bonus;
        this.x = x;
        this.y = y;
        this.giftWidth = giftWidth;
        this.giftHeight = giftHeight;
        this.isItBullet = isItBullet;
        this.isItArmor = isItArmor;
        this.bulletType = bulletType;
        this.giftNumber = giftNumber;
    }

    public Bullet getBulletType(){
        return this.bulletType;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }

    public int getBonus(){
        return this.bonus;
    }

    public boolean getIsItArmor(){
        return this.isItArmor;
    }

    public void render(Graphics graphics){
        graphics.drawImage(this.giftImg, this.x, this.y, this.giftWidth, this.giftHeight, null);
    }

    public void update(){
        int mainY = this.y;
        mainY = mainY + 9;
        setY(mainY);
    }
}
