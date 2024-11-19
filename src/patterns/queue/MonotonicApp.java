package patterns.queue;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicApp {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        MonotonicApp app = new MonotonicApp();
        int[] result = app.dailyTemperatures(new int[]{40, 32, 31, 37, 50});
        System.out.println(Arrays.toString(result));
    }
}
