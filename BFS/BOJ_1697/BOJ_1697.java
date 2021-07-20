import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1697 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);


        int[] isVisited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        isVisited[N] = 0;

        int point = 0;

        while (true) {

            point = queue.poll();

            if(point == K){
                break;
            }

            if (point - 1 >= 0) {
                if (isVisited[point - 1] == 0) {
                    queue.offer(point - 1);
                    isVisited[point - 1] = isVisited[point] + 1;
                }
            }

            if (point + 1 < 100001) {
                if (isVisited[point + 1] == 0) {
                    queue.offer(point + 1);
                    isVisited[point + 1] = isVisited[point] + 1;
                }
            }

            if (point * 2 < 100001) {
                if (isVisited[point * 2] == 0) {
                    queue.offer(point * 2);
                    isVisited[point * 2] = isVisited[point] + 1;
                }
            }

        }
        System.out.println(isVisited[point]);


    }
}
