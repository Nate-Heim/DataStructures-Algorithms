import java.util.ArrayList;
import java.util.List;

public class HashFunction{
    static int M = 5;

    static int encode(char key) {
        return (13 * key) % M;
    }

    public static void main(String[] args) {
        String input = "EASYQUTION";
        List<Integer> hashCodes = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            hashCodes.add(encode(ch));
        }

        System.out.println(hashCodes);
    }
}