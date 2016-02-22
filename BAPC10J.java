import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BAPC10J {

    static Scanner scanner = new Scanner(System.in);
    Node[] A, B;

    public void run() {
        int hWords = scanner.nextInt();
        int vWords = scanner.nextInt();
        A = new Node[hWords];
        B = new Node[vWords];

        int n = 2500;
        char[][] boxes = new char[n][n];
        HashMap<Point, Integer> horzWor = new HashMap();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boxes[i][j] = ' ';
            }
        }

        for (int i = 0; i < hWords; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String word = scanner.next();
            for (int j = 0; j < word.length(); j++) {
                boxes[x + j][y] = word.charAt(j);
                horzWor.put(new Point(x + j, y), i);
            }
            A[i] = new Node();
        }

        for (int i = 0; i < vWords; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String word = scanner.next();
            B[i] = new Node();

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (c != boxes[x][j + y] && boxes[x][j + y] != ' ') {
                    B[i].adj.add(horzWor.get(new Point(x, j + y)));
                }
            }
        }

        for (int i = 0; i < hWords; i++) B[i].match = -1; // reset matching
        int M = 0; // matching size
        for (int i = 0; i < vWords; i++) { // incremental approach
            for (int j = 0; j < vWords; j++) B[j].visited = false; // reset DFS
            if (augment(i)) M++; // if augmenting path, then increase matching
        }
        System.out.println(hWords + vWords - M);
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            new BAPC10J().run();
        }
    }

    boolean augment(int i) {
        if (B[i].visited) return false;
        B[i].visited = true;
        for (Integer j : B[i].adj) {
            if (A[j].match == -1 || augment(A[j].match)) { // check for augmenting path
                A[j].match = i; // directly updates matching
                return true;
            }
        }
        return false;
    }
}

class Node {
    ArrayList<Integer> adj = new ArrayList<>();
    boolean visited = false;
    int match = -1;
}