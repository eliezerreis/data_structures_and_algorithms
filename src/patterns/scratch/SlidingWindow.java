package patterns.scratch;

public class SlidingWindow {

    private double maxAverage(int[] nums, int k) {
        if (nums.length == 1)
            return nums[0];

        double average = 0, max = 0;

        for (int i = 0; i < k; i++) {
            average += nums[i] / (double) k;
        }
        max = average;
        for (int right = k; right < nums.length; right++) {
            average += nums[right] / (double) k - nums[right - k] / (double) k;
            max = Math.max(max, average);

        }

        return max;
    }

    private int longestOnes(int[] nums, int k) {
        int left = 0, maxOnes = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                count++;

            while (count > k) {
                if (nums[left] == 0)
                    count--;
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }

        return maxOnes;
    }

    private int maxSum(int[] nums, int length) {
        int left = 0, sum = 0, maxSum = 0;

        // Calculate the initial summation of the first window
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        //add and subtract the next window
        for (int right = length; right < nums.length; right++) {
            sum += nums[right] - nums[right - left];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    private int maxProduct(int[] nums, int k) {
        int left = 0, max = 0, product = 1;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product > k) {
                product /= nums[left];
                left++;
            }

            max += right - left + 1;
        }

        return max;
    }

    private int maxBinary(int[] nums) {
        int left = 0, maxBinaryNumber = 0;

        // Number of times I see a zero in the binary string;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                count++;

            while (count > 1) {
                if (nums[left] == 0)
                    count--;
                left++;
            }

            maxBinaryNumber = Math.max(maxBinaryNumber, right - left + 1);
        }

        return maxBinaryNumber;
    }

    private int maxSubArrayWithSum(int[] nums, int target) {
        int left = 0, longest = 0, sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        SlidingWindow window = new SlidingWindow();

        int[] nums1 = new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5};
        int[] nums2 = new int[]{1, 1, 0, 0, 1, 0, 1, 1};
        int[] nums3 = new int[]{10, 5, 2, 6};
        int[] nums4 = new int[]{3, -1, 4, 12, -8, 5, 6};
        int[] nums5 = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int[] nums6 = new int[]{3, 3, 4, 3, 0};


        int result1 = window.maxSubArrayWithSum(nums1, 8);
        int result2 = window.maxBinary(nums2);
        int result3 = window.maxProduct(nums3, 100);
        int result4 = window.maxSum(nums4, 4);
        int result5 = window.longestOnes(nums5, 3);
        double result6 = window.maxAverage(nums6, 3);

        System.out.println("maxSubArrayWithSum: " + result1);
        System.out.println("maxBinary: " + result2);
        System.out.println("maxProduct: " + result3);
        System.out.println("maxSum: " + result4);
        System.out.println("longestOnes: " + result5);
        System.out.println("maxAverage: " + result6);
    }
}
