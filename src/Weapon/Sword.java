package Weapon;

public class Sword implements Weapon{
    @Override
    public int bonus (){
        return 5;
    }
    public String name(){
        return "меч";
    }
}
