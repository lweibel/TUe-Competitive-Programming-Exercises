import java.util.Scanner;

public class EAPC15D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            int heiwid = scanner.nextInt();
            int count = 0;
            boolean again = true;
            char board[][] = new char[heiwid + 2][heiwid + 2];
            for (int i = 1; i < board.length - 1; i++) {
                String row = scanner.next();
                for (int j = 1; j < board[i].length - 1; j++) {
                    board[i][j] = row.charAt(j - 1);
                }
            }
            while (again) {
                again = false;
                for (int i = 1; i < board.length - 1; i++) {
                    for (int j = 1; j < board[i].length - 1; j++) {
                        if (board[i][j] == 'w') {
                            if (board[i - 1][j - 1] == '-') {
                                board[i - 1][j - 1] = 'w';
                                count++;
                                again = true;
                            }
                            if (board[i - 1][j] == '-') {
                                board[i - 1][j] = 'w';
                                again = true;
                                count++;
                            }
                            if (board[i][j - 1] == '-') {
                                board[i][j - 1] = 'w';
                                again = true;
                                count++;
                            }
                            if (board[i][j] == '-') {
                                board[i][j] = 'w';
                                again = true;
                                count++;
                            }
                            if (board[i + 1][j] == '-') {
                                board[i + 1][j] = 'w';
                                again = true;
                                count++;
                            }
                            if (board[i][j + 1] == '-') {
                                board[i][j + 1] = 'w';
                                again = true;
                                count++;
                            }
                            if (board[i + 1][j + 1] == '-') {
                                board[i + 1][j + 1] = 'w';
                                again = true;
                                count++;
                            }
                            if (board[i + 1][j - 1] == '-') {
                                board[i + 1][j - 1] = 'w';
                                again = true;
                                count++;
                            }
                            if (board[i - 1][j + 1] == '-') {
                                board[i - 1][j + 1] = 'w';
                                again = true;
                                count++;
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
