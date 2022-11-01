import java.io.PrintStream;
import java.util.ArrayList;

public class Game {
    private Object[][] map = new Object[10][10];
    private ArrayList<Warrior> warriors = new ArrayList<>();
    private ArrayList<Tree> trees = new ArrayList<>();
    private ArrayList<Monstor> monstors = new ArrayList<>();

    private MountDoom mountDoom = new MountDoom();


    public void setMonsterTreeCoordinates(Object object){
        int x ,y;
        boolean slotEmpty = true;
        while (slotEmpty) {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (map[x][y] == null) {
                map[x][y]=object;
                slotEmpty = false;
            }
        }


    }

    public void setWarriorsCoordinates(Warrior warrior){
        int x,y;
        boolean slotEmpty = true;
        while (slotEmpty){
            x = (int) (Math.random() * 10);
            if (x==0){
                y=(int)(Math.random()*10);
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
        int x, y;
        boolean slotEmpty;
        map[5][5] = mountDoom; //set coordinates to mountDoom


        for (int i = 0; i < 4; i++) {
            monstors.add(i, new Monstor());
            setMonsterTreeCoordinates(monstors.get(i));
        }//create 4 Monsters & set locations
        for (int i = 0; i < 4; i++) {
            trees.add(i, new Tree());
            setMonsterTreeCoordinates(monstors.get(i));
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



