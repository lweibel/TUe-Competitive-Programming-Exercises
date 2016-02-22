import java.util.*;

class EAPC10B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            int[] numberDigits = new int[10];
            int[] subSets = new int[4];
            int sameNum = 0;
            boolean niceOrNah = true;
            for (int i = 0; i < 2; i++) {
                subSets[i] = scanner.nextInt();
                if (i == 1) {
                    int x = scanner.nextInt();
                    subSets[2] = x / 100;
                    subSets[3] = x % 100;
                    if (subSets[3] < 10) {
                        numberDigits[0] += 1;
                    }
                }
            }
            for (int i = 0; i < subSets.length; i++) {
                for (int j = 0; j < String.valueOf(subSets[i]).length(); j++) {
                    String number = String.valueOf(subSets[i]);
                    int singleDig = Character.digit(number.charAt(j), 10);
                    numberDigits[singleDig] += 1;
                }
            }
            for (int numberTimes : numberDigits) {
                if (numberTimes > 0 && sameNum == 0) {
                    sameNum = numberTimes;
                }
                if (numberTimes > 0 && sameNum > 0 && numberTimes != sameNum) {
                    niceOrNah = false;
                }
            }
            if (!niceOrNah) {
                System.out.println("no");
                continue;
            }
            Arrays.sort(subSets);
            if (subSets[0] + subSets[1] + subSets[2] == subSets[3]) {
                niceOrNah = true;
            } else if (subSets[0] + subSets[1] == subSets[2] + subSets[3]) {
                niceOrNah = true;
            } else if (subSets[0] + subSets[2] == subSets[1] + subSets[3]) {
                niceOrNah = true;
            } else if (subSets[0] + subSets[3] == subSets[1] + subSets[2]) {
                niceOrNah = true;
            } else {
                niceOrNah = false;
            }

            if (niceOrNah) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
