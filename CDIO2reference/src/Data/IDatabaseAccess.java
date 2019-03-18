package Data;

public interface IDatabaseAccess {
    String getOperator(int userID);
    String getMaterial(int materialID);//"BatchID" = materialID
}
