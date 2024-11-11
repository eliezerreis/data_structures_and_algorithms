package search;

public class LinearSearch {

    public int linearSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }

        return -1;
    }


    public static void main(String[] args) {

        LinearSearch search = new LinearSearch();
        int[] nums = {20, 35, 10, 7, 50, 1, 99};

        System.out.println(search.linearSearch(nums, -10));
        System.out.println(search.linearSearch(nums, 20));
        System.out.println(search.linearSearch(nums, 99));

    }
}
