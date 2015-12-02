
package javagameproject;

import javagameproject.Game.Game;

public class Launcher {
    public static void main(String[] args){
        Game game = new Game("MyFirstGame", 800, 600);
        game.start();
    }
}
