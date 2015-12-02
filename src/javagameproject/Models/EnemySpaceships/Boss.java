package javagameproject.Models.EnemySpaceships;


import javagameproject.Models.Gifts.FireBoltBulletGift;
import javagameproject.Models.Gifts.Gift;
import javagameproject.Models.Gifts.HealthBonus;
import javagameproject.Models.Weapons.Bullets.*;
import javagameproject.gfx.ImageLoader;

import java.awt.*;
import java.util.ArrayList;

public class Boss extends Spaceship {
    private static final String name = "Boss";
    private static final int health = 3700;
    private static final int armor = 300;
    private static final int width = 300;
    private static final int height = 250;
    private static final Image bossImg = ImageLoader.loadImage("/images/BigBoss.png");
    private ArrayList<Bullet> bossBulletsArray;
    private int bulletsCounter;

    public Boss(int x, int y){
        super(name, width, height, x, y, bossImg, health, armor, new MissleBullet(x, y, ImageLoader.loadImage("/images/ReversedMissleBullet.png")));
        this.bossBulletsArray = new ArrayList<Bullet>();
        this.bulletsCounter = 0;
    }

    public ArrayList<Bullet> getBossBulletsArray(){
        return this.bossBulletsArray;
    }

    public void setBossBulletsArray(ArrayList<Bullet> newBulletsArray){
        this.bossBulletsArray = newBulletsArray;
    }

    private void bossShoot(){
        Bullet fireBullet = new LightingBullet(getObjectX() + 110, getObjectY() + 25, ImageLoader.loadImage("/images/LightingBullet.png"));
        fireBullet.setIsItFiredFromSpaceship(true);
        this.bossBulletsArray.add(fireBullet);

        Bullet fireBoltBullet = new FireBoltBullet(getObjectX() + 200, getObjectY() + 60, ImageLoader.loadImage("/images/fireBoltBullet.png"));
        fireBoltBullet.setIsItFiredFromSpaceship(true);
        this.bossBulletsArray.add(fireBoltBullet);

        Bullet lightingBullet = new LightingBullet(getObjectX() + 270, getObjectY() + 60, ImageLoader.loadImage("/images/LightingBullet.png"));
        lightingBullet.setIsItFiredFromSpaceship(true);
        this.bossBulletsArray.add(lightingBullet);

        Bullet fireBullet2 = new FireBullet(getObjectX() + 30, getObjectY() + 120, ImageLoader.loadImage("/images/ReversedNormalBullet.png"));
        fireBullet2.setIsItFiredFromSpaceship(true);
        fireBullet2.setIsItFiredFromBoss(true);
        this.bossBulletsArray.add(fireBullet2);
    }

    public void render(Graphics graphics){
        super.render(graphics);
        if(!super.getIsTheShipDead()){
            for(int i = 0; i < this.bossBulletsArray.size(); i++){
                this.bossBulletsArray.get(i).render(graphics);
            }
        }
    }

    public void update(){
        super.update();

        if(!super.getIsTheShipDead()) {

            this.bulletsCounter++;
            if (this.bulletsCounter % 26 == 0) {
                this.bossShoot();
            }
            if(this.bulletsCounter == 1000){
                this.bulletsCounter = 0;
            }

            for (int i = 0; i < this.bossBulletsArray.size(); i++) {
                this.bossBulletsArray.get(i).update();
                if (this.bossBulletsArray.get(i).getY() > 650) {
                    this.bossBulletsArray.remove(i);
                }
            }
        }
    }
}
