/**
 * Created by Roberto on 2/3/2015.
 */
    public class MathOperations extends Thread {
    private Complex z;
    private int xcord;
    private int ycord;
    private boolean isDone;






    public MathOperations(Complex z, int xcord, int ycord, int iterations)
    {
        this.z = z;
        isDone = false;
        start();
    }


    public void Mendlebraught()
    {
        for(int x = 0; x< 100; x++)
            z = (Complex.addComplex(new Complex(xcord,ycord),Complex.multiplyComplex(z,z)));

        if(Math.sqrt(z.getReal()*z.getReal()+z.getImaginary()*z.getImaginary())<2)
        {
            writeDrawMap(xcord, ycord, true);
        }
        else
            writeDrawMap(xcord, ycord, false);
    }

    public synchronized void writeDrawMap(int xcord,int ycord, boolean draw)
    {
        Renderer.writeDrawMap(draw,xcord,ycord);
    }

    public void run()
    {
        Mendlebraught();
    }
}
