// ID: 318811304

import biuoop.GUI;
import objects.AnimationRunner;
import interfaces.LevelInformation;
import levels.LevelOne;
import levels.LevelTwo;
import levels.LevelThree;
import levels.LevelFour;
import utils.GameFlow;
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;
import utils.BuildLevel;

/**
 * @author Ben Levi
 * Class Operation : the class create new game (levels list) and run it.
 */
public class Ass6Game {

    static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;

    /**
     * Function Name : main.
     * Function Operation : the function create new game and run it.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Game", GUI_WIDTH, GUI_HEIGHT);
        KeyboardSensor keyboard = gui.getKeyboardSensor();
        AnimationRunner runner = new AnimationRunner(gui);
        GameFlow flow = new GameFlow(runner, keyboard);

        List<LevelInformation> listArgs = new ArrayList<>();
        for (String str : args) {
            try {
                if ((Integer.parseInt(str) >= 1) && (Integer.parseInt(str) <= 4)) {
                    BuildLevel build = new BuildLevel(Integer.parseInt(str));
                    listArgs.add(build.getLevel());
                }
            } catch (Exception ex) {
                continue;
            }
        }

        // if have no valid input of levels number - so run the regular levels.
        if (listArgs.size() == 0) {
            List<LevelInformation> list = new ArrayList<>();
            list.add(new LevelOne());
            list.add(new LevelTwo());
            list.add(new LevelThree());
            list.add(new LevelFour());
            flow.runLevels(list);
            gui.close();
            return;
        }

        flow.runLevels(listArgs);
        gui.close();

    }
}
