package sort;

import java.util.Arrays;

public class SelectionSort {
    public int[] sort(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[]{};

        if(nums.length == 1)
            return nums;

        for (int i = nums.length - 1; i > 0; i--) {
            int biggestNumberIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[j] > nums[biggestNumberIndex]) {
                    biggestNumberIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[biggestNumberIndex];
            nums[biggestNumberIndex] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        SelectionSort selection = new SelectionSort();

        System.out.println(Arrays.toString(selection.sort(new int[]{20, 35, -15, 7, 55, -22, 1})));
        System.out.println(Arrays.toString(selection.sort(new int[]{9,9,9,9})));
        System.out.println(Arrays.toString(selection.sort(null)));
        System.out.println(Arrays.toString(selection.sort(new int[]{})));
        System.out.println(Arrays.toString(selection.sort(new int[]{1})));
    }
}
