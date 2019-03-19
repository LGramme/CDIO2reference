package domain;

import java.io.IOException;

public interface IController {

    String getOperator(int operatorNum);
    void tare() throws IOException;
    double getWeight() throws IOException;
    void close();
    boolean checkWighing(double tara, double netto, double brutto);

}
