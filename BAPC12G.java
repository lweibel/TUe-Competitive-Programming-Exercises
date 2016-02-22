import java.util.Scanner;

public class BAPC12G {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            new BAPC12G().goodCoalition();
        }
    }

    public void goodCoalition() {
        // Amount of "items"
        int n = scanner.nextInt();
        // Less than 76 "weight'
        int m = 76;
        // "item weight"
        int[] seatsWon = new int[n + 1];
        // "item value"
        double[] probComplete = new double[n + 1];
        // Arrays holding party information
        for (int i = 1; i <= n; i++) {
            seatsWon[i] = scanner.nextInt();
            probComplete[i] = scanner.nextDouble() / 100;
        }
        //dp array
        double[][] dp = new double[n + 1][m + 1];
        // Initializing base values
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = -1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int seats = Math.min(j, seatsWon[i]);
                dp[i][j] = dp[i - 1][j];
                double v = probComplete[i];
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - seats] * v);
            }
        }
        System.out.println(dp[n][m] * 100.0);
    }
}
