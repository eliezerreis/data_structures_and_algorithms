package search;

import java.util.Arrays;

public class BinarySearchIterative {

    // Merge two sorted arrays in one sorted array
    private int[] mergeAndSort(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];
        int i = 0; // position on left array
        int j = 0; // position on right array
        int k = 0; // position we are inserting on temporary array (merged array)

        // Added the smallest elements in the merge array one at a time
        while (i < left.length && j < right.length) mix[k++] = left[i] > right[j] ? right[j++] : left[i++];

        // Add remaining elements of the left array
        while (i < left.length) mix[k++] = left[i++];

        // Add remaining elements of the right array
        while (j < right.length) mix[k++] = right[j++];

        return mix;
    }

    public int[] sort(int[] nums) {
        if (nums.length <= 1) return nums;

        int middle = nums.length / 2;

        int[] left = new int[middle];
        int[] right = new int[nums.length - middle];

        System.arraycopy(nums, 0, left, 0, middle);
        System.arraycopy(nums, middle, right, 0, nums.length - middle);

        left = sort(left);
        right = sort(right);

        return mergeAndSort(left, right);
    }

    // Binary search needs a sorted array
    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int middle = (start + end) / 2;

            if (nums[middle] == target) return middle;

            if (nums[middle] > target) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return -1;

    }

    public int searchFor(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        return binarySearch(nums, target);
    }


    public static void main(String[] args) {

        BinarySearchIterative finder = new BinarySearchIterative();
        int[] nums = {20, 35, 10, 7, 50, 1, 99};

        //Sort the array before searching;
        nums = finder.sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println("#10 found at index:" + finder.searchFor(nums, 10));
        System.out.println("#20 found at index: " + finder.searchFor(nums, 20));
        System.out.println("#1 found at index: " + finder.searchFor(nums, 1));
        System.out.println("#7 found at index: " + finder.searchFor(nums, 7));
        System.out.println("#100 found at index: " + finder.searchFor(nums, 100));


    }
}
