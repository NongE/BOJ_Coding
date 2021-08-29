import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class BOJ_1149 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][3];

        for (int i = 0; i < N; i++) {
            house[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[N+1][3];

        dp[0] = house[0];
        for(int i = 1; i<N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
        }

        int minNum = Integer.MAX_VALUE;
        for(int i =0; i<3; i++){
            if (dp[N-1][i] < minNum){
                minNum = dp[N-1][i];
            }
        }

        bw.write(Integer.toString(minNum));
        bw.flush();
        bw.close();

    }

}
