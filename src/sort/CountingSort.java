package sort;

import java.util.Arrays;

public class CountingSort {

    public void sort(int[] nums, int min, int max) {
        int[] counter = new int[max - min + 1];

        // count the number of occurrences of each number and place in the correct place in the array
        for (int i = 0; i < nums.length; i++) {
            int position = nums[i] - min;
            counter[position]++;
        }

        // Rebuild the array
        for (int i = 0, j = 0; i < counter.length; i++) {
            while (counter[i] > 0) {
                nums[j++] = i + min;
                counter[i]--;
            }
        }
    }

    public static void main(String[] args) {


        CountingSort sorter = new CountingSort();
        int[] nums = {20, 35, -15, 7, 55, 1, -22};
        //int[] nums = {8, 2, 1, 3, 9, 4, 7, 6, 5};
        //int[] nums = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        //int[] nums = {20, 50, 10, 8, 2, 8, 7, 10, 4, 3};

        // Find the range of values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        sorter.sort(nums, min, max);
        System.out.println(Arrays.toString(nums));
    }
}
