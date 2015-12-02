package javagameproject.Phase;

import javagameproject.Models.Levels.Level;
import javagameproject.Models.Menus.MainMenu;

public class PhaseManager  {

    private static Phase currentPhase;
    private static Level currentLevel;
    //i'll set player when i make it

    public static Phase getCurrentPhase(){
        if(currentPhase == null){
            currentPhase = new PhaseMenu(new MainMenu());
        }
        return currentPhase;
    }

    public static void setCurrentPhase(Phase phase){
        currentPhase = phase;
    }

    public static Level getCurrentLevel(){
        return currentLevel;
    }

    public static void setCurrentLevel(Level level){
        currentLevel = level;
    }

    // get and set for currentPlayer when i make it
}
