import java.util.Scanner;

public class EAPC10F {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        while (testCases-- != 0) {
            int[] profitDay = new int[scanner.nextInt()];
            for (int i = 0; i < profitDay.length; i++) {
                profitDay[i] = scanner.nextInt();
            }
            if (profitDay.length == 1) {
                System.out.println("1 1");
                continue;
            }
            int maxProf = profitDay[0];
            int minPos = 0;
            int maxPos = 1;
            int endMaxProf = -1000;
            int endMinPos = -1;
            int endMaxPos = -1;
            for (int i = 1; i < profitDay.length; i++) {
                if (profitDay[i] > maxProf && maxProf < 0) {
                    minPos = i;
                    maxPos = i;
                    maxProf = profitDay[i];
                    if (maxProf > endMaxProf) {
                        endMinPos = minPos;
                        endMaxPos = maxPos;
                        endMaxProf = maxProf;
                    }
                } else {
                    if (maxProf > endMaxProf) {
                        endMinPos = minPos;
                        endMaxPos = i;
                        endMaxProf = maxProf;
                    }
                    maxProf += profitDay[i];
                    maxPos = i;
                    if (maxProf > endMaxProf) {
                        endMinPos = minPos;
                        endMaxPos = i;
                        endMaxProf = maxProf;
                    }
                    if (endMaxProf == profitDay[0]) {
                        endMaxPos = 0;
                        endMinPos = 0;
                    }
                }
            }
            endMinPos++;
            endMaxPos++;
            System.out.println(endMinPos + " " + endMaxPos);
        }
    }
}
