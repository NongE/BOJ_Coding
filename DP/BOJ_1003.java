
import java.io.*;
import java.util.*;

public class BOJ_1003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] answer = new int[T][2];

        for(int i =0; i<T; i++){

            int N = Integer.parseInt(br.readLine());

            if(N == 0){
                answer[i][0] = 1;
                answer[i][1] = 0;
            }else{
                int[][] dp = new int[N+1][2];

                dp[0][0] = 1;
                dp[0][1] = 0;

                dp[1][0] = 0;
                dp[1][1] = 1;


                for(int j =2; j<=N; j++){
                    dp[j][0] += dp[j-1][0] + dp[j-2][0];
                    dp[j][1] += dp[j-1][1] + dp[j-2][1];
                }

                answer[i][0] = dp[N][0];
                answer[i][1] = dp[N][1];
            }


        }

        for (int i =0 ;i<T; i++){
            bw.write(answer[i][0]+" "+answer[i][1]+"\n");
            bw.flush();
        }
        bw.close();

        
        
    }
}
