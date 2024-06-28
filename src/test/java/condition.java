import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class OrderedExecution {
    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();
    private int turn = 1;

    public void first(Runnable printFirst) {
        lock.lock();
        try {
            while (turn != 1) {
                condition1.await();
            }
            printFirst.run();
            turn = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) {
        lock.lock();
        try {
            while (turn != 2) {
                condition2.await();
            }
            printSecond.run();
            turn = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) {
        lock.lock();
        try {
            while (turn != 3) {
                condition3.await();
            }
            printThird.run();
            turn = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}

public class condition {
    public static void main(String[] args) {
        OrderedExecution orderedExecution = new OrderedExecution();

        Thread t1 = new Thread(() -> orderedExecution.first(() -> System.out.println("First")));
        Thread t2 = new Thread(() -> orderedExecution.second(() -> System.out.println("Second")));
        Thread t3 = new Thread(() -> orderedExecution.third(() -> System.out.println("Third")));

        t1.start();
        t2.start();
        t3.start();
    }
}

