/* Write a program called ReverseHello.java that creates a thread
(let's call it Thread 1). Thread 1 creates another thread (Thread 2);
Thread 2 creates Thread 3; and so on, up to Thread 50.

Each thread should print Hello from Thread num!

but you should structure your program such that the threads print
their greetings in reverse order.
* */
public class ReverseHello implements Runnable{
    private static int index = 1;

    @Override
    public void run() {
        // interesting, when index is 50, while (index <= 50) is true,
        // it could still run the while loop. then index += 1, so now
        // index is 51, the name of thread is 51. However, in console
        // output, the max thread number is 50. hahaha, I am so silly, 
		// my index starts from 1 rather than 0. Therefore, it is index <= 50
        while (index <= 50) {
            index += 1;
            Thread t = new Thread(new ReverseHello(), index + "");
            // attention, if the print code is in here, I could get
            // sequential output, but the task want reverse order,
            // so move the location.
            // System.out.println("Hello from Thread " + index +  "!");

            // attention!!!, t.start() should before t.join().
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // attention, the following code is wrong, after all 50
            // threads are created, the index would be 51, I could
            // not use index, so, use getName()
            // System.out.println("Hello from Thread " + index +  "!");

            // third version, and it's at the correct place with correct code.
            System.out.println("Hello from Thread " + Thread.currentThread().getName() + "!");
        }
    }

    public static void main(String[] args) {
        new Thread(new ReverseHello(), index + "").start();
    }
}
