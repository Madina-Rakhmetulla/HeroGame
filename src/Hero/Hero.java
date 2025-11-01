package Hero;
import Weapon.Weapon;
import Strategy.Attack;
import observer.Observer;
public class Hero {
    private final String name;
    private int health;
    private final int power;
    private final int defense;
    private final Weapon weapon;
    private Attack Strategy;
    private int position;
    private Observer observer;
    public Hero(String name, int health, int power, int defense, Weapon weapon, Attack attack) {
        this.name =name;
        this.health =health;
        this.power =power;
        this.defense =defense;
        this.weapon =weapon;
        this.Strategy =attack;
        this.position =0;
    }
    public void setObserver(Observer observer) {
        this.observer = observer;
    }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getPower() { return power; }
    public int getDefense() { return defense; }
    public Weapon getWeapon() { return weapon; }
    public Attack getAttackStrategy() { return Strategy; }
    public int getPosition() { return position; }
    public void setPosition(int pos) { this.position = pos; }
    public void move(String direction) {
        if (direction.equals("влево") && position > 0) position--;
        else if (direction.equals("вправо") && position < 10) position++;
        System.out.println(name + " переместился на позицию " + position);
    }
    public boolean isAlive() {
        return health > 0;
    }
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }
    public void changeAttack(Attack newAttack) {
        this.Strategy = newAttack;
        System.out.println(name + " теперь стратегия: " + newAttack.name());
    }
    public int attack(Hero target) {
        int damage = Strategy.calculate(this, target);
        target.takeDamage(damage);
        String msg = name + " атакует " + target.getName() + " (" + Strategy.name() + ") — урон " + damage;
        if (observer != null) observer.update(msg);
        else System.out.println(msg);
        if (!target.isAlive()) {
            if (observer != null) observer.update(target.getName() + " пал в бою!");
            else System.out.println(target.getName() + " пал в бою!");
        }
        return damage;
    }
}