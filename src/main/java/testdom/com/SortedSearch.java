package testdom.com;

/*Implement function countNumbers that accepts a sorted array of unique integers and,
* efficiently with respect to time used, counts the number of array elements that are less
* than the parameter lessThan. For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4)
* should return 2 because there are two array elements less than 4.
**/

import java.util.Arrays;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int length = sortedArray.length;

        if (length == 0) return 0;
        if (sortedArray[0] >= lessThan) return 0;
        if (sortedArray[length - 1] < lessThan) return length;

        int index = Arrays.binarySearch(sortedArray, lessThan);

        if (index < 0) return ~index;

        return index;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 0));
    }
}