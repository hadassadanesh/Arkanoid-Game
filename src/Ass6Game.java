/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

import gamesettings.AnimationRunner;
import gamesettings.GameFlow;
import interfaces.LevelInformation;
import levels.DirectHitLevel;
import levels.FinalFourLevel;
import levels.PurpleLevel;
import levels.WideEasyLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * create a new game, initialize and run it.
 */
public class Ass6Game {

    /**
     * create a new game, and run it.
     * <p>
     *
     * @param args an array of strings, the arguments are in charge of which level will be played.
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            //if there are arguments
            AnimationRunner runner = new AnimationRunner();
            GameFlow gameFlow = new GameFlow(runner, runner.getGui().getKeyboardSensor());
            List<LevelInformation> list = new ArrayList<>();
            //for every argument:
            for (String argument : args) {
                //if it is a char (it's length is 1)
                if (argument.length() == 1) {
                    //if it is a digit
                    if (Character.isDigit(argument.charAt(0))) {
                        //find th digit (the argument)
                        int theNum = Integer.parseInt(argument);
                        if (theNum <= 4) {
                            // if the argument is 1, add the first level to the list.
                            if (theNum == 1) {
                                DirectHitLevel firstLevel = new DirectHitLevel();
                                list.add(firstLevel);
                            } else if (theNum == 2) {
                                // if the argument is 2, add the second level to the list.
                                WideEasyLevel secondLevel = new WideEasyLevel();
                                list.add(secondLevel);
                            } else if (theNum == 3) {
                                // if the argument is 3, add the third level to the list.
                                PurpleLevel thirdLevel = new PurpleLevel();
                                list.add(thirdLevel);
                            } else if (theNum == 4) {
                                // if the argument is 4, add the fourth level to the list.
                                FinalFourLevel fourLevel = new FinalFourLevel();
                                list.add(fourLevel);
                            }
                        }
                    }
                }
            }
            // if the list is not empty, run th levels that are in it.
            if (list.size() != 0) {
                gameFlow.runLevels(list);
            }
        }
        //if there are no arguments, a game with four levels runs, level after level.
        DirectHitLevel firstLevel = new DirectHitLevel();
        WideEasyLevel secondLevel = new WideEasyLevel();
        PurpleLevel thirdLevel = new PurpleLevel();
        FinalFourLevel fourLevel = new FinalFourLevel();
        AnimationRunner runner = new AnimationRunner();
        GameFlow gameFlow = new GameFlow(runner, runner.getGui().getKeyboardSensor());
        List<LevelInformation> list = new ArrayList<>();
        list.add(firstLevel);
        list.add(secondLevel);
        list.add(thirdLevel);
        list.add(fourLevel);
        gameFlow.runLevels(list);
    }
}
