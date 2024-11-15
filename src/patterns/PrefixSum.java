package patterns;

import java.util.Arrays;

public class PrefixSum {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int n = nums.length;
        int length = k * 2 + 1;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        if (length > n) {
            return result;
        }

        long total = 0;
        for (int i = 0; i < length; i++) {
            total += nums[i];
        }
        result[k] = (int) (total /  length);
        for (int right = length; right < n; right++) {
            total += nums[right] - nums[right - length];
            result[right - k] = (int) (total / length);
        }

        return result;
    }

    public int minStartValue(int[] nums) {
        int startValue = 1;

        while (true) {
            int total = startValue;
            boolean isValid = true;

            for (int num : nums) {
                total += num;

                if (total < 1) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return startValue;
            } else {
                startValue += 1;
            }
        }
    }

    public int[] runningSum(int[] nums) {
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        return prefix;
    }

    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];


        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            int firstSection = prefix[i];
            int secondSection = prefix[n - 1] - prefix[i];

            if (firstSection >= secondSection) answer++;

        }

        return answer;
    }

    public boolean[] answers(int[] nums, int[][] queries, int limit) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            int curr = prefix[y] - prefix[x] + nums[x];
            ans[i] = curr < limit;
        }

        return ans;
    }

    public static void main(String[] args) {

        PrefixSum prefix = new PrefixSum();

        int[] nums1 = new int[]{1, 6, 3, 2, 7, 2};
        int[] nums2 = new int[]{10, 4, -8, 7};
        int[] nums3 = new int[]{1, 6, 3, 2, 7, 2};
        int[] nums4 = new int[]{-3, 2, -3, 4, 2};
        int[] nums5 = new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6};
        int[][] queries = new int[][]{new int[]{0, 3}, new int[]{2, 5}, new int[]{2, 4}};

        boolean[] result1 = prefix.answers(nums1, queries, 13);
        int result2 = prefix.waysToSplitArray(nums2);
        int[] result3 = prefix.runningSum(nums3);
        int result4 = prefix.minStartValue(nums4);
        int[] result5 = prefix.getAverages(nums5, 3);


        System.out.println("answers: " + Arrays.toString(result1));
        System.out.println("waysToSplitArray: " + result2);
        System.out.println("runningSum: " + Arrays.toString(result3));
        System.out.println("minStartValue: " + result4);
        System.out.println("minStartValue: " + Arrays.toString(result5));
    }
}
