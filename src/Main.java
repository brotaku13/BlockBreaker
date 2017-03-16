import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{
    public static void main(String[] args){

        JFrame frame = new JFrame("Breakout game");
        //frame.setPreferredSize(new Dimension(C.APPLICATION_WIDTH, C.APPLICATION_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(C.APPLICATION_WIDTH, C.APPLICATION_HEIGHT));
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));


        BreakoutGame gameInstance = new BreakoutGame();
        gameInstance.setBackground(Color.BLACK);
        gameInstance.setPreferredSize(new Dimension(C.WIDTH, C.HEIGHT));


        ScoreUI scorePanel = new ScoreUI();
        scorePanel.setBackground(Color.DARK_GRAY);
        scorePanel.setPreferredSize(new Dimension(C.UIWIDTH, C.UIHEIGHT));

        pane.add(gameInstance);
        pane.add(scorePanel);

        frame.add(pane);
        frame.pack();
        frame.setVisible(true);

    }
}
