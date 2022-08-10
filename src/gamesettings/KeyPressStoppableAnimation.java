/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package gamesettings;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * wrap an animation and add to it the behavior of  stopping the.
 * game if a specific key is pressed.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * a constructor that gets a keyboard, a key and an animation.
     * <p>
     *
     * @param sensor    the keyboard.
     * @param key       the key that needs to be pressed if this animation should stop.
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        // the animation should not stop.
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //do on frame of th animation
        getAnimation().doOneFrame(d);
        // if the key is pressed
        if (getSensor().isPressed(getKey())) {
            //if this key was not already pressed.
            if (!isAlreadyPressed()) {
                // stop the animation
                setStop(true);
            }
        } else { //if this key is not pressed, change isAlreadyPressed to be false.
            setAlreadyPressed(false);
        }
    }

    @Override
    public boolean shouldStop() {
        // return the situation of this this animation, if it should stop or not.
        return isStop();
    }

    /**
     * return the stopping state of the object.
     * <p>
     *
     * @return stop field.
     */
    public boolean isStop() {
        return stop;
    }

    /**
     * return the animation.
     * <p>
     *
     * @return the animation.
     */
    public Animation getAnimation() {
        return animation;
    }

    /**
     * return the keyboard.
     * <p>
     *
     * @return the keyboard.
     */
    public KeyboardSensor getSensor() {
        return sensor;
    }

    /**
     * return the key.
     * <p>
     *
     * @return the key.
     */
    public String getKey() {
        return key;
    }

    /**
     * return isAlreadyPressed.
     * <p>
     *
     * @return isAlreadyPressed
     */
    public boolean isAlreadyPressed() {
        return isAlreadyPressed;
    }

    /**
     * set isAlreadyPressed to be the alreadyPressed.
     * <p>
     *
     * @param alreadyPressed the new isAlreadyPressed.
     */
    public void setAlreadyPressed(boolean alreadyPressed) {
        isAlreadyPressed = alreadyPressed;
    }

    /**
     * set 'stop' to be the newStop.
     * <p>
     *
     * @param newStop the new 'stop'.
     */
    private void setStop(boolean newStop) {
        this.stop = newStop;
    }
}
