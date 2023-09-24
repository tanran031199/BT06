package BT.BT06;

import java.util.Scanner;

public class BaiTap06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees;

        Employee nv1 = new Employee(1, "A", 20, 1, true);
        Employee nv2 = new Employee(2, "B", 25, 2, true);
        Employee nv3 = new Employee(3, "C", 22, 3, false);
        Employee nv4 = new Employee(4, "D", 30, 4, true);
        Employee nv5 = new Employee(5, "E", 37, 5, false);

        employees = new Employee[] {nv1, nv2, nv3, nv4, nv5};

        System.out.println("Danh sách nv trước khi sửa đổi: ");
        for (Employee e: employees) {
            e.displayData();
        }


        System.out.println("Sửa đổi thông tin NV " + nv2.getId());
        nv2.inputData(sc);

        System.out.println("Danh sách nv sau khi sửa đổi: ");
        for (Employee e: employees) {
            e.displayData();
        }
    }
}
