import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.concurrent.Executors;

import static java.lang.Character.toUpperCase;

/**
 * Created by Roberto on 2/2/2015.
 */
public class Renderer extends Canvas implements KeyListener,Runnable {

    private boolean[] keys;
    private BufferedImage back;
    Color backroundColor = new Color(225,225,225);
    private final int width;
    private final int height;
    static boolean [][] drawMap;
    private Thread [] threads = new Thread [10];
    Executor e = new Executor() {
        @Override
        public void execute(Runnable command) {

        }
    };

    boolean init =  true;
    private double xRadian;
    private double yRadian;
    private double zRadian;
    private double zoom;
    int res = 0;


    Random rand = new Random();

    public Renderer(int width, int height)
    {
        this.width = width;
        this.height = height;
        keys = new boolean[4];
        setBackground(Color.WHITE);
        setVisible(true);
        new Thread(this).start();
        addKeyListener(this);		//starts the key thread to log key strokes
        drawMap = new boolean [width] [height];
    }




    public void update(Graphics window){
        paint(window);
    }

    public void paint(Graphics window) {

        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        //create a graphics reference to the back ground image
        //draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        //creates backround color
        graphToBack.setColor(backroundColor);
        graphToBack.fillRect(0, 0, width, height);

        graphToBack.setColor(Color.black);


        int threadIndex = 0;
        for(int x = 0; x< width; x++)
        {
            for(int y = 0; y< height; y++) {

                double graphx = 4*((double)x-((double)width/2))/(double)width;
                double graphy = 4*((double)y-((double)height/2))/(double)width;
                Complex z = new Complex(graphx,graphy);
                e.execute(new MathOperations(z,x,y,10));

            }
            if(x%10 == 0)
                System.out.println(x);
        }


        for(int x = 0; x< width; x++)
        {
            for(int y = 0; y< height; y++) {
                if(drawMap [x][y])
                    graphToBack.fillRect(x,y,1,1);
            }
        }



        twoDGraph.drawImage(back, null, 0, 0);
    }//paint



    //serves to create actions when keys are pressed
    public void keyPressed(KeyEvent e) {

        switch (toUpperCase(e.getKeyChar())) {
            case 'A':keys[0] = true;
                decXradian();
                break;

            case 'D':keys[3] = true;
                incXradian();
                break;

            case 'W':keys[0] = true;
                decYradian();
                break;

            case 'S':keys[3] = true;
                incYradian();

                break;

            case 'E':keys[1] = true;
                incZradian();
                break;

            case 'Q':keys[1] = true;
                decZradian();
                break;

            //case for adding particles
            case 'R':keys[2] = true;
                break;

            case 'T':
                keys[1] = true;
                incZoom();
                break;

            case 'G':
                keys[1] = true;
                decZoom();
                break;


        }
    }//keyPressed

    //serves to set the keys back to their original states
    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'A':keys[0] = false;break;
            case 'E':keys[1] = false;break;
            case 'Q':keys[1] = false;break;
            case 'R':keys[2] = false;break;
            case 'D':keys[3] = false;break;
            case 'W':keys[0] = false;break;
            case 'S':keys[1] = false;break;
            case 'T':keys[0] = false;break;
            case 'G':keys[1] = false;break;
        }
    }//keyReleased

    //has to be here for keyListener
    public void keyTyped(KeyEvent e) {
    }
    //user input variable minipulation
    public void incYradian() {
        yRadian +=.01;
    }

    public void decYradian()
    {
        yRadian -= .01;
    }

    public void incXradian() {
        xRadian +=.01;
    }

    public void decXradian()
    {
        xRadian -= .01;
    }

    public void incZradian() {
        zRadian +=.01;
    }

    public void decZradian()
    {
        zRadian -= .01;
    }

    public void incZoom() {
        zoom+=.01;
    }

    public void decZoom()
    {
        zoom-= .01;
    }

    public static synchronized void writeDrawMap(boolean state, int x, int y)
    {
        drawMap[x][y] = state;
    }




    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(0);
                repaint();
            }
        } catch (Exception e) {
        }
    }//run

}
