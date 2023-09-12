import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Map<KeyCharacterEnum, List<String>> characterMap1 = new HashMap<>();
        characterMap1.put(KeyCharacterEnum.CPU, List.of("Intel Core i7"));
        characterMap1.put(KeyCharacterEnum.RAM, List.of("16GB"));
        characterMap1.put(KeyCharacterEnum.STORAGE_CAPACITY, List.of("512GB"));
        characterMap1.put(KeyCharacterEnum.SCREEN_SIZE, List.of("15.6 inches"));

        Map<KeyCharacterEnum, List<String>> characterMap2 = new HashMap<>();
        characterMap2.put(KeyCharacterEnum.CPU, List.of("AMD Ryzen 9"));
        characterMap2.put(KeyCharacterEnum.RAM, List.of("32GB"));
        characterMap2.put(KeyCharacterEnum.STORAGE_CAPACITY, List.of("1TB"));
        characterMap2.put(KeyCharacterEnum.SCREEN_SIZE, List.of("13.3 inches"));

        Map<KeyCharacterEnum, List<String>> characterMap3 =  new HashMap<>();
        characterMap3.put(KeyCharacterEnum.CPU, List.of("Qualcomm Snapdragon 888"));
        characterMap3.put(KeyCharacterEnum.RAM, List.of("8GB"));
        characterMap3.put(KeyCharacterEnum.STORAGE_CAPACITY, List.of("128GB"));
        characterMap3.put(KeyCharacterEnum.CPU.SCREEN_SIZE, List.of("1.4 inches"));

        Map<KeyCharacterEnum, List<String>> characterMap4 =  new HashMap<>();
        characterMap3.put(KeyCharacterEnum.CPU, List.of("ipi Snapdragon 580"));
        characterMap3.put(KeyCharacterEnum.RAM, List.of("6GB"));
        characterMap3.put(KeyCharacterEnum.STORAGE_CAPACITY, List.of("64GB"));
        characterMap3.put(KeyCharacterEnum.CPU.SCREEN_SIZE, List.of("1.4 inches"));


        List<Product> products = new ArrayList<>();
        Product product1 = new Product(CategoryEnum.LAPTOP, "LaptopX", characterMap1, 1299.99);
        Product product2 = new Product(CategoryEnum.LAPTOP, "Laptop", characterMap2, 1399.99);
        Product product3 = new Product(CategoryEnum.PHONE, "Iphone13 pro max", characterMap3, 999.99);
        Product product4 = new Product(CategoryEnum.SMARTWATCH, "AppleWatch", characterMap4, 999.99);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        Scanner scan = new Scanner(System.in);

        System.out.println("1. Product");
        System.out.println("2. Characters");
        System.out.print("Write action: ");
        int x = scan.nextInt();

        switch (x){
            case 1:
                System.out.println();
                System.out.println("Selected action (Product)");
                run(products);
                break;
            case 2:
                System.out.println();
                System.out.println("Selected action (Characters)");
                run1(products, characterMap1);
                break;
        }
    }
    public static void run(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        Methoods methoods = new Methoods(products);
        while (true) {
            System.out.println();
            System.out.println("Select action:");
            System.out.println("1. Save product");
            System.out.println("2. Update product");
            System.out.println("3. Get product by ID");
            System.out.println("4. Search product by name");
            System.out.println("5. Filter product by character");
            System.out.println("6. Sort product by character");
            System.out.println("7. Delete product");
            System.out.println("8. Get all products");
            System.out.println("0.Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Select category (Laptop, Phone, SmartWatch) :");
                    String categoryS = scanner.nextLine().toUpperCase();
                    CategoryEnum category = CategoryEnum.valueOf(categoryS);
                    System.out.println();
                    System.out.print("Write the title: ");
                    String nameProduct = scanner.nextLine();

                    Map<KeyCharacterEnum, List<String>> characterNew = new HashMap<>();
                    characterNew.put(KeyCharacterEnum.CPU, List.of("Processor"));
                    characterNew.put(KeyCharacterEnum.RAM, List.of("Random access memory->(RAM)"));
                    characterNew.put(KeyCharacterEnum.STORAGE_CAPACITY, List.of("Main memory"));
                    characterNew.put(KeyCharacterEnum.SCREEN_SIZE, List.of("Screen"));
                    System.out.println();
                    System.out.print("Write price: ");
                    int priceProduct = scanner.nextInt();

                    Product product1 = new Product(category, nameProduct, characterNew, priceProduct);
                    methoods.saveProduct(product1);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Write product's ID to update:");
                    int idToUpdate = scanner.nextInt();
                    System.out.println("Write new product's name:");
                    String newName = scanner.next();
                    methoods.updateProduct(idToUpdate, newName);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Write product's ID to search:");
                    int idToFind = scanner.nextInt();

                    methoods.getByIdProduct(idToFind);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Write product's name to search:");
                    String nameToSearch = scanner.next();
                    methoods.searchByProductName(nameToSearch);
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Write character's kay (CPU, RAM, STORAGE_CAPACITY, SCREEN_SIZE): ");
                    KeyCharacterEnum filterKey = KeyCharacterEnum.valueOf(scanner.next().toUpperCase());
                    System.out.println("Write a value to filter:");
                    String filterValue = scanner.next();
                    methoods.filterByCharacter(filterKey, filterValue);
                    break;
                case 6:
                    System.out.println();
                    System.out.print("Write character's kay (CPU, RAM, STORAGE_CAPACITY, SCREEN_SIZE): ");
                    String sortK = scanner.nextLine().toUpperCase();

                    KeyCharacterEnum sortKey = KeyCharacterEnum.valueOf(sortK);
                    methoods.sortByCharacter(sortKey);
                    break;
                case 7:
                    System.out.println();
                    System.out.println("Write product's ID to delete:");
                    int idToDelete = scanner.nextInt();
                    methoods.deleteByProduct(idToDelete);
                    break;
                case 8:
                    System.out.println();
                    methoods.getAllProduct();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Exit the program.");
                    return;
                default:
                    System.out.println();
                    System.out.println("Wrong command.");
            }
        }
    }

    public static void run1 (List<Product> products, Map<KeyCharacterEnum, List<String>> characterMap3){
        Methoods methoods = new Methoods(products, characterMap3);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Delete character");
            System.out.println("2. Delete all");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Write ID: ");
                    int id = scanner.nextInt();
                    methoods.deleteCharacterByKeyName(id, KeyCharacterEnum.CPU);
                    break;
                case 2:

                    methoods.deleteAllCharacters();
                    break;
            }
        }
    }
}