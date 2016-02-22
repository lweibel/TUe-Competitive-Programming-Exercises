import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11B {

    static Scanner scanner = new Scanner(System.in);

    public void run() {
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        int delay = scanner.nextInt();
        int startY = 0;
        int startX = 0;

        Node[][] nodeGrid = new Node[height][width];

        char[][] charGrid = new char[height][width];
        for (int y = 0; y < charGrid.length; y++) {
            String row = scanner.next();
            for (int x = 0; x < charGrid[y].length; x++) {
                charGrid[y][x] = row.charAt(x);
                nodeGrid[y][x] = new Node();
            }
        }

        for (int y = 0; y < nodeGrid.length; y++) {
            for (int x = 0; x < nodeGrid[y].length; x++) {
                if (charGrid[y][x] == '#') {
                    continue;
                } else {
                    if (charGrid[y][x] == 'S') {
                        startY = y;
                        startX = x;
                    }
                    int[] localx = {-1, 0, 1, 0};
                    int[] localy = {0, 1, 0, -1};
                    for (int i = 0; i < 4; i++) {
                        if (y + localy[i] >= 0 && y + localy[i] < height && x + localx[i] >= 0 && x + localx[i] < width) {
                            if (charGrid[y + localy[i]][x + localx[i]] == '.') {
                                nodeGrid[y][x].adj.add(new Edge(1, nodeGrid[y + localy[i]][x + localx[i]]));
                            } else if (charGrid[y + localy[i]][x + localx[i]] == '@') {
                                nodeGrid[y][x].adj.add(new Edge(1 + delay, nodeGrid[y + localy[i]][x + localx[i]]));
                            }
                        }
                    }
                }

            }
        }

        boolean run = true;
        dijkstra(nodeGrid[startY][startX]);
        for (int i = 0; i < width; i++) {
            if (charGrid[height - 1][i] != '#') {
                System.out.println(nodeGrid[height - 1][i].dist + 1);
                run = false;
                break;
            } else if (charGrid[0][i] != '#') {
                System.out.println(nodeGrid[0][i].dist + 1);
                run = false;
                break;
            }
        }
        if (run) {
            for (int i = 0; i < height; i++) {
                if (charGrid[i][0] != '#') {
                    System.out.println(nodeGrid[i][0].dist + 1);
                    break;
                } else if (charGrid[i][width - 1] != '#') {
                    System.out.println(nodeGrid[i][width - 1].dist + 1);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            new B11B().run();
        }
    }

    class Edge {
        Node target;
        int weight;

        Edge(int i, Node j) {
            weight = i;
            target = j;
        }
    }

    class Node {
        ArrayList<Edge> adj = new ArrayList<>();
        int dist = Integer.MAX_VALUE / 2;
    }

    class NodeDist implements Comparable<NodeDist> {
        int d;
        Node i;

        NodeDist(Node index, int dist) {
            i = index;
            d = dist;
        }

        @Override
        public int compareTo(NodeDist other) {
            return (d - other.d);
        }
    }

    void dijkstra(Node source) {
        PriorityQueue<NodeDist> Q = new PriorityQueue<>();
        source.dist = 0;
        Q.add(new NodeDist(source, 0));
        while (!Q.isEmpty()) {
            NodeDist nd = Q.poll();
            Node k = nd.i;
            int d = nd.d;
            if (k.dist < d) continue;
            for (Edge e : k.adj) {
                int newDist = d + e.weight;
                if (newDist < e.target.dist) {
                    e.target.dist = newDist;
                    Q.add(new NodeDist(e.target, newDist));
                }
            }
        }
    }
}


