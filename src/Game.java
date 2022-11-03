
import java.util.ArrayList;
import java.util.Random;

public class Game {

    private final ArrayList<Warrior> warriors;
    private final ArrayList<Tree> trees;
    private final ArrayList<Monstor> monsters;
    private final GameMap gameMap;
    private final Random r;
    private final MountDoom mountDoom;

    Game() {
        this.warriors = new ArrayList<>();
        this.trees = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.gameMap = new GameMap(10);
        this.r = new Random();
        this.mountDoom = new MountDoom();
    }


    public void setMonsterTreeCoordinates(Object object){
        int x ;
        int y ;

        boolean slotEmpty = true;
        while (slotEmpty) {
            x = r.nextInt(10);
            y = r.nextInt(10);
            Object[][] grid = gameMap.getGrid();
            if (grid[x][y] == null) {
                grid[x][y]=object;
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

            Object[][] grid = gameMap.getGrid();
            if (grid[x][y] == null){

                grid[x][y]=warrior;
                warrior.setX(x);
                warrior.setY(y);

                slotEmpty = false;
            }
        }
    }




    public void setGame() {
        gameMap.getGrid()[5][5] = mountDoom; //set coordinates to mountDoom

        for (int i = 0; i < 4; i++) {
            Monstor monstor = new Monstor();
            monsters.add(i, monstor);
            setMonsterTreeCoordinates(monstor);
        }//create 4 Monsters & set locations

        for (int i = 0; i < 4; i++) {
            Tree tree = new Tree();
            trees.add(i, tree);
            setMonsterTreeCoordinates(tree);
        }//create 4 Trees & set locations

        for (int i = 0; i < 4; i++) {
            Warrior warrior = new Warrior();
            warriors.add(i, warrior);
            setWarriorsCoordinates(warrior);
            warrior.setMountDoom(mountDoom);
            mountDoom.subscribe(warrior);
            warrior.setWarriorNum(i+1);
            warrior.setMap(gameMap);
        }//create 4 Warriors & set locations
    }

    public void startGame(){
        warriors.get(0).start();
        warriors.get(1).start();
        warriors.get(2).start();
        warriors.get(3).start();

    }
}



