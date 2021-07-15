import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] MN = br.readLine().split(" ");

        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        int[][] tomato = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {

                tomato[i][j] = Integer.parseInt(tmp[j]);
                if (tomato[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                queue.offer(new int[]{i, j});

                while (!queue.isEmpty()) {

                    int[] points = queue.poll();

                    int tn = points[0];
                    int tm = points[1];

                    int[] dn = {-1, 1, 0, 0};
                    int[] dm = {0, 0, -1, 1};

                    if (!isVisited[tn][tm] && tomato[tn][tm] >= 1) {
                        isVisited[tn][tm] = true;

                        for (int s = 0; s < 4; s++) {
                            int dtn = tn + dn[s];
                            int dtm = tm + dm[s];

                            if (dtn >= 0 && dtn < N && dtm >= 0 && dtm < M) {

                                if (tomato[dtn][dtm] == 0 && !isVisited[dtn][dtm]) {
                                    queue.offer(new int[]{dtn, dtm});
                                    tomato[dtn][dtm] = tomato[tn][tm] + 1;
                                }

                            }

                        }


                    }

                }


            }
        }

        int m = 0;
        boolean brakeFlag = false;

        for(int i = 0; i<N; i++){
            if (brakeFlag){
                break;
            }
            for (int j =0; j<M; j++){
                if(tomato[i][j] == 0){
                    m = 0;
                    brakeFlag = true;
                    break;
                }
                if(tomato[i][j]>m){
                    m = tomato[i][j];
                }
            }
        }
        System.out.println(m-1);


    }
}
