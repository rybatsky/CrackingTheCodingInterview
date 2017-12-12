package moderatedifficulty.task1612;

//16.12
public class XmlTagConverter {
    public static void encode(String v, StringBuilder sb) {
        v = v.replace("0", "\\0");
        sb.append(v);
        sb.append(" ");
    }

    public static void encodeEnd(StringBuilder sb) {
        sb.append("0");
        sb.append(" ");
    }

    public static void encode(Attribute attr, StringBuilder sb) {
        encode(attr.getTagCode(), sb);
        encode(attr.getValue(), sb);
    }

    public static void encode(Element root, StringBuilder sb) {
        encode(root.getNameCode(), sb);
        for (Attribute a : root.getAttributes()) {
            encode(a, sb);
        }
        encodeEnd(sb);
        if (root.getValue() != null && !root.getValue().equals("")) {
            encode(root.getValue(), sb);
        } else {
            for (Element e : root.getChildren()) {
                encode(e, sb);
            }
        }
        encodeEnd(sb);
    }

    public static String encodeToString(Element root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    public static void main(String args[]) {
        Element root = new Element("family");
        Attribute a1 = new Attribute("lastName", "mcdowell");
        Attribute a2 = new Attribute("state", "CA");
        root.insert(a1);
        root.insert(a2);

        Element child = new Element("person", "Some Message");
        Attribute a3 = new Attribute("firstName", "Gayle");
        child.insert(a3);

        root.insert(child);

        String s = encodeToString(root);
        System.out.println(s);
    }
}
