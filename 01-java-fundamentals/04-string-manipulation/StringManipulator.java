import java.util.Exceptions;
import java.util.Collections;
import java.util.Hashmaps;

public class StringManipulator{
    public String trimAndConcat(String string1, String string2){
        return string1.trim().concat(string2.trim());
    }

    public Interger getIndexOrNullChar(String input, char c){
        if(input.indexOf(c) ==-1) {
            return null;
        }
        return input.indexOf(c);
    }

    public Interger getIndexOrNullString(String input, String sub) {
        if(input.indexOf(sub) ==-1) {
            return null;
        }
        return input.indexOf(sub);
    }

    public String concatSubstring(String input, int idxA, int idxB, String replacement){
        String substr;
        try{
            substring = input.substring(idxA, idxB);
        } catch (Exceptions e){
            System.out.println(String.format("Exception caught: %s", e));
            substr = "Whoops!";
        }

        return substr.concat(replacement);
    }
}