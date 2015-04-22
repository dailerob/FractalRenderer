/**
 * Created by Roberto on 2/3/2015.
 */
public class MathOperations extends Thread {
    private Complex z;
    private int xcord;
    private int ycord;
    private boolean isDone;





    public MathOperations(Complex z,int xcord, int ycord)
    {
        this.xcord = xcord;
        this.ycord = ycord;
        this.z = z;
        isDone = false;
        start();
    }



    public void Mendlebraught(Complex f, int xcord, int ycord, int iterations)
    {
        z = new Complex(f.getReal(),f.getImaginary());
        this.xcord = xcord;
        this.ycord = ycord;
        for(int x = 0; x< iterations; x++)
            z = (Complex.addComplex(f,Complex.multiplyComplex(z,z)));

        if(Math.sqrt(z.getReal()*z.getReal()+z.getImaginary()*z.getImaginary())<2)
        {
            writeDrawMap(true);
        }
        else
            writeDrawMap(false);
    }

    public void JuliaSet(Complex f, int xcord, int ycord, int iterations)
    {
        z = new Complex(f.getReal(),f.getImaginary());
        this.xcord = xcord;
        this.ycord = ycord;
        for(int x = 0; x< iterations; x++)
            z = (Complex.addComplex(new Complex(-0.835,-0.2321),Complex.multiplyComplex(z,z)));

        if(Math.sqrt(z.getReal()*z.getReal()+z.getImaginary()*z.getImaginary())<2)
        {
            writeDrawMap(true);
        }
        else
            writeDrawMap(false);
    }



    public synchronized void writeDrawMap(boolean draw)
    {
        Renderer.drawMap[xcord][ycord] = draw;
        isDone=true;
    }


    public boolean done ()
    {
        return isDone;
    }



    @Override
    public void run() {

        JuliaSet(new Complex(0, 0), xcord, ycord, 100);
    }
}
