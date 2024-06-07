/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.intern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author maytinh
 */
public class bt4 {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm= new DatabaseConnectionManager("Sinhvien","sa","1410");
        Connection cnt= null;
        PreparedStatement pre= null;
        ResultSet rss= null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so sinh vien ");
        int n = Integer.parseInt(sc.nextLine());

        try {
            cnt= dcm.getConnection(); 
            for (int i = 0; i < n; i++) {
                System.out.println("Nhap thong tin " + (i + 1) + ":");
                System.out.print("Ten: ");
                String ten = sc.nextLine();

                System.out.print("Gioi tinh: ");
                String gioitinh = sc.nextLine();

                System.out.print("Que quan: ");
                String que = sc.nextLine();

                System.out.print("Tuoi: ");
                int tuoi = Integer.parseInt(sc.nextLine());

                insertStudent(cnt, ten, gioitinh, que, tuoi);
            }
            System.out.println("All student information has been inserted into the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection cnt, String ten, String gioitinh,String que, int tuoi) {
        String sql = "INSERT INTO sv (ten, gioitinh, que, tuoi) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = cnt.prepareStatement(sql)) {
            pstmt.setString(1, ten);
            pstmt.setString(2, gioitinh);
            pstmt.setString(3, que);
            pstmt.setInt(4, tuoi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Ten da ton` tai");
            } else {
                e.printStackTrace();
            }
        }
    }
}

