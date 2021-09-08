import java.util.*;
import java.util.stream.Stream;
import java.io.*;

class Node implements Comparable<Node> {

    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
        if (this.weight < other.weight) {
            return -1;
        } else {
            return 1;
        }
    }
}

public class Main {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static int[] dijkstra(int start, int end, int size) {

        Queue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        int[] getDist = new int[size + 1];
        Arrays.fill(getDist, Integer.MAX_VALUE);

        getDist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.weight > getDist[node.index]) {
                continue;
            } else {
                for (int i = 0; i < graph.get(node.index).size(); i++) {
                    int cost = getDist[node.index] + graph.get(node.index).get(i).weight;
                    if (cost < getDist[graph.get(node.index).get(i).index]) {
                        getDist[graph.get(node.index).get(i).index] = cost;
                        pq.offer(new Node(graph.get(node.index).get(i).index, cost));
                    }
                }
            }
        }
        return getDist;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NE = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NE[0];
        int E = NE[1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < E; i++) {
            int[] info = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(info[0]).add(new Node(info[1], info[2]));
            graph.get(info[1]).add(new Node(info[0], info[2]));
        }

        int[] needVisit = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] needVisit_1 = dijkstra(needVisit[0], needVisit[1], N);
        int[] needVisit_2 = dijkstra(needVisit[1], needVisit[0], N);
        int[] start_1 = dijkstra(1, needVisit[0], N);

        if (start_1[needVisit[0]] == Integer.MAX_VALUE || start_1[needVisit[1]] == Integer.MAX_VALUE
                || needVisit_1[needVisit[1]] == Integer.MAX_VALUE || needVisit_2[N] == Integer.MAX_VALUE
                || needVisit_1[N] == Integer.MAX_VALUE) {
            bw.write(-1 + "\n");
        } else {
            int d1 = start_1[needVisit[0]] + needVisit_1[needVisit[1]] + needVisit_2[N];
            int d2 = start_1[needVisit[1]] + needVisit_1[needVisit[1]] + needVisit_1[N];
            int d = Math.min(d1, d2);
            bw.write(d + "\n");
        }

        bw.flush();
        bw.close();
    }
}