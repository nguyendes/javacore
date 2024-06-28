


class OddThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println(i);
                Thread.sleep(10); // Sleep for 10 milliseconds
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class EvenThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println(i);
                Thread.sleep(15); // Sleep for 15 milliseconds
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class lab6 {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();
        
        // Start the odd thread
        oddThread.start();
        
        try {
       
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        evenThread.start();

        try {
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


