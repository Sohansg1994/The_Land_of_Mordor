import java.util.ArrayList;

public class Warrior extends Thread {

    private Object[][] map=new Object[10][10];
    private ArrayList<Warrior> warriors = new ArrayList<>();
    private int x;
    private int y;



    public void setWarriors(ArrayList<Warrior> warriors) {
        this.warriors = warriors;
    }

    public Object[][] getMap() {
        return map;
    }

    public void setMap(Object[][] map) {
        this.map = map;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void run() {
        System.out.println("Start Location w:"+x+" "+y);
        int m, n;
        boolean status =true;

        while (status) {
            boolean check = true;
            while (check) {

                m = (int) (Math.random() * (2 + 2) - 2);
                if (m == 0) {
                    n = (int) (Math.random() * (2 + 2) - 2);
                } else {
                    n = 0;
                }

                if (((m + x) < 10 && (m + x) >= 0) && ((n + y) < 10 && (n + y) >= 0)) {

                    if (map[(m + x)][(n + y)] == null) {
                        this.x = m + x;
                        this.y = n + y;
                        map[x][y] = map[x-m][y-n];
                        map[x-m][y-n]=null;
                        System.out.println("Warrior 1 moves to " + x + " " + y + " Slot");
                        check = false;

                    } else {
                        if (map[(m + x)][(n + y)].getClass() == MountDoom.class) {
                            System.out.println("YOU WON");
                            this.x = m + x;
                            this.y = n + y;
                            check = false;
                            status = false;

                        } else if (map[(m + x)][(n + y)].getClass() == Tree.class) {
                            System.out.println("Tree !!");
                            check = false;

                        } else if (map[(m + x)][(n + y)].getClass() == Warrior.class) {
                            if (m==0&&n==0){}
                            else {
                                System.out.println("Another Warrior !!");}
                            check = false;
                        } else {
                            System.out.println("A Monster ! , YOU ARE ELIMINATED ");
                            check = false;
                            status=false;

                        }
                    }


                } else {
                    continue;
                }
            }
        }
    }
}