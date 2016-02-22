import java.util.*;

class EAPC13H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            int stockPrice = scanner.nextInt();
            int parts = scanner.nextInt();
            while (parts-- != 0) {
                stockPrice += (scanner.nextInt() * scanner.nextInt());
            }
            System.out.println(stockPrice);
        }
    }
}
