
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private final Object[][] map = new Object[10][10];
    private final ArrayList<Warrior> warriors = new ArrayList<>();
    private final ArrayList<Tree> trees = new ArrayList<>();
    private final ArrayList<Monstor> monstors = new ArrayList<>();

    private final Random r=new Random();

    private final MountDoom mountDoom = new MountDoom();


    public void setMonsterTreeCoordinates(Object object){
        int x ;
        int y ;

        boolean slotEmpty = true;
        while (slotEmpty) {
            x = r.nextInt(10);
            y = r.nextInt(10);
            if (map[x][y] == null) {
                map[x][y]=object;
                slotEmpty = false;
            }
        }


    }

    public void setWarriorsCoordinates(Warrior warrior){
        int x;
        int y;
        boolean slotEmpty = true;
        while (slotEmpty){
            x = r.nextInt(10);
            if (x==0){
                y=r.nextInt(10);
            }else {y=0;}
            if (map[x][y] == null){

                map[x][y]=warrior;
                warrior.setX(x);
                warrior.setY(y);

                slotEmpty = false;
            }
        }



    }




    public void setGame() {

        map[5][5] = mountDoom; //set coordinates to mountDoom


        for (int i = 0; i < 4; i++) {
            monstors.add(i, new Monstor());
            setMonsterTreeCoordinates(monstors.get(i));
        }//create 4 Monsters & set locations
        for (int i = 0; i < 4; i++) {
            trees.add(i, new Tree());
            setMonsterTreeCoordinates(trees.get(i));
        }//create 4 Trees & set locations
        for (int i = 0; i < 4; i++) {
            warriors.add(i, new Warrior());
            setWarriorsCoordinates(warriors.get(i));
            warriors.get(i).setMountDoom(mountDoom);
            mountDoom.subscribe(warriors.get(i));
            warriors.get(i).setWarriorNum(i+1);
            warriors.get(i).setMap(map);
        }//create 4 Warriors & set locations







    }

    public void startGame(){
        warriors.get(0).start();
        warriors.get(1).start();
        warriors.get(2).start();
        warriors.get(3).start();



    }


}



