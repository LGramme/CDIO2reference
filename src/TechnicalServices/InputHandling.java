package TechnicalServices;

//*******************************************
//A class for managing input more easily, especially when you want to make your program able to handle wrong inputs.
//*******************************************
public class InputHandling {

    //***************************************
    //Returns true if the string consists only of numbers
    //***************************************
    public static boolean isNumber(String input){
        Boolean output = false;

        for (int e = 0; e < input.length(); e++) {
            if (input.charAt(e) <= '9' && '0' <= input.charAt(e) || input.charAt(e) == '.')
                output = true;
            else
                return false;
        }
        return output;
    }


    //***************************************
    //Assigns the String value to the int variable if possible else it returns 0
    //***************************************
    public static double toNum(String value){
        double var = 0;
        if (isNumber(value)) {
            int count = 0;
            int comma = 0;
            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) != '.') {
                    var += (Math.pow(10d, (double) (value.length() - count - 1))) * (value.charAt(i) - '0');
                    count++;
                } else {
                    comma = -(value.length() - count);
                }
            }
            var *= Math.pow(10d, (double) comma);
            return var;
        } else {
            throw new IllegalArgumentException("String, doesn't represent a number");
        }
    }
}
