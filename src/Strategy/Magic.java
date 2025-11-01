package Strategy;
import Hero.Hero
public class Magic implements Attack{
    @Override
    public int calculate (Hero attacker, Hero target){
        int power =attacker.getPower;
        int bonus =attacker.getWeapon().bonus();
        int defense =target.getDefense();
        int raw = power + bonus;
        int damage = (int) (raw * 1.1) - defense;
        return Math.max(0, damage);
    }
    @Override
    public String name(){
        return "магия";
    }

}
