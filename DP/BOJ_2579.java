import java.io.*;
import java.nio.Buffer;

public class BOJ_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
            dp[i] = stair[i];
        }

        if (N == 1){
            System.out.println(stair[N]);
        }else if(N == 2){
            System.out.println(stair[N-1] + stair[N]);
        }else{
            dp[2] = stair[1] + stair[2];
            dp[3] = stair[2] + Math.max(dp[0] + stair[2], dp[1]);

            for (int i = 3; i <= N; i++) {

                dp[i] = stair[i] + Math.max(dp[i-3] + stair[i-1], dp[i-2]);

            }


            System.out.println(dp[N]);
        }


    }

}
