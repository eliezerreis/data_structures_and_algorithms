package sort;

import java.util.Arrays;

public class SelectionSort {
    public int[] sort(int[] nums) {
        // No need to compute empty arrays
        if(nums == null || nums.length <= 1)
            return nums;

        for (int i = nums.length - 1; i > 0; i--) {
            // The largest element is the last element on the list, specially after first pass
            int largestIndex = i;
            for (int j = 0; j <= i; j++) {
                if (nums[j] > nums[largestIndex]) {
                    largestIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[largestIndex];
            nums[largestIndex] = temp;
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
