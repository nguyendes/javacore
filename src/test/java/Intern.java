

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Intern {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\maytinh\\Downloads\\xx.txt"); 
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); 
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
