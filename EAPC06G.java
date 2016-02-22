import java.util.*;

class EAPC06G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            String pattern = scanner.next();
            String text = scanner.next();
            int count = 0;
            int m = pattern.length();
            int n = text.length();
            int[] partialMatchTable = new int[m + 1];
            int i = 0;
            int j = -1;
            partialMatchTable[i] = j;
            while (i < m) {
                while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    j = partialMatchTable[j];
                }
                i++;
                j++;
                partialMatchTable[i] = j;
            }
            i = 0;
            j = 0;
            while (i < n) {
                while (j >= 0 && text.charAt(i) != pattern.charAt(j)) {
                    j = partialMatchTable[j];
                }
                i++;
                j++;
                if (j == m) {
                    count++;
                    j = partialMatchTable[j];
                }
            }
            System.out.println(count);
        }
    }
}

