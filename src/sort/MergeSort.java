package sort;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] nums, int start, int middle, int end) {
        int i = start; // left index
        int j = middle; // right index
        int k = 0;
        int[] mix = new int[end - start];

        // no need to sort in this case
        if (nums[middle - 1] <= nums[middle])
            return;

        while (i < middle && j < end)
            mix[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
//
//        while (i < middle)
//            mix[k++] = nums[i++];
//
//        while (j < end)
//            mix[k++] = nums[j++];

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
        MergeSort selection = new MergeSort();
        int[] nums = new int[]{20, 35, -15, 7, 55, 1, -22};
        //int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6};
        nums = selection.sort(nums);

        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(selection.sort(new int[]{9, 9, 9, 9})));
//        System.out.println(Arrays.toString(selection.sort(null)));
//        System.out.println(Arrays.toString(selection.sort(new int[]{})));
//        System.out.println(Arrays.toString(selection.sort(new int[]{1})));
    }

}
