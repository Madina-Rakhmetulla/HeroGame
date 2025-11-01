package Weapon;

public class Bow implements Weapon{
    @Override
    public int bonus (){
        return 3;
    }
    public String name(){
        return "лук";
    }
}
