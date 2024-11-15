package patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {

    public void reverse(char[] s) {
        int i = 0, j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }

    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = right;

        while (left < right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right]))
                result[index--] = (int) Math.pow(nums[right--], 2);
            else
                result[index--] = (int) Math.pow(nums[left++], 2);
        }

        return result;

    }

    public boolean checkPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z]", "");
        text = text.toLowerCase();

        int right = text.length() - 1;
        int left = 0;

        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--))
                return false;
        }

        return true;
    }

    public int[] twoSum(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target)
                return new int[]{left, right};

            if (sum > target)
                right--;
            else
                left++;
        }

        return new int[]{};
    }

    public int sum(int[] a, int[] b) {
        int i = 0, j = 0, result = 0;


        while (i < a.length && j < b.length) {
            result += a[i++] + b[j++];
        }

        while (i < a.length)
            result += a[i++];

        while (j < b.length)
            result += b[j++];

        return result;
    }

    public boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == a.length();
    }

    public static void main(String[] args) {
        TwoPointers pointers = new TwoPointers();

        List<String> strs = new ArrayList<>();
        strs.add("Racecar!");
        strs.add("I did, did I?");
        strs.add("a");
        strs.add("ata");
        strs.add("BB");
        strs.add("BBB");
        strs.add("Hello!");
        strs.add("Don't nod");
        strs.add("abccba");
        strs.add("Was it a car or a cat I saw?");
        strs.add("9999999");

        for (String s : strs) {
            System.out.println(s + (pointers.checkPalindrome(s) ? " is a palindrome." : " isn't a palindrome."));
        }


        System.out.println("TwoSum: " + Arrays.toString(pointers.twoSum(new int[]{1, 2, 4, 6, 8, 9, 14, 15}, 13)));
        System.out.println("Sum of two arrays:" + pointers.sum(new int[]{1, 2, 3, 4, 5}, new int[]{5, 6, 7, 8, 9, 10})); //60
        System.out.println("ace is substring of abcde: " + pointers.isSubsequence("ace", "abcde"));


        int[] nums = {-4, -1, 0, 3, 10};

        System.out.println("SortedSquares: " + Arrays.toString(pointers.sortedSquares(nums)));

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        pointers.reverse(s);
        System.out.println("Reserve String:" + Arrays.toString(s));
    }
}
