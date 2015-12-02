package javagameproject.Models.Weapons.Bullets;

import java.awt.*;

// width = x; height = y;

public abstract class Bullet {
    private int damage;
    private Image bulletImg;
    private int x;
    private int y;
    private int bulletWidth;
    private int bulletHeight;
    private boolean isItFiredFromSpaceship;
    private int bulletNumber;
    private boolean isItFiredFromBoss;

    public Bullet(int damage, Image bulletImg, int x, int y, int bulletHeight, int bulletWidth, int bulletNumber){
        this.damage = damage;
        this.bulletImg = bulletImg;
        this.x = x;
        this.y = y;
        this.bulletHeight = bulletHeight;
        this.bulletWidth = bulletWidth;
        this.isItFiredFromSpaceship = false;
        this.isItFiredFromBoss = false;
        this.bulletNumber = bulletNumber;
    }

    public void setIsItFiredFromSpaceship(boolean change){
        this.isItFiredFromSpaceship = change;
    }

    public void setIsItFiredFromBoss(boolean change){ this.isItFiredFromBoss = change; }

    public boolean getIsItFiredFromBoss(){
        return this.isItFiredFromBoss;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getX(){
        return this.x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return this.y;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getBulletNumber(){
        return this.bulletNumber;
    }

    public Image getBulletImg(){
        return this.bulletImg;
    }

    public void render(Graphics graphics){
        graphics.drawImage(this.bulletImg, this.x, this.y, this.bulletWidth,this.bulletHeight, null);
    }

    public void update(){
        if(this.isItFiredFromSpaceship){
            int mainY = this.y;
            mainY = mainY + 14;
            setY(mainY);
            if(isItFiredFromBoss){
                int mainX = this.x;
                mainX = mainX - 14;
                setX(mainX);
            }
        }
        else{
            int mainY = this.y;
            mainY = mainY - 14;
            setY(mainY);
        }
    }
}
