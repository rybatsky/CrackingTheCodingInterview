package hard.task177;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//17.7 (180min)
public class NameJoiner {

    public static Map<String, NameSet> constructGroups(Map<String, Integer> names) {
        Map<String, NameSet> groups = new HashMap<>();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            NameSet group = new NameSet(name, frequency);
            groups.put(name, group);
        }
        return groups;
    }

    public static Map<String, Integer> mergeGroups(Map<String, NameSet> groups, String[][] synonyms) {
        for (String[] entry : synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            NameSet set1 = groups.get(name1);
            NameSet set2 = groups.get(name2);
            if (set1 != set2) {
                NameSet smaller = set2.size() < set1.size() ? set2 : set1;
                NameSet bigger = set2.size() < set1.size() ? set1 : set2;

                Set<String> otherNames = smaller.getNames();
                int frequency = smaller.getFrequency();
                bigger.copyNamesWithFrequency(otherNames, frequency);

                for (String name : otherNames) {
                    groups.put(name, bigger);
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (NameSet group : groups.values()) {
            map.put(group.getRootName(), group.getFrequency());
        }
        return map;
    }

    public static Map<String, Integer> mostPopular(Map<String, Integer> names, String[][] synonyms) {
        Map<String, NameSet> groups = constructGroups(names);
        return mergeGroups(groups, synonyms);
    }

    public static void main(String[] args) {
        Map<String, Integer> names = new HashMap<>();

        names.put("John", 15);
        names.put("Jon", 12);
        names.put("Johnny", 18);
        names.put("Chris", 13);
        names.put("Kris", 4);
        names.put("Christopher", 14);

        String[][] synonyms = {{"Jon", "John"}, {"John", "Johnny"},
                {"Chris", "Kris"}, {"Chris", "Christopher"}};

        Map<String, Integer> popular = mostPopular(names, synonyms);
        for (Map.Entry<String, Integer> entry : popular.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(name + ": " + frequency);
        }
    }
}
