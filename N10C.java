import java.util.Scanner;

public class N10C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        while (testCases-- != 0) {
            char[] name = scanner.next().toCharArray();
            int[] minMoves = new int[name.length];
            int minLetterShifts = 0;
            for (int i = 0; i < name.length; i++) {
                if (Math.abs('A' - name[i]) <= 'Z' - name[i] + 1) {
                    minMoves[i] = Math.abs('A' - name[i]);
                    minLetterShifts += minMoves[i];
                } else {
                    minMoves[i] = 'Z' - name[i] + 1;
                    minLetterShifts += minMoves[i];
                }
            }

            int outputMin = minLetterShifts + minMoves.length - 1;
            for (int i = 0; i < minMoves.length; i++) {
                int testMin = minLetterShifts;
                int manualShift = 0;
                for (int j = 0; j < i; j++) {
                    if (testMin == 0) {
                        if (minLetterShifts + manualShift < outputMin) {
                            outputMin = minLetterShifts + manualShift;
                            break;
                        }
                    }
                    testMin -= minMoves[j];
                    if (j > 0) {
                        manualShift++;
                    }
                }
                if (testMin == 0) {
                    if (minLetterShifts + manualShift < outputMin) {
                        outputMin = minLetterShifts + manualShift;
                        break;
                    }
                }
                manualShift *= 2;
                for (int j = minMoves.length - 1; j >= i; j--) {
                    testMin -= minMoves[j];
                    manualShift++;
                    if (testMin == 0) {
                        if (minLetterShifts + manualShift < outputMin) {
                            outputMin = minLetterShifts + manualShift;
                            break;
                        }
                    }
                }
            }

            /*Trying other way*/
            for (int i = minMoves.length - 1; i > 0; i--) {
                int testMin = minLetterShifts;
                int manualShift = 0;
                for (int j = minMoves.length - 1; j > i; j--) {

                    testMin -= minMoves[j];
                    if (j < minMoves.length - 1) {
                        manualShift++;
                    }
                }
                manualShift *= 2;
                manualShift++;
                if (testMin == 0) {
                    if (minLetterShifts + manualShift < outputMin) {
                        outputMin = minLetterShifts + manualShift;
                        break;
                    }
                }
                for (int j = 0; j <= i; j++) {
                    testMin -= minMoves[j];
                    manualShift++;
                    if (testMin == 0) {
                        if (minLetterShifts + manualShift < outputMin) {
                            outputMin = minLetterShifts + manualShift;
                            break;
                        }
                    }
                }
            }
            System.out.println(outputMin);
        }
    }
}
