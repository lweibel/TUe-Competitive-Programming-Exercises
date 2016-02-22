import java.util.Scanner;

public class BAPC12E {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        while (testCases-- != 0) {
            String word = scanner.nextLine();
            int matrixLength = (int) Math.sqrt(word.length());
            char[][] encodeMatrix = new char[matrixLength][matrixLength];
            int counter = 0;
            for (int i = 0; i < encodeMatrix.length; i++) {
                for (int j = 0; j < encodeMatrix[i].length; j++) {
                    encodeMatrix[i][j] = word.charAt(counter);
                    counter++;
                }
            }
            for (int i = encodeMatrix.length - 1; i >= 0; i--) {
                for (int j = 0; j < encodeMatrix.length; j++) {
                    System.out.print(encodeMatrix[j][i]);
                }
            }
            System.out.println();
        }
    }
}
