package stacks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromeWithStack {
    public boolean check(String s) {
        if (s.length() == 1)
            return true;

        s = s.replaceAll("[^a-zA-Z]", "");
        s = s.toLowerCase();

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        StringBuilder reversed = new StringBuilder(stack.size());

        while (!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString().equals(s);
    }

    public static void main(String[] args) {
        PalindromeWithStack palindrome = new PalindromeWithStack();

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
            System.out.println(s + (palindrome.check(s) ? " is a palindrome." : " isn't a palindrome."));
        }

    }
}
