package treeandgraph.task47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    public enum State { COMPLETE, PARTIAL, BLANK };

    private List<Project> children = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();
    private String name;
    private State state = State.BLANK;

    public Project(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State st) {
        state = st;
    }

    public List<Project> getChildren() {
        return children;
    }
}
