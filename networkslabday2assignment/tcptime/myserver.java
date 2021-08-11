package tcptimeserver;

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class myserver {
    public static void main (String args[]) throws Exception{
    	ServerSocket server = new ServerSocket(8888);
    	while(true)
    	{
    		System.out.println("Waiting for client to connect");
    		Socket socket = server.accept();
    		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
    		out.println("Hello the time and date is: "+new Date());
    		
    	}
    }
}
