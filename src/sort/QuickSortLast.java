package sort;

import java.util.Arrays;

public class QuickSortLast {

    // The strategy is to set the pivot always at the last position
    public int partition(int[] nums, int first, int pivot) {

        int i = first;
        int j = i;

        // Rearrange the elements, putting those less than the pivot to the left
        for (; j < pivot; j++) {
            if (nums[j] < nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        // Place the pivot in its correct position (after the last smaller element)
        int temp = nums[i];
        nums[i] = nums[pivot];
        nums[pivot] = temp;

        // return the pivot final position
        return i;
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
        QuickSortLast sorter = new QuickSortLast();
        //int[] nums = {20, 35, -15, 7, 55, 1, -22};
        int[] nums = {8, 2, 1, 3, 9, 4, 7, 6, 5};

        sorter.sort(nums);
        System.out.println(Arrays.toString(nums));

    }

}
