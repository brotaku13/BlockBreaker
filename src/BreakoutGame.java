import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class BreakoutGame extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
    //declaring variables needed
    Paddle paddle;
    Ball ball;
    ArrayList<Brick> Bricks = new ArrayList<>();

    //instantiating time
    Timer t = new Timer(10, this);

    //constructor for JPanel
    public BreakoutGame(){
        //instantiating original paddle and ball
        paddle = new Paddle(C.WIDTH / 2, C.PADDLE_Y_OFFSET);
        ball = new Ball(C.WIDTH / 2, C.HEIGHT / 2, C.BALL_VELOCITY, C.BALL_VELOCITY);

        //calls function that builds the array of bricks
        brickBuilder(Bricks, C.NBRICKS_PER_COLUMN);

        //adds mouse listeners
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    //draws this every tick
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        paddle.draw(g);
        ball.draw(g);
        for (Brick brick : Bricks)
            brick.draw(g);
        if (C.NTURNS == 0){
            g.setColor(Color.RED);
            g.setFont(new Font("SansSerf", Font.ROMAN_BASELINE, 50));
            g.drawString("-- YOU DIED --", (C.WIDTH / 2) - 130, (C.HEIGHT / 2) + 50);

            g.setColor(Color.RED);
            g.setFont(new Font("SansSerf", Font.ROMAN_BASELINE, 25));
            g.drawString("Click to play again", (C.WIDTH / 2) - 100, (C.HEIGHT / 2) + 100);

        }

    }

    //action to take every tick
    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();

        //lives taken on death
        if (!ball.CollisionDetection(paddle, Bricks)){
            C.NTURNS -= 1;
        }

        //at game over, reset
        if (C.NTURNS == 0){
            Bricks.clear();
            brickBuilder(Bricks, C.NBRICKS_PER_COLUMN);
            C.POINTS = 0;
            t.stop();
        }

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    //detecting mouse x coordinates
    @Override
    public void mouseMoved(MouseEvent e) {

        paddle.move(e.getX());
    }

    //detects mouse clicks: starts game
    @Override
    public void mouseClicked(MouseEvent e) {

        t.start();
        //sets number of turns to 3 if death
        if (C.NTURNS == 0)
            C.NTURNS = 3;
            t.start();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void brickBuilder(ArrayList<Brick> Bricks, int numberOfRows){
        Color brickColor = Color.BLUE;
        for (int i = 0; i < C.NBRICKS_PER_ROW; i++){
            for (int j = 0; j < numberOfRows; j++){
                switch(j){
                    case 0:
                        brickColor = Color.RED;
                        break;
                    case 1:
                        brickColor = Color.ORANGE;
                        break;
                    case 2:
                        brickColor = Color.YELLOW;
                        break;
                    case 3:
                        brickColor = Color.GREEN;
                        break;
                    case 4:
                        brickColor = Color.CYAN;
                        break;
                    case 5:
                        brickColor = Color.GREEN;
                        break;
                    case 6:
                        brickColor = Color.YELLOW;
                        break;
                    case 7:
                        brickColor = Color.ORANGE;
                        break;
                    default:
                        brickColor = Color.BLUE;
                        break;
                }
                Bricks.add(new Brick(i * (C.BRICK_WIDTH + C.BRICK_SPACING), C.BRICK_SPACE_FROM_TOP + (j * (C.BRICK_HEIGHT + C.BRICK_SPACING)), C.BRICK_WIDTH, C.BRICK_HEIGHT, brickColor ));
            }
        }
    }
}
