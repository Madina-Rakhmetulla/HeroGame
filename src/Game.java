import Hero.*;
import observer.Console;
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Игрок 1, введите имя героя: ");
        String name1 =scanner.nextLine();
        System.out.println("1 — Воин  2 — Лучник  3 — Маг");
        int type1 =scanner.nextInt();
        scanner.nextLine();
        String heroType1 = switch (type1) {
            case 1 -> "warrior";
            case 2 -> "archer";
            case 3 -> "mage";
            default -> "warrior";
        };
        System.out.print("Игрок 2, введите имя героя: ");
        String name2 =scanner.nextLine();
        System.out.println("1 — Воин  2 — Лучник  3 — Маг");
        int type2 =scanner.nextInt();
        scanner.nextLine();
        String heroType2 = switch (type2) {
            case 1 -> "warrior";
            case 2 -> "archer";
            case 3 -> "mage";
            default -> "warrior";
        };
        Hero hero1 =Factory.create(heroType1, name1);
        Hero hero2 =Factory.create(heroType2, name2);
        Console announcer = new Console();
        hero1.setObserver(announcer);
        hero2.setObserver(announcer);
        System.out.println("\n Всё готово! Начинается бой!\n");
        Arena.start(hero1, hero2);
    }
}