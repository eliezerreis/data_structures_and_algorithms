package sort;

import java.util.Arrays;

public class RadixSort {

    public void countingSort(int[] nums, int place) {
        int len = nums.length;
        int[] counter = new int[10];
        int[] temp = new int[len];

        // count the number of occurrences of a specific digit
        for (int num : nums) {
            int position = (num / place) % 10;
            counter[position]++;
        }

        // store the cumulative counter
        for (int i = 1; i < 10; i++) {
            counter[i] += counter[i - 1];
        }

        // We transverse the array backwards to ensure stability
        for (int i = len - 1; i >= 0; i--) {
            int num = nums[i];
            int digit = (num / place) % 10;
            temp[counter[digit] - 1] = num;
            counter[digit]--;
        }

        // Copy the sorted array to the original array
        System.arraycopy(temp, 0, nums, 0, len);
    }

    public void sort(int[] nums, int max) {
        // Process each digit starting from the last one
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(nums, place);
        }
    }

    public static void main(String[] args) {
        RadixSort sorter = new RadixSort();
        int[] nums = {20, 35, 1500, 7, 9020, 7584, 22};

        // Find the max value
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
        }

        sorter.sort(nums, max);
        System.out.println(Arrays.toString(nums));
    }
}
