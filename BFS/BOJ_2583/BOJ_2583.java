import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2583 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] MNK = br.readLine().split(" ");

        int M = Integer.parseInt(MNK[0]);
        int N = Integer.parseInt(MNK[1]);
        int K = Integer.parseInt(MNK[2]);


        int[][] map = new int[M][N];

        for (int i = 0; i < K; i++) {
            String[] points = br.readLine().split(" ");

            int ux = Integer.parseInt(points[0]);
            int uy = Integer.parseInt(points[1]);

            int tx = Integer.parseInt(points[2]);
            int ty = Integer.parseInt(points[3]);

            for (int j = uy; j < ty; j++) {
                for (int k = ux; k < tx; k++) {
                    map[j][k] = -1;
                }
            }

        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[M][N];
        List<Integer> max = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                queue.offer(new int[]{i, j});
                int cnt = 1;
                boolean activeFlag = false;
                while (!queue.isEmpty()) {

                    int[] point = queue.poll();
                    int pm = point[0];
                    int pn = point[1];

                    if (!isVisited[pm][pn] && map[pm][pn] != -1) {
                        isVisited[pm][pn] = true;
                        activeFlag = true;
                        int[] dx = {1, -1, 0, 0};
                        int[] dy = {0, 0, 1, -1};

                        for (int k = 0; k < 4; k++) {
                            int tdm = pm + dx[k];
                            int tdn = pn + dy[k];

                            if (tdm >= 0 && tdm < M && tdn >= 0 && tdn < N) {
                                if (map[tdm][tdn] == 0 && !isVisited[tdm][tdn]) {
                                    queue.offer(new int[]{tdm, tdn});
                                    map[tdm][tdn] = cnt;
                                    cnt++;
                                }

                            }

                        }

                    }

                }
                if (activeFlag) {
                    max.add(cnt);
                }

            }

        }
        Collections.sort(max);
        System.out.println(max.size());
        for (int i = 0; i < max.size(); i++) {
            System.out.print(max.get(i) + " ");
        }
    }
}
