package recursion;

import java.util.Comparator;

public class Box {
    public int width;
    public int height;
    public int depth;

    public Box(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    public boolean smaller(Box b) {
        if (b == null) {
            return true;
        }
        return width < b.width && height < b.height && depth < b.depth;
    }

    public String toString() {
        return "Box(" + width + ", " + height + ", " + depth + ")";
    }

    static class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box x, Box y){
            return y.height - x.height;
        }
    }
}
