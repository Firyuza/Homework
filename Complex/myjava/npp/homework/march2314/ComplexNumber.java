package myjava.npp.homework.march2314;

import java.lang.Math;

public class ComplexNumber implements TrigonometricForm, ComplexActions, ComplexMath {

    private double real;
    private double imaginary;

    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }
    public boolean isEqual(ComplexNumber complex) {
        return (this.real == complex.getReal() && this.imaginary == complex.getImaginary());
    }
    @Override
    public String toString(){
        String temp;
        if(this.imaginary < 0) {
            return this.real + "" + this.imaginary + 'i';
        }
        else {
            return this.real + "+" + this.imaginary + 'i';
        }
    }
    public double getModule() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }
    public double getArg() {
        return Math.atan(this.imaginary / this.real);
    }
    public void conjugate() {
        this.imaginary *= -1;
    }
    public void add(ComplexNumber complex) {
        this.real += complex.getReal();
        this.imaginary += complex.getImaginary();
    }
    public void subtract(ComplexNumber complex) {
        this.real -= complex.getReal();
        this.imaginary -= complex.getImaginary();
    }
}
