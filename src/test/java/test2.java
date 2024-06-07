/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author maytinh
 */
public class test2 {
    public static void main(String[] args) throws IOException
{
    InputStream inStream = new FileInputStream("C:\\Users\\maytinh\\Downloads\\xx.txt");
    OutputStream outStream = new FileOutputStream("C:\\Users\\maytinh\\Downloads\\bb.txt");

 while (inStream.available() > 8)
 {
  int data = inStream.read(); 
  outStream.write(data); 
 }

 inStream.close(); //close the streams
 outStream.close();
}
}
