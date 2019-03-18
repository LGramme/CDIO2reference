package domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Controller {
    Socket socket;

    Controller(String adress, int host) throws IOException {
        socket = new Socket(adress, host);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
    }
}
