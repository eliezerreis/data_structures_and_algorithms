package patterns.hash;

import java.util.*;
import java.util.stream.Collectors;

public class TwoPointers {

    public int countElements(int[] arr) {
        Set<Integer> elements = new HashSet<>();

        // O(n)
        for (int element : arr)
            elements.add(element);

        // O(n)
        int count = 0;
        for (int j : arr) {
            if (elements.contains(j + 1))
                count++;

        }

        return -1;
    }

    public char firstRepeatedLetter(String s) {
        Set<Character> counter = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (counter.contains(c))
                return c;

            counter.add(c);
        }

        return ' ';
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }


    public static void main(String[] args) {
        TwoPointers pointers = new TwoPointers();
        int[] nums1 = {5, 2, 7, 10, 3, 9};

        int[] result1 = pointers.twoSum(nums1, 8);
        char result2 = pointers.firstRepeatedLetter("abcdeda");

        System.out.println("twoSum: " + Arrays.toString(result1));

        System.out.println("firstRepeatedLetter: " + result2);

    }
}
