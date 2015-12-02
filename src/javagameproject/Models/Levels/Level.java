package javagameproject.Models.Levels;

import javagameproject.Models.EnemySpaceships.Spaceship;
import javagameproject.Models.Gifts.Gift;
import javagameproject.Models.Player;
import javagameproject.Models.Weapons.Bullets.Bullet;
import javagameproject.Models.Weapons.Bullets.FireBoltBullet;
import javagameproject.Models.Weapons.Bullets.FireBullet;
import javagameproject.Models.Weapons.Bullets.MissleBullet;
import javagameproject.Phase.Phase;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;
import javagameproject.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Level {

    private String title;
    private BufferedImage backgroundImg;
    private Image backgroundOfDeathImg;
    private int levelNumber;
    private Player player;
    private Image overOrMaxHP;
    private Image HP;
    private Image HP2;
    private Image HP3;
    private Image HP4;
    private Image HP5;
    private Image HP6;
    private Image HP7;
    private Image HP8;
    private Image HP9;
    private Image armor;
    private Image armor2;
    private Image armor3;
    private Image armor4;
    private Image armor5;
    private Image armor6;
    private Image armor7;
    private Image armor8;
    private Image armor9;
    private SpriteSheet spriteSheetForHP;
    private SpriteSheet spriteSheetForArmor;
    private boolean isAllEnemysDead;

    protected Level(String title, BufferedImage backgroundImg, int levelNumber, Image backgroundOfDeathImg ){
        this.title = title;
        this.backgroundImg = backgroundImg;
        this.levelNumber = levelNumber;
        this.backgroundOfDeathImg = backgroundOfDeathImg;
        this.player = new Player("SG8");
        this.spriteSheetForHP = new SpriteSheet(ImageLoader.loadImage("/images/healthBarSpriteSheet.gif"));
        this.spriteSheetForArmor = new SpriteSheet(ImageLoader.loadImage("/images/armorBarSpriteSheet.png"));
        this.overOrMaxHP = this.spriteSheetForHP.crop(5, 0, 122, 12);
        this.HP = this.spriteSheetForHP.crop(5, 0, 122, 12);
        this.HP2 = this.spriteSheetForHP.crop(5, 35, 108, 12);
        this.HP3 = this.spriteSheetForHP.crop(5, 54, 93, 12);
        this.HP4 = this.spriteSheetForHP.crop(5, 72, 76, 12 );
        this.HP5 = this.spriteSheetForHP.crop(5, 90, 58, 12);
        this.HP6 = this.spriteSheetForHP.crop(5, 108, 40, 12);
        this.HP7 = this.spriteSheetForHP.crop(5, 126, 24, 12);
        this.HP8 = this.spriteSheetForHP.crop(5, 144, 11, 12);
        this.HP9 = this.spriteSheetForHP.crop(5, 162, 3, 12);

        this.armor = this.spriteSheetForArmor.crop(5, 0, 122, 12);
        this.armor2 = this.spriteSheetForArmor.crop(5, 36, 108, 12);
        this.armor3 = this.spriteSheetForArmor.crop(5, 54, 93, 12);
        this.armor4 = this.spriteSheetForArmor.crop(5, 72, 76, 12 );
        this.armor5 = this.spriteSheetForArmor.crop(5, 90, 58, 12);
        this.armor6 = this.spriteSheetForArmor.crop(5, 108, 40, 12);
        this.armor7 = this.spriteSheetForArmor.crop(5, 126, 24, 12);
        this.armor8 = this.spriteSheetForArmor.crop(5, 144, 11, 12);
        this.armor9 = this.spriteSheetForArmor.crop(5, 162, 3, 12);

        this.isAllEnemysDead = false;

//        if(this.levelNumber == 3){
//            this.player.setBulletType(new MissleBullet(this.player.getCurrentWidthPos(), 493, ImageLoader.loadImage("/images/MissleBullet.png")));
//        }
        if(this.levelNumber == 4){
            this.player.setBulletType(new FireBoltBullet(this.player.getCurrentWidthPos(), 493, ImageLoader.loadImage("/images/fireBoltBullet.png")));
        }
        if(this.levelNumber == 5 || this.levelNumber == 6){
            this.player.setBulletType(new FireBoltBullet(this.player.getCurrentWidthPos(), 493, ImageLoader.loadImage("/images/fireBoltBullet.png")));
        }
}
    public int getLevelNumber(){
        return  this.levelNumber;
    }

    public void setIsAllEnemyDead(boolean isAllEnemyDead){
        this.isAllEnemysDead = isAllEnemyDead;
    }

    public boolean getIsAllEnemyDead(){
        return this.isAllEnemysDead;
    }

    public Image getBackgroundOfDeathImg(){
        return this.backgroundOfDeathImg;
    }

    public String getTitle(){
        return this.title;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player newPlayer){
        this.player = newPlayer;
    }

    protected void enemyHitted(Spaceship enemy, Player player){
        for(int i = 0; i < player.getBulletsFiredArray().size(); i++){
            if((player.getBulletsFiredArray().get(i).getX() >= enemy.getObjectX() && player.getBulletsFiredArray().get(i).getX() + 10 <= enemy.getObjectX() + enemy.getObjectWidth()) && player.getBulletsFiredArray().get(i).getY() <= enemy.getObjectY() + 18){
                int healthLeft = enemy.getHealth();
                healthLeft -= player.getBulletsFiredArray().get(i).getDamage();
                enemy.setHealth(healthLeft);
                ArrayList<Bullet> bulletsArray = player.getBulletsFiredArray();
                bulletsArray.remove(i);
                player.setBulletsFired(bulletsArray);
            }
        }
    }

    protected void playerHitted(Spaceship enemy, Player player){
        for(int i = 0; i < enemy.getSpaceshipBullets().size(); i++){
            if((enemy.getSpaceshipBullets().get(i).getX() >= player.getCurrentWidthPos() && enemy.getSpaceshipBullets().get(i).getX() <= player.getCurrentWidthPos() + 70) && enemy.getSpaceshipBullets().get(i).getY() >= 520){

                if(player.getArmor() > 0) {

                    int playerArmorLeft = player.getArmor();
                    playerArmorLeft -= enemy.getSpaceshipBullets().get(i).getDamage();
                    player.setArmor(playerArmorLeft);
                }

                if(player.getArmor() <= 0) {
                    int playerHealthLeft = player.getHealth();
                    playerHealthLeft -= enemy.getSpaceshipBullets().get(i).getDamage();
                    player.setHealth(playerHealthLeft);
                }
                ArrayList<Bullet> bulletsArrayList = enemy.getSpaceshipBullets();
                bulletsArrayList.remove(i);
                enemy.setSpaceshipBullets(bulletsArrayList);
            }
        }
    }

    protected void playerGetAGift(Spaceship enemy, Player player){
        enemy.setIsTheShipCarrysGift(true);
        for(int i = 0; i < enemy.getGiftArray().size(); i++){
            if((enemy.getGiftArray().get(i).getX() >= player.getCurrentWidthPos() && enemy.getGiftArray().get(i).getX() <= player.getCurrentWidthPos() + 70) && enemy.getGiftArray().get(i).getY() >= 500){
                if(enemy.getGiftArray().get(i).getBonus() != 0){
                    if(!enemy.getGiftArray().get(i).getIsItArmor()){
                        int playerHealth = player.getHealth();
                        playerHealth += enemy.getGiftArray().get(i).getBonus();
                        player.setHealth(playerHealth);
                    }
                    else{
                        int playerArmor = player.getArmor();
                        playerArmor += enemy.getGiftArray().get(i).getBonus();
                        player.setArmor(playerArmor);
                    }
                }
                else {
                    Bullet newBulletType = enemy.getGiftArray().get(i).getBulletType();
                    player.setBulletType(newBulletType);
                }
                ArrayList<Gift> newGiftArray = enemy.getGiftArray();
                newGiftArray.remove(i);
                enemy.setGiftsArray(newGiftArray);
            }
        }
    }

    public void render(Graphics graphics){
        graphics.drawImage(this.backgroundImg, 0, 0, null);
        graphics.drawImage(this.HP, 9, 13, null);
        graphics.drawImage(this.armor, 9, 35, null);
        this.player.render(graphics);
    }

    public void update(){
        this.player.update();
        if(this.player.getHealth() >= 500){
            this.HP = this.overOrMaxHP;
        }
        if(this.player.getHealth() <= 450 && this.player.getHealth() > 400){
            this.HP = this.HP2;
        }
        if(this.player.getHealth() <= 400 && this.player.getHealth() > 350){
            this.HP = this.HP3;
        }
        if(this.player.getHealth() <= 350 && this.player.getHealth() > 300){
            this.HP = this.HP4;
        }
        if(this.player.getHealth() <= 300 && this.player.getHealth() > 250){
            this.HP = this.HP5;
        }
        if(this.player.getHealth() <= 250 && this.player.getHealth() > 200){
            this.HP = this.HP6;
        }
        if(this.player.getHealth() <= 200 && this.player.getHealth() > 150){
            this.HP = this.HP7;
        }
        if(this.player.getHealth() <= 150 && this.player.getHealth() > 50){
            this.HP = this.HP8;
        }
        if(this.player.getHealth() <= 50 && this.player.getHealth() > 0){
            this.HP = this.HP9;
        }


        if(this.player.getArmor() <= 450 && this.player.getArmor() > 400){
            this.armor = this.armor2;
        }
        if(this.player.getArmor() <= 400 && this.player.getArmor() > 350){
            this.armor = armor3;
        }
        if(this.player.getArmor() <= 350 && this.player.getArmor() > 300){
            this.armor = armor4;
        }
        if(this.player.getArmor() <= 300 && this.player.getArmor() > 250){
            this.armor = armor5;
        }
        if(this.player.getArmor() <= 250 && this.player.getArmor() > 200){
            this.armor = armor6;
        }
        if(this.player.getArmor() <= 200 && this.player.getArmor() > 150){
            this.armor = armor7;
        }
        if(this.player.getArmor() <= 150 && this.player.getArmor() > 50){
            this.armor = armor8;
        }
        if(this.player.getArmor() <= 50 && this.player.getArmor() > 0){
            this.armor = armor9;
        }
    }
}
