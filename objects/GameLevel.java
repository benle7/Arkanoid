// ID: 318811304

package objects;

import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import utils.SpriteCollection;
import utils.GameEnvironment;
import utils.Counter;
import utils.BlockRemover;
import utils.ScoreTrackingListener;
import utils.BallRemover;
import utils.KeyPressStoppableAnimation;
import interfaces.Collidable;
import interfaces.Sprite;
import geometry.Rectangle;
import biuoop.DrawSurface;
import java.awt.Color;
import interfaces.Animation;


/**
 * @author Ben Levi
 * Class Operation : the class represent new game and his construction.
 */
public class GameLevel implements Animation {

    static final int GUI_WIDTH = 800;
    static final int GUI_HEIGHT = 600;
    static final double SHORT_LENGTH = 25;

    private final LevelInformation level;
    private final SpriteCollection sprites;
    private final GameEnvironment environment;

    private final Counter remainingBlocks;
    private final Counter remainingBalls;
    private final Counter score;

    private final biuoop.KeyboardSensor keyboard;
    private final Paddle user;

    private final AnimationRunner runner;
    private boolean running;

    /**
     * Function Name : Game.
     * Function Operation : constructor.
     * @param level the level.
     * @param keyboard the keyboard.
     * @param runner the AnimationRunner.
     * @param score the score.
     */
    public GameLevel(LevelInformation level, biuoop.KeyboardSensor keyboard,
                     AnimationRunner runner, Counter score) {
        this.level = level;
        this.runner = runner;
        this.running = true;

        this.keyboard = keyboard;
        this.user = new Paddle(keyboard,
                (double) ((GUI_WIDTH / 2) - (level.paddleWidth() / 2)),
                level.paddleWidth(), level.paddleSpeed());

        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter(this.level.numberOfBlocksToRemove());
        this.remainingBalls = new Counter(this.level.numberOfBalls());
        this.score = score;
    }

    /**
     * Function Name : getRemainingBlocks.
     * Function Operation : return the number of blocks.
     * @return Counter the number of blocks.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    /**
     * Function Name : getRemainingBalls.
     * Function Operation : return the number of balls.
     * @return Counter the number of balls.
     */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }

    /**
     * Function Name : addCollidable.
     * Function Operation : the function add collidable to game environment.
     * @param c collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Function Name : removeCollidable.
     * Function Operation : the function remove collidable from game environment.
     * @param c collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Function Name : addSprite.
     * Function Operation : the function add sprite to the collection.
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Function Name : removeSprite.
     * Function Operation : the function remove sprite from the collection.
     * @param s sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Function Name : buildFrame.
     * Function Operation : the function create the frame.
     */
    private void buildFrame() {
        double extra = 20;
        double zero = 0;

        // the background (only Sprite).
        addSprite(this.level.getBackground());

        Sprite blockIndicator = new Block(new Rectangle(zero, zero, GUI_WIDTH, SHORT_LENGTH), Color.lightGray);
        addSprite(blockIndicator);

        Sprite indicatorScore = new ScoreIndicator(this.score);
        indicatorScore.addToGame(this);
        Sprite indicatorLevel = new LevelIndicator(this.level.levelName(), 7);
        indicatorLevel.addToGame(this);

        Block up = new Block(new Rectangle(zero, SHORT_LENGTH,
                GUI_WIDTH + extra, SHORT_LENGTH), Color.gray);
        Block left = new Block(new Rectangle(zero, SHORT_LENGTH,
                SHORT_LENGTH, GUI_HEIGHT + extra), Color.gray);
        Block right = new Block(new Rectangle(GUI_WIDTH - SHORT_LENGTH, SHORT_LENGTH,
                SHORT_LENGTH, GUI_HEIGHT + extra), Color.gray);
        up.addToGame(this);
        left.addToGame(this);
        right.addToGame(this);

        BallRemover remover = new BallRemover(this, this.remainingBalls);
        Block deathRegion = new Block(new Rectangle(zero, GUI_HEIGHT,
                GUI_WIDTH, SHORT_LENGTH), Color.gray);
        deathRegion.addHitListener(remover);
        deathRegion.addToGame(this);
    }

    /**
     * Function Name : buildBalls.
     * Function Operation : the function create the balls.
     */
    private void buildBalls() {
        int radius = 6;
        double startY = this.user.getStart().getY() - radius;
        double startX = this.user.getStart().getX() + (double) (this.level.paddleWidth() / 2);
        // remain balls already initialized by num of balls on level.
        int numBalls = this.level.numberOfBalls();
        for (int i = 0; i < numBalls; i += 1) {
            Ball ball = new Ball(startX, startY, radius, Color.white);
            ball.setVelocity(this.level.initialBallVelocities().get(i));
            ball.setEnvironment(this.environment);
            ball.addToGame(this);
        }
    }

    /**
     * Function Name : initialize.
     * Function Operation : the function initialize the
     * game (frame,paddle, balls and blocks).
     */
    public void initialize() {
        buildFrame();
        this.user.addToGame(this);
        buildBalls();
        ScoreTrackingListener scoreTrack = new ScoreTrackingListener(this.score);
        BlockRemover remover = new BlockRemover(this, this.remainingBlocks);
        // remain blocks already initialized by num of blocks to remove on level.
        for (Block block : this.level.blocks()) {
            block.addHitListener(scoreTrack);
            block.addHitListener(remover);
            block.addToGame(this);
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Function Name : checkBlocksAndBalls.
     * Function Operation : the function check balls and blocks number,
     * if have no blocks or balls - should stop,
     */
    private void checkBlocksAndBalls() {
        if (this.remainingBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
        this.sprites.notifyAllTimePassed();
        checkBlocksAndBalls();
        this.sprites.drawAllOn(d);
    }

    /**
     * Function Name : run.
     * Function Operation : the function run the game.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }
}
