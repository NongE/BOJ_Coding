import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main {

    public static class Node implements Comparable<Node> {

        int[] index;
        int dist;

        public Node(int[] index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        public int[] getIndex() {
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

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] MN = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = MN[0];
        int N = MN[1];

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] mapPay = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(mapPay[i], Integer.MAX_VALUE);
        }

        boolean[][] visited = new boolean[N][M];

        int[] moveN = { 1, -1, 0, 0 };
        int[] moveM = { 0, 0, 1, -1 };

        PriorityQueue<Node> q = new PriorityQueue<Node>();

        q.offer(new Node(new int[] { 0, 0 }, 0));
        mapPay[0][0] = 0;

        while (!q.isEmpty()) {
            Node point = q.poll();

            int[] pointIndex = point.getIndex();
            int indexN = pointIndex[0];
            int indexM = pointIndex[1];

            if (visited[indexN][indexM] == false) {
                for (int i = 0; i < 4; i++) {
                    int tn = indexN + moveN[i];
                    int tm = indexM + moveM[i];

                    if (tn >= 0 && tn < N && tm >= 0 && tm < M) {

                        if (map[tn][tm] == 1) {
                            if (mapPay[tn][tm] > mapPay[indexN][indexM] + 1) {
                                mapPay[tn][tm] = mapPay[indexN][indexM] + 1;
                                q.offer(new Node(new int[] { tn, tm }, mapPay[tn][tm]));
                            }
                        } else if (map[tn][tm] == 0) {
                            if (mapPay[tn][tm] > mapPay[indexN][indexM]) {
                                mapPay[tn][tm] = mapPay[indexN][indexM];
                                q.offer(new Node(new int[] { tn, tm }, mapPay[tn][tm]));
                            }

                        }
                    }
                }
                visited[indexN][indexM] = true;
            }

        }

        bw.write(mapPay[N - 1][M - 1] + "\n");
        bw.flush();
        bw.close();

    }

}
