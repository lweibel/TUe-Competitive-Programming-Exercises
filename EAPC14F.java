import java.util.*;

class EAPC14F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            long runway = Math.round(scanner.nextDouble() / 10);
            if (runway == 0) {
                System.out.println("18");
            } else if (runway > 18) {
                System.out.println(String.format("%02d", runway - 18));
            } else if (runway < 10) {
                System.out.println(String.format("%02d", runway));
            } else {
                System.out.println(runway);
            }
        }
    }
}
