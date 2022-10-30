import java.io.PrintStream;
import java.util.ArrayList;

public class Game {
    private Object[][] map = new Object[10][10];
    private ArrayList<Warrior> warriors = new ArrayList<>();
    private ArrayList<Tree> trees = new ArrayList<>();
    private ArrayList<Monstor> monstors = new ArrayList<>();

    private MountDoom mountDoom = new MountDoom();
    private GameHelper gameHelper=new GameHelper();



    public void setGame() {
        int x, y;
        boolean slotEmpty;
        map[5][5] = mountDoom; //set coordinates to mountDoom


        for (int i = 0; i < 4; i++) {
            monstors.add(i, new Monstor());
        }//create 4 Monsters & add to monsters list
        for (int i = 0; i < 4; i++) {
            trees.add(i, new Tree());
        }//create 4 Trees & add to trees list
        for (int i = 0; i < 4; i++) {
            warriors.add(i, new Warrior());
        }//create 4 Warriors & add to warrior list


        for (Monstor m: monstors) {
            slotEmpty = true;
            while (slotEmpty) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                if (map[x][y] == null) {
                    map[x][y]=m;
                    slotEmpty = false;
                }
            }
        }//set locations to monsters & locate them in map
        for (Tree t : trees) {
            slotEmpty = true;
            while (slotEmpty) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                if (map[x][y] == null) {
                    map[x][y]=t;
                    slotEmpty = false;
                }
            }
        }//set locations to trees & locate them in map
        for (Warrior w : warriors){
            slotEmpty = true;
            while (slotEmpty){
                x = (int) (Math.random() * 10);
                if (x==0){
                    y=(int)(Math.random()*10);
                }else {y=0;}
                    if (map[x][y] == null){

                        map[x][y]=w;
                        w.setX(x);
                        w.setY(y);
                        System.out.println(x+" "+y);
                        slotEmpty = false;
                    }
            }

        } //set location to warriors & locate them in map


        warriors.get(0).setMap(map);
        warriors.get(1).setMap(map);
        warriors.get(2).setMap(map);
        warriors.get(3).setMap(map);
        warriors.get(0).setWarriors(warriors);




    }

    public void startGame(){
        warriors.get(0).start();
        warriors.get(1).start();








    }


}



