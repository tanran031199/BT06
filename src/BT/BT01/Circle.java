package BT.BT01;

public class Circle {
    private final float PI = 3.14f;
    double radius;

    Circle() {
    }

    Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double r) {
        this.radius = r;
    }

    public double perimeter() {
        return this.radius * this.PI * 2;
    }
    public double area() {
        return Math.pow(this.radius, 2) * this.PI;
    }

    public void display() {
        System.out.printf("Hình tròn của bạn: \n" +
                "Bán kính: %.2fcm.\n" +
                "Chu vi: %.2fcm.\n" +
                "Diện tích: %.2fcm2.\n\n",
                this.radius,
                this.perimeter(),
                this.area());
    }
}
