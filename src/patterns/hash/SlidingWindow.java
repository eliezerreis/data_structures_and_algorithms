package patterns.hash;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    public int maxNumberOfBalloons(String text) {

        Map<String, Integer> letters = new HashMap<>(Map.of("b", 0, "a", 0, "l", 0, "ll", 0, "o", 0, "oo", 0, "n", 0));


        for (int i = 0; i < text.length(); i++) {
            String letter = String.valueOf(text.charAt(i));
            if (letters.containsKey(letter)) {
                int value = letters.get(letter) + 1;
                letters.put(letter, value);
                if ((letter.equals("l") || letter.equals("o")) && value == 2) {
                    letters.put(letter, 0);
                    String key = letter + letter;
                    letters.put(key, letters.get(key) + 1);
                }
            }
        }

        letters.remove("l");
        letters.remove("o");

        int numberOfWords = 0;
        for (String letter : letters.keySet()) {
            numberOfWords = Math.max(numberOfWords, letters.get(letter));
        }

        return numberOfWords;
    }

    private int mostKDistinctLetters(String s, int k) {
        Map<Character, Integer> distinctLetters = new HashMap<>();

        int left = 0;
        int count = 0;


        // O(n)
        for (int right = 0; right < s.length(); right++) {
            // Updating rule
            char letter = s.charAt(right);
            int value = distinctLetters.getOrDefault(letter, 0);
            distinctLetters.put(letter, value);

            // Constrain rule
            while (distinctLetters.size() > k) {
                char letterToRemove = s.charAt(left);

                value = distinctLetters.get(letterToRemove);
                if (value > 1) {
                    distinctLetters.put(letter, value - 1);
                } else {
                    distinctLetters.remove(letterToRemove);
                }

                left++;
            }

            count = Math.max(count, right - left + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        SlidingWindow window = new SlidingWindow();
        int result1 = window.mostKDistinctLetters("eceba", 2);
        int result2 = window.maxNumberOfBalloons("nlaebolko");
        int result3 = window.findMaxLength(new int[]{0,1,0,1,0,1});

        System.out.println("mostKDistinctLetter: " + result1);
        System.out.println("maxNumberOfBalloons: " + result2);
        System.out.println("findMaxLength: " + result3);


    }


}
