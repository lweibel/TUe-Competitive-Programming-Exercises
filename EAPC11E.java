import java.util.Scanner;

public class EAPC11E {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        while (testCases-- != 0) {
            String sequence = scanner.next();
            int x = 0;
            int y = 0;
            int sign = 1;
            DiceCube dice = new DiceCube();
            for (int i = 0; i < sequence.length(); i++) {
                if (sequence.charAt(i) == '-') {
                    sign = -1;
                } else if (sequence.charAt(i) == '+') {
                    sign = 1;
                } else if (sequence.charAt(i) == '.') {
                    break;
                } else if (sequence.charAt(i) == 'X') {
                    x += sign;
                    dice.rotateX(sign);
                } else if (sequence.charAt(i) == 'Y') {
                    y += sign;
                    dice.rotateY(sign);
                } else {
                    int end = i;
                    while (sequence.charAt(end) != '+' && sequence.charAt(end) != '-' && sequence.charAt(end) != '.' && sequence.charAt(end) != 'X' && sequence.charAt(end) != 'Y') {
                        end++;
                    }
                    int multiply = Integer.parseInt(sequence.substring(i, end));
                    if (sequence.charAt(end) == 'X') {
                        x += (sign * multiply);
                        i += (end - i);
                        int rotations = multiply % 4;
                        while (rotations-- != 0) {
                            dice.rotateX(sign);
                        }
                    } else {
                        y += (sign * multiply);
                        i += (end - i);
                        int rotations = multiply % 4;
                        while (rotations-- != 0) {
                            dice.rotateY(sign);
                        }
                    }
                }
            }
            System.out.println("position (" + x + "," + y + "), " + dice.getFront() + " dots");
        }
    }
}

class DiceCube {
    int front = 1;
    int top = 5;
    int right = 4;
    int left = 3;
    int bottom = 2;
    int back = 6;

    void rotateX(int sign) {
        if (sign == 1) {
            int temp = front;
            front = left;
            left = back;
            back = right;
            right = temp;
        } else if (sign == -1) {
            int temp = front;
            front = right;
            right = back;
            back = left;
            left = temp;
        }
    }

    void rotateY(int sign) {
        if (sign == 1) {
            int temp = front;
            front = bottom;
            bottom = back;
            back = top;
            top = temp;
        } else if (sign == -1) {
            int temp = front;
            front = top;
            top = back;
            back = bottom;
            bottom = temp;
        }
    }

    int getFront() {
        return front;
    }
}
