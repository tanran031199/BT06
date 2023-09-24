package BT.BT02;

import java.util.Scanner;

public class BaiTap02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuadraticEquation quadraticEquation;

        System.out.println("Nhập a: ");
        double a = sc.nextDouble();
        System.out.println("Nhập b: ");
        double b = sc.nextDouble();
        System.out.println("Nhập c: ");
        double c = sc.nextDouble();

        quadraticEquation = new QuadraticEquation(a, b, c);
        quadraticEquation.display();
    }
}
