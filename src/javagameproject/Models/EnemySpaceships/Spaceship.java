package javagameproject.Models.EnemySpaceships;

import javagameproject.Models.GameObject;
import javagameproject.Models.Gifts.*;
import javagameproject.Models.Levels.LevelOne;
import javagameproject.Models.Weapons.Bullets.*;
import javagameproject.Phase.PhaseForLevels;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Spaceship extends GameObject {

    private int health;
    private int armor;
    private Bullet bulletType;
    private boolean isMovingUp;
    private boolean isMovingDown;
    private boolean isMovingLeft;
    private boolean isMovingRight;
    private Image deadShip;
    private ArrayList<Bullet> spaceshipBullets;
    private int bulletsCounter;
    private boolean isTheShipDead;
    private ArrayList<Gift> giftsArray;
    private boolean isTheGiftDropped;
    private boolean isTheShipCarrysGift;
    private int giftNumber;

    protected Spaceship(String name, int width, int height, int x, int y, Image img, int health, int armor, Bullet bulletType){
        super(name, width, height, x, y, img);
        this.health = health;
        this.armor = armor;
        this.bulletType = bulletType;
        this.isMovingDown = false;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.isMovingUp = false;
        this.spaceshipBullets = new ArrayList<Bullet>();
        this.giftsArray = new ArrayList<Gift>();
        this.bulletsCounter = 0;
        this.isTheShipDead = false;
        this.isTheGiftDropped = false;
        this.isTheShipCarrysGift = false;
        this.giftNumber = 0;

    }

    public boolean getIsTheShipDead(){
        return this.isTheShipDead;
    }

    public ArrayList<Gift> getGiftArray(){
        return this.giftsArray;
    }

    public void setGiftsArray(ArrayList<Gift> newArray){
        this.giftsArray = newArray;
    }

    public void setIsTheShipCarrysGift(boolean isItReally){
        this.isTheShipCarrysGift = isItReally;
    }

    public boolean getIsMovingDown(){
        return this.isMovingDown;
    }

    public boolean getIsMovingUp(){
        return this.isMovingUp;
    }

    public boolean getIsMovingLeft(){
        return this.isMovingLeft;
    }

    public boolean getIsMovingRight(){
        return this.isMovingRight;
    }

    public void setIsMovingDown(boolean isMovingDown){
        this.isMovingDown = isMovingDown;
    }

    public void setIsMovingUp(boolean isMovingUp){
        this.isMovingUp = isMovingUp;
    }

    public void setIsMovingLeft(boolean isMovingLeft){
        this.isMovingLeft = isMovingLeft;
    }

    public void setIsMovingRight(boolean isMovingRight){
        this.isMovingRight = isMovingRight;
    }

    public Bullet getBulletType(){
        return this.bulletType;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health){
        if(health <= 0){
            this.deadShip = ImageLoader.loadImage("/images/Blast.png");
            this.setObjectImg(this.deadShip);
            this.health = health;
            this.isTheShipDead = true;
        }
        else{
            this.health = health;
        }
    }

    public ArrayList<Bullet> getSpaceshipBullets(){
        return this.spaceshipBullets;
    }

    public void setSpaceshipBullets(ArrayList<Bullet> bulletsArrayList){
        this.spaceshipBullets = bulletsArrayList;
    }

     private void spaceshipShoot(Bullet currentBullet){
         switch(currentBullet.getBulletNumber()){
             case 1:
                Bullet fireBullet = new FireBullet(getObjectX() + 18, getObjectY() + 18, currentBullet.getBulletImg());
                 fireBullet.setIsItFiredFromSpaceship(true);
                 this.spaceshipBullets.add(fireBullet);
                 break;
             case 2:
                 Bullet missleBullet = new MissleBullet(getObjectX() + 18, getObjectY() + 18, currentBullet.getBulletImg());
                 missleBullet.setIsItFiredFromSpaceship(true);
                 this.spaceshipBullets.add(missleBullet);
                 break;
             case 3:
                Bullet fireBoltBullet = new FireBoltBullet(getObjectX() + 18, getObjectY() + 18, currentBullet.getBulletImg());
                 fireBoltBullet.setIsItFiredFromSpaceship(true);
                 this.spaceshipBullets.add(fireBoltBullet);
                 break;
             case 4:
                 Bullet lightingBullet = new LightingBullet(getObjectX() + 18, getObjectY() + 18, currentBullet.getBulletImg());
                 lightingBullet.setIsItFiredFromSpaceship(true);
                 this.spaceshipBullets.add(lightingBullet);
                 break;
         }
    }

    private void spaceshipGiftFalling(int giftNumber){


        if(giftNumber == 0){
            Gift armorBonusGift = new ArmorBonus(getObjectX(), getObjectY());
            this.giftsArray.add(armorBonusGift);
        }
        if(giftNumber == 1) {
            Gift armorMinusGift = new ArmorMinus(getObjectX(), getObjectY());
                this.giftsArray.add(armorMinusGift);
        }
        if(giftNumber == 2) {
            Gift fireBulletGift = new FireBulletBonus(getObjectX(), getObjectY());
               this.giftsArray.add(fireBulletGift);
        }
        if(giftNumber == 3) {
            Gift healthBonusGift = new HealthBonus(getObjectX(), getObjectY());
              this.giftsArray.add(healthBonusGift);
        }
        if(giftNumber == 4) {
            Gift healthMinusGift = new HealthMinus(getObjectX(), getObjectY());
            this.giftsArray.add(healthMinusGift);
        }
        if(giftNumber == 5) {
            Gift missleBulletGift = new MissleBulletBonus(getObjectX(), getObjectY());
           this.giftsArray.add(missleBulletGift);
        }
        if(giftNumber == 6) {
            Gift missleBulletGift = new FireBoltBulletGift(getObjectX(), getObjectY());
            this.giftsArray.add(missleBulletGift);
        }
        if(giftNumber == 7) {
            Gift missleBulletGift = new LightingBulletGift(getObjectX(), getObjectY());
            this.giftsArray.add(missleBulletGift);
        }
    }


    public void render(Graphics graphics){

        graphics.drawImage(super.getObjectImg(), super.getObjectX(), super.getObjectY(), super.getObjectWidth(), super.getObjectHeight(), null);
        if(!this.isTheShipDead){
            for(int i = 0; i < this.spaceshipBullets.size(); i++){
                this.spaceshipBullets.get(i).render(graphics);
            }
        }
        if(this.isTheShipDead && this.isTheShipCarrysGift) {
            for(int i = 0; i < this.giftsArray.size(); i++){
                this.giftsArray.get(i).render(graphics);
            }
        }
    }

    public void update(){
        if(this.isMovingRight == true){
            int currentX = getObjectX();
            currentX += 4;
            setX(currentX);
        }
        if(this.isMovingLeft == true){
            int currentX = getObjectX();
            currentX -= 4;
            setX(currentX);
        }
        if(this.isMovingUp == true){
            int currentY = getObjectY();
            currentY -= 4;
            setY(currentY);
            if(currentY == -80){
                setIsMovingUp(false);
            }
        }
        if(this.isMovingDown == true){
            int currentY = getObjectY();
            currentY += 4;
            setY(currentY);
        }
        if(!this.isTheShipDead) {

            this.bulletsCounter++;
            if (this.bulletsCounter % 19 == 0) {
                this.spaceshipShoot(this.bulletType);
            }
                if(this.bulletsCounter == 1000){
                    this.bulletsCounter = 0;
                }

            for (int i = 0; i < this.spaceshipBullets.size(); i++) {
                    this.spaceshipBullets.get(i).update();
                if (this.spaceshipBullets.get(i).getY() > 650) {
                    this.spaceshipBullets.remove(i);
                }
            }
        }

        if(this.isTheShipDead){

            Random rand = new Random();
            this.giftNumber = rand.nextInt(8);

            for(int i = 0; i < this.spaceshipBullets.size(); i++){
                this.spaceshipBullets.remove(i);
            }
            if(!this.isTheGiftDropped){
                this.spaceshipGiftFalling(this.giftNumber);
                this.isTheGiftDropped = true;
            }
            for(int i = 0; i < this.giftsArray.size(); i++){
                this.giftsArray.get(i).update();
                if(this.giftsArray.get(i).getY() > 650){
                    this.giftsArray.remove(i);
                }
            }
        }
    }
}
