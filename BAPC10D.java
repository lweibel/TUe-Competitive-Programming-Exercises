import java.util.Scanner;

public class BAPC10D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            int nHole = scanner.nextInt();
            System.out.println(ropesCut(nHole));
        }
    }

    public static int ropesCut(int n) {
        double cutRopes = (Math.ceil(n / 2) + Math.ceil(n / 2) - Math.ceil(Math.floor((n - 1) / 3) / 2));
        return (int) cutRopes;
    }
}
