package sort;

import java.util.Arrays;

public class DescendingMergeSort {

    public void mergeSort(int[] nums, int start, int middle, int end) {
        int i = start; // left index
        int j = middle; // right index
        int k = 0;
        int[] mix = new int[end - start];

        // no need to sort in this case
        if (nums[middle - 1] >= nums[middle])
            return;

        while (i < middle && j < end)
            mix[k++] = nums[i] > nums[j] ? nums[i++] : nums[j++];


        System.arraycopy(nums, i, nums, start + k, middle - i);
        System.arraycopy(mix, 0, nums, start, k);
    }

    public void split(int[] nums, int start, int end) {
        if (end - start <= 1)
            return;

        int middle = (start + end) / 2;

        split(nums, start, middle);
        split(nums, middle, end);
        mergeSort(nums, start, middle, end);
    }


    public int[] sort(int[] nums) {
        // No need to compute empty arrays
        if (nums == null || nums.length <= 1)
            return nums;

        split(nums, 0, nums.length);

        return nums;
    }

    public static void main(String[] args) {
        DescendingMergeSort sorter = new DescendingMergeSort();
        int[] nums = {20, 35, -15, 7, 55, 1, -22};
        // int[] nums = {8, 2, 1, 3, 9, 4, 7, 6, 5};
        // int[] nums = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        // int[] nums = {20, 50, 10, 8, 2, 8, 7, 10, 4, 3};

        sorter.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
