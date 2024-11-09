package sort;

import java.util.Arrays;

public class BubbleSort {
    public int[] sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (j < nums.length - 1 && nums[j] > nums[j + 1]) {
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
    }
}
