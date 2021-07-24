import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loopCount = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();


        for (int k = 0; k < loopCount; k++) {
            int I = Integer.parseInt(br.readLine());

            int[][] map = new int[I][I];

            String[] inputStartPoint = br.readLine().split(" ");
            String[] inputEndPoint = br.readLine().split(" ");
            int[] startPoint = new int[2];
            int[] endPoint = new int[2];
            for (int i = 0; i < inputStartPoint.length; i++) {
                startPoint[i] = Integer.parseInt(inputStartPoint[i]);
                endPoint[i] = Integer.parseInt(inputEndPoint[i]);
            }

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] isVisited = new boolean[I][I];

            queue.offer(startPoint);

            boolean findFlag = false;

            int cnt = 0;

            while (true) {

                if (findFlag) {
                    break;
                }
                int[] point = queue.poll();

                int x = point[0];
                int y = point[1];

                if (x == endPoint[0] && y == endPoint[1]) {
                    cnt = map[x][y];
                    break;
                }


                if (!isVisited[x][y]) {

                    isVisited[x][y] = true;

                    int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
                    int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

                    for (int i = 0; i < 8; i++) {
                        int tdx = x + dx[i];
                        int tdy = y + dy[i];

                        if (tdx >= 0 && tdx < I && tdy >= 0 && tdy < I) {

                            if (!isVisited[tdx][tdy]) {
                                queue.offer(new int[]{tdx, tdy});
                                map[tdx][tdy] = map[x][y] + 1;
                            }


                        }

                    }


                }


            }
            answer.add(cnt);
        }

        for (int k = 0; k < loopCount; k++) {
            System.out.println(answer.get(k));
        }


    }
}
