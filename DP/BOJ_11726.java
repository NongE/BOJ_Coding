import java.io.*;
import java.util.*;

public class BOJ_11726 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        if (n == 1) {
            bw.write((1) + "\n");
        } else {

            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2])% 10007;
            }

            bw.write((dp[n]) + "\n");
        }


        bw.flush();
        bw.close();


    }
}
