package sort;

import java.util.Arrays;

public class QuickSortFirst {

    // The strategy is to set the pivot always at the last position
    public int partition(int[] nums, int first, int last) {
        // Choose the first element as the pivot
        int pivot = nums[first];
        // Start from the element after the pivot
        int i = first + 1;

        // Rearrange the elements, putting those less than the pivot to the left
        for (int j = first + 1; j <= last; j++) {
            if (nums[j] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        // Place the pivot in its correct position (after the last smaller element)
        int temp = nums[first];
        nums[first] = nums[i - 1];
        nums[i - 1] = temp;

        // return the pivot final position
        return i - 1;
    }

    public void quickSort(int[] nums, int first, int last) {
        if (first >= last)
            return;

        // Get the current position of the pivot
        int pivot = partition(nums, first, last);

        quickSort(nums, first, pivot - 1); // sort the left subarray
        quickSort(nums, pivot + 1, last); // sort the right subarray
    }


    public int[] sort(int[] nums) {
        // No need to compute empty arrays
        if (nums == null || nums.length <= 1)
            return nums;

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    public static void main(String[] args) {
        QuickSortFirst sorter = new QuickSortFirst();
        int[] nums = {20, 35, -15, 7, 55, 1, -22};
        //int[] nums = {8, 2, 1, 3, 9, 4, 7, 6, 5};

        sorter.sort(nums);
        System.out.println(Arrays.toString(nums));

    }

}
