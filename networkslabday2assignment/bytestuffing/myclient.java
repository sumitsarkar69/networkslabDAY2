package bytestuffing;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class myclient {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket cs=new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();

        byte buf[] = null;

        System.out.println("Enter data: ");
        String inp = sc.nextLine();

        String s ="";

        for(int i =0;i<inp.length();i++) {
            if((inp.charAt(i)=='F')||(inp.charAt(i)=='E')) {
                s = s+'E'+inp.charAt(i);
            }
            else {
                s = s+inp.charAt(i);
            }
        }
        s = "F"+s+"F";
        buf = s.getBytes();
        DatagramPacket dpsend = new DatagramPacket (buf, buf.length,ip,54444);
        System.out.println("Data Stuffed in client: "+s);
        System.out.println("Sending to server...");

        cs.send(dpsend);
        cs.close();
        sc.close();


    }

}