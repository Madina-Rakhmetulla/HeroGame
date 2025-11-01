package Strategy;
import Hero.Hero;
public class Ranged implements Attack{
    @Override
    public int calculate (Hero attacker, Hero target){
        int power =attacker.getPower();
        int bonus =attacker.getWeapon().bonus();
        int defense =target.getDefense();
        int damage = (int) ((power + bonus) * 1.1) - defense;
        return Math.max(0, damage);
    }
    @Override
    public String name(){
        return "дальний бой";
    }

}
