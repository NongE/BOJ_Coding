import java.util.*;
import java.io.*;
import java.util.stream.Stream;

class Node implements Comparable<Node> {
    int index;
    int time;

    @Override
    public int compareTo(Node other) {
        if (this.time < other.time) {
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

        int[] NK = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];

        boolean[] visited = new boolean[K + 1];
        Queue<Node> pq = new PriorityQueue<>();

        int[] result = new int[K + 1];
        Arrays.fill(result, Integer.MAX_VAULE);

        pq.offer(new Node(N, 0));
        result[N] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.time > result[node.index]) {
                continue;
            } else {

                if (node.index * 2 <= 100000 && !visited[node.index * 2]) {
                    if (result[node.index * 2] > node.item) {
                        result[node.index * 2] = node.item;
                        pq.offer(new Node(node.index * 2, node.tiem));
                    }

                }
                if (node.index + 1 <= 100000 && !visited[node.index + 1]) {
                    if (result[node.index + 1] > node.item) {
                        result[node.index + 1] = node.item;
                        pq.offer(new Node(node.index + 1, node.tiem));
                    }
                }
                if (node.index - 1 <= 100000 && !visited[node.index - 1]) {
                    if (result[node.index - 1] > node.item) {
                        result[node.index - 1] = node.item;
                        pq.offer(new Node(node.index - 1, node.tiem));
                    }
                }

            }
        }
        for (int i = 0; i <= K; i++) {
            System.out.print(result[i] + " ");
        }

    }
}