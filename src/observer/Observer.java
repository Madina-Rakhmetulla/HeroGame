package observer;

interface Observer {
    void update(String message);
}
interface Subject {
    void add(Observer o);
    void remove(Observer o);
    void notify(String message);
}