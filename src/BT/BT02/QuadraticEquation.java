package BT.BT02;

import java.text.DecimalFormat;

public class QuadraticEquation {
    private double a, b, c;
    private String solution;
    private DecimalFormat df = new DecimalFormat("#.##");

    QuadraticEquation() {
    }
    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }
    public void setB(double b) {
        this.b = b;
    }
    public void setC(double C) {
        this.c = c;
    }

    public double getDiscriminant() {
        double delta = Math.pow(b, 2) - (4 * a * c);

        this.solution = (delta > 0) ? "phương trình có 2 nghiệm là: " :
                (delta == 0) ? "phương trình có nghiệm kép là: " :
                        "phương trình vô nghiệm!!!";

        return delta;
    }

    public double getRoot1() {
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return Double.NaN;
        } else {
            return (-b + Math.sqrt(discriminant)) / (2 * a);
        }
    }
    public double getRoot2() {
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return Double.NaN;
        } else {
            return (-b - Math.sqrt(discriminant)) / (2 * a);
        }
    }

    public void display() {
        double discriminant = getDiscriminant();
        String print = discriminant > 0 ? df.format(getRoot1()) + " và " + df.format(getRoot2()) :
                discriminant == 0 ? String.valueOf(df.format(getRoot1())) :
                        "";

        System.out.println("Nghiệm của phương trình " + a + "x + " + b + " + " + c + " là:");
        System.out.printf("%s%s", solution, print);
    }
}
