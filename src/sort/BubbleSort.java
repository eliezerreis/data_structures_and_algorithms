package sort;

import java.util.Arrays;

public class BubbleSort {
    public int[] sort(int[] nums) {
        // No need to sort an empty array
        if(nums == null || nums.length <= 1)
            return nums;

        for (int i = 0; i < nums.length; i++) {
            // The last ith element is already sorted
            for (int j = 0; j < nums.length - i -1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        BubbleSort bubble = new BubbleSort();
        System.out.println(Arrays.toString(bubble.sort(new int[]{10, -10, 25, 7, 8, 12, -5, 9, -15})));
        System.out.println(Arrays.toString(bubble.sort(new int[]{20, 35, -15, 7, 55, -22, 1})));
        System.out.println(Arrays.toString(bubble.sort(new int[]{9,9,9,9})));
        System.out.println(Arrays.toString(bubble.sort(null)));
        System.out.println(Arrays.toString(bubble.sort(new int[]{})));
        System.out.println(Arrays.toString(bubble.sort(new int[]{1})));
    }
}
