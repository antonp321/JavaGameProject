
// ДА СЕ ОПИШЕ !!! (възможно е да е само тест)
package javagameproject.Models;

import javagameproject.Game.InputHandlers.PlayerInputHandler;
import javagameproject.Models.Weapons.Bullets.*;
import javagameproject.Phase.PhaseManager;
import javagameproject.Phase.PhaseOfDeath;
import javagameproject.gfx.ImageLoader;
import javagameproject.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {

    private int currentWidthPos;
    private int currentHeightPos;
    private String playerName;
    private PlayerInputHandler playerInputHandler;
    private Image playerImgMovingType1;
    private Image playerImgMovingType2;
    private Image playerImgStayAtPlace;
    private Image playerImg;
    private SpriteSheet spriteSheet;
    private boolean isPlayerMovingLeft;
    private boolean isPlayerMovingRight;
    private ArrayList<Bullet> bulletsFired;
    private int currentBulletHeigh;
    private int health;
    private int armor;
    private int playerWidth;
    private int playerHeight;
    private Bullet bulletType;
    private int maxBounds;


    public Player(String playerName){
        this.currentHeightPos = 493;
        this.currentWidthPos = 0;
        this.currentBulletHeigh = 493;
        this.playerName = playerName;
        this.playerInputHandler = new PlayerInputHandler(this);
        this.spriteSheet = new SpriteSheet(ImageLoader.loadImage("/images/player.gif"));
        // ще сменя магическите параметри впоследствие
        this.playerImgMovingType1 = this.spriteSheet.crop(0, 77, 37, 50);
        this.playerImgMovingType2 = this.spriteSheet.crop(37, 77, 37, 50);
        this.playerImgStayAtPlace = this.spriteSheet.crop(151 , 63 , 40, 66);
        this.isPlayerMovingLeft = false;
        this.isPlayerMovingRight = false;
        this.bulletsFired = new ArrayList<Bullet>();
        this.health = 500;
        this.armor = 500;
        this.playerWidth = 101;
        this.playerHeight = 119;
        this.bulletType = new FireBullet(getCurrentWidthPos() + 55, this.currentBulletHeigh, ImageLoader.loadImage("/images/NormalBullet.png"));
        this.maxBounds = 720;
    }

    public Bullet getBulletType(){
        return this.bulletType;
    }

    public void setMaxBounds(int newMaxBounds){
        this.maxBounds = newMaxBounds;
    }

    public void setBulletType(Bullet newBulletType){
        this.bulletType = newBulletType;
    }

    public boolean getIsPlayerMovingLeft() { return this.isPlayerMovingLeft; }

    public boolean getIsPlayerMovingRight() { return  this.isPlayerMovingRight; }

    public void setIsPlayerMovingLeft(boolean isPlayerMovingLeft) {
        this.isPlayerMovingLeft = isPlayerMovingLeft;
    }

    public void setIsPlayerMovingRight(boolean isPlayerMovingRight){
        this.isPlayerMovingRight = isPlayerMovingRight;
    }

    public int getCurrentWidthPos(){
        return this.currentWidthPos;
    }

    public ArrayList<Bullet> getBulletsFiredArray(){
        return this.bulletsFired;
    }

    public void setBulletsFired(ArrayList<Bullet> bulletsFired){
        this.bulletsFired = bulletsFired;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int newHealth){

        if(newHealth <= 0){
            this.isPlayerMovingRight = false;
            this.isPlayerMovingLeft = false;
            this.health = newHealth;
        }
        else{
            this.health = newHealth;
        }
    }

    public int getArmor() { return this.armor; }

    public void setArmor(int newArmor){
        this.armor = newArmor;
    }

    public void setCurrentWidthPos(int currentWidthPos) {
        boolean outOfBounds = currentWidthPos < 0 || currentWidthPos > maxBounds;
        if(!outOfBounds){
            this.currentWidthPos = currentWidthPos;
        }
    }

    public void update(){

        if(this.health > 0) {

            if (this.currentWidthPos % 3 == 0) {
                this.playerImg = playerImgMovingType1;
            } else {
                this.playerImg = playerImgMovingType2;
            }

            if (!this.isPlayerMovingRight && !this.isPlayerMovingLeft) {
                this.playerImg = playerImgStayAtPlace;
            }
            for (int i = 0; i < this.bulletsFired.size(); i++) {
                this.bulletsFired.get(i).update();
                if (this.bulletsFired.get(i).getY() < 0) {
                    this.bulletsFired.remove(i);
                }
            }

            if (this.getIsPlayerMovingLeft()) {
                this.setCurrentWidthPos(this.getCurrentWidthPos() - 5);
            }

            if (this.getIsPlayerMovingRight()) {
                this.setCurrentWidthPos(this.getCurrentWidthPos() + 5);
            }
        }
        else{
            PhaseManager.setCurrentPhase(new PhaseOfDeath());
        }

    }

    public void render(Graphics graphics){
        graphics.drawImage(this.playerImg, this.currentWidthPos, this.currentHeightPos, this.playerWidth, this.playerHeight, null);
        for(int i = 0; i < this.bulletsFired.size(); i++){
            this.bulletsFired.get(i).render(graphics);
        }
    }

    public void shoot(Bullet currentBullet){

        switch(currentBullet.getBulletNumber()){
            case 1:
                Bullet fireBullet = new FireBullet(getCurrentWidthPos() + 55, this.currentBulletHeigh, ImageLoader.loadImage("/images/NormalBullet.png"));
                this.bulletsFired.add(fireBullet);
                fireBullet.setIsItFiredFromSpaceship(false);
                break;
            case 2:
                Bullet missleBullet = new MissleBullet(getCurrentWidthPos() + 45, this.currentBulletHeigh, ImageLoader.loadImage("/images/MissleBullet.png"));
                this.bulletsFired.add(missleBullet);
                missleBullet.setIsItFiredFromSpaceship(false);
                break;
            case 3:
                Bullet fireBoltBullet = new FireBoltBullet(getCurrentWidthPos() + 43, this.currentBulletHeigh - 29, ImageLoader.loadImage("/images/fireBoltBullet.png"));
                this.bulletsFired.add(fireBoltBullet);
                fireBoltBullet.setIsItFiredFromSpaceship(false);
                break;
            case 4:
                Bullet lightingBullet = new LightingBullet(getCurrentWidthPos() + 50, this.currentBulletHeigh - 51, ImageLoader.loadImage("/images/LightingBullet.png"));
                this.bulletsFired.add(lightingBullet);
                lightingBullet.setIsItFiredFromSpaceship(false);
                break;
        }

    }
}
