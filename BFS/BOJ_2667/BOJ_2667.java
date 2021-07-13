import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class BOJ_2667 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] apt = new int[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                apt[i][j] = tmp.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][N];

        List<Integer> answer = new ArrayList<>();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                queue.offer(new int[]{i, j});



                cnt = 0;
                while (true) {

                    int[] tmp = queue.poll();
                    int tn = tmp[0];
                    int tm = tmp[1];

                    if (apt[tn][tm] != 0) {
                        if (!isVisited[tn][tm]) {

                            isVisited[tn][tm] = true;
                            if (apt[tn][tm] == 1){
                                cnt ++;
                                apt[tn][tm] = cnt;
                            }

                            // 상
                            if (tn - 1 >= 0 && apt[tn - 1][tm] == 1 && !isVisited[tn - 1][tm]) {
                                queue.offer(new int[]{tn - 1, tm});
                            }
                            // 하
                            if (tn + 1 <= (N - 1) && apt[tn + 1][tm] == 1 && !isVisited[tn + 1][tm]) {
                                queue.offer(new int[]{tn + 1, tm});
                            }

                            // 좌
                            if (tm - 1 >= 0 && apt[tn][tm - 1] == 1 && !isVisited[tn][tm - 1]) {
                                queue.offer(new int[]{tn, tm - 1});
                            }

                            if (tm + 1 <= (N - 1) && apt[tn][tm + 1] == 1 && !isVisited[tn][tm + 1]) {
                                queue.offer(new int[]{tn, tm + 1});
                            }
                        }
                    }
                    if (queue.isEmpty()) {
                        break;
                    }

                }

                if(cnt != 0){
                    // System.out.println(i +", "+j);
                    answer.add(cnt);
                }


            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        if (answer.size() == 0){
            System.out.println(0);
        }else{
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }



    }
}
