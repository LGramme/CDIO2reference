package domain;

import Data.IDatabaseAccess;
import TechnicalServices.InputHandling;

import java.io.*;
import java.net.Socket;

public class Controller {
    Socket socket;
    IDatabaseAccess database;
    BufferedReader in;
    PrintWriter out;

    public Controller(IDatabaseAccess database, String adress, int host) throws IOException {
        socket = new Socket(adress, host);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
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

    public double getWeight() throws IOException {
        out.println("S");
        out.flush();
        String str = in.readLine();
        str = str.split(" ")[6];

        return InputHandling.toNum(str);
    }

    public void close() {
        out.println("Q");
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
