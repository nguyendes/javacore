/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maytinh
 */
public class TestThread extends Thread{
    private String ten;
    
    public TestThread(String ten){
        this.ten= ten;
    }
    @Override
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println(this.ten+":"+i);
        }
    }
    public static void main(String[] args){
        TestThread doituongA= new TestThread("A");
        TestThread doituongB= new TestThread("B");
        TestThread doituongC= new TestThread("C");
        
        doituongA.start();
        doituongB.start();
        doituongC.start();
    }   
}
