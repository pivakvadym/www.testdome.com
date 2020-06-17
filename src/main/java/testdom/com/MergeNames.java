package testdom.com;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
 * Implement the uniqueNames method.
 * When passed two arrays of names, it will return an array containing the names that appear in either or both arrays.
 * The returned array should have no duplicates. For example, calling testdom.com.MergeNames.uniqueNames(new String[]{'Ava', 'Emma', 'Olivia'},
 * new String[]{'Olivia', 'Sophia', 'Emma'}) should return an array containing Ava, Emma, Olivia, and Sophia in any order.
 **/
public class MergeNames {

    public static String[] uniqueNames(String[] a, String[] b) {
        return Stream.of(Arrays.asList(a), Arrays.asList(b))
                .flatMap(Collection::stream)
                .distinct().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}