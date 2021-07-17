import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        int[] answer = new int[testcase];

        for (int i = 0; i < testcase; i++) {

            String[] info = br.readLine().split(" ");

            int M = Integer.parseInt(info[0]);
            int N = Integer.parseInt(info[1]);
            int numPlant = Integer.parseInt(info[2]);

            int[][] area = new int[N][M];

            for (int j = 0; j < numPlant; j++) {

                String[] plantedPoint = br.readLine().split(" ");

                int pM = Integer.parseInt(plantedPoint[0]);
                int pN = Integer.parseInt(plantedPoint[1]);

                area[pN][pM] = 1;

            }

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] isVisited = new boolean[N][M];
            boolean isPlanted = false;
            int cnt = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    queue.offer(new int[]{x, y});

                    while (!queue.isEmpty()) {

                        int[] tmpNM = queue.poll();

                        int[] dn = {-1, 1, 0, 0};
                        int[] dm = {0, 0, -1, 1};

                        int tn = tmpNM[0];
                        int tm = tmpNM[1];

                        if (!isVisited[tn][tm] && area[tn][tm] != 0){
                            isVisited[tn][tm] = true;
                            isPlanted = true;
                            for (int z = 0; z < 4; z++) {

                                int ttn = tn +dn[z];
                                int ttm = tm + dm[z];

                                if (ttn >= 0 && ttn < N && ttm >= 0 && ttm < M) {
                                    if(area[ttn][ttm] == 1 && !isVisited[ttn][ttm]){
                                        queue.offer(new int[]{ttn, ttm});
                                    }

                                }


                            }

                        }

                    }
                    if(isPlanted){
                        cnt ++;
                        isPlanted = false;
                    }

                }
            }
            answer[i] = cnt;

        }

        for (int i =0; i<testcase; i++){
            System.out.println(answer[i]);
        }

    }
}
