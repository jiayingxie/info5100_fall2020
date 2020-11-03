import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SumValue {
/*
* Write a program that calculate the sum value in an array of
* ints using 4 threads. You should construct an 4,000,000
* long array of random numbers and return the sum of the array.
* Please finish those two method: generateRandomArray and sum.
* */

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
        List<countSubSumThread> list = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            countSubSumThread thread = new countSubSumThread(i * 250, (i + 1) * 250, arr);
            list.add(thread);
            thread.start();
        }

        // !!!pay attention!!!, after calling join, only these 4 threads
        // are done, main could execute, therefore, we could get the
        // right answer. If do not call join, sometimes, threads do not
        // finish their tasks when main is finished
        for (int i = 0; i < 4; ++i) {
            try {
                list.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long totalSum = 0;
        for (int i = 0; i < 4; ++i) {
            totalSum += list.get(i).getSum();
        }

        return totalSum;
    }
    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
    /*
    * console output
Thread-0 finished its task, the sum is -102150165
Thread-3 finished its task, the sum is 1797121726
Thread-1 finished its task, the sum is -1238917027
Thread-2 finished its task, the sum is -1287637343
Sum: -831582809
    * */
}
class countSubSumThread extends Thread{
    private int startIndex;
    private int endIndex;
    private int sum = 0;
    private int[] arr;

    public countSubSumThread(int startIndex, int endIndex, int[] arr) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.arr = arr;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; ++i) {
            sum += arr[i];
        }
        System.out.println(Thread.currentThread().getName() +
                " finished its task, the sum is " + sum);
    }
}