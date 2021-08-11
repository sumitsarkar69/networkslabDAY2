package bitstuffing;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class myclient {

    public static void main(String[] args)throws Exception {

        Scanner sc = new Scanner(System.in);
        DatagramSocket cs=new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();

        byte buf[] = null;

        System.out.println("Enter data: ");
        String inp = sc.nextLine();

        int cnt = 0;
        String s ="";
        for(int i = 0; i<inp.length(); i++ ) {
            char ch = inp.charAt(i);
            if(ch== '1') {
                cnt++;
                if(cnt<5)
                    s+=ch;
                else {
                    s=s+ch+'0';
                    cnt = 0;
                }
            }
            else {
                s+=ch;
                cnt = 0;
            }
        }
        s = "01111110"+s+"01111110";

        buf = s.getBytes();
        DatagramPacket dpsend = new DatagramPacket (buf, buf.length,ip,52222);
        System.out.println("Data Stuffed in client: "+s);
        System.out.println("Sending to server...");

        cs.send(dpsend);
        cs.close();
        sc.close();

    }

}