import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_4963 {
    public static boolean dfs(int[][] island, boolean[][] isVisited, int startW, int startH, int w, int h) {

        boolean isActivated = false;

        if (island[startH][startW] == 1 && !isVisited[startH][startW]) {
            isVisited[startH][startW] = true;
            isActivated = true;

            int[] dw = {-1, 1, 0, 0, -1, 1, -1, 1};
            int[] dh = {0, 0, -1, 1, 1, 1, -1, -1};

            for (int i = 0; i < 8; i++) {

                int dwp = startW + dw[i];
                int dhp = startH + dh[i];

                if (dwp >= 0 && dwp < w && dhp >= 0 && dhp < h) {
                    dfs(island, isVisited, dwp, dhp, w, h);
                }

            }


        }

        return isActivated;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int w = 9;
        int h = 9;

        List<Integer> answer = new ArrayList<>();

        while (true) {
            String[] wh = br.readLine().split(" ");

            w = Integer.parseInt(wh[0]);
            h = Integer.parseInt(wh[1]);

            if (w == 0 && h == 0) {
                break;
            }

            boolean[][] isVisited = new boolean[h][w];
            int[][] island = new int[h][w];

            for (int i = 0; i < h; i++) {

                String[] point = br.readLine().split(" ");

                for (int j = 0; j < w; j++) {
                    island[i][j] = Integer.parseInt(point[j]);
                }


            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (dfs(island, isVisited, j, i, w, h)) {
                        cnt++;
                    }
                }
            }
            answer.add(cnt);

        }

        for (int i : answer) {
            System.out.println(i);
        }

    }
}
