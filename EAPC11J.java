import java.util.Scanner;

public class EAPC11J {

    static Scanner scanner = new Scanner(System.in);

    public void run() {
        int numShurikens = scanner.nextInt();
        int maxTake = scanner.nextInt();
        int lastTaken = scanner.nextInt();
        int[] shurikenStack = new int[numShurikens];

        for (int i = 1; i < numShurikens; i++) {
            for (int j = 1; j <= Math.min(i, maxTake); j++) {
                if (shurikenStack[i - j] == 0 || shurikenStack[i - j] == j) {
                    if (shurikenStack[i] == 0) {
                        shurikenStack[i] = j;
                    } else {
                        shurikenStack[i] = -1;
                    }
                }
            }
        }
        for (int i = 1; i <= Math.min(numShurikens, maxTake); i++) {
            if ((shurikenStack[numShurikens - i] == 0 || shurikenStack[numShurikens - i] == i) && lastTaken != i) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
    }

    public static void main(String[] args) {
        int testCases = Integer.parseInt(scanner.nextLine());
        while (testCases-- != 0) {
            new EAPC11J().run();
        }
    }
}


