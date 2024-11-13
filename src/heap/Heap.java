package heap;

public class Heap {

    private final int[] heap;
    private int size;

    public Heap(int capacity) {
        this.heap = new int[capacity];
    }

    public void buildHeap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // Copy the array to the heap and set the size
        System.arraycopy(nums, 0, heap, 0, nums.length);
        size = nums.length;

        // Start from the last non-leaf node and apply fixHeapBelow
        for (int i = getParent(size - 1); i >= 0; i--) {
            fixHeapBelow(i);
        }
    }

    // Perform heap sort on the heap
    public void heapSort() {
        int s = size;
        for (int i = size - 1; i > 0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            size--;  // Exclude the last element from the heap
            fixHeapBelow(0);  // Restore the max heap property from the root down
        }
        size = s;
    }

    public void insert(int value) {
        if (isFull())
            throw new IndexOutOfBoundsException("Heap is full.");

        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty.");

        return heap[0];
    }

    public void delete(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty.");

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Element out of bound");

        heap[index] = heap[size - 1];
        size--;

        fixHeapBelow(index);
    }


    // Fix elements above the index to keep the max heap condition
    private void fixHeapAbove(int index) {
        int newValue = heap[index];

        // While node is bigger them his parent keep swapping;
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    public void print() {
        for (int j = 0; j < size; j++) {
            System.out.print(heap[j] + " ");
        }
    }

    // Fix elements below the index to keep the max heap condition
    private void fixHeapBelow(int index) {
        int largerChild;
        int left = getLeft(index);
        int right = getRight(index);

        while (left < size) {

            if (right < size && heap[right] > heap[left]) {
                largerChild = right;
            } else {

                largerChild = left;
            }

            if (heap[index] >= heap[largerChild]) {
                break;
            }

            int temp = heap[index];
            heap[index] = heap[largerChild];
            heap[largerChild] = temp;

            index = largerChild;

            left = getLeft(index);
            right = getRight(index);
        }
    }

    private boolean isFull() {
        return size == heap.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeft(int index) {
        return (index * 2) + 1;
    }

    private int getRight(int index) {
        return (index * 2) + 2;
    }

}
