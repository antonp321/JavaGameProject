
package javagameproject.Game;

import javagameproject.Display.Display;
import javagameproject.Models.Menus.MainMenu;
import javagameproject.Models.Menus.Menuu;
import javagameproject.Models.Player;
import javagameproject.Phase.Phase;
import javagameproject.Phase.PhaseManager;
import javagameproject.Phase.PhaseMenu;
import javagameproject.gfx.ImageLoader;
import javagameproject.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

    private String title;
    private int width;
    private int height;
    private Thread thread;
    private Boolean isRunning;
    private BufferStrategy buffer;
    private Graphics graphics;
    private Display display;
    private SpriteSheet spriteSheet;
    private Phase phase;
    private Player player;

    //Да се опише после (възможно е да е само тест)
    private int spriteSheetWidth;
    private int spriteSheetHeight;
    //test only
    private int playerPos;
    
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        this.isRunning = false;
    }
    
    private void init(){
        this.display = Display.getInstance();
        this.phase = PhaseManager.getCurrentPhase();
        this.spriteSheet = new SpriteSheet(ImageLoader.loadImage("/images/player.gif"));

        this.spriteSheetWidth = 37;
        this.spriteSheetHeight = 50;
        //test only
//        this.player = new Player("SG");
//        this.playerPos = 0;
    }

    private void update(){
        this.phase = PhaseManager.getCurrentPhase();
        this.phase.update();
    }
    
    private void render(){
        if (this.buffer == null){
            this.display.getCanvas().createBufferStrategy(2);
        }

        this.buffer = this.display.getCanvas().getBufferStrategy();
        this.graphics = this.buffer.getDrawGraphics();

//        Image playerImg = spriteSheet.crop(37*4 + 3 , 63 , this.spriteSheetWidth + 3, this.spriteSheetHeight + 16);

        this.phase.render(graphics);
//        this.graphics.drawImage(playerImg, 0, 493, 101, 119, null);

//          this.player.render(graphics);

        this.buffer.show();
        this.graphics.clearRect(0, 0, this.width, this.height);
        this.graphics.dispose();
    }
    
    @Override
    public void run() {
        this.init();
        
       while(isRunning){
           try {
               Thread.sleep(60);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           render();
           update();

           //test only
//           this.playerPos++;
//           if(this.playerPos >= 2){
//                this.playerPos = 0;
//           }
       }
       
       stop();
    }
    
    
    public synchronized void start(){
        if(isRunning){
            return;
        }

        isRunning = true;
        
        this.thread = new Thread(this);
        this.thread.start();
    }
    
    public synchronized void stop(){
        if(!isRunning){
            return;
        }

        isRunning = false;
        
        try {
            this.thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
