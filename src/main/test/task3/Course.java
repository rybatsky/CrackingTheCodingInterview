package test.task3;

public class Course implements Comparable{
    private int beginning;
    private int ending;

    public Course(int beginning, int ending) {
        this.beginning = beginning;
        this.ending = ending;
    }

    public int getBeginning() {
        return beginning;
    }

    public int getEnding() {
        return ending;
    }

    @Override
    public int compareTo(Object o) {
        Course c = (Course) o;
        if (this.getEnding() > c.getEnding()) {
            return 1;
        } else if (this.getEnding() < c.getEnding()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Course{" +
                "beginning=" + beginning +
                ", ending=" + ending +
                '}';
    }
}
