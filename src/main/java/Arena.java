import java.util.Observable;

public class Arena extends Observable {

    private String name;
    private String city;
    private String state;
    private Integer capacity;


    public Arena(String name, String city, String state, Integer capacity) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.capacity = capacity;
    }

    public void getArena() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Arena{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}