public class SuperWarrior extends Warrior {
    public SuperWarrior(Object[][] map, int warriorNum, MountDoom mountDoom) {
        super(map, warriorNum, mountDoom);
    }

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
