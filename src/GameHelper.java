import java.util.ArrayList;

public class GameHelper  {
    private Object[][] mapUpdate=new Object[10][10];
    private ArrayList<Warrior> warriorsCopy = new ArrayList<>();

    public void setWarriorsCopy(ArrayList<Warrior> warriorsCopy) {
        this.warriorsCopy = warriorsCopy;
    }

    public Object[][] getMapUpdate() {
        return mapUpdate;
    }

    public void setMapUpdate(Object[][] mapUpdate) {
        this.mapUpdate = mapUpdate;
    }
    public void movementCheck(){
        int x=warriorsCopy.get(0).getX();
        int y=warriorsCopy.get(0).getY();

        int m, n;
        boolean check = true;
        while (check) {
            m = (int) (Math.random() * (2 + 2) - 2);
            if (m==0){
                n = (int) (Math.random() * (2 + 2) - 2);
            }else {n=0;}

            System.out.println((m)+" "+(n));
            if (((m + x) <= 10 && (m + x) >= 0) && ((n + y) <= 10 && (n + y) >= 0)) {
                x = m + x;
                y = n + y;
                check=false;

            } else {
                continue;
            }
        }

    }
}

