package BT.BT05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BaiTap05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students;
        Student st1 = new Student(1, 15, "Nguyễn Văn A", "Hà Nội", "84988888888", true);
        Student st2 = new Student(2, 18, "Nguyễn Văn B", "Hà Nam", "84988888888", true);
        Student st3 = new Student(3, 16, "Nguyễn Thị C", "Hà Tây", "84988888888", false);

        students = new Student[]{st1, st2, st3};

        int choice;
        do {
            System.out.println("Menu quản lý HS:");
            System.out.println("Chọn các lựa chọn sau để thực thi chương trình:");
            System.out.println("1. Xem danh sách HS.");
            System.out.println("2. Thêm HS.");
            System.out.println("3. Sửa thông tin HS.");
            System.out.println("4. Xóa HS.");
            System.out.println("0. Thoát chương trình.");


            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("\n\u001B[36m----------------------------Danh sách HS----------------------------\n");

                    for (Student st : students) {
                        System.out.println(st.displayData());

                        if (st != students[students.length - 1]) {
                            System.out.println("*************************************************\n");
                        }
                    }

                    System.out.println("\n--------------------------------------------------------------------\n");
                    System.out.println("\u001B[0m");
                    break;
                case 2:
                    int addStudentMenu;
                    do {
                        System.out.println("\n\u001B[33m1. Thêm mới HS.\n" +
                                "2. Danh sách HS.\n" +
                                "0. Quay về Menu Chính.");
                        addStudentMenu = Integer.parseInt(sc.nextLine());

                        switch (addStudentMenu) {
                            case 1:
                                System.out.println("\n----------------------------Thêm mới HS----------------------------\n");

                                students = addNewStudent(students);

                                System.out.println("\n--------------------------------------------------------------------");
                                break;
                            case 2:
                                System.out.println("\n\u001B[36m----------------------------Danh sách HS----------------------------\n");

                                for (Student st : students) {
                                    System.out.println(st.displayData());

                                    if (st != students[students.length - 1]) {
                                        System.out.println("*************************************************\n");
                                    }
                                }

                                System.out.println("--------------------------------------------------------------------");
                                System.out.print("\u001B[33m");
                                break;
                            case 0:
                                System.out.println("Bạn đã quay về Menu chính");
                                System.out.println("\u001B[0m");
                                break;
                            default:
                                System.out.println("\u001B[31mKhông có lựa chọn " + addStudentMenu + ". Vui lòng chọn lại!");
                                System.out.print("\u001B[33m");
                                break;
                        }
                    } while (addStudentMenu != 0);
                    break;
                case 3:
                    int changeInfo;
                    boolean exit = false;

                    do {
                        System.out.println("\n\u001B[33m1. Sửa thông tin HS.\n" +
                                "2. Danh sách HS.\n" +
                                "0. Quay về Menu Chính.");
                        try {
                            changeInfo = Integer.parseInt(sc.nextLine());

                            switch (changeInfo) {
                                case 1:
                                    System.out.println("\n----------------------------Sửa thông tin HS----------------------------\n");
                                    boolean found = false;

                                    do {
                                        System.out.println("Nhập id của HS muốn sửa đổi:");
                                        int id = Integer.parseInt(sc.nextLine());

                                        for (Student st : students) {
                                            if (st.getId() == id) {
                                                found = true;
                                                st.inputData(sc);
                                                break;
                                            }
                                        }

                                        if (!found) {
                                            System.out.println("\u001B[31mId nhập vào không tồn tại vui lòng nhập lại!\n");
                                            System.out.print("\u001B[33m");
                                        }
                                    } while (!found);

                                    System.out.println("\n--------------------------------------------------------------------");
                                    break;
                                case 2:
                                    System.out.println("\n\u001B[36m----------------------------Danh sách HS----------------------------\n");

                                    for (Student st : students) {
                                        System.out.println(st.displayData());

                                        if (st != students[students.length - 1]) {
                                            System.out.println("*************************************************\n");
                                        }
                                    }

                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.print("\u001B[33m");
                                    break;
                                case 0:
                                    System.out.println("Bạn đã quay về Menu chính");
                                    System.out.println("\u001B[0m");
                                    exit = true;
                                    break;
                                default:
                                    System.out.println("\u001B[31mKhông có lựa chọn " + changeInfo + ". Vui lòng chọn lại!");
                                    System.out.print("\u001B[33m");
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("\u001B[31mSai định dạng vui lòng nhập lại!");
                            System.out.print("\u001B[33m");
                        }
                    } while (!exit);

                    break;
                case 4:
                    int deleteStudentMenu;
                    do {
                        System.out.println("\n\u001B[33m1. Xóa HS.\n" +
                                "2. Danh sách HS.\n" +
                                "0. Quay về Menu Chính.");
                        deleteStudentMenu = Integer.parseInt(sc.nextLine());

                        switch (deleteStudentMenu) {
                            case 1:
                                System.out.println("\n----------------------------Xóa HS----------------------------\n");

                                boolean found = false;
                                int id;

                                do {
                                    System.out.println("Nhập id của HS muốn loại khỏi danh sách:");
                                    id = Integer.parseInt(sc.nextLine());

                                    for (Student st : students) {
                                        if (st.getId() == id) {
                                            found = true;
                                            break;
                                        }
                                    }

                                    if (!found) {
                                        System.out.println("\u001B[33mId học sinh nhập vào không tồn tại. Vui lòng nhập lại!");
                                        System.out.print("\u001B[33m");
                                    }

                                } while (!found);

                                if (found) {
                                    students = deleteStudent(students, id);
                                }
                                System.out.println("\n--------------------------------------------------------------------");
                                break;
                            case 2:
                                System.out.println("\n\u001B[36m----------------------------Danh sách HS----------------------------\n");

                                for (Student st : students) {
                                    System.out.println(st.displayData());

                                    if (st != students[students.length - 1]) {
                                        System.out.println("*************************************************\n");
                                    }
                                }

                                System.out.println("--------------------------------------------------------------------");
                                System.out.print("\u001B[33m");
                                break;
                            case 0:
                                System.out.println("Bạn đã quay về Menu chính");
                                System.out.println("\u001B[0m");
                                break;
                            default:
                                System.out.println("\u001B[31mKhông có lựa chọn " + deleteStudentMenu + ". Vui lòng chọn lại!");
                                System.out.print("\u001B[33m");
                                break;
                        }
                    } while (deleteStudentMenu != 0);
                    break;
                case 0:
                    System.out.println("Bạn đã rời khỏi chương trình!");
                    break;
                default:
                    System.out.println("\u001B[31mKhông có lựa chọn " + choice + ". Vui lòng chọn lại!\n");
                    System.out.print("\u001B[0m");
                    break;
            }
        } while (choice != 0);
    }

    public static Student[] addNewStudent(Student[] students) {
        Student[] newStudentList = new Student[students.length + 1];

        for (int i = 0; i < students.length; i++) {
            newStudentList[i] = students[i];
        }

        Scanner sc = new Scanner(System.in);

        int id, age = 0;
        String name, address, tel = "";
        boolean gender = true;

        System.out.println("Nhập tên HS: ");
        name = sc.nextLine();

        int inputAge;
        do {
            System.out.println("Nhập tuổi HS: ");
            inputAge = Integer.parseInt(sc.nextLine());
            try {
                if (inputAge >= 5 && inputAge <= 40) {
                    age = inputAge;
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
                gender = true;
            } else if (chooseGender == 2) {
                gender = false;
            } else {
                System.out.println("\u001B[31mKhông có lựa chọn: " + chooseGender + ". Vui lòng chọn lại!");
                System.out.print("\u001B[33m");
            }
        } while (chooseGender != 1 && chooseGender != 2);

        System.out.println("Nhập địa chỉ HS: ");
        address = sc.nextLine();

        boolean isPhoneNumber = false;
        do {
            System.out.println("Nhập số điện thoại HS: ");
            String regexPhoneNumber = "(0|84)[35789]\\d{8}$";
            String inputNumber = sc.nextLine();
            isPhoneNumber = Pattern.matches(regexPhoneNumber, inputNumber);

            if (isPhoneNumber) {
                for (int i = 0; i < inputNumber.length(); i++) {
                    if (i == 0 && inputNumber.charAt(0) == '0') {
                        tel += "84";
                    } else {
                        tel += inputNumber.charAt(i);
                    }
                }
            } else {
                System.out.println("\u001B[31mSố điện thoại không hợp lệ vui lòng nhập lại!");
                System.out.print("\u001B[33m");
            }
        } while (!isPhoneNumber);

        int lastStudentId = newStudentList[newStudentList.length - 2].getId();
        newStudentList[newStudentList.length - 1] = new Student(lastStudentId + 1, age, name, address, tel, gender);

        return newStudentList;
    }

    public static Student[] deleteStudent(Student[] students, int id) {
        Student[] newStudentList = new Student[students.length - 1];

        int newIndex = 0;

        for (Student student : students) {
            if (student.getId() != id) {
                newStudentList[newIndex] = student;
                newIndex++;
            }
        }

        System.out.println("HS " + id + " đã được xóa khỏi danh sách!");

        return newStudentList;
    }
}
