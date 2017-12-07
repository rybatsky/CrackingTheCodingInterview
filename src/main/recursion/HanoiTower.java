package recursion;

import java.util.Stack;

public class HanoiTower {
    private Stack<Integer> disks;
    private int index;

    public HanoiTower(int i) {
        disks = new Stack<>();
        index = i;
    }

    public Stack<Integer> getDisks() {
        return disks;
    }

    public void add(int disk) {
        if (!disks.isEmpty() && disks.peek() <= disk) {
            System.out.println("Can't move disk " + disk);
        } else {
            disks.push(disk);
        }
    }

    public void moveTopDisk(HanoiTower t) {
        int top = disks.pop();
        t.add(top);
    }

    public void moveDisks(int n, HanoiTower destination, HanoiTower buffer){
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopDisk(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
}
