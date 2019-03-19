import Data.Dummy;
import Data.IDatabaseAccess;
import UI.TUI;
import domain.Controller;
import domain.IController;

import java.io.IOException;

public class Main {
    private final static String adress = "127.0.0.1";
    private final static int host = 8000;

    public static void main(String[] args) throws IOException {
        IDatabaseAccess db = new Dummy();
        IController con = new Controller(db, adress, host);
        TUI tui = new TUI(con);
        tui.run();
    }
}
