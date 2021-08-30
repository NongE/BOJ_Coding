import java.util.*;
import java.io.*;
import java.util.stream.Stream;


public class BOJ_1932 {

    public static void main(String args[]) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n + 1][n + 1];

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            triangle[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dp[i] = triangle[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(j == 0){
                    dp[i][j] = triangle[i][j] + dp[i-1][0];
                }else if (j == i-1){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        Arrays.sort(dp[n]);

        bw.write(Integer.toString(dp[n][n-1]));
        bw.flush();
        bw.close();

    }

}
