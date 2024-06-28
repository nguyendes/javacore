

class mythread extends Thread{
    public mythread(String name){
        super(name);
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"has priotiry:"+ Thread.currentThread().getPriority());
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"is running");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


public class testpriority {
    public static void main(String[] args) {
        mythread thread1= new mythread("thread1");
        mythread thread2= new mythread("thread2");
        mythread thread3= new mythread("thread3");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
