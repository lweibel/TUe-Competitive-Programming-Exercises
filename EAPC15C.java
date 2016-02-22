import java.util.Scanner;

public class EAPC15C {

    static Scanner scanner = new Scanner(System.in);

    public void run() {
        int cutsMade = scanner.nextInt();
        double sum = 0;
        double x = 0;
        double y = 0;
        String dir;
        double x2 = 0;
        double y2 = 0;
        double answer = 0;

        for (int i = 0; i < cutsMade; i++) {
            dir = scanner.next();
            int length = scanner.nextInt();
            switch (dir) {
                case "x":
                    x2 = x + length;
                    break;
                case "y":
                    x2 = x + length * .5;
                    y2 = y + length * Math.sqrt(0.75);
                    break;
                case "z":
                    x2 = x + length * -.5;
                    y2 = y + length * Math.sqrt(0.75);
                    break;
                default:
                    break;
            }
            sum += (x * y2 - x2 * y);
            x = x2;
            y = y2;
        }
        answer = (.5 * Math.abs(sum / (.5 * Math.sqrt(0.75))));
        System.out.println(Math.round(answer));
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            new EAPC15C().run();
        }
    }

}


