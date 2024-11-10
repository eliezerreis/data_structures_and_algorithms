package sort;

import java.util.Arrays;

public class MergeSortByArray {

    public int[] mergeSort(int[] first, int[] second) {
        int i = 0; // left index
        int j = 0; // right index
        int k = 0;
        int[] mix = new int[first.length + second.length];

        while (i < first.length && j < second.length)
            mix[k++] = first[i] < second[j] ? first[i++] : second[j++];

        while (i < first.length)
            mix[k++] = first[i++];

        while (j < second.length)
            mix[k++] = second[j++];

        return mix;
    }

    public int[] split(int[] arr) {
        if (arr.length <= 1)
            return arr;

        int middle = arr.length / 2;

        int[] left = split(Arrays.copyOfRange(arr, 0, middle));
        int[] right = split(Arrays.copyOfRange(arr, middle, arr.length));

        return mergeSort(left, right);
    }


    public int[] sort(int[] nums) {
        // No need to compute empty arrays
        if (nums == null || nums.length <= 1)
            return nums;

        nums = split(nums);

        return nums;
    }

    public static void main(String[] args) {
        MergeSortByArray selection = new MergeSortByArray();
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
