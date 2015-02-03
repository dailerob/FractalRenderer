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

    public static Complex multiplyComplex(Complex a, Complex b)
    {
        double r;
        double i;
        r = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        i = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        return new Complex(r,i);
    }

    public static Complex devideComplex(Complex a, Complex b)
    {
        Complex Denominator = multiplyComplex(a,conjugateComplex(b));
        return new Complex(Denominator.getReal(),Denominator.getImaginary());
    }

    public static Complex conjugateComplex (Complex a)
    {
        return(new Complex(a.getReal(),-1*a.getImaginary()));
    }

    public static Complex sinComplex(Complex a)
    {
        return new Complex(Math.sin(a.getReal()) * Math.cosh(a.getImaginary()), Math.cos(a.getReal()) * Math.sinh(a.getImaginary()));
    }

    public static Complex cosComplex(Complex a)
    {
        return new Complex(Math.cos(a.getReal()) * Math.cosh(a.getImaginary()), -Math.sin(a.getReal()) * Math.sinh(a.getImaginary()));
    }

    public static Complex tanComplex(Complex a)
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
