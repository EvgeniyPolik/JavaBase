import java.util.ArrayList;
import java.util.Scanner;

public class inter_shop {

    public static Scanner console = new Scanner(System.in);

    public static class Shop {
        public static String name;
        public static ArrayList<Notebook> CatalogNoteBook = new ArrayList<Notebook>();

        @FunctionalInterface
        public interface FindOption {
            Boolean match(Notebook notebook, String value);
        }

        public static void Welcome() {  // Главное меню
            System.out.printf("Добро пожадовать в %s ", name);
            while (true) {
            System.out.println("Главное меню введите одну из следующих команд: ");
            System.out.println("1) Добавить новый Ноутбук;");
            System.out.println("2) Напечатать каталог;");
            System.out.println("3) Поиск;");
            System.out.println("4) Или любая команда для выхода.");
            String userInput = console.nextLine();
            if (userInput.equals("1"))
                AddNotebook();
            else if (userInput.equals("2"))
                PrintCatalog();
            else if (userInput.equals("3"))
                FindInCatalog();
            else
                break;
            }
        }
        
        public static void AddNotebook() {  // Добавление ноутбука
            System.out.println("Добавление нового ноутбука.");
            System.out.println("Введите Бренд:");
            String brand = console.nextLine();
            System.out.println("Введите Модель:");
            String model = console.nextLine();
            System.out.println("Введите объем оперативной памяти:");
            Integer ram = console.nextInt();
            System.out.println("Введите объем жесткого диска:");
            Integer hdd = console.nextInt();
            console.nextLine();
            System.out.println("Укажите ОС:");
            String os = console.nextLine();
            System.out.println("Укажите цвет:");
            String color = console.nextLine();
            System.out.println("Укажите серийный номер:");
            String serialNumber = console.nextLine();
            System.out.println("Укажите цену:");
            Double price = console.nextDouble();
    
            CatalogNoteBook.add(new Notebook(brand, model, ram, hdd, os, color, serialNumber, price));

            System.out.println("Ноутбук добавлен успешно!\n");
        }

        public static FindOption ChooseFindOption() {  // Определимся с критерием и делаем функцию для поиска
            FindOption findOption = null;
            while (findOption == null) {
            System.out.println("Выберете критерий поиска: \n");
            System.out.println("1) Бренд (Производитель);");
            System.out.println("2) Минимальный объем оперативной памяти;");
            System.out.println("3) Минимальный объем жесткого диска;");
            System.out.println("4) Тип операционной системы;");
            System.out.println("5) Максимальная цена;");
            System.out.println("6) Цвет;");
            String userChoose = console.nextLine();

            switch (userChoose) {  // выбираем нужную функцию для поиска
                case "1":
                    findOption = (notebook, value) -> notebook.getBrand().equals(value);
                    break;
                case "2":
                    findOption = (notebook, value) -> notebook.getRam() >= Integer.parseInt(value);
                    break;
                case "3":
                    findOption = (notebook, value) -> notebook.getHdd() >= Integer.parseInt(value);
                    break;
                case "4":
                    findOption = (notebook, value) -> notebook.getOs().equals(value);
                    break;
                case "5":
                    findOption = (notebook, value) -> notebook.getPrice() <= Double.parseDouble(value);
                    break;
                case "6":
                    findOption = (notebook, value) -> notebook.getColor().equals(value);
                    break;
                default:
                    System.out.println("Неверный ввод");                    
            } 
        }
            return findOption;
    }


        public static void FindInCatalog() {  // Запросим какое значение ищем и выводим на экран
            FindOption findFunction = ChooseFindOption();
            System.out.println("Введите искомое значение");
            String userInput = console.nextLine();
            for (Notebook notebook : CatalogNoteBook) {
                if (findFunction.match(notebook, userInput))
                    System.out.println(notebook);
            }
            System.out.println();
        }


        public static void PrintCatalog() {  // Напечатать весь каталог наутбуков
            for (var notebook : CatalogNoteBook) {
                System.out.println(notebook);
            }
            System.out.println();
        }

        public static void CreateTestCatalog() {  // Заполнить каталог для тестирования
            CatalogNoteBook.add(new Notebook("Kepeer", "first model", 32, 2500, "win 11", "black", "a23411", 34500.00));
            CatalogNoteBook.add(new Notebook("Depeer", "second model", 16, 1500, "freeOS", "black", "w22098", 33000.99));
            CatalogNoteBook.add(new Notebook("Depeer", "third model", 8, 1500, "Linux", "red", "z32255", 30100.00));
            CatalogNoteBook.add(new Notebook("Kepeer", "mega model", 64, 3000, "freeOS", "red", "d65276", 40500.00));
            CatalogNoteBook.add(new Notebook("Droida", "drw-16", 16, 1500, "win 11", "green", "ytsd582", 29999.99));
            CatalogNoteBook.add(new Notebook("Droida", "drw-32", 32, 1000, "Linux", "green", "grw9634", 32500.00));
            CatalogNoteBook.add(new Notebook("Droida", "drw-8", 8, 1500, "freeOS", "yellow", "srd2312", 19999.00));
        }
    }


    public static void main(String[] args) {       
        Shop.name = "Мой магазин";
        Shop.CreateTestCatalog();
        Shop.Welcome();  // Экран приветствия
    }
}
