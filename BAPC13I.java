import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BAPC13I {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            new BAPC13I().run();
        }
    }

    public void run() {
        int numAvailAttr = scanner.nextInt();
        int output = 1;
        Map<String, Integer> disguises = new HashMap<>();
        for (int i = 0; i < numAvailAttr; i++) {
            String item = scanner.next();
            String body = scanner.next();
            if (disguises.containsKey(body)) {
                int curCount = disguises.get(body);
                disguises.put(body, curCount + 1);
            } else {
                disguises.put(body, 1);
            }
        }
        for (Integer value : disguises.values()) {
            output *= (value + 1);
        }
        System.out.println(output - 1);
    }
}
