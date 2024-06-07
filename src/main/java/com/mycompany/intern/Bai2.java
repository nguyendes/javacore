package com.mycompany.intern;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream input = Bai2.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Khong tim thay file");
                return;
            }
            properties.load(input);

            int electric_1 = Integer.parseInt(properties.getProperty("electric_1"));
            int electric_2 = Integer.parseInt(properties.getProperty("electric_2"));
            int electric_3 = Integer.parseInt(properties.getProperty("electric_3"));
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            int tongsotien;
            if (i <= 100) {
                tongsotien = i * electric_1;
            } else if (i <= 150) {
                tongsotien = 100 * electric_1 + (i - 100) * electric_2;
            } else {
                tongsotien = 100 * electric_1 + 50 * electric_2 + (i - 150) * electric_3;
            }
            System.out.println("So tien la: " + tongsotien);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}