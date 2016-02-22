import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

class BAPC10I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while (testCases-- != 0) {
            String weirdPass = scanner.next();
            List<Character> realPass = new LinkedList<>();
            ListIterator cursorIterator = realPass.listIterator();
            for (int i = 0; i < weirdPass.length(); i++) {
                if (weirdPass.charAt(i) == '<') {
                    if (cursorIterator.hasPrevious()) {
                        cursorIterator.previous();
                    }
                } else if (weirdPass.charAt(i) == '>') {
                    if (cursorIterator.hasNext()) {
                        cursorIterator.next();
                    }
                } else if (weirdPass.charAt(i) == '-') {
                    if (cursorIterator.hasPrevious()) {
                        cursorIterator.previous();
                        cursorIterator.remove();
                    }
                } else {
                    cursorIterator.add(weirdPass.charAt(i));
                }
            }
            try {
                for (Character letter : realPass) {
                    out.write(letter);
                }
                out.newLine();
                out.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}

