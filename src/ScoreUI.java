import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by brian on 3/14/2017.
 */
public class ScoreUI extends JPanel implements ActionListener {

    public ScoreUI(){
        Timer t = new Timer(16, this);
        t.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("score: " + C.POINTS, 20, 20);
        g.drawString("Lives remaining: " + C.NTURNS, 20, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }
}
