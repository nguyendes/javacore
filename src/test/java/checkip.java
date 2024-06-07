

import java.net.InetAddress;

public class checkip {
    public static void main(String[] args) {
        try {
            InetAddress myip= InetAddress.getLocalHost();
            System.out.println(myip.getHostAddress());
            System.out.println(myip.getHostName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
