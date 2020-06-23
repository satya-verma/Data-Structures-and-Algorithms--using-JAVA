package algorithms.sorting.merge_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    /** mergeSort function */
    public List<Integer> mergeSort(List<Integer> array) {
        if (array.size() == 1) {
            return array;
        }

        List<Integer> left = array.subList(0, array.size() / 2);
        List<Integer> right = array.subList(array.size() / 2, array.size());

        return merge(mergeSort(left), mergeSort(right));
    }

    /** merge function */
    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        List<Integer> leftRemaining = left.subList(leftIndex, left.size());
        List<Integer> rightRemaining = right.subList(rightIndex, right.size());

        result.addAll(leftRemaining);
        result.addAll(rightRemaining);

        return result;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        System.out.println(sort.mergeSort(numbers));
    }
}
