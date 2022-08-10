/**
 * @author Hadassa Danesh
 * ID 322567041
 * @version 1.0
 * @since 2020-06-14
 */

package gamesettings;

import geometry.Point;
import geometry.Rectangle;
import interfaces.Animation;
import interfaces.LevelInformation;
import listenersofblock.BallRemover;
import listenersofblock.BlockRemover;
import listenersofblock.ScoreTrackingListener;
import sprites.Ball;
import sprites.Block;
import sprites.Paddle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Collidable;
import interfaces.Sprite;
import sprites.ScoreIndicator;

import java.awt.Color;
import java.util.List;

/**
 * this class is in charge of one level.
 * it initializes it, and has a method that run the level.
 */
public class GameLevel implements Animation {
    //the width and the height of the game are constants.
    static final int WIDTH_OF_GAME = 800;
    static final int HEIGHT_OF_GAME = 600;
    //the width and the height of a side block are the same, 25.
    static final int WIDTH_OR_HEIGHT_OF_SIDE_BLOCK = 25;
    // the radius of a ball is the same at every level, 5.
    static final int RADIUS_OF_BALL = 5;
    // the height of a paddle is the same at every level, 15.
    static final int HEIGHT_OF_PADDLE = 10;
    //the level's name is at the same place on the screen with the same size of letters, for every level.
    static final int X_VAL_OF_TEXT = 550;
    static final int Y_VAL_OF_TEXT = 23;
    static final int SIZE_OF_LETTERS = 20;
    static final int Y_OF_PADDLE = HEIGHT_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK - HEIGHT_OF_PADDLE - 25;
    static final int NUM_OF_SECONDS_COUNTDOWN = 2;
    static final int COUNTFROM_COUNTDOWN = 3;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    // the current number of blocks.
    private Counter blocksCounter;
    // the current number of balls.
    private Counter ballsCounter;
    private AnimationRunner runner;
    private boolean running;
    // the information about the level.
    private LevelInformation levelInformation;
    // the current score
    private Counter score;
    private KeyboardSensor keyboardSensor;

    /**
     * a constructor that initialize the fields of a GameLevel.
     * <p>
     *
     * @param levelInformation the information about the level.
     * @param score            the current score of this level.
     * @param runner           the AnimationRunner that runs this animation.
     * @param keyboardSensor   the keyboard.
     */
    public GameLevel(LevelInformation levelInformation, Counter score, AnimationRunner runner,
                     KeyboardSensor keyboardSensor) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blocksCounter = new Counter();
        this.ballsCounter = new Counter();
        this.runner = runner;
        this.levelInformation = levelInformation;
        this.score = score;
        this.keyboardSensor = keyboardSensor;
    }


    /**
     * adds the given collidable to the environment.
     * <p>
     *
     * @param c a collidable.
     */
    public void addCollidable(Collidable c) {
        getEnvironment().addCollidable(c);
    }

    /**
     * adds the given sprite to the environment.
     * <p>
     *
     * @param s a sprite.
     */
    public void addSprite(Sprite s) {
        getTheSpriteCollection().addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Sprites.Ball and Sprites.Paddle and add them to the game.
     * creates the listeners.
     * <p>
     */
    public void initialize() {
        // add the background to the game.
        getLevelInformation().getBackground().addToGame(this);
        // create a BlockRemover listener.
        BlockRemover blockRemover = new BlockRemover(this, getBlocksCounter());
        // create a ScoreTrackingListener.
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(getScore());
        List<Block> blockList = getLevelInformation().blocks();
        for (Block block : blockList) {
            // increase the number of blocks by 1.
            getBlocksCounter().increase(1);
            block.addHitListener(scoreTrackingListener);
            //add the blockRemover as a listener of the the block.
            block.addHitListener(blockRemover);
            // add te block to the game
            block.addToGame(this);
        }
        addPaddle();
        addSideBlocks();
        createBallsOnTopOfPaddle();
        ScoreIndicator scoreIndicator = new ScoreIndicator(getScore());
        scoreIndicator.addToGame(this);
    }

    /**
     * returns a new ball at the middle of the paddle.
     * <p>
     *
     * @param widthOfPaddle  the width of the paddle at this level.
     * @param xValueOfPaddle the x value of the left point of the paddle.
     * @return a new ball.
     */
    public Ball createABall(int widthOfPaddle, int xValueOfPaddle) {
        // the middle of the paddle
        int x = xValueOfPaddle + widthOfPaddle / 2;
        int y = Y_OF_PADDLE - 1;
        //add 1 to the counter of the balls in the game every time that a ball is created.
        getBallsCounter().increase(1);
        //return the ball.
        return new Ball(new Point(x, y), RADIUS_OF_BALL, Color.WHITE, getEnvironment());
    }

    /**
     * gets a ball and initialize it's velocity.
     * <p>
     *
     * @param ball     a ball that the method will initialize it's velocity.
     * @param velocity th velocity that the ball should have.
     */
    public void initializeVelocity(Ball ball, Velocity velocity) {
        ball.setVelocity(velocity);
    }

    /**
     * initializes big blocks (to the sides of the game) and adds them to the game.
     * <p>
     */
    public void addSideBlocks() {
        //side block from point (0,25). this is the left vertical side block of the game.
        Rectangle rectangle2 = new Rectangle(new Point(0, WIDTH_OR_HEIGHT_OF_SIDE_BLOCK),
                WIDTH_OR_HEIGHT_OF_SIDE_BLOCK, HEIGHT_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK);
        Block block2 = new Block(rectangle2, Color.GRAY);
        // side block from point(0,0). this is the top side block of the game.
        Rectangle rectangle = new Rectangle(new Point(0, 0), WIDTH_OF_GAME, WIDTH_OR_HEIGHT_OF_SIDE_BLOCK);
        Block block1 = new Block(rectangle, Color.GRAY);
        // side block from point (775, 25). this is the right vertical side block of the game.
        Rectangle rectangle3 = new Rectangle(new Point(WIDTH_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                WIDTH_OR_HEIGHT_OF_SIDE_BLOCK), WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                HEIGHT_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK);
        Block block3 = new Block(rectangle3, Color.GRAY);
        // side block from point (25, 600). this is the bottom side block of the game, the death-region.
        Rectangle rectangle4 = new Rectangle(new Point(WIDTH_OR_HEIGHT_OF_SIDE_BLOCK, HEIGHT_OF_GAME),
                WIDTH_OF_GAME - 2 * WIDTH_OR_HEIGHT_OF_SIDE_BLOCK,
                WIDTH_OR_HEIGHT_OF_SIDE_BLOCK);
        Block block4 = new Block(rectangle4, Color.GRAY);
        // create a BallRemover object, and add it has a listener of the death-region.
        BallRemover ballRemover = new BallRemover(this, getBallsCounter());
        block4.addHitListener(ballRemover);
        //create an array of all the side blocks.
        Block[] blocks = new Block[] {block1, block2, block3, block4};
        //add all the side blocks to the game.
        for (Block block : blocks) {
            block.addToGame(this);
        }
    }

    /**
     * initialize a paddle and adds it to the game.
     * <p>
     */
    public void addPaddle() {
        int xOfPaddle = WIDTH_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK - getLevelInformation().paddleWidth();
        Rectangle rectangleOfPaddle = new Rectangle(new Point(xOfPaddle / 2.0, Y_OF_PADDLE),
                getLevelInformation().paddleWidth(), HEIGHT_OF_PADDLE);
        // initialize the paddle.
        Paddle paddle = new Paddle(getKeyboardSensor(), rectangleOfPaddle, Color.YELLOW,
                getLevelInformation().paddleSpeed());
        //add the paddle to the game.
        paddle.addToGame(this);
    }

    /**
     * run the level.
     * <p>
     */
    public void run() {
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(NUM_OF_SECONDS_COUNTDOWN, COUNTFROM_COUNTDOWN,
                getTheSpriteCollection(), getLevelInformation().levelName()));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }

    /**
     * create balls on the top of the paddle.
     * <p>
     */
    public void createBallsOnTopOfPaddle() {
        int xOfPaddle = (WIDTH_OF_GAME - WIDTH_OR_HEIGHT_OF_SIDE_BLOCK - levelInformation.paddleWidth()) / 2;
        //create levelInformation.numberOfBalls() balls.
        for (int i = 0; i < getLevelInformation().numberOfBalls(); i++) {
            Ball ball = createABall(getLevelInformation().paddleWidth(), xOfPaddle);
            initializeVelocity(ball, this.getLevelInformation().initialBallVelocities().get(i));
            ball.addToGame(this);
        }
    }

    /**
     * return the game environment.
     * <p>
     *
     * @return the game environment.
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * return the SpriteCollection of the game.
     * <p>
     *
     * @return the SpriteCollection of the game.
     */
    public SpriteCollection getTheSpriteCollection() {
        return this.sprites;
    }

    /**
     * return the counter of the blocks in the game.
     * <p>
     *
     * @return the counter of the blocks in the game.
     */
    public Counter getBlocksCounter() {
        return this.blocksCounter;
    }

    /**
     * return the counter of the balls in the game.
     * <p>
     *
     * @return the counter of the blocks in the game.
     */
    public Counter getBallsCounter() {
        return this.ballsCounter;
    }

    /**
     * return the current score of the game.
     * <p>
     *
     * @return the current score of the game.
     */
    public Counter getScore() {
        return score;
    }

    /**
     * remove the given collidable from the game.
     * <p>
     *
     * @param c the given collidable.
     */
    public void removeCollidable(Collidable c) {
        getEnvironment().getCollidables().remove(c);
    }

    /**
     * remove the given sprite from the game.
     * <p>
     *
     * @param s the given sprite.
     */
    public void removeSprite(Sprite s) {
        getTheSpriteCollection().getSprites().remove(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // draw the background
        getLevelInformation().getBackground().drawOn(d);
        //draw all the sprites.
        getTheSpriteCollection().drawAllOn(d);
        d.setColor(Color.BLACK);
        // draw the level's name
        d.drawText(X_VAL_OF_TEXT, Y_VAL_OF_TEXT, "Level Name: " + getLevelInformation().levelName(),
                SIZE_OF_LETTERS);
        // notify the sprites that the time passed.
        getTheSpriteCollection().notifyAllTimePassed();

        //if there are no blocks in this level, increase the score by 100, and stop the run of the level.
        if ((getBlocksCounter().getValue() == 0)) {
            getScore().increase(100);
            this.running = false;
        }
        if (getBallsCounter().getValue() == 0) {
            // if there are no balls in this level anymore, stop the animation.
            this.running = false;
        }
        if (getKeyboardSensor().isPressed("p")) {
            // if the key "p" is pressed, pause the screen until the space key is pressed.
            this.runner.run(new KeyPressStoppableAnimation(getKeyboardSensor(), KeyboardSensor.SPACE_KEY,
                    new PauseScreen()));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * return the levelInformation.
     * <p>
     *
     * @return the levelInformation.
     */
    public LevelInformation getLevelInformation() {
        return levelInformation;
    }

    /**
     * return the keyboardSensor.
     * <p>
     *
     * @return the keyboardSensor.
     */
    public KeyboardSensor getKeyboardSensor() {
        return keyboardSensor;
    }

}