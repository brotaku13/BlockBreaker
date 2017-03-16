import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;


public class Ball extends Rectangle {

    //initializing variables
    public int ballX;
    public int ballY;
    public double velX;
    public double velY;


    Random rand = new Random();

    //ball constructor
    public Ball(int startX, int startY, double initvelX, double initvelY) {
        ballX = startX;
        ballY = startY;
        velX = initvelX;
        velY = initvelY;
    }

    //draw ball
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, C.BALL_SIZE, C.BALL_SIZE);

    }

    //reset Ball
    public void resetBall() {
        ballX = rand.nextInt(C.WIDTH) + 1;
        ballY = C.HEIGHT / 2;
        boolean dir = rand.nextBoolean();
        if (dir)
            velX = C.BALL_VELOCITY;
        else
            velX = C.BALL_VELOCITY * -1;
    }


    //move ball (Velocity controlled through constants class)
    public void move() {
        ballX += 1 * velX;
        ballY += 1 * velY;
    }

    //get bounding box for collision detection

    public Rectangle ballRect() {
        return new Rectangle(ballX, ballY, C.BALL_SIZE, C.BALL_SIZE);
    }

    //more specific collision detection
    public Rectangle ballTopLeft() {
        return new Rectangle(ballX, ballY, C.BALL_SIZE / 2, C.BALL_SIZE / 2);
    }

    public Rectangle ballTopRight() {
        return new Rectangle(ballX + C.BALL_SIZE / 2, ballY, C.BALL_SIZE / 2, C.BALL_SIZE / 2);
    }

    public Rectangle ballBottomLeft() {
        return new Rectangle(ballX, ballY + C.BALL_SIZE / 2, C.BALL_SIZE / 2, C.BALL_SIZE / 2);
    }

    public Rectangle ballBottomRight() {
        return new Rectangle(ballX + C.BALL_SIZE / 2, ballY + C.BALL_SIZE / 2, C.BALL_SIZE / 2, C.BALL_SIZE / 2);
    }


    //collision detection logic
    //returns false if you lose the game
    public boolean CollisionDetection(Paddle paddle, ArrayList<Brick> Bricks) {
        //if ball touches sides
        if (ballX + C.BALL_SIZE >= C.WIDTH || ballX <= 0) {
            velX *= -1;
            return true;
        }

        //if touches ceiling
        if (ballY <= 0) {
            velY *= -1;
            return true;
        }
        if (ballRect().intersects(paddle.paddleRect())) {
            velY *= -1;
            return true;
            }
/**
        if (ballRect().intersects(paddle.paddleRect())) {
            if (ballBottomRight().intersects(paddle.paddleRectLeft())){
                velX = velX * 2;
                velY = -velY;
                return true;
            }
            else if (ballBottomLeft().intersects(paddle.paddleRectRight())){
                velX = velX * 2;
                velY = -velY;
                return true;
            }
            else if (ballBottomLeft().intersects(paddle.paddleRectCenter())){
                if (Math.abs(velX) == 1)
                    velY = -velY;
                else
                    velY = -1;
            }
            else if (ballTopRight().intersects(paddle.paddleRectBottom())){
                velY = -velY;
            }
        }
*/
        //if touches bottom
        if (ballY + C.BALL_SIZE >= C.HEIGHT) {
            resetBall();
            return false;

        }

        //if touches brick
        for (int i = 0; i < Bricks.size(); i++) {
            //top left and top right (top of ball)
            if (ballTopLeft().intersects(Bricks.get(i).brickRect()) && ballTopRight().intersects(Bricks.get(i).brickRect())) {
                velY *= -1;
                Bricks.remove(i);
                C.POINTS += 100;
                return true;
            }
            //bottom left and bottom right (bottom of ball)
            else if (ballBottomLeft().intersects(Bricks.get(i).brickRect()) && ballBottomRight().intersects(Bricks.get(i).brickRect())) {
                velY *= -1;
                Bricks.remove(i);
                C.POINTS += 100;
                return true;
            }
            //top right and bottom right (right side of ball)
            else if (ballTopRight().intersects(Bricks.get(i).brickRect()) && ballBottomRight().intersects(Bricks.get(i).brickRect())) {
                velX *= -1;
                Bricks.remove(i);
                C.POINTS += 100;
                return true;
            }
            //top left and bottom left (left side of ball)
            else if (ballTopLeft().intersects(Bricks.get(i).brickRect()) && ballBottomLeft().intersects(Bricks.get(i).brickRect())) {
                velX *= -1;
                Bricks.remove(i);
                C.POINTS += 100;
                return true;
            }

        }
        return true;
    }



}
