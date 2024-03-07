/**
 * Lab 2 Ingenieria de Software
 * Operaciones sobre numeros complejos
 * 
 * @autor Dereck Fernando Baldiviezo Cruz
 * @version 1.0
 * @date 2024-03-07
 **/
public class Main {
    public static void main(String[] args){
    Complex x = new Complex(2,3);
    Complex y = new Complex(-5,3);
    Complex z = new Complex(0,0);
    z = x.multiplication(y);
    System.out.println(z.toStr());
    Complex conjugateX = x.conjugate();
    System.out.println("Conjugado de x: " + conjugateX.toStr());
    double moduloX = x.module();
    System.out.println("Modulo de x: " + moduloX);
    double faseX = x.phase();
    System.out.println("Fase de x: " + faseX);
    Complex potenciaX = x.power(3);
    System.out.println("Potencia de x^3: " + potenciaX.toStr());
    Complex raizCuadradaX = x.sqrt();
    System.out.println("Raiz cuadrada de x: " + raizCuadradaX.toStr());
    Complex logX = x.logarithm();
    System.out.println("Logaritmo de x: " + logX.toStr());
    }
}
 class Complex {
    double real;
    double img;

    public Complex(double r, double i) {
        this.real = r;
        this.img = i;
    }

    public Complex adition(Complex y) {
        Complex z = new Complex(0,0);
        z.real = this.real + y.real;
        z.img = this.img + y.img;
        return (z);
    }

    public Complex substract(Complex y) {
        Complex z = new Complex(0,0);
        z.real = this.real - y.real;
        z.img = this.img - y.img;
        return (z);
    }

    public Complex multiplication(Complex y) {
        Complex z = new Complex(0,0);
        z.real = this.real * y.real - this.img * y.img;
        z.img = this.real * y.img + this.img * y.real;
        return (z);
        }

    public String toStr() {
        return (String.valueOf(this.real) +" + "+ String.valueOf(this.img+"i"));
}
    public Complex division(Complex y) {
        Complex z = new Complex(0, 0);
        double denominator = y.real * y.real + y.img * y.img;

        z.real = (this.real * y.real + this.img * y.img) / denominator;
        z.img = (this.img * y.real - this.real * y.img) / denominator;

        return z;
    }
    public Complex conjugate() {
        return new Complex(this.real, -this.img);
    }
    public double module() {
        return Math.sqrt(this.real * this.real + this.img * this.img);
    }
    public double phase() {
        return Math.atan2(this.img, this.real);
    }
    public Complex power(int exponente) {
        double r = Math.pow(this.module(), exponente);
        double theta = this.phase() * exponente;

        double realPart = r * Math.cos(theta);
        double imagPart = r * Math.sin(theta);

        return new Complex((int) realPart, (int) imagPart);
    }
    public Complex sqrt() {
        double magnitud = Math.sqrt(this.module());
        double argumento = this.phase() / 2.0;

        double realPart = magnitud * Math.cos(argumento);
        double imgPart = magnitud * Math.sin(argumento);

        return new Complex((int) realPart, (int) imgPart);
    }
    public Complex logarithm() {
        Complex z = new Complex(0,0);
        double r = this.module();
        double theta = Math.atan2(this.img, this.real);

        double realPart = Math.log(r);
        double imagPart = theta;
        z.real = realPart;
        z.img = imagPart;
        return (z);
    }

}