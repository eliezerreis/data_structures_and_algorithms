package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public void sort(int[] nums) {
        List<Integer>[] buckets = new ArrayList[10];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : nums) {
            buckets[hash(num)].add(num);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (List<Integer> bucket : buckets)
            for (int value : bucket) {
                nums[j++] = value;
            }

    }

    public int hash(int value) {
        return Math.abs(value) / 10;
    }

    public static void main(String[] args) {

        BucketSort sorter = new BucketSort();
        int[] nums = {20, 35, 10, 7, 50, 1, 99};
        // int[] nums = {8, 2, 1, 3, 9, 4, 7, 6, 5};
        // int[] nums = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        // int[] nums = {20, 50, 10, 8, 2, 8, 7, 10, 4, 3};

        sorter.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
