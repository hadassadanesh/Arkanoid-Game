/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package gamesettings;

import biuoop.KeyboardSensor;
import interfaces.LevelInformation;

import java.util.List;

/**
 * a class that is in charge of the flow of the game.
 * this class has a method that can get a list of levels, and run them.
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter score;

    /**
     * a constructor of GameFlow.
     * <p>
     *
     * @param ar the animationRunner.
     * @param ks the keyboard.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.score = new Counter();
    }

    /**
     * run the given levels.
     * * <p>
     *
     * @param levels a list with the level information of all the level to run.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            //create a level
            GameLevel level = new GameLevel(levelInfo, getScore(), getAr(), getKs());
            //initialize it
            level.initialize();
            //while there are balls and blocks, run the level.
            while (level.getBallsCounter().getValue() != 0 && level.getBlocksCounter().getValue() != 0) {
                level.run();
            }
            // if there are no balls
            if (level.getBallsCounter().getValue() == 0) {
                // play "Game Over" animation.
                getAr().run(new KeyPressStoppableAnimation(getKs(), KeyboardSensor.SPACE_KEY,
                        new GameOver(getScore())));
                getAr().getGui().close();
            }
        }
        //play "You Win" animation.
        getAr().run(new KeyPressStoppableAnimation(getKs(), KeyboardSensor.SPACE_KEY,
                new YouWinAnimation(getScore())));
        getAr().getGui().close();
    }

    /**
     * return the current score. the score is kept across levels, throughout the entire game.
     * <p>
     *
     * @return the current score.
     */
    public Counter getScore() {
        return score;
    }

    /**
     * return the animationRunner.
     * <p>
     *
     * @return the animationRunner.
     */
    public AnimationRunner getAr() {
        return ar;
    }

    /**
     * return the keyboard.
     * <p>
     *
     * @return the keyboard.
     */
    public KeyboardSensor getKs() {
        return ks;
    }
}