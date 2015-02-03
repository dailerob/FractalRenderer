import javax.swing.*;
import java.awt.*;

/**
 * Created by Roberto on 2/2/2015.
 */
public class FractalRunner extends JFrame{
    private static final int WIDTH = 1680;
    private static final int HEIGHT = 1050;

    public FractalRunner()
    {
        super("Phyics");
        setSize(WIDTH,HEIGHT);

        Renderer game = new Renderer(WIDTH,HEIGHT);

        ((Component)game).setFocusable(true);
        getContentPane().add(game);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main( String args[] )
    {
        FractalRunner run = new FractalRunner();
    }
}
