package recursion;

import java.util.ArrayList;
import java.util.Collections;

//8.13 (60min)
public class StapelSizeCounter {

    public static int highestStapel(ArrayList<Box> boxes) {
        boxes.sort(new Box.BoxComparator());
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    public static int createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).smaller(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.getHeight();
        return maxHeight;
    }

    public static void main(String[] args) {
        ArrayList<Box> boxList = new ArrayList<>();
        boxList.add(new Box(2, 3, 4));
        boxList.add(new Box(3, 4, 5));
        boxList.add(new Box(8, 7, 2));
        boxList.add(new Box(8, 8, 8));
        boxList.add(new Box(2, 3, 9));
        boxList.add(new Box(1, 3, 8));
        boxList.add(new Box(7, 4, 2));

        System.out.println(highestStapel(boxList));
    }
}
