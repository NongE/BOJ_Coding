import java.util.*;
import java.io.*;
import java.util.stream.Stream;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }

}

public class BOJ_1753 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] VE = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int V = VE[0];
        int E = VE[1];

        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < E; i++) {
            int[] uvw = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(uvw[0]).add(new Node(uvw[1], uvw[2]));
        }

        int[] shortDistance = new int[100000];
        Arrays.fill(shortDistance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        shortDistance[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int index = node.getIndex();
            int dist = node.getDistance();

            if (shortDistance[index] < dist) {
                continue;
            }
            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = shortDistance[index] + graph.get(index).get(i).getDistance();
                if (cost < shortDistance[graph.get(index).get(i).getIndex()]) {
                    shortDistance[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
                }
            }

        }

        for (int i = 1; i <= V; i++) {
            if (shortDistance[i] == Integer.MAX_VALUE) {
                bw.write("INF" + "\n");
            } else {
                bw.write(shortDistance[i] + "\n");
            }
        }
        bw.flush();
        bw.close();

    }
}