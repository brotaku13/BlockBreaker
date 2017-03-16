import java.awt.*;


public class Brick extends Rectangle {

    //initiating variables
    public int brickX;
    public int brickY;
    public int brickWidth;
    public int brickHeight;
    public Color brickColor;

    //brick constructor
    public Brick(int x, int y, int width, int height, Color color){
        brickX = x;
        brickY = y;
        brickWidth = width;
        brickHeight = height;
        brickColor = color;
    }

    //draw method
    public void draw(Graphics g){
        g.setColor(brickColor);
        g.fillRect(brickX, brickY, brickWidth, brickHeight);
    }

    //get bounds for collision detection
    public Rectangle brickRect(){
        return new Rectangle(brickX, brickY, brickWidth, brickHeight);
    }

    //more specific collision detection
    public Rectangle bickTopLeft(){ return new Rectangle(brickX, brickY, C.BRICK_WIDTH / 2, C.BRICK_WIDTH / 2);}
    public Rectangle brickTopRight(){return new Rectangle(brickX + C.BRICK_WIDTH / 2, brickY, C.BRICK_WIDTH / 2, C.BRICK_WIDTH / 2);}
    public Rectangle brickBottomLeft(){return new Rectangle(brickX, brickY + C.BRICK_HEIGHT /2, C.BRICK_WIDTH / 2, C.BRICK_WIDTH / 2);}
    public Rectangle brickBottomRight(){return new Rectangle(brickX + C.BRICK_WIDTH / 2, brickY + C.BRICK_HEIGHT / 2, C.BRICK_WIDTH / 2, C.BRICK_WIDTH / 2);}

}
