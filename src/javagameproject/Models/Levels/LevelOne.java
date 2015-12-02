package javagameproject.Models.Levels;

import javagameproject.Models.EnemySpaceships.Firemaw4;
import javagameproject.Models.EnemySpaceships.Razorgore1;
import javagameproject.Models.EnemySpaceships.Spaceship;
import javagameproject.Models.EnemySpaceships.Vaelstrazz2;
import javagameproject.Models.Gifts.Gift;
import javagameproject.Models.Player;
import javagameproject.Models.Weapons.Bullets.Bullet;
import javagameproject.Phase.Phase;
import javagameproject.Phase.PhaseForLevels;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LevelOne extends Level {

    private final static int levelNumber = 1;
    private final static String levelTitle = "The Great Wall";
    private final static BufferedImage firstLevelBackground = ImageLoader.loadImage("/images/levelOneBackground.jpg");
    private final static Image firstLevelBackgroundOfDeath = ImageLoader.loadImage("/images/levelOneBackgroundOfDeath.jpg");
    private Spaceship enemy1;
    private Spaceship enemy2;
    private Spaceship enemy3;
    private Spaceship enemy4;
    private Spaceship enemy5;

    public LevelOne(){
        super(levelTitle, firstLevelBackground, levelNumber, firstLevelBackgroundOfDeath);
        this.enemy1 = new Razorgore1(100, 50);
        this.enemy2 = new Firemaw4(300, 120);
        this.enemy3 = new Razorgore1(80, 30);
        this.enemy4 = new Vaelstrazz2(25, 80);
        this.enemy5 = new Vaelstrazz2(685, 80);
        this.enemy1.setIsMovingRight(true);
        this.enemy2.setIsMovingLeft(true);
        this.enemy3.setIsMovingDown(true);
        this.enemy3.setIsMovingRight(true);

    }

    private void playerLeavesTheLevel(Player player){
        if(this.enemy1.getHealth() <= 0 && this.enemy2.getHealth() <= 0 && this.enemy3.getHealth() <= 0 && this.enemy4.getHealth() <= 0 && this.enemy5.getHealth() <= 0){
            super.setIsAllEnemyDead(true);
            player.setIsPlayerMovingLeft(false);
            player.setIsPlayerMovingRight(true);
            player.setMaxBounds(840);
            if(player.getCurrentWidthPos() == 840){
                PhaseManager.setCurrentLevel(new LevelTwo());
            }
        }
    }

    private void enemy1MovingRotaions(Spaceship enemy){

        if(enemy.getObjectX() > 550 && enemy.getHealth() > 0){
            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }

        if(enemy.getObjectX() < 40 && enemy.getHealth() > 0){
            enemy.setIsMovingRight(true);
            enemy.setIsMovingLeft(false);
        }

    }

    private void enemy2MovingRotaions(Spaceship enemy){
        if(enemy.getObjectX() > 560 && enemy.getHealth() > 0){
            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }

        if(enemy.getObjectX() < 10 && enemy.getHealth() > 0){
            enemy.setIsMovingRight(true);
            enemy.setIsMovingLeft(false);
        }
    }

    private void enemy3MovingRotaion(Spaceship enemy){
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

    public void render(Graphics graphics){
        super.render(graphics);
        this.enemy1.render(graphics);
        this.enemy2.render(graphics);
        this.enemy3.render(graphics);
        this.enemy4.render(graphics);
        this.enemy5.render(graphics);
    }

    public void update(){
        super.update();
        //enemy1
        if(this.enemy1.getHealth() <= 0){
            this.enemy1.setIsMovingLeft(false);
            this.enemy1.setIsMovingRight(false);
            this.enemy1.setIsMovingUp(true);
            super.playerGetAGift(this.enemy1, super.getPlayer());
        } else{
            enemy1MovingRotaions(this.enemy1);
        }
        this.enemy1.update();
        super.enemyHitted(this.enemy1, super.getPlayer());
        super.playerHitted(this.enemy1, super.getPlayer());

        //enemy2
        if(this.enemy2.getHealth() <= 0){
            this.enemy2.setIsMovingLeft(false);
            this.enemy2.setIsMovingRight(false);
            this.enemy2.setIsMovingUp(true);
            super.playerGetAGift(this.enemy2, super.getPlayer());
        } else{
            enemy2MovingRotaions(this.enemy2);
        }
        this.enemy2.update();
        super.enemyHitted(this.enemy2, super.getPlayer());
        super.playerHitted(this.enemy2, super.getPlayer());

        //enemy3
        if(this.enemy3.getHealth() <= 0){
            this.enemy3.setIsMovingLeft(false);
            this.enemy3.setIsMovingRight(false);
            this.enemy3.setIsMovingDown(false);
            this.enemy3.setIsMovingUp(true);
        }
        else{
            enemy3MovingRotaion(this.enemy3);
        }
        this.enemy3.update();
        super.enemyHitted(this.enemy3, super.getPlayer());
        super.playerHitted(this.enemy3, super.getPlayer());

        //enemy4
        if(this.enemy4.getHealth() <= 0){
            this.enemy4.setIsMovingUp(true);
        }

        this.enemy4.update();
        super.enemyHitted(this.enemy4, super.getPlayer());
        super.playerHitted(this.enemy4, super.getPlayer());

        //enemy5
        if(this.enemy5.getHealth() <= 0){
            this.enemy5.setIsMovingUp(true);
        }

        this.enemy5.update();
        super.enemyHitted(this.enemy5, super.getPlayer());
        super.playerHitted(this.enemy5, super.getPlayer());

        this.playerLeavesTheLevel(super.getPlayer());

        if(super.getPlayer().getCurrentWidthPos() == 800){
            PhaseManager.setCurrentPhase(new PhaseForLevels(new LevelTwo()));
            PhaseManager.setCurrentLevel(new LevelTwo());

        }
    }
}
