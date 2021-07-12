import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] point = br.readLine().split(" ");

        int N = Integer.parseInt(point[0]);
        int M = Integer.parseInt(point[1]);


        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < tmp.length(); j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        // bfs
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];

        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tn = tmp[0];
            int tm = tmp[1];
            if (!isVisited[tn][tm]) {

                isVisited[tn][tm] = true;
                // 우측
                if (tm + 1 <= (M - 1) && map[tn][tm + 1] == 1 && !isVisited[tn][tm + 1]) {
                    queue.offer(new int[]{tn, tm + 1});
                    if (map[tn][tm + 1] == 1) {
                        map[tn][tm + 1] = map[tn][tm] + 1;
                    }
                }
                // 하단
                if (tn + 1 <= (N - 1) && map[tn + 1][tm] == 1 && !isVisited[tn + 1][tm]) {
                    queue.offer(new int[]{tn + 1, tm});
                    if (map[tn + 1][tm] == 1) {
                        map[tn + 1][tm] = map[tn][tm] + 1;
                    }
                }
                // 상단
                if (tn - 1 >= 0 && map[tn - 1][tm] == 1 && !isVisited[tn - 1][tm]) {
                    queue.offer(new int[]{tn - 1, tm});
                    if (map[tn - 1][tm] == 1) {
                        map[tn - 1][tm] = map[tn][tm] + 1;
                    }
                }
                // 좌측
                if (tm - 1 >= 0 && map[tn][tm - 1] == 1 && !isVisited[tn][tm - 1]) {
                    queue.offer(new int[]{tn, tm - 1});
                    if (map[tn][tm - 1] == 1) {
                        map[tn][tm - 1] = map[tn][tm] + 1;
                    }
                }
            }

        }


        System.out.println(map[N - 1][M - 1]);


    }
}
