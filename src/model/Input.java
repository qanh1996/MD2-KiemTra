package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static model.Validate.*;

public class Input {
    public static Contact inputContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập thông tin liên hệ: ");
        String phoneNumber = inputPhoneNumber();
        System.out.println("Mời bạn nhập nhóm liên lạc: ");
        String group = scanner.nextLine();
        System.out.println("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày, tháng, năm sinh: ");
        LocalDate dateOfBirth = inputDate();
        System.out.println("Mời bạn nhập email: ");
        String email = inputEmail();
        return new Contact(phoneNumber,group,name,gender,address,dateOfBirth,email);

    }

    public static String inputPhoneNumber() {
        String phoneNumber;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter phoneNumber: ");
            phoneNumber=scanner.nextLine();
            if(!Validate.isValid(phoneNumber, PHONE_NUMBER_REGEX)) System.out.println("Số điện thoại không hợp lệ !");
        } while (!Validate.isValid(phoneNumber, PHONE_NUMBER_REGEX));
        return phoneNumber;
    }


    public static String inputEmail() {
        String email;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter email: ");
            email=scanner.nextLine();
            if(!Validate.isValid(email, EMAIL_REGEX)) System.out.println("Email không hợp lệ !");
        } while (!Validate.isValid(email,EMAIL_REGEX));
        return email;
    }

    private static LocalDate inputDate() {
        String dateString;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Hãy nhập ngày sinh vào đây ( dd/mm/yyyy): ");
            dateString = scanner.nextLine();
            if (!Validate.isValid(dateString, DATEOFBIRTH_REGEX))
                System.out.println("Ngày không hợp lệ !");
        } while (!Validate.isValid(dateString, DATEOFBIRTH_REGEX));
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString,dateTimeFormatter);
        return date;
    }
}
