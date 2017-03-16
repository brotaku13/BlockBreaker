
public class C {
    //sets application height and width
    public static final int APPLICATION_HEIGHT = 600;
    public static final int APPLICATION_WIDTH = 1000;

    //sets game panel height and width
    public static final int HEIGHT = 600;
    public static final int WIDTH = 800;


    //sets UI height and width
    public static final int UIHEIGHT = HEIGHT;
    public static final int UIWIDTH = APPLICATION_WIDTH - WIDTH;

    //sets paddle height and width
    public static final int PADDLE_WIDTH = 100;
    public static final int PADDLE_HEIGHT = 15;

    //sets paddle y offset
    public static final int PADDLE_Y_OFFSET = HEIGHT - 50;

    //sets ball size
    public static final int BALL_SIZE = 15; //15

    //sets how fast the ball moves
    public static final int BALL_VELOCITY = 8;

    //defining blocks
    public static final int NBRICKS_PER_ROW = 10;
    public static final int NBRICKS_PER_COLUMN = 8;
    public static final int BRICK_WIDTH = 75;
    public static final int BRICK_SPACING = (WIDTH % BRICK_WIDTH) / NBRICKS_PER_ROW;
    public static final int BRICK_HEIGHT = BRICK_WIDTH / 3;
    public static final int BRICK_SPACE_FROM_TOP = 50;

    //sets score and turns...basic UI
    public static int POINTS = 0;
    public static int NTURNS = 3;




}
