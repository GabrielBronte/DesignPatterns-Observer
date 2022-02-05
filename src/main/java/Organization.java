import java.util.Observable;
import java.util.Observer;

public class Organization implements Observer {

    private String name;
    private String lastUpdate;

    public Organization(String name){
        this.name = name;
    }

    public String getLastUpdate(){
        return this.lastUpdate;
    }

    public void addObserver(Arena arena){
        arena.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg1){
        this.lastUpdate = this.name + ", nova arena disponivel para contato: " + observable.toString();
    }

}

