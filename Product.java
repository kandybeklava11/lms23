import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Product {
private static int idd=1;
    private int id;
    private CategoryEnum category;
    private String name;
    private Map<KeyCharacterEnum, List<String>> characterList;
    private double price;

    public Product(CategoryEnum category, String name, Map<KeyCharacterEnum, List<String>> characterList, double price) {
        this.id = idd++;
        this.category = category;
        this.name = name;
        this.characterList = characterList;
        this.price = price;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Product.idd = idd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<KeyCharacterEnum, List<String>>> getCharacterList() {
        return Collections.singletonList(characterList);
    }

    public void setCharacterList(Map<KeyCharacterEnum, List<String>> characterList) {
        this.characterList = characterList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "\nProduct: " +
                "id = " + id + "\n" +
                "category = " + category + "\n" +
                "name = " + name + "\n" +
                "characterList = " + characterList + "\n" +
                "price = " + price+"\n";
    }
}
