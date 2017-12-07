package recursion;

//8.6 (30min)
public class HanoiTowerSolver {
    public static void main(String[] args) {
        int n = 5;
        HanoiTower[] towers = new HanoiTower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new HanoiTower(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(n, towers[2], towers[1]);

        for (int i = 0; i < 3; i++) {
            System.out.println("HanoiTower " + i + ": " + towers[i].getDisks().toString());
        }
    }
}
