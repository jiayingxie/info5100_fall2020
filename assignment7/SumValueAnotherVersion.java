import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

// this version referenced East China Normal University's
// teaching code
public class SumValueAnotherVersion {
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
    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        // Executor Frame Work was provided from JDK5, threads could reuse. (once new a thread,
        // normally the thread could only start once).
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        // Future could return result.
        List<Future<Long>> ansList = new ArrayList<>();

        int interval = arr.length / 4;

        // execute task and submit task
        for (int i = 0; i < 4; ++i) {
                MyThread t = new MyThread(i * interval, (i + 1) * interval, arr);
                Future<Long> ans = executor.submit(t);
                ansList.add(ans);
        }

        // count total sum.
        long totalSum = 0;
        for (Future<Long> f: ansList) {
            try {
                // Future.get(), get result, if thread is still running,
                // has to wait
                totalSum += f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // close executor
        executor.shutdown();

        return totalSum;
    }
    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}

// Callable is an equivalent of Runnable, it has call() like run()
// in Runnable, but call() could have return value, while run()
// return void.
class MyThread implements Callable<Long> {
    private int startIndex;
    private int endIndex;
    private int[] arr;

    public MyThread(int startIndex, int endIndex, int[] arr) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.arr = arr;
    }

    public MyThread(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = startIndex; i < endIndex; ++i) {
            sum += arr[i];
        }
        System.out.println(Thread.currentThread().getName()
                + " is finished, sum is " + sum);
        return sum;
    }
}