import java.util.*;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        ArrayList<String> resultList = new ArrayList<>();
        resultList.addAll(Arrays.asList(names1));
        resultList.addAll(Arrays.asList(names2));
        Set<String> set = new HashSet<>(resultList);
        return set.toArray(new String[set.size()]);

//        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}