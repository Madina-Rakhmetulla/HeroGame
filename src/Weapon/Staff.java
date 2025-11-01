package Weapon;

public class Staff implements Weapon{
    @Override
    public int bonus (){
        return 7;
    }
    public String name(){
        return "посох";
    }
}
