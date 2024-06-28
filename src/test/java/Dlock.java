


 class Resource {
   private int value;
   public int  getvalue(){
    return value;
   }
   public void setvalue(int value){
      this.value= value;
   } 
}
public class Dlock{
   private  static Resource resource1= new Resource();
   private  static Resource resource2= new Resource();

   private static class ThreadA extends Thread{
      public void run(){
         synchronized (resource1){
            System.out.println("ThreadA acquired resource1");
            try{
               Thread.sleep(100);
            }catch(InterruptedException e){
               e.printStackTrace();
            }
            synchronized(resource2){
               System.out.println("ThreadA wants to acquired resource2");
            }
         }
      }
   }

   private static class ThreadB extends Thread{
      public void run(){
         synchronized (resource2){
            System.out.println("ThreadB acquired resource2");
            try{
               Thread.sleep(100);
            }catch(InterruptedException e){
               e.printStackTrace();
            }
            synchronized(resource1){
               System.out.println("ThreadA wants to acquired resource1");
            }
         }
      }
   }
   public static void main(String[] args) {
      ThreadA threadA = new ThreadA();
      ThreadB threadB = new ThreadB();
  
      threadA.start();
      threadB.start();
  }
  

   }


    


