package heap;

import trees.util.Tree;

public class HeapApp {

    public static void main(String[] args) {
        var nums = new int[]{80, 75, 60, 68, 55, 40, 52, 67};

        Heap heap = new Heap(nums.length);
        heap.buildHeap(nums);
        heap.print();

        System.out.println();
        System.out.println("Get root:" + heap.peek());

        System.out.println("Deleting some items");
        heap.delete(1);
        heap.delete(3);
        heap.delete(4);
        heap.print();

        System.out.println();
        System.out.println("Heap sorted");
        heap.heapSort();
        heap.print();

        System.out.println();
    }
}
