import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /**
         * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
         * Создать множество ноутбуков.
         * Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет
         * ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру,
         * соответствующую необходимому критерию:
         * 1 - ОЗУ
         *
         * 2 - Объем ЖД
         *
         * 3 - Операционная система
         *
         * 4 - Цвет …
         *
         * Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации
         * можно также в Map.
         * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
         */

        Laptop laptop1 = new Laptop("Lenovo", 8, 512, "Windows", "Gray");
        Laptop laptop2 = new Laptop("HP", 12, 256, "Windows", "Blue");
        Laptop laptop3 = new Laptop("Huawei", 16, 512, "Windows", "Gray");
        Laptop laptop4 = new Laptop("Apple MacBook", 12, 256, "MacOS", "Green");
        Laptop laptop5 = new Laptop("Dell", 8, 256, "Windows", "White");
        Laptop laptop6 = new Laptop("Samsung", 6, 128, "Windows", "Orange");

//        System.out.println(laptop1);

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        laptops.add(laptop6);
//        System.out.println(laptops);

        Map<String, Object> parameters = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите желаемые характеристики");
        System.out.println("Введите желаемые характеристики: 1. Объем оперативной памяти: ");
        System.out.println("Введите желаемые характеристики: 2. Объем жесткого диска: ");
        System.out.println("Введите желаемые характеристики: 3. Операционная система: ");
        System.out.println("Введите желаемые характеристики: 4. Цвет: ");

        int userParameter;
        while (true){
            userParameter = scanner.nextInt();
            if (userParameter == 0){
                break;
            }
            switch (userParameter){
                case 1:
                    System.out.println("Объем оперативной памяти");
                    parameters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Объем жесткого диска");
                    parameters.put("ssd", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Операционная  система");
                    parameters.put("operationSystem", scanner.next());
                    break;
                case 4:
                    System.out.println("Цвет");
                    parameters.put("color", scanner.next());
                    break;
                default:
                    System.out.println("По заданным параметрам ничего не нашлось, попробуйте снова");
            }

        }

        Set<Laptop> filteredLaptops = laptops.stream()
                .filter(laptop -> parameters.getOrDefault("ram", 0) instanceof Integer && laptop.getRam() >= (int) parameters.getOrDefault("ram", 0))
                .filter(laptop -> parameters.getOrDefault("ssd", 0) instanceof Integer && laptop.getSsd() >= (int) parameters.getOrDefault("ssd", 0))
                .filter(laptop -> parameters.getOrDefault("os", "").equals("") || laptop.getOperationSystem().equalsIgnoreCase((String) parameters.getOrDefault("os", "")))
                .filter(laptop -> parameters.getOrDefault("color", "").equals("") || laptop.getColor().equalsIgnoreCase((String) parameters.getOrDefault("color", "")))
                .collect(Collectors.toSet());

        System.out.println("По заданным параметрам подходят: ");
        for (Laptop laptop: filteredLaptops){
            System.out.println(laptop);
        }














    }






}