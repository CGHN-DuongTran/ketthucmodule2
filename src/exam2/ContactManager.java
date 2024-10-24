package exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Đã thêm danh bạ.");
    }

    public void updateContact() {
        System.out.print("Nhập tên danh bạ cần sửa: ");
        String name = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.print("Nhập tên mới: ");
                contact.setName(scanner.nextLine());
                System.out.print("Nhập số điện thoại mới: ");
                contact.setPhoneNumber(scanner.nextLine());
                System.out.println("Đã cập nhật danh bạ.");
                return;
            }
        }
        System.out.println("Không tìm thấy danh bạ.");
    }

    public void deleteContact() {
        System.out.print("Nhập tên danh bạ cần xóa: ");
        String name = scanner.nextLine();
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
        System.out.println("Đã xóa danh bạ.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Không có danh bạ nào.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void start() {
        while (true) {
            System.out.println("\nQuản lý danh bạ");
            System.out.println("1. Thêm danh bạ");
            System.out.println("2. Sửa danh bạ");
            System.out.println("3. Xóa danh bạ");
            System.out.println("4. Hiển thị danh bạ");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa dòng mới

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    displayContacts();
                    break;
                case 5:
                    System.out.println("Đang thoát...");
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
