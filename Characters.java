import java.util.List;
import java.util.Map;

public class Characters {
    private static int idds = 1;
    private int ids;
    private Map<KeyCharacterEnum, List<String>> characteristics;

    public Characters(Map<KeyCharacterEnum, List<String>> characteristics) {
        this.ids = idds++;
        this.characteristics = characteristics;
    }

    // Геттеры и сеттеры для полей
    public long getId() {
        return ids;
    }

    public void setId(int ids) {
        this.ids = ids;
    }

    public Map<KeyCharacterEnum, List<String>> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<KeyCharacterEnum, List<String>> characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "Characters: " +
                "id = " + ids + "\n" +
                "characteristics = " + characteristics;
    }
}
