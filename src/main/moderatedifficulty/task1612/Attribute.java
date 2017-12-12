package moderatedifficulty.task1612;

public class Attribute {
    private String tag;
    private String value;

    public Attribute(String t, String v) {
        tag = t;
        value = v;
    }

    public String getTagCode() {
        switch (tag) {
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

    public String getValue() {
        return value;
    }
}
