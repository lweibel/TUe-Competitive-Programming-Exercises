import java.util.Scanner;

public class EAPC13B {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            new EAPC13B().run();
        }
    }

    public void run() {
        int numMics = scanner.nextInt();
        int backgroundNoise = scanner.nextInt();
        int listenX = scanner.nextInt();
        int listenY = scanner.nextInt();
        int[] micArrayX = new int[numMics];
        int[] micArrayY = new int[numMics];
        int[] micArrayS = new int[numMics];
        double[] strSignalMics = new double[numMics];
        double compareSum = 0;
        boolean noise = true;

        for (int i = 0; i < numMics; i++) {
            micArrayX[i] = scanner.nextInt();
            micArrayY[i] = scanner.nextInt();
            micArrayS[i] = scanner.nextInt();
        }

        for (int i = 0; i < numMics; i++) {
            double eucliDistance = Math.pow(listenX - micArrayX[i], 2) + Math.pow(listenY - micArrayY[i], 2);
            strSignalMics[i] = ((double) micArrayS[i] / eucliDistance);
            compareSum += strSignalMics[i];
        }

        for (int i = 0; i < numMics; i++) {
            if (strSignalMics[i] > 6 * (backgroundNoise + (compareSum - strSignalMics[i]))) {
                System.out.println(i + 1);
                noise = false;
                break;
            }
        }

        if (noise) {
            System.out.println("NOISE");
        }
    }
}
