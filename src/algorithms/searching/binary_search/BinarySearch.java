package algorithms.searching.binary_search;

// In binary-search the elements must be sorted. If they are unsorted, first sort them.
// In this case we assume that array is sorted so we directly apply binary search.
// you can sort array using "Arrays.sort(array)" method.

public class BinarySearch {
    public String binarySearch(int[] arr, int key) {
        // key = element you are searching for
        int first = 0;                  // first index
        int last = arr.length - 1;      // last index
        int mid = (first + last) / 2;   // mid index

        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                return "Element Found At Index " + mid;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return "Element Not Found";
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        // make sure your array is sorted. Binary-Search works on sorted array.
        int[] array = {10,25,32,45,55,68};
        String result = bs.binarySearch(array,55);
        System.out.println(result);
        String result2 = bs.binarySearch(array,100);
        System.out.println(result2);
    }
}
