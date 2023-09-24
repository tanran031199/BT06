package BT.BT06;

import java.util.Scanner;

public class Employee {
    private int id, age, rate = 1, salary = 1300;
    private String name;
    private boolean gender;

    Employee() {
    }

    public Employee(int id, String name, int age, int rate, boolean gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.rate = rate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void inputData(Scanner sc) {
        System.out.println("Nhập vào tên NV:");
        name = sc.nextLine();
        System.out.println("Nhập vào tuổi:");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào hệ số lương:");
        rate = Integer.parseInt(sc.nextLine());

        int chooseGender;
        do {
            System.out.println("Chọn giới tính:\n1. Nam.\n2. Nữ.");
            chooseGender = Integer.parseInt(sc.nextLine());
            if (chooseGender == 1) {
                gender = true;
            } else if(chooseGender == 2) {
                gender = false;
            } else {
                System.out.println("Không có lựa chọn " + chooseGender + ". Vui lòng chọn lại!");
            }
        } while (chooseGender != 1 && chooseGender != 2);
    }

    public void displayData() {
        System.out.println();
        System.out.println("Thông tin của NV " + id);
        System.out.println("Tên NV: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Giới tính: " + (gender ? "Nam" : "Nữ"));
        System.out.println("Hệ số lương: " + rate);
        System.out.println("Lương: " + salary * rate);
        System.out.println();
    }
}
