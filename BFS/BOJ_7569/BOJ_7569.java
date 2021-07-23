import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_7569 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] MNH = br.readLine().split(" ");

        int M = Integer.parseInt(MNH[0]);
        int N = Integer.parseInt(MNH[1]);
        int H = Integer.parseInt(MNH[2]);

        int[][][] farm = new int[H][N][M];

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[H][N][M];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                String[] info = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    farm[k][i][j] = Integer.parseInt(info[j]);
                    if (farm[k][i][j] == 1) {
                        queue.offer(new int[]{k, i, j});
                    }
                }

            }
        }

        while (!queue.isEmpty()) {
            int[] Points = queue.poll();

            int th = Points[0];
            int tn = Points[1];
            int tm = Points[2];

            if (farm[th][tn][tm] != 0 && farm[th][tn][tm] != -1 && !isVisited[th][tn][tm]) {

                isVisited[th][tn][tm] = true;

                int[] dt = {1, -1, 0, 0, 0, 0};
                int[] dn = {0, 0, 1, -1, 0, 0};
                int[] dm = {0, 0, 0, 0, 1, -1};

                for (int v = 0; v < 6; v++) {
                    int dth = th + dt[v];
                    int dtn = tn + dn[v];
                    int dtm = tm + dm[v];

                    if (dtn >= 0 && dtn < N && dtm >= 0 && dtm < M && dth >= 0 && dth < H) {

                        if (farm[dth][dtn][dtm] == 0 && !isVisited[dth][dtn][dtm]) {
                            farm[dth][dtn][dtm] = farm[th][tn][tm] + 1;
                            queue.offer(new int[]{dth, dtn, dtm});


                        }

                    }


                }


            }


        }

        int max = 0;
        boolean zeroFlag = false;

        for (int k = 0; k < H; k++) {
            if (zeroFlag) break;
            for (int i = 0; i < N; i++) {
                if (zeroFlag) break;
                for (int j = 0; j < M; j++) {
                    if (farm[k][i][j] == 0) {
                        zeroFlag = true;
                        max = 0;
                        break;
                    }
                    if (farm[k][i][j] > max) {
                        max = farm[k][i][j];
                    }
                }
            }
        }

        System.out.println(max - 1);


    }
}
