import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], arr[i-1] + arr[i]);
            dp[i] = Math.max(dp[i], dp[i-1] + arr[i]);
        }

        Arrays.sort(dp);

        bw.write(dp[n-1]+"");
        bw.flush();
        bw.close();

    }
}
