import java.util.*;

class EAPC12A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            int mosquitoes = scanner.nextInt();
            int count = 0;
            int[] mosqX = new int[mosquitoes];
            int[] mosqY = new int[mosquitoes];
            for (int i = 0; i < mosqX.length; i++) {
                mosqX[i] = scanner.nextInt();
                mosqY[i] = scanner.nextInt();
            }
            int swats = scanner.nextInt();
            int[] swatX = new int[swats];
            int[] swatY = new int[swats];
            for (int i = 0; i < swatX.length; i++) {
                swatX[i] = scanner.nextInt();
                swatY[i] = scanner.nextInt();
            }
            for (int i = 0; i < swatX.length; i++) {
                for (int j = 0; j < mosqX.length; j++) {
                    if ((mosqX[j] >= swatX[i] - 50 && mosqX[j] <= swatX[i] + 50) && (mosqY[j] >= swatY[i] - 50 && mosqY[j] <= swatY[i] + 50)) {
                        count++;
                        mosqX[j] = 10000000;
                        mosqY[j] = 10000000;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
