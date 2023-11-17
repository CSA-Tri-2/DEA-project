import java.util.ArrayList;

public class FibFor {

    public ArrayList<Integer> calculateFibonacci(int nth) {
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        for (int i = 2; i < nth; i++) {
            fib.add(fib.get(i - 2) + fib.get(i - 1));
        }

        return fib;
    }

    public static void main(String[] args) {
        FibFor fibFor = new FibFor();
        ArrayList<Integer> result = fibFor.calculateFibonacci(20);

        // Print the result
        System.out.println(result);
    }
}