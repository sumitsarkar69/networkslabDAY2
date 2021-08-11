package tcpechoserver;

import java.net.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class myserver {
    public static void main(String args[]) throws Exception{

        ServerSocket ss=new ServerSocket(52265);

        Socket s=ss.accept();;

        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());

        String str="";

        while(true) {
            System.out.println("Waiting for client's Reply...");
//            Date date = new Date(System.currentTimeMillis());  //for echoTCP comment this
//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy HH:mm");  //for echoTCP comment this
//            dout.writeUTF(formatter.format(date));  //for echoTCP comment this
            str=din.readUTF();
            if(str.equals("stop"))
                break;
            else {
                System.out.println("Client: "+str);
                System.out.println("Server: "+str);
            }
            str=din.readUTF();
        }



        din.close();
        s.close();
        ss.close();

    }
}