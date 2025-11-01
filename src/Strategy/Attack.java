package Strategy;
import Hero.Hero;
public interface Attack {
    int calculate(Hero attacker, Hero target);
    String name();
}
