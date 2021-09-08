import java.util.*;
import java.io.*;
import java.util.stream.Stream;

class Node implements Comparable<Node> {

    int index;
    int dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    public int getIndex() {
        return index;
    }

    public int getDist() {
        return dist;
    }

    @Override
    public int compareTo(Node other) {
        if (this.dist < other.dist) {
            return -1;
        } else {
            return 1;
        }

    }

}

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> arr = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<Node>());
        }

        for (int i = 0; i < M; i++) {
            int[] info = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr.get(info[0]).add(new Node(info[1], info[2]));
        }

        int[] SE = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = SE[0];
        int end = SE[1];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] pay = new int[N + 1];

        Arrays.fill(pay, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));

        pay[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int index = node.getIndex();
            int dist = node.getDist();

            if (dist > pay[index]) {
                continue;
            } else {
                for (int i = 0; i < arr.get(index).size(); i++) {
                    Node tmp = arr.get(index).get(i);
                    int cost = pay[index] + tmp.getDist();
                    if (cost < pay[tmp.getIndex()]) {
                        pay[tmp.getIndex()] = cost;
                        pq.offer(new Node(tmp.getIndex(), cost));
                    }
                }

            }

        }

        bw.write(pay[end] + "\n");
        bw.flush();
        bw.close();

    }
}