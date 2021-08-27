import java.io.*;
import java.nio.Buffer;

public class BOJ_9095 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[] answer = new int[T];

        for (int i = 0; i < T; i++) {

            int[] dp = new int[11];

            int tc = Integer.parseInt(br.readLine());

            dp[0] = 1;
            dp[1] = 1;

            for (int j = 2; j <= tc; j++) {

                if (j - 1 >= 0) {
                    dp[j] += dp[j - 1];
                }

                if (j - 2 >= 0) {
                    dp[j] += dp[j - 2];
                }

                if (j - 3 >= 0) {
                    dp[j] += dp[j - 3];
                }

            }

            answer[i]= dp[tc];

        }

        for (int i =0; i<T; i++){
            bw.write(answer[i] + "\n");
            bw.flush();

        }
        bw.close();

    }
}
