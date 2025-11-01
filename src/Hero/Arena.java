package Hero;
import java.util.Scanner;
import Strategy.*;
public class Arena {
    private static Hero first;
    private static Hero second;
    private static void Map() {
        char[] map = "...........".toCharArray();
        int p1 =first.getPosition();
        int p2 =second.getPosition();
        if (p1 == p2) map[p1] = 'X';
        else {
            map[p1] = '1';
            map[p2] = '2';
        }
        System.out.println("[" + new String(map) + "]");
    }
    private static boolean playerTurn(Hero current, Hero opponent, Scanner scanner) {
        System.out.println("\n Ход " + current.getName());
        System.out.println("1 — атаковать");
        System.out.println("2 — сменить стратегию");
        System.out.println("3 — передвинуться");
        System.out.print("> ");
        int choice =scanner.nextInt();
        if (choice == 1) {
            double distance =Math.abs(current.getPosition() - opponent.getPosition());
            String attackName =current.getAttackStrategy().name();
            if (distance > 1 && attackName.equals("ближний бой")) {
                System.out.println("Слишком далеко для ближнего боя!");
            } else {
                int baseDamage =current.attack(opponent);
                if (distance <=1 && attackName.equals("ближний бой")) {
                    int bonus =(int) (baseDamage * 0.2);
                    opponent.takeDamage(bonus);
                    System.out.println("Ближний удар! +20% урона (" + bonus + ")");
                }
            }
        } else if (choice == 2) {
            System.out.println("1 — ближний бой");
            System.out.println("2 — дальний бой");
            System.out.println("3 — магия");
            int s =scanner.nextInt();
            if (s == 1) current.changeAttack(new Melee());
            else if (s == 2) current.changeAttack(new Ranged());
            else if (s == 3) current.changeAttack(new Magic());
        } else if (choice == 3) {
            System.out.print("Направление (влево / вправо): ");
            String dir = scanner.next();
            current.move(dir);
        }
        Map();
        if (!opponent.isAlive()) {
            System.out.println(opponent.getName() + " пал в бою!");
            return true;
        }
        return false;
    }
    public static void start(Hero hero1, Hero hero2) {
        Scanner scanner =new Scanner(System.in);
        first =hero1;
        second =hero2;
        hero1.setPosition(2);
        hero2.setPosition(8);
        System.out.println("Бой начинается между " + hero1.getName() + " и " + hero2.getName() + "!");
        Map();
        while (hero1.isAlive() && hero2.isAlive()) {
            if (playerTurn(hero1, hero2, scanner)) break;
            if (playerTurn(hero2, hero1, scanner)) break;
            System.out.println("\nЗдоровье:");
            System.out.println("1: " + hero1.getName() + " — " + hero1.getHealth() + " HP");
            System.out.println("2: " + hero2.getName() + " — " + hero2.getHealth() + " HP\n");
        }
        System.out.println("\nПобедитель: " + (hero1.isAlive() ? hero1.getName() : hero2.getName()) + "!");
    }
}