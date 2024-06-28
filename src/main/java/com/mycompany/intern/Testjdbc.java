/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.intern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author maytinh
 */
public class Testjdbc {

    public static void main(String[] args) {
  
        DatabaseConnectionManager dcm= new DatabaseConnectionManager("NhanVien","sa","1410");
        Connection cnt= null;
        PreparedStatement pre= null;
        ResultSet rss= null;
        try{
            cnt= dcm.getConnection();
            String sql="""
                       select*from nv
                       """;
            pre= cnt.prepareStatement(sql);
            rss= pre.executeQuery();
            while(rss.next()){
                System.out.println(rss.getInt(1)+rss.getString(2));
            }
            System.out.println("done");
        }catch(Exception e){
            e.printStackTrace();
    }
    }




    
}
