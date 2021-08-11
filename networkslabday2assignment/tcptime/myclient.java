package tcptimeserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class myclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("127.0.0.1",8888);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String mag = in.readLine();
			System.out.println("Server :" +mag);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
