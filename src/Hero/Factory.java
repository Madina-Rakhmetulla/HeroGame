package Hero;
import Strategy.*;
import Weapon.*;
public class Factory {
    public static Hero create(String type, String name) {
        return switch (type.toLowerCase()) {
            case "warrior" -> new Hero(name, 120, 25, 10, new Sword(), new Melee());
            case "archer" -> new Hero(name, 100, 20, 8, new Bow(), new Ranged());
            case "mage" -> new Hero(name, 90, 18, 6, new Staff(), new Magic());
            default -> throw new IllegalArgumentException("Неизвестный тип героя: " + type);
        };
    }
}