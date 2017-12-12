package moderatedifficulty.task1612;

import java.util.ArrayList;
import java.util.List;

public class Element {
    private List<Attribute> attributes;
    private List<Element> children;
    private String name;
    private String value;

    public Element(String n) {
        name = n;
        attributes = new ArrayList<>();
        children = new ArrayList<>();
    }

    public Element(String n, String v) {
        name = n;
        value = v;
        attributes = new ArrayList<>();
        children = new ArrayList<>();
    }

    public String getNameCode() {
        switch (name) {
            case "family":
                return "1";
            case "person":
                return "2";
            case "firstName":
                return "3";
            case "lastName":
                return "4";
            case "state":
                return "5";
        }
        return "-";
    }

    public void insert(Attribute attribute) {
        attributes.add(attribute);
    }

    public void insert(Element child) {
        children.add(child);
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getValue() {
        return value;
    }

    public List<Element> getChildren() {
        return children;
    }
}
