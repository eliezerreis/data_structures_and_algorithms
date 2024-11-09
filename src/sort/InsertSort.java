package sort;

import java.util.Arrays;

public class InsertSort {

    public int[] sort(int[] nums) {
        // No need to compute empty arrays
        if (nums == null || nums.length <= 1)
            return nums;


        for (int i = 1; i < nums.length; i++) {
            int element = nums[i];
            int j;

            // If needed, swift the elements of the array to receive the new element
            for (j = i; j > 0 && element < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }

            // Update the element in his correct position
            nums[j] = element;
        }

        return nums;
    }

    public static void main(String[] args) {
        InsertSort selection = new InsertSort();

        System.out.println(Arrays.toString(selection.sort(new int[]{20, 35, -15, 7, 55, -22, 1})));
        System.out.println(Arrays.toString(selection.sort(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(selection.sort(null)));
        System.out.println(Arrays.toString(selection.sort(new int[]{})));
        System.out.println(Arrays.toString(selection.sort(new int[]{1})));
    }

}
