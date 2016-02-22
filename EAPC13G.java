import java.util.*;

class EAPC13G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            boolean real = true;
            String message = scanner.next();
            HashMap<Character, Integer> charOccurences = new HashMap<>();
            for (int i = 0; i < message.length(); i++) {
                charOccurences.put(message.charAt(i), 0);
            }
            for (int i = 0; i < message.length(); i++) {
                charOccurences.put(message.charAt(i), charOccurences.get(message.charAt(i)) + 1);
                if (charOccurences.get(message.charAt(i)) == 3) {
                    if (i == message.length() - 1) {
                        System.out.println("FAKE");
                        real = false;
                        break;
                    } else if (message.charAt(i + 1) != message.charAt(i)) {
                        System.out.println("FAKE");
                        real = false;
                        break;
                    } else {
                        charOccurences.put(message.charAt(i), 0);
                        i++;
                    }
                }
            }
            if (real == true) {
                System.out.println("OK");
            }
        }
    }
}
