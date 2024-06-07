

import java.net.InetAddress;

public class checkipweb {
    public static void main(String[] args) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName("ap.poly.edu.vn");
            for (int i = 0; i < addresses.length; i++) {
                System.out.println("Address " + (i + 1) + ": " + addresses[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

