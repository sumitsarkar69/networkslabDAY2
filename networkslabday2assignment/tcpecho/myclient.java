package tcpechoserver;

import java.net.*;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.io.*;
public class myclient  {

    public static void main(String[] args)  throws Exception {

        Socket s=new Socket("localhost",52265);

        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str="",str2="";

        while(!str.equals("stop")){ 
            System.out.println("\nEnter Response: ");
            str=br.readLine();
            //str2=din.readUTF(); //for echoTCP comment this
            dout.writeUTF(str);
            System.out.println("Waiting for Server's Reply...");
            dout.writeUTF(str);
            System.out.println("Server says: "+str);
            //System.out.println(str2); //for echoTCP comment this
        }

        dout.close();
        s.close();

    }
}