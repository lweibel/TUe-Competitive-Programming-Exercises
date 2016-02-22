import java.util.*;

class EAPC13E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int testCases = Integer.parseInt(scanner.nextLine());
        while (testCases-- != 0) {
            int numberWords = Integer.parseInt(scanner.nextLine());

            String words = scanner.nextLine();
            String[] firstPublic = words.split("\\s+");

            String words2 = scanner.nextLine();
            String[] secondPublic = words2.split("\\s+");

            String words3 = scanner.nextLine();
            String[] ciphertext = words3.split("\\s+");

            String[] plaintext = new String[firstPublic.length];
            for (int i = 0; i < firstPublic.length; i++) {
                for (int j = 0; j < secondPublic.length; j++) {
                    if (firstPublic[i].equals(secondPublic[j])) {
                        plaintext[i] = ciphertext[j];
                    }
                }
            }
            for (int i = 0; i < plaintext.length; i++) {
                System.out.print(plaintext[i]);
                if (i < plaintext.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
