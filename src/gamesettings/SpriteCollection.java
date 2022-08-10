/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */
package gamesettings;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * a list of all the sprites at the game.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * a constructor that initializes a list of sprites.
     * <p>
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * adds the given sprite to the sprite's list.
     * <p>
     *
     * @param s the sprite that the method adds to the sprite's list.
     */
    public void addSprite(Sprite s) {
        getSprites().add(s);
    }

    /**
     * calls timePassed() on all sprites.
     * <p>
     */
    public void notifyAllTimePassed() {
        List<Sprite> theSprites = new ArrayList<Sprite>(getSprites());
        for (Sprite sprite : theSprites) {
            sprite.timePassed();
        }
    }

    /**
     * draw all the sprites on the given surface.
     * <p>
     *
     * @param d the surface where the method will drow all the sprites.
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> theSprites = new ArrayList<Sprite>(getSprites());
        for (Sprite sprite : theSprites) {
            sprite.drawOn(d);
        }
    }

    /**
     * return the list of sprites.
     * <p>
     *
     * @return the list of sprites.
     */
    public List<Sprite> getSprites() {
        return this.sprites;
    }
}