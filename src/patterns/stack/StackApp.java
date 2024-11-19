package patterns.stack;

import java.util.Stack;

public class StackApp {

    public String transformString(String a) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '#') {
                if (result.length() > 0)
                    result.deleteCharAt(result.length() - 1);
            } else {
                result.append(a.charAt(i));
            }
        }

        return result.toString();
    }

    public boolean backspaceCompare(String a, String b) {
        return transformString(a).equals(transformString(b));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");

        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }


    public String makeGoodString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char currChar : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.lastElement() - currChar) == 32)
                stack.pop();
            else
                stack.add(currChar);
        }

        StringBuilder ans = new StringBuilder();
        for (char currChar : stack)
            ans.append(currChar);
        return ans.toString();
    }

    public static void main(String[] args) {
        String a = "abc#d";
        String b = "abd#d#d";

        StackApp stack = new StackApp();
        boolean equivalent = stack.backspaceCompare(a, b);

        System.out.println("Is the String equivalent? " + equivalent);
        System.out.println("Simplified directory:  " + stack.simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println("Good string:  " + stack.makeGoodString("ElieeEzer"));

    }
}
