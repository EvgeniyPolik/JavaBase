/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
Добавить функции:
1) Добавление номера
2) Вывод всего
 */

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class task_1 {

    public static HashMap<String, ArrayList<String>> PhoneBook;
    public static Scanner console;

    private static void AddNewContact() {
        System.out.println("Введите фамилию:");
        String last_name = console.next();
        System.out.println("Введите номер телефона:");
        String phone = console.next();
        if (PhoneBook.containsKey(last_name))
            PhoneBook.get(last_name).add(phone);
        else 
            PhoneBook.put(last_name, new ArrayList<String>(Arrays.asList(phone)));
    }

    private static void PrintPhoneBook() {
        for (String key : PhoneBook.keySet()) {
            String phones = "";
            String ws = "";
            for (int i = 0; i < PhoneBook.get(key).size(); i++) {
                phones += ws + PhoneBook.get(key).get(i);
                ws = ", ";
            }
            System.out.printf("%s: %s\n", key, phones);
        }
    }

    private static void UserDialog() {
        
        while (true) {
            System.out.println("Введите номер команды:\n1) Создать контакт или добавить номер.\n2) Вывести справочник.\nexit для выхода");
            String command = console.next();
            if (command.equals("exit"))
                break;
            else if (command.equals("1"))
                AddNewContact();
            else if (command.equals("2"))
                PrintPhoneBook();
            else 
            System.out.println("Неверная команда попробуйте еще");
        }
    }

    public static void main(String[] args) {
        PhoneBook = new HashMap<>();
        console = new Scanner(System.in);
        UserDialog();
    }
}