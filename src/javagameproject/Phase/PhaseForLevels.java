package javagameproject.Phase;

import javagameproject.Models.Levels.Level;
import javagameproject.Models.Levels.LevelOne;

import java.awt.*;

public class PhaseForLevels extends Phase {

    private Level level;

    public PhaseForLevels(Level level){
        this.level = level;
    }

    @Override
    public void update() {
        this.level.update();
    }

    @Override
    public void render(Graphics graphics) {
        this.level.render(graphics);
    }
}
