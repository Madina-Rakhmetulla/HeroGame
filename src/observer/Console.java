package observer;

public class Console implements Observer {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}