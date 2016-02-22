import java.util.*;

class EAPC08F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            String watWord = scanner.next();
            int numDic = scanner.nextInt(); //my favorite variable name ever
            String[] dicWords = new String[numDic];
            int substitutions = Integer.MAX_VALUE;
            int whatSheSay = -1;
            for (int i = 0; i < dicWords.length; i++) {
                int counter = 0;
                dicWords[i] = scanner.next();
                for (int j = 0; j < watWord.length(); j++) {
                    if (watWord.charAt(j) != dicWords[i].charAt(j)) {
                        counter++;
                    }
                }
                if (counter < substitutions) {
                    substitutions = counter;
                    whatSheSay = i;
                }
            }
            System.out.println(dicWords[whatSheSay]);
        }
    }
}

