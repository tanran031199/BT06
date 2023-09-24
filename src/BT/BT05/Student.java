package BT.BT05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
    private int id, age;
    private String name, address, tel;
    private boolean gender;

    public Student() {
    }

    public Student(int id, int age, String name, String address, String tel, boolean gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.tel = tel;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void inputData(Scanner sc) {
        System.out.println("Nhập tên HS: ");
        this.name = sc.nextLine();

        int inputAge;
        do {
            System.out.println("Nhập tuổi HS: ");
            inputAge = Integer.parseInt(sc.nextLine());
            try {
                if (inputAge >= 5 && inputAge <= 40) {
                    this.age = inputAge;
                } else {
                    System.out.println("\u001B[31mSố tuổi của học sinh không phù hợp để đi học! vui lòng nhập lại!");
                    System.out.print("\u001B[33m");
                }
            } catch (Exception e) {
                System.out.println("\u001B[31mĐịnh dạng không hợp lệ. Vui lòng nhập lại!");
                System.out.print("\u001B[33m");
            }
        } while (inputAge < 5 || inputAge > 40);

        int chooseGender;
        do {
            System.out.println("Nhập giới tính HS: \n1. Nam.\n2. Nữ.");
            chooseGender = Integer.parseInt(sc.nextLine());
            if (chooseGender == 1) {
                this.gender = true;
            } else if (chooseGender == 2) {
                this.gender = false;
            } else {
                System.out.println("\u001B[31mKhông có lựa chọn: " + chooseGender + ". Vui lòng chọn lại!");
                System.out.print("\u001B[33m");
            }
        } while (chooseGender != 1 && chooseGender != 2);

        System.out.println("Nhập địa chỉ HS: ");
        this.address = sc.nextLine();

        boolean isPhoneNumber = false;
        do {
            System.out.println("Nhập số điện thoại HS: ");
            String regexPhoneNumber = "(0|84)[35789]\\d{8}$";
            String inputNumber = sc.nextLine();
            isPhoneNumber = Pattern.matches(regexPhoneNumber, inputNumber);

            if (isPhoneNumber) {
                tel = "";
                for (int i = 0; i < inputNumber.length(); i++) {
                    if (i == 0 && inputNumber.charAt(0) == '0') {
                        tel += "84";
                    } else {
                        tel += inputNumber.charAt(i);
                    }
                }
            } else {
                System.out.println("\u001B[31mSố điện thoại không hợp lệ vui long nhập lại!");
                System.out.print("\u001B[33m");
            }
        } while (!isPhoneNumber);
    }

    public String displayData() {
        String displayTel = "+";

        for (int i = 0; i < tel.length(); i++) {
            if (i == 1 || i == 3 || i == 7) {
                displayTel += tel.charAt(i) + "-";
            } else {
                displayTel += tel.charAt(i);
            }
        }

        return "Thông tin HS " + id + ":\n" +
                "Họ và tên: " + name + ".\n" +
                "Tuổi: " + age + ".\n" +
                "Giới tính: " + (gender ? "Nam" : "Nữ") + ".\n" +
                "Địa chỉ: " + address + ".\n" +
                "Số điện thoại: " + displayTel + ".\n";
    }
}
