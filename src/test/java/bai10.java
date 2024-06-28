

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class Tinnhan{
    private int id;
    private String noidung;

    public Tinnhan(int id, String noidung){
        this.id= id;
        this.noidung= noidung;
    }

   @Override
   public String toString() {
       return "Tin nhan{id=" + id + ", content='" + noidung + "'}";
   } 
}
class SanXuat implements Runnable{
    private BlockingQueue<Tinnhan> queue;
    private Random random= new Random();

    public SanXuat(BlockingQueue<Tinnhan> queue){
        this.queue= queue;
    }
    @Override
    public void run(){
        while(true){
            try {
                int idtinnhan= random.nextInt(10,99);
                Tinnhan tn= new Tinnhan(idtinnhan, "noi dung"+idtinnhan);
                queue.put(tn);
                System.out.println("tao ra"+tn);
                TimeUnit.SECONDS.sleep(random.nextInt(1,10));

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
    class Tieuthu implements Runnable{
        private BlockingQueue<Tinnhan> queue;
        private Random random= new Random();

        public Tieuthu(BlockingQueue<Tinnhan> queue){
            this.queue= queue;
        }

        @Override
        public void run(){
            while (true) {
                try {
                    Tinnhan tn= queue.take();
                    System.out.println("tieuthu"+tn);
                    TimeUnit.SECONDS.sleep(random.nextInt(1,10));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                
            }
        }
    }

public class bai10 {
    public static void main(String[] args) {
        int queueSizeLimit= 3;

        BlockingQueue<Tinnhan> queue= new LinkedBlockingDeque<>(queueSizeLimit);

        Thread threadsx= new Thread(new SanXuat(queue));
        Thread threadtt= new Thread(new Tieuthu(queue));

        threadsx.start();
        threadtt.start();

        try{
            threadsx.join();
            threadtt.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }
}


