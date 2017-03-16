import org.w3c.dom.css.Rect;

import java.awt.*;


public class Paddle extends Rectangle {

    //declaring variables
    public int paddleX;
    public int paddleY;

    //constructor
    public Paddle (int initX, int initY){
        paddleX = initX;
        paddleY = initY;
    }

    //draw
    public void draw(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(paddleX, C.PADDLE_Y_OFFSET, C.PADDLE_WIDTH, C.PADDLE_HEIGHT);
    }

    //getting bounds for collision detection
    public Rectangle paddleRect(){
        return new Rectangle(paddleX, paddleY, C.PADDLE_WIDTH, C.PADDLE_HEIGHT);
    }

    //better paddle bounds
    public Rectangle paddleRectLeft(){return new Rectangle(paddleX, paddleY, C.PADDLE_WIDTH / 4, C.PADDLE_HEIGHT / 2);}

    public Rectangle paddleRectCenter(){return new Rectangle(paddleX + C.PADDLE_WIDTH / 4, paddleY, C.PADDLE_WIDTH / 2, C.PADDLE_HEIGHT / 2);}

    public Rectangle paddleRectRight(){return new Rectangle(paddleX + C.PADDLE_WIDTH / 4 + C.PADDLE_WIDTH / 2, paddleY, C.PADDLE_WIDTH / 4, C.PADDLE_HEIGHT / 2);}

    //bottom of paddle
    public Rectangle paddleRectBottom(){return new Rectangle(paddleX , paddleY + C.PADDLE_HEIGHT / 2, C.PADDLE_WIDTH, C.PADDLE_HEIGHT / 2);}

    //movement based on mouse movement
    public void move(int mouseX){

        //sets mouse to middle of paddle
        mouseX -= C.PADDLE_WIDTH / 2;

        //NOT WORKING tell paddle not to go past sides
        if (mouseX - C.PADDLE_WIDTH * 3 / 2 <= 0)
            paddleX = 1;

        if (mouseX + (C.PADDLE_WIDTH) >= C.WIDTH)
            paddleX = C.WIDTH - C.PADDLE_WIDTH;

        //else paddle = mouse
        else
            paddleX = mouseX;
    }


}
