import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

// refer East China Normal University java II teaching code.
class MyTask extends RecursiveTask<Integer> {
    private int startIndex;
    private int endIndex;
    private int[] arr;

    private final int threadHold = 10;
    private int maxValue = Integer.MIN_VALUE;

    public MyTask(int startIndex, int endIndex, int[] arr) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (endIndex - startIndex <= threadHold) {
            for (int i = startIndex; i < endIndex; ++i) {
                maxValue = (maxValue < arr[i]) ? arr[i] : maxValue;
            }
        } else {
            int mid = startIndex + (endIndex - startIndex) / 2;
            MyTask task1 = new MyTask(startIndex, mid, arr);
            MyTask task2 = new MyTask(mid, endIndex, arr);
            invokeAll(task1, task2);

            int max1 = task1.join();
            int max2 = task2.join();
            maxValue = Math.max(max1, max2);
        }

        return maxValue;
    }
}

public class FindMaximumValue {
    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
        Random r = new Random();
        for (int i = 0; i < arr.length; ++i) {
            // count the symbol the the number.
            int symbol = r.nextInt(2);
            int absoluteValue = r.nextInt();
            // if symbol is 1, let the number be positive, else,
            // let the number be negative.
            arr[i] = symbol == 1 ? absoluteValue : -absoluteValue;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[4000000];
        generateRandomArray(arr);

        ForkJoinPool pool = new ForkJoinPool();
        MyTask task = new MyTask(0, arr.length, arr);
        ForkJoinTask<Integer> ans = pool.submit((ForkJoinTask<Integer>) task);

        int maxValue = Integer.MIN_VALUE;
        try {
            maxValue = ans.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("The maximum value within the array is " + maxValue);
    /*
    * console output:
The maximum value within the array is 2147481043
    * */
    }
}
