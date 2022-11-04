
import java.util.Random;

public class Warrior extends Thread {

    protected   Object[][] map;
    protected final int warriorNum;
    protected int x;
    protected int y;
    protected boolean status ;
    protected boolean check  ;
    private final MountDoom mountDoom;
    protected final Random r;

    public Warrior(Object[][] map, int warriorNum,   MountDoom mountDoom) {
        this.map = map;
        this.warriorNum = warriorNum;
        this.status = true;
        this.check = true;
        this.mountDoom = mountDoom;
        this.r=new Random();
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void getNotified(){
        this.status=false;
    }
    public void update(MountDoom mountDoom){
        mountDoom.notifySubscribers();
    }
    public void warriorMove(int m,int n){
        this.x = m + x;
        this.y = n + y;
        map[x][y] = map[x-m][y-n];
        map[x-m][y-n]=null;
        System.out.println("Warrior "+ warriorNum + " moves to " + x + " " + y + " Slot");
        this.check = false;

    }
    public void mountDoomFound(int m,int n){
        update(mountDoom);
        System.out.println("Warrior "+warriorNum+"  WON ");
        System.out.println("Game Over !!");

        this.x = m + x;
        this.y = n + y;
        this.check = false;


    }

    public void treeFound(){
        System.out.println("Warrior "+warriorNum+" found"+"Tree !!");
        this.check = false;
    }
    public void warriorFound(){
        System.out.println("Warrior "+warriorNum+" Another Warrior !!");
        this.check = false;

    }

    public void monsterFound(){
        System.out.println("A Monster ! , Warrior "+ warriorNum+ "  ELIMINATED ");
        this.check = false;
        this.status=false;
    }

    @SuppressWarnings("SynchronizeOnNonFinalField")
    @Override
    public void run() {

        System.out.println("Warrior "+warriorNum+" Start Location :"+x+" "+y);
        int m;
        int n;


        while (status) {
            this.check=true;
            while (check) {
                m = r.nextInt(-1,2);
                if (m == 0) {
                    n = r.nextInt(-1,2);
                } else {
                    n = 0;
                }
                if (m==0&&n==0){continue;}

                if (((m + x) < 10 && (m + x) >= 0) && ((n + y) < 10 && (n + y) >= 0)) {

                    synchronized (map) {
                       if (!status){
                           break;
                       }

                        if (map[(m + x)][(n + y)] == null) {
                            warriorMove(m, n);
                        } else {
                            if (map[(m + x)][(n + y)].getClass() == MountDoom.class) {
                                mountDoomFound(m, n);
                            } else if (map[(m + x)][(n + y)].getClass() == Tree.class) {
                                treeFound();
                            } else if (map[(m + x)][(n + y)].getClass() == Warrior.class) {
                                warriorFound();
                            } else {
                                monsterFound();
                            }
                        }

                    }
                }
            }

        }
    }
}