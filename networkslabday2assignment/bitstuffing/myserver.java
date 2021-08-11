package bitstuffing;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class myserver {

    public static void main(String[] args) throws Exception{

        DatagramSocket ss=new DatagramSocket(52222);

        byte[] rd=new byte[100];

        DatagramPacket rp=new DatagramPacket(rd,rd.length);

        ss.receive(rp);
        StringBuilder s = data(rd); 

        System.out.println("Stuffed data from client: "+s);
        System.out.println("Unstuffed data: ");

        int cnt = 0;
        for(int i = 8;i<s.length()-8; i++) {
            char ch = s.charAt(i);
            if(ch == '1') {
                cnt++;
                System.out.print(ch);
                if(cnt==5) {
                    i++;
                    cnt = 0;
                }
            }
            else {
                System.out.print(ch);
                cnt = 0;
            }
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