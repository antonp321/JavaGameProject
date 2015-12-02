package javagameproject.Models.Levels;


import javagameproject.Models.EnemySpaceships.Boss;
import javagameproject.Models.EnemySpaceships.Spaceship;
import javagameproject.Models.Player;
import javagameproject.Models.Weapons.Bullets.Bullet;
import javagameproject.Phase.EndPhase;
import javagameproject.Phase.PhaseForLevels;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BossLevel extends Level {
    private final static int levelNumber = 6;
    private final static String levelTitle = "He is Here!";
    private final static BufferedImage bossLevelBackground = ImageLoader.loadImage("/images/BossLevelBackground.jpg");
    private final static Image bossLevelBackgroundOfDeath = ImageLoader.loadImage("/images/BossLevelBackgroundOfDeath.jpg");
    private Boss boss;

    public BossLevel(){
        super(levelTitle, bossLevelBackground, levelNumber, bossLevelBackgroundOfDeath);
        this.boss = new Boss(240, 10);

        this.boss.setIsMovingDown(true);
        this.boss.setIsMovingRight(true);
    }


    private void bossMovingRotaions(Spaceship enemy){
        if(enemy.getObjectX() > 560 && enemy.getHealth() > 0){

            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }

        if(enemy.getObjectX() < 30 && enemy.getHealth() > 0){

            enemy.setIsMovingRight(true);
            enemy.setIsMovingLeft(false);
        }

        if(enemy.getObjectY() > 250){
            enemy.setIsMovingDown(false);
            enemy.setIsMovingUp(true);
        }
        if(enemy.getObjectY() < 30){
            enemy.setIsMovingUp(false);
            enemy.setIsMovingDown(true);
        }
    }

    private void playerHittedByBoss(Boss enemy, Player player){
        for(int i = 0; i < enemy.getBossBulletsArray().size(); i++){
            if((enemy.getBossBulletsArray().get(i).getX() >= player.getCurrentWidthPos() && enemy.getBossBulletsArray().get(i).getX() <= player.getCurrentWidthPos() + 70) && enemy.getBossBulletsArray().get(i).getY() >= 520){

                if(player.getArmor() > 0) {

                    int playerArmorLeft = player.getArmor();
                    playerArmorLeft -= enemy.getBossBulletsArray().get(i).getDamage();
                    player.setArmor(playerArmorLeft);
                }

                if(player.getArmor() <= 0) {
                    int playerHealthLeft = player.getHealth();
                    playerHealthLeft -= enemy.getBossBulletsArray().get(i).getDamage();
                    player.setHealth(playerHealthLeft);
                }
                ArrayList<Bullet> bulletsArrayList = enemy.getBossBulletsArray();
                bulletsArrayList.remove(i);
                enemy.setBossBulletsArray(bulletsArrayList);
            }
        }
    }

    public void render(Graphics graphics) {
        super.render(graphics);
        this.boss.render(graphics);
    }

    public void update(){
        super.update();
        this.boss.update();
        super.enemyHitted(this.boss, super.getPlayer());
        super.playerHitted(this.boss, super.getPlayer());
        bossMovingRotaions(this.boss);
        this.playerHittedByBoss(this.boss, super.getPlayer());

        if(this.boss.getHealth() <= 0){
            PhaseManager.setCurrentPhase(new EndPhase());
            PhaseManager.setCurrentLevel(new BossLevel());

        }
    }
}
