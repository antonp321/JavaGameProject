
package javagameproject.Game.InputHandlers;

import javagameproject.Models.Player;
import javagameproject.Phase.PhaseManager;

import java.awt.event.KeyEvent;
import java.security.Key;

public class PlayerInputHandler extends InputHandler{

    private Player player;
    private int shootingCounter;

    public PlayerInputHandler(Player player){
        super();
        this.player = player;
        this.shootingCounter = 0;
    }

    @Override
    public void keyPressed(KeyEvent pressedKey) {
        if(this.player.getHealth() > 0) {

            int keyCode = pressedKey.getKeyCode();

            if (keyCode == KeyEvent.VK_RIGHT) {
                this.player.setIsPlayerMovingRight(true);
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                this.player.setIsPlayerMovingLeft(true);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent typedKey) {
    }

    @Override
    public void keyReleased(KeyEvent releasedKey) {

        if(this.player.getHealth() > 0 && !PhaseManager.getCurrentLevel().getIsAllEnemyDead()) {

            int keyCode = releasedKey.getKeyCode();

            if (keyCode == KeyEvent.VK_RIGHT) {
                this.player.setIsPlayerMovingRight(false);
                this.shootingCounter++;
            }
            if (keyCode == KeyEvent.VK_LEFT) {

                this.player.setIsPlayerMovingLeft(false);
                this.shootingCounter++;
            }

            if(keyCode == KeyEvent.VK_SPACE) {
                this.shootingCounter++;
                if (this.player.getIsPlayerMovingLeft() == false && this.player.getIsPlayerMovingRight() == false) {
                    if(this.player.getBulletType().getBulletNumber() == 1){
                        this.player.shoot(this.player.getBulletType());
                    }
                    if(this.player.getBulletType().getBulletNumber() == 2 && this.shootingCounter % 2 == 0){
                        this.player.shoot(this.player.getBulletType());
                    }
                    if(this.player.getBulletType().getBulletNumber() == 3 && this.shootingCounter % 3 == 0){
                        this.player.shoot(this.player.getBulletType());
                    }
                    if(this.player.getBulletType().getBulletNumber() == 4 && this.shootingCounter % 3 == 0){
                        this.player.shoot(this.player.getBulletType());
                    }

                }
                if (this.shootingCounter > 500) {
                    this.shootingCounter = 0;
                }
            }
        }
    }
}
