package observer;

public interface Subject {
    void add(Observer o);
    void remove(Observer o);
    void notify(String message);
}