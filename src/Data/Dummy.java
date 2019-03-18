package Data;

import java.util.HashMap;
import java.util.Map;

public class Dummy implements IDatabaseAccess {

    Map<Integer,String> user;
    Map<Integer,String> batch;

    Dummy(){
        user = new HashMap<>();
        user.put(12,"Anders And");
        batch = new HashMap<>();
        batch.put(1234,"Salt");
    }

    @Override
    public String getOperator(int userID) {
        return user.get(userID);
    }

    @Override
    public String getMaterial(int materialID) {
        return batch.get(materialID);
    }
}
