import org.junit.jupiter.api.Test;
import socket.ISocketController;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	@Test
	public void test() throws InterruptedException {
		try (Socket socket = new Socket("localhost",ISocketController.PORT)) {			
			OutputStream sos = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(sos);
			InputStream is = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			pw.println("RM20 4 INDTAST");
			pw.flush();
			String in = reader.readLine();
			System.out.println(in);
			
			//socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
