import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Methoods {
    private List<Product> products;

    public Methoods(List<Product> products) {
        this.products = products;
    }


    //METHOD
    public void saveProduct(Product productToSave) {
        boolean x = false;
        for (Product p : products) {
            if (!(p.equals(productToSave))) {
                x = true;
                setProducts(Collections.singletonList(productToSave));
                System.out.println("Продукт успешно добавлен");
                break;
            }
        }
        if (!x) {
            System.out.println("Данный продукт не найден");
        }
    }

    public void updateProduct(int iDproduct, String productName) {
        boolean x = false;
        for (Product p:products) {
            if (p.getId() == iDproduct) {
                x = true;
                p.setName(productName);
                System.out.println("Успешно обновлено");
                break;
            }
        }
        if (!x){
            System.out.println("Данный продукт не найден");
        }
    }

    public void getByIdProduct(int productId) {
        boolean x = false;
        for (Product p:products) {
            if (p.getId() == productId) {
                x = true;
                System.out.println("Продукт найден: " + p.getName());
                break;
            }
        }
        if(!x){
            System.out.println("Продукт не найден");
        }
    }

    public void searchByProductName(String productName) {
        boolean x = false;
        for (Product p:products) {
            if (p.getName().equals(productName)) {
                x = true;
                System.out.println("Продукт успешно найден: " + p);
                break;
            }
        }
        if(!x){
            System.out.println("Продукт не найден");
        }
    }

    public void filterByCharacter(KeyCharacterEnum key, String value) {
        boolean x = false;
        for (Product p:products) {
            for (Map<KeyCharacterEnum, List< String> > c: p.getCharacterList()) {
                if (c.containsKey(key) && c.get(key).contains(value)) {
                    x = true;
                    System.out.println("Успешно отсортирован: " + p);
                    break;
                }
            }
        }
        if(!x){
            System.out.println("Данный тип не найден");
        }
    }

    public void sortByCharacter(KeyCharacterEnum key) {
        Comparator<Product> productComparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                List<Map<KeyCharacterEnum, List<String>>> products1 = o1.getCharacterList();
                List<Map<KeyCharacterEnum, List<String>>> products2 = o2.getCharacterList();

                if(products1.isEmpty() || products2.isEmpty()){
                    return 0;
                }

                String p1 = String.valueOf(products1.get(0).get(key));
                String p2 = String.valueOf(products2.get(0).get(key));
                return p1.compareTo(p2);
            }
        };

        for (Product p:products) {
            System.out.println(p);
        }
    }

    public void deleteByProduct(int productId) {
        boolean x = false;

        for (Product p:products) {
            if(p.getId() == productId){
                x = true;
                products.remove(p);
                System.out.println("Продукт успешно удален");
                break;
            }
        }
        if(!x){
            System.out.println("Данный продукт не найден");
        }
    }

    public void getAllProduct() {
        System.out.println(getProducts());
    }
    List<Product> productss;
    Map<KeyCharacterEnum, List<String>> characterMap;

    public Methoods(List<Product> products, Map<KeyCharacterEnum, List<String>> characterMap) {
        this.products = products;
        this.characterMap = characterMap;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;

    }

    public void deleteCharacterByKeyName(int characterId, KeyCharacterEnum key) {
        Characters characters = (Characters) characterMap.get(characterId);
        if (characters != null) {
            characters.getCharacteristics().remove(key);
            System.out.println(characterMap);
        }
    }

    public void deleteAllCharacters() {
        characterMap.clear();
        System.out.println(characterMap);
    }
}
