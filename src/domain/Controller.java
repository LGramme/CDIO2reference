package domain;

import Data.IDatabaseAccess;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Controller {
    Socket socket;
    IDatabaseAccess database;
    InputStream in;
    PrintWriter out;

    public Controller(IDatabaseAccess database, String adress, int host) throws IOException {
        socket = new Socket(adress, host);
        in = socket.getInputStream();
        out = new PrintWriter(socket.getOutputStream());
        this.database = database;
    }

    public String getOperator(int operatorNum){
        String result;
        if (operatorNum > 10 && operatorNum < 100) {
            result = database.getOperator(operatorNum);
        } else {
            return "OperatorNumber out of bounds(11-99)";
        }

        if (result != null) {
            return result;
        } else {
            return "Unknown user";
        }
    }

    public void tare(){
        out.println("T");
    }

    public void getWeight() {
        out.println("S");
    }

}
