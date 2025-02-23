package bai3_1;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    // Constructors
    public MyComplex() {}

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Getters and Setters
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Convert to String
    @Override
    public String toString() {
        return real + "+" + imag + "i";
    }

    // Check if the complex number is real or imaginary
    public boolean isReal() {
        return imag == 0;
    }

    public boolean isImaginary() {
        return real == 0;
    }

    // Equality checks
    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag;
    }

    public boolean equals(MyComplex another) {
        return this.real == another.real && this.imag == another.imag;
    }

    // Calculate magnitude
    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    // Add operations
    public MyComplex addInto(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.real, this.imag + right.imag);
    }
}
