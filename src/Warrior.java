public class Warrior extends Thread {
    private Object[][] map=new Object[10][10];


    private int warriorNum;
    private int x;
    private int y;

    private boolean status =true;
    private MountDoom mountDoom;

    public void setWarriorNum(int warriorNum) {
        this.warriorNum = warriorNum;
    }

    public void setMountDoom(MountDoom mountDoom) {
        this.mountDoom = mountDoom;
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

    public void getNotified(){
        this.status=false;

    }

    public void update(MountDoom mountDoom){
        mountDoom.notifySubscribers();
    }



    @Override
    public void run() {

        System.out.println("Warrior "+warriorNum+" Start Location :"+x+" "+y);
        int m, n;
        //System.out.println("Warrior "+warriorNum+" Status : "+status);

        while (status) {
            boolean check = true;
            while (check) {

                //
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
                        System.out.println("Warrior "+ warriorNum + " moves to " + x + " " + y + " Slot");
                        check = false;

                    } else {
                        if (map[(m + x)][(n + y)].getClass() == MountDoom.class) {
                            update(mountDoom);
                            System.out.println("Warrior "+warriorNum+"  WON ");
                            System.out.println("Game Over !!");
                            this.x = m + x;
                            this.y = n + y;
                            check = false;



                        } else if (map[(m + x)][(n + y)].getClass() == Tree.class) {
                            System.out.println("Tree !!");
                            check = false;

                        } else if (map[(m + x)][(n + y)].getClass() == Warrior.class) {
                            if (m==0&&n==0){

                            }
                            else {
                               //System.out.println("Another Warrior !!");
                            }
                            check = false;
                        } else {
                            System.out.println("A Monster ! , Warrior "+ warriorNum+ "  ELIMINATED ");
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