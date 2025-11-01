package Strategy;
import Hero.Hero
public class Melee implements Attack{
    @Override
    public int calculate (Hero attacker, Hero target){
        int power =attacker.getPower;
        int bonus =attacker.getWeapon().bonus();
        int defense =target.getDefense();
        int damage = power + bonus - defense;
        return Math.max(0, damage);
    }
    @Override
    public String name(){
        return "ближний бой";
    }

}
