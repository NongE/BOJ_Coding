import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2468 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];


        for (int i = 0; i < N; i++) {

            String[] area = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(area[j]);
            }

        }




        int max = 0;

        for (int h = 1; h<=100; h++){

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] isVisited = new boolean[N][N];
            int cnt = 0;

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {

                    if (map[x][y] >= h && !isVisited[x][y]) {
                        queue.offer(new int[]{x, y});

                        while (true) {
                            int[] points = queue.poll();

                            int px = points[0];
                            int py = points[1];

                            if (!isVisited[px][py]) {
                                isVisited[px][py] = true;

                                int[] dx = {-1, 1, 0, 0};
                                int[] dy = {0, 0, 1, -1};

                                for (int i = 0; i < 4; i++) {

                                    int tx = px + dx[i];
                                    int ty = py + dy[i];

                                    if (tx >= 0 && tx < N && ty >= 0 && ty < N) {

                                        if (!isVisited[tx][ty] && map[tx][ty] >= h) {
                                            queue.offer(new int[]{tx, ty});
                                        }


                                    }


                                }

                            }

                            if (queue.isEmpty()) {
                                cnt++;
                                break;
                            }

                        }
                    }


                }

            }

            if(cnt > max){
                max = cnt;

            }

        }

        System.out.println(max);


    }
}
