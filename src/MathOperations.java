/**
 * Created by Roberto on 2/3/2015.
 */
public class MathOperations implements Runnable {


    private Complex z;
    int xcord;
    int ycord;
    int iterations;


    public MathOperations(Complex z, int xcord, int ycord, int iterations)
    {
        this.z = z;
        this.xcord = xcord;
        this.ycord = ycord;
        this.iterations = iterations;
    }


    public void Mendlebraught()
    {
        for(int x = 0; x< iterations; x++)
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
