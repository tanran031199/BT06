package BT.BT04;

public class BaiTap04 {
    public static void main (String[] args) {
        Fan f1 = new Fan(3, true, 10.0, "yellow");
        Fan f2 = new Fan(2, false, 5.0, "blue");

        System.out.println(f1);
        System.out.println(f2);
    }
}
