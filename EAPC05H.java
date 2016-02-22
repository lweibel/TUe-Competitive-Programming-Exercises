import java.util.*;

class EAPC05H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            int numberStones = scanner.nextInt();
            int timeAvailable = scanner.nextInt();
            int maxMass = scanner.nextInt();
            int[] t = new int[numberStones + 1];
            int[] m = new int[numberStones + 1];
            int[] v = new int[numberStones + 1];
            for (int i = 1; i < t.length; i++) {
                t[i] = scanner.nextInt();
                m[i] = scanner.nextInt();
                v[i] = scanner.nextInt();
            }
            int[][][] space = new int[timeAvailable + 1][maxMass + 1][numberStones + 1];
            for (int timeLeft = 0; timeLeft < space.length; timeLeft++) {
                for (int weightCanCarry = 0; weightCanCarry < space[timeLeft].length; weightCanCarry++) {
                    for (int items = 1; items < space[timeLeft][weightCanCarry].length; items++) {
                        if (m[items] > weightCanCarry || t[items] > timeLeft) {
                            space[timeLeft][weightCanCarry][items] = space[timeLeft][weightCanCarry][items - 1];
                        } else {
                            space[timeLeft][weightCanCarry][items] = Math.max(space[timeLeft][weightCanCarry][items - 1], space[timeLeft - t[items]][weightCanCarry - m[items]][items - 1] + v[items]);
                        }
                    }
                }
            }
            System.out.println(space[timeAvailable][maxMass][numberStones]);
        }
    }
}

