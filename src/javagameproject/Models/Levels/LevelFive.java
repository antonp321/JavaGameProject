package javagameproject.Models.Levels;


import javagameproject.Models.EnemySpaceships.*;
import javagameproject.Models.Player;
import javagameproject.Phase.PhaseForLevels;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelFive extends Level{
    private final static int levelNumber = 5;
    private final static String levelTitle = "The tower will fall this time.";
    private final static BufferedImage fifthLevelBackground = ImageLoader.loadImage("/images/LevelFiveBackground.jpg");
    private final static Image fifthLevelBackgroundOfDeath = ImageLoader.loadImage("/images/LevelFiveBackgroundOfDeath.jpg");
    private Spaceship enemy1;
    private Spaceship enemy2;
    private Spaceship enemy3;
    private Spaceship enemy4;
    private Spaceship enemy5;
    private Spaceship enemy6;

    public LevelFive(){
        super(levelTitle, fifthLevelBackground, levelNumber, fifthLevelBackgroundOfDeath);
        this.enemy1 = new Broodlord3(100, 10);
        this.enemy2 = new Firemaw4(650, 128);
        this.enemy3 = new Flamegor5(100, 210);
        this.enemy4 = new Firemaw4(25, 80);
        this.enemy5 = new Vaelstrazz2(685, 80);
        this.enemy6 = new Razorgore1(400, 20);
        this.enemy1.setIsMovingRight(true);
        this.enemy2.setIsMovingLeft(true);
        this.enemy3.setIsMovingRight(true);
        this.enemy4.setIsMovingRight(true);
        this.enemy5.setIsMovingLeft(true);

    }

    private void playerLeavesTheLevel(Player player){
        if(this.enemy1.getHealth() <= 0 && this.enemy2.getHealth() <= 0 && this.enemy3.getHealth() <= 0 && this.enemy4.getHealth() <= 0 && this.enemy5.getHealth() <= 0){
            super.setIsAllEnemyDead(true);
            player.setIsPlayerMovingLeft(false);
            player.setIsPlayerMovingRight(true);
            player.setMaxBounds(840);
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
        if(enemy.getObjectX() > 550 && enemy.getHealth() > 0){

            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }

        if(enemy.getObjectX() < 40 && enemy.getHealth() > 0){

            enemy.setIsMovingRight(true);
            enemy.setIsMovingLeft(false);
        }
    }

    private void enemy4MovingRotaions(Spaceship enemy){
        if(enemy.getObjectX() > 130 && enemy.getHealth() > 0){

            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }
        if(enemy.getObjectX() < 10 && enemy.getHealth() > 0){

            enemy.setIsMovingRight(true);
            enemy.setIsMovingLeft(false);
        }
    }

    private void enemy5MovingRotaions(Spaceship enemy){
        if(enemy.getObjectX() < 460 && enemy.getHealth() > 0){
            enemy.setIsMovingLeft(false);
            enemy.setIsMovingRight(true);
        }
        if(enemy.getObjectX() > 700 && enemy.getHealth() > 0){
            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }
    }

    public void render(Graphics graphics){
        super.render(graphics);
        this.enemy1.render(graphics);
        this.enemy2.render(graphics);
        this.enemy3.render(graphics);
        this.enemy4.render(graphics);
        this.enemy5.render(graphics);
        this.enemy6.render(graphics);
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
            super.playerGetAGift(this.enemy3, super.getPlayer());
        }
        else{
            enemy3MovingRotaion(this.enemy3);
        }
        this.enemy3.update();
        super.enemyHitted(this.enemy3, super.getPlayer());
        super.playerHitted(this.enemy3, super.getPlayer());

        //enemy4
        if(this.enemy4.getHealth() <= 0){
            this.enemy4.setIsMovingLeft(false);
            this.enemy4.setIsMovingRight(false);
            this.enemy4.setIsMovingUp(true);
        }
        else{
            enemy4MovingRotaions(this.enemy4);
        }

        this.enemy4.update();
        super.enemyHitted(this.enemy4, super.getPlayer());
        super.playerHitted(this.enemy4, super.getPlayer());

        //enemy5
        if(this.enemy5.getHealth() <= 0){
            this.enemy5.setIsMovingLeft(false);
            this.enemy5.setIsMovingRight(false);
            this.enemy5.setIsMovingUp(true);
        }
        else{
            enemy5MovingRotaions(this.enemy5);
        }

        this.enemy5.update();
        super.enemyHitted(this.enemy5, super.getPlayer());
        super.playerHitted(this.enemy5, super.getPlayer());

        // enemy6

        if(this.enemy6.getHealth() <= 0){
            this.enemy6.setIsMovingLeft(false);
            this.enemy6.setIsMovingRight(false);
            this.enemy6.setIsMovingUp(true);
        }

        this.enemy6.update();
        super.enemyHitted(this.enemy6, super.getPlayer());
        super.playerHitted(this.enemy6, super.getPlayer());

        this.playerLeavesTheLevel(super.getPlayer());

        if(super.getPlayer().getCurrentWidthPos() == 800){
            PhaseManager.setCurrentPhase(new PhaseForLevels(new BossLevel()));
            PhaseManager.setCurrentLevel(new BossLevel());

        }
    }
}
