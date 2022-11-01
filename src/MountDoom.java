import java.util.ArrayList;

public class MountDoom {
    private ArrayList<Warrior> warriors=new ArrayList<>();

    public void subscribe(Warrior w){
        warriors.add(w);
    }

    public void notifySubscribers(){
        for (Warrior w:warriors){
            w.getNotified();
        }

    }


    }








