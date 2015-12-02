package javagameproject.Models.Levels;

import javagameproject.Models.EnemySpaceships.*;
import javagameproject.Models.Player;
import javagameproject.Models.Weapons.Bullets.MissleBullet;
import javagameproject.Phase.Phase;
import javagameproject.Phase.PhaseForLevels;
import javagameproject.Phase.PhaseManager;
import javagameproject.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelThree extends Level{

    private final static int levelNumber = 3;
    private final static String levelTitle = "Egyptians are under attack.";
    private final static BufferedImage thirdLevelBackground = ImageLoader.loadImage("/images/LevelThreeBackground.jpeg");
    private final static Image thirdLevelBackgroundOfDeath = ImageLoader.loadImage("/images/LevelThreeBackgroundOfDeath.jpg");
    private Spaceship enemy1;
    private Spaceship enemy2;
    private Spaceship enemy3;
    private Spaceship enemy4;
    private Spaceship enemy5;
    private Spaceship enemy6;

    public LevelThree(){
        super(levelTitle, thirdLevelBackground, levelNumber, thirdLevelBackgroundOfDeath);
        this.enemy1 = new Broodlord3(100, 10);
        this.enemy2 = new Vaelstrazz2(280, 40);
        this.enemy3 = new Vaelstrazz2(480, 40);
        this.enemy4 = new Firemaw4(25, 100);
        this.enemy5 = new Firemaw4(685, 100);
        this.enemy6 = new Flamegor5(100, 10);

        this.enemy1.setIsMovingDown(true);
        this.enemy1.setIsMovingRight(true);
        this.enemy2.setIsMovingDown(true);
        this.enemy3.setIsMovingDown(true);
        this.enemy4.setIsMovingRight(true);
        this.enemy5.setIsMovingLeft(true);
    }

    private void playerLeavesTheLevel(Player player){
        if(this.enemy1.getHealth() <= 0 && this.enemy2.getHealth() <= 0 && this.enemy3.getHealth() <= 0 && this.enemy4.getHealth() <= 0 && this.enemy5.getHealth() <= 0 && this.enemy6.getHealth() <= 0){
            super.setIsAllEnemyDead(true);
            player.setIsPlayerMovingLeft(false);
            player.setIsPlayerMovingRight(true);
            player.setMaxBounds(840);
        }
    }

    private void enemy1MovingRotaions(Spaceship enemy){
        if(enemy.getObjectY() >= 350 && enemy.getHealth() > 0){
            enemy.setIsMovingDown(false);
            enemy.setIsMovingUp(true);
        }
        if(enemy.getObjectY() <= 15 && enemy.getHealth() > 0){
            enemy.setIsMovingUp(false);
            enemy.setIsMovingDown(true);
        }
        if(enemy.getObjectX() >= 700 && enemy.getHealth() > 0){
            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }
        if(enemy.getObjectX() <= 120 && enemy.getHealth() > 0){
            enemy.setIsMovingLeft(false);
            enemy.setIsMovingRight(true);
        }
    }

    private void enemy2MovingRotaions(Spaceship enemy){
        if(enemy.getObjectY() >= 200 && enemy.getHealth() > 0){
            enemy.setIsMovingDown(false);
            enemy.setIsMovingUp(true);
        }
        if(enemy.getObjectY() <= 40 && enemy.getHealth() > 0){
            enemy.setIsMovingUp(false);
            enemy.setIsMovingDown(true);
        }
    }

    private void enemy3MovingRotaion(Spaceship enemy){
        if(enemy.getObjectY() >= 200 && enemy.getHealth() > 0){
            enemy.setIsMovingDown(false);
            enemy.setIsMovingUp(true);
        }
        if(enemy.getObjectY() <= 40 && enemy.getHealth() > 0){
            enemy.setIsMovingUp(false);
            enemy.setIsMovingDown(true);
        }
    }

    private void enemy4MovingRotaions(Spaceship enemy){
        if(enemy.getObjectX() >= 350 && enemy.getHealth() > 0){
            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }
        if(enemy.getObjectX() <= 25 && enemy.getHealth() > 0){
            enemy.setIsMovingLeft(false);
            enemy.setIsMovingRight(true);
        }
    }

    private void enemy5MovingRotaions(Spaceship enemy){
        if(enemy.getObjectX() <= 350 && enemy.getHealth() > 0){
            enemy.setIsMovingLeft(false);
            enemy.setIsMovingRight(true);
        }
        if(enemy.getObjectX() >= 625 && enemy.getHealth() > 0){
            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }
    }

    private void enemy6MovingRotaions(Spaceship enemy){
        if(enemy.getObjectY() >= 350 && enemy.getHealth() > 0){
            enemy.setIsMovingDown(false);
            enemy.setIsMovingUp(true);
        }
        if(enemy.getObjectY() <= 15 && enemy.getHealth() > 0){
            enemy.setIsMovingUp(false);
            enemy.setIsMovingDown(true);
        }
        if(enemy.getObjectX() >= 700 && enemy.getHealth() > 0){
            enemy.setIsMovingRight(false);
            enemy.setIsMovingLeft(true);
        }
        if(enemy.getObjectX() <= 120 && enemy.getHealth() > 0){
            enemy.setIsMovingLeft(false);
            enemy.setIsMovingRight(true);
        }
    }

    public void render(Graphics graphics){
        super.render(graphics);
        this.enemy1.render(graphics);
        this.enemy2.render(graphics);
        this.enemy3.render(graphics);
        this.enemy4.render(graphics);
        this.enemy5.render(graphics);
        if(this.enemy4.getHealth() <= 0){
            this.enemy6.render(graphics);
        }
    }

    public void update(){
        super.update();
        //enemy1
        if(this.enemy1.getHealth() <= 0){
            this.enemy1.setIsMovingLeft(false);
            this.enemy1.setIsMovingRight(false);
            this.enemy1.setIsMovingDown(false);
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
            this.enemy2.setIsMovingDown(false);
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

        //enemy6
        if(this.enemy4.getHealth() <= 0){
            if(this.enemy6.getHealth() <= 0){
                this.enemy6.setIsMovingLeft(false);
                this.enemy6.setIsMovingRight(false);
                this.enemy6.setIsMovingDown(false);
                this.enemy6.setIsMovingUp(true);
                super.playerGetAGift(this.enemy6, super.getPlayer());
            } else{
                enemy6MovingRotaions(this.enemy6);
            }
            this.enemy6.update();
            super.enemyHitted(this.enemy6, super.getPlayer());
            super.playerHitted(this.enemy6, super.getPlayer());
        }

        this.playerLeavesTheLevel(super.getPlayer());

        if(super.getPlayer().getCurrentWidthPos() == 800){
            PhaseManager.setCurrentPhase(new PhaseForLevels(new LevelFour()));
            PhaseManager.setCurrentLevel(new LevelFour());

        }
    }
}
