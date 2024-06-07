package com.mycompany.intern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;


public class bt1 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = Bai2.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Khong tim thay file");
                return;
            }
            properties.load(input);

             Scanner sc = new Scanner(System.in);
            int somau =Integer.parseInt(properties.getProperty("somau")); 
            int max =Integer.parseInt(properties.getProperty("max"));
            int dem = 0; 
            while (dem < max) {
            System.out.print("Nhap so: ");
            if (sc.hasNextInt()) {
                int sonhap = sc.nextInt();
                dem++;

                if (sonhap == somau) {
                    System.out.println("Nhap thanh cong");
                    break;
                } else {
                    System.out.println("Vui long nhap lai.");
                }        
        }
        
    }
        if (dem == max) {
            System.out.println("Ban da nhap sai qua so lan.");
        }
        sc.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}