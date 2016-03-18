import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BAPC13F {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            new BAPC13F().run();
        }
    }

    public void run() {
        int numCities = scanner.nextInt();
        int numPilots = scanner.nextInt();
        Node[] V = new Node[numCities];
        int N = numCities;

        for (int i = 0; i < V.length; i++) {
            V[i] = new Node();
        }

        for (int i = 0; i < numPilots; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            A--;
            B--;
            // subtracting one for array
            V[A].adj.add(new Edge(B, 1));
            V[B].adj.add(new Edge(A, 1));
        }

        class NW implements Comparable<NW> {
            int i, w, p;

            NW(int index, int weight, int parent) {
                this.i = index;
                this.w = weight;
                this.p = parent;
            }

            @Override
            public int compareTo(NW o) {
                return (w - o.w);
            }
        }

        ArrayList<NW> L = new ArrayList<>();
        ArrayList<NW> L2 = new ArrayList<>();

        PriorityQueue<NW> Q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            Q.add(new NW(i, Integer.MAX_VALUE / 2, -1));
        }

        while (!Q.isEmpty()) {
            NW nw = Q.poll();
            int k = nw.i;
            if (V[k].inTree) continue;
            V[k].inTree = true;
            L.add(nw);
            for (Edge e : V[k].adj) {
                if (V[e.target].inTree) continue;
                Q.add(new NW(e.target, e.weight, k));
            }
        }

        for (int i = 0; i < L.size(); i++) {
            if (L.get(i).p >= 0) L2.add(L.get(i));
        }

        System.out.println(L2.size());
    }

    class Node {
        ArrayList<Edge> adj = new ArrayList<>();
        boolean inTree = false;
    }

    class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}