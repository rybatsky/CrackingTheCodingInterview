package stackandqueue;

import java.util.Stack;

//3.2 (50min)
public class MinFinder extends Stack<MinNode> {

    public void push(int item) {
        int curMin = Math.min(item, min());
        super.push(new MinNode(item, curMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }

    public static void main(String[] args) {
        MinFinder mf = new MinFinder();
        MinFinder mf2 = new MinFinder();
        mf.push(10);
        mf.push(2);
        mf.push(11);
        mf.push(1);
        mf2.push(10);
        mf2.push(2);
        mf2.push(11);
        mf2.push(1);
        System.out.println(mf.min());
        mf2.pop();
        System.out.println(mf2.min());
    }
}

class MinNode {
    public int item;
    public int min;

    public MinNode(int item, int min) {
        this.item = item;
        this.min = min;
    }
}
