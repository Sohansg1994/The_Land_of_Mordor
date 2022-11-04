
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private final Object[][] map;
    private final ArrayList<Warrior> warriors ;
    private final Random r;
    private final MountDoom mountDoom ;
    public Game() {
        this.map = new Object[10][10];
        this.warriors = new ArrayList<>();
        this.r=new Random();
        this.mountDoom = new MountDoom();
    }

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
            Monstor monstor=new Monstor();
            setMonsterTreeCoordinates(monstor);
        }//create 4 Monsters & set locations
        for (int i = 0; i < 4; i++) {
            Tree tree =new Tree();
            setMonsterTreeCoordinates(tree);
        }//create 4 Trees & set locations
        for (int i = 0; i < 4; i++) {
            Warrior warrior=new Warrior(map,i+1,mountDoom);
            warriors.add(i, warrior);
            setWarriorsCoordinates(warrior);
            mountDoom.subscribe(warrior);


        }//create 4 Warriors & set locations

        SuperWarrior superWarrior=new SuperWarrior(map,warriors.size()+1,mountDoom);
        warriors.add(superWarrior);
        setWarriorsCoordinates(superWarrior);
        mountDoom.subscribe(superWarrior);    //Create SuperWarrior & Set locations

    }

    public void startGame(){
        warriors.get(0).start();
        warriors.get(1).start();
        warriors.get(2).start();
        warriors.get(3).start();
        warriors.get(4).start();




    }


}



