import java.util.*;

class EAPC06D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            String winString = scanner.next();
            String frontSide = scanner.next();
            String backSide = scanner.next();
            int startIndex = 0;
            int count = 0;
            for (int i = 0; i < winString.length(); i++) {
                for (int j = startIndex; j < frontSide.length(); j++) {
                    if (frontSide.charAt(j) == winString.charAt(i) || backSide.charAt(j) == winString.charAt(i) || frontSide.charAt(j) == '*' || backSide.charAt(j) == '*') {
                        startIndex = j + 1;
                        count++;
                        break;
                    }
                }
            }
            if (count == winString.length()) {
                System.out.println("win");
            } else {
                System.out.println("lose");
            }
        }
    }
}

