


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 *
 * @author maytinh
 */
public class test3 {
    public static void main(String[] args) throws IOException
{
    FileInputStream inStream = new FileInputStream("C:\\Users\\maytinh\\Downloads\\xx.txt");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); 
            }

            bufferedReader.close();
}
}

