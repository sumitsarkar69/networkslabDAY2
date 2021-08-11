package udptimeserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class myclient {

    public static void main(String[] args) {
        // args give message contents and server hostname
        String message = "What is the time?";
        String host = "localhost";
        int port = 8080;
        DatagramSocket aSocket = null;


        if (args.length == 3) {
            message = args[0];
            host = args[1];
            port = Integer.valueOf(args[2]);
        }

        try {
            aSocket = new DatagramSocket();
            byte[] m = message.getBytes();
            InetAddress aHost = InetAddress.getByName(host);
            int serverPort = port;
            DatagramPacket request
                    = new DatagramPacket(m, message.length(), aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println(
                    "Reply: " + new String(reply.getData())
            );
        } catch (SocketException e) {
            System.out.println(
                    "Socket: " + e.getMessage()
            );
        } catch (IOException e) {
            System.out.println(
                    "IO: " + e.getMessage()
            );
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }

}