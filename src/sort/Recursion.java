package sort;

public class Recursion {

    public static int factorial(int num) {
        if (num <= 1)
            return num;

        return num * factorial(num - 1);
    }

    public static int fibonacci(int num) {
        if (num <= 1)
            return num;
        int i = fibonacci(num - 1);
        int j = fibonacci(num - 2);

        return  i+j;
    }

    public static void main(String[] args) {
        int number = 4;
Recursion.fibonacci(5);
        System.out.println(number + "! = " + Recursion.factorial(4));

        System.out.print("Fibonacci Sequence of " + number + " = ");
        for (int i = 0; i < number; i++) {
            System.out.print(" "+Recursion.fibonacci(i));
        }
        System.out.println();
    }

}
