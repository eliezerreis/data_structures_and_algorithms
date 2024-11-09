package sort;

import java.util.Arrays;

public class ShellSort {
    public int[] sort(int[] nums) {
        // No need to compute empty arrays
        if (nums == null || nums.length <= 1)
            return nums;

        // Initialize gap size and begin sorting
        int gap = nums.length / 2;

        // keep reducing the gap until we dont have more gap
        while (gap > 0) {

            for (int i = gap; i < nums.length; i++) {
                int element = nums[i];
                int j = i;

                //shift element to right to find the correct position
                while (j - gap >= 0 && element < nums[j - gap]) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }

                // Insert the element at it's position
                nums[j] = element;
            }

            gap /= 2;
        }
        return nums;
    }

    public static void main(String[] args) {
        ShellSort selection = new ShellSort();

        System.out.println(Arrays.toString(selection.sort(new int[]{20, 35, -15, 7, 55, 1, -22})));
        System.out.println(Arrays.toString(selection.sort(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(selection.sort(null)));
        System.out.println(Arrays.toString(selection.sort(new int[]{})));
        System.out.println(Arrays.toString(selection.sort(new int[]{1})));
    }

}
