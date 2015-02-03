/**
 * Created by Roberto on 2/2/2015.
 */
public class Complex {

    private double real;
    private double imaginary;


    public Complex(double real, double imaginary) {
        this.imaginary = imaginary;
        this.real = real;

    }

    public Complex(double imaginary) {
        this.imaginary = imaginary;
    }

    public static Complex addComplex(Complex a, Complex b)
    {
        double r;
        double i;
        r = a.getReal() + b.getReal();
        i = a.getImaginary() + b.getImaginary();
        return new Complex(r,i);

    }

    public static Complex subtractComplex(Complex a, Complex b)
    {
        double r;
        double i;
        r = a.getReal() + b.getReal();
        i = a.getImaginary() + b.getImaginary();
        return new Complex(r,i);
    }

    public Complex multiplyComplex(Complex a, Complex b)
    {
        double r;
        double i;
        r = a.getReal() + b.getReal();
        i = a.getImaginary() + b.getImaginary();
        return new Complex(r,i);
    }

    public Complex devideComplex(Complex a, Complex b)
    {
        double r;
        double i;
        r = a.getReal() + b.getReal();
        i = a.getImaginary() + b.getImaginary();
        return new Complex(r,i);
    }

    public Complex sinComplex(Complex a)
    {
        return new Complex(Math.sin(real) * Math.cosh(imaginary), Math.cos(real) * Math.sinh(imaginary));
    }

    public Complex cosComplex(Complex a)
    {
        return new Complex(Math.cos(real) * Math.cosh(imaginary), -Math.sin(real) * Math.sinh(imaginary));
    }

    public Complex tanComplex(Complex a)
    {
        return devideComplex(sinComplex(a),cosComplex(a));

    }



    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

}
