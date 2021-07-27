import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] KN = br.readLine().split(" ");

        int K = Integer.parseInt(KN[0]);
        int N = Integer.parseInt(KN[1]);

        long[] cable = new long[K];

        long end = 0;

        for (int i = 0; i < K; i++) {
            cable[i] = Integer.parseInt(br.readLine());
            if (cable[i] > end) {
                end = cable[i];
            }
        }


        long start = 1;
        long answer = 0;

        while (start <= end) {

            long mid = (start + end) / 2;

            long sum = 0;

            for (int i = 0; i < K; i++) {
                sum += (cable[i] / mid);
            }

            if (sum >= N) {
                if (answer < mid) {
                    answer = mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }


        System.out.println(answer);


    }
}
