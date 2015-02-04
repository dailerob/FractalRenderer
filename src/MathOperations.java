/**
 * Created by Roberto on 2/3/2015.
 */
public class MathOperations extends Thread {
    private Complex z;
    private int width;
    private int height;
    private boolean isDone;





    public MathOperations(Complex z,int width, int height)
    {
        this.width = width;
        this.height = height;
        this.z = z;
        isDone = false;
        start();
    }



    public void Mendlebraught(double w, double h, int iterations)
    {
        for(int x = 0; x< iterations; x++)
            z = (Complex.addComplex(new Complex(w,h),Complex.multiplyComplex(z,z)));

        if(z.getReal()+z.getImaginary()<2)
        {
            writeDrawMap(true);
        }
        else
            writeDrawMap(false);
    }

    public synchronized void writeDrawMap(boolean draw)
    {
        Renderer.drawMap[width][height] = draw;
        isDone=true;
    }

    public boolean done ()
    {
        return isDone;
    }



    @Override
    public void run() {

        Mendlebraught(width,height,10);
    }
}
