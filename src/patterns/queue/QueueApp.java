package patterns.queue;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    int maxSize = 0;
    int total = 0;
    Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        this.maxSize = size;
    }

    public double next(int val) {
        queue.add(val);
        total += val;
        if (queue.size() > maxSize) {
            Integer value = queue.poll();
            if (value != null)
                total -= value;
        }

        return total / (double) queue.size();
    }
}


public class QueueApp {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(2);
        ma.next(1);
        ma.next(3);
        ma.next(3);
        double last = ma.next(10);

        System.out.println(last);
    }
}
