package bytestuffing;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class myserver {

    public static void main(String[] args)throws Exception {

        DatagramSocket ss=new DatagramSocket(54444);

        byte[] rd=new byte[100];

        DatagramPacket rp=new DatagramPacket(rd,rd.length);

        ss.receive(rp);
        StringBuilder s = data(rd); 

        System.out.println("Stuffed data from client: "+s);
        System.out.println("Unstuffed data: ");

        for(int i =1;i<s.length()-1;i++) {
            if(s.charAt(i)=='E') {
                i++;
            }
            System.out.print(s.charAt(i));
        }
        System.out.println();
        ss.close();
    }
    private static StringBuilder data(byte[] a) {
        if(a == null)return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while(a[i] != 0){
            ret.append((char)a[i]);
            i++;
        }
        return ret;
    }

}