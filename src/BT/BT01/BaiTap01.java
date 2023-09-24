package BT.BT01;

import java.util.Scanner;

public class BaiTap01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle circle;

        System.out.println("Nhập bán kính hình tròn: ");
        double radius = sc.nextDouble();

        circle = new Circle(radius);
        circle.display();

        System.out.println("Nhập bán kính mới: ");
        double newRadius = sc.nextDouble();
        circle.setRadius(newRadius);
        circle.display();
    }
}
