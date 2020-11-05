import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

        // the number each thread need to count
        int interval = arr.length / 4;

        for (int i = 0; i < 4; ++i) {
            countSubSumThread thread = new countSubSumThread(i * interval, (i + 1) * interval, arr);
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
Thread-1 finished its task, the sum is -1044374966678
Thread-0 finished its task, the sum is -436371076196
Thread-2 finished its task, the sum is -1103786269264
Thread-3 finished its task, the sum is 407453131905
Sum: -2177079180233
    * */
}
class countSubSumThread extends Thread{
    private int startIndex;
    private int endIndex;
    private long sum = 0;
    private int[] arr;

    public countSubSumThread(int startIndex, int endIndex, int[] arr) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.arr = arr;
    }

    public long getSum() {
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