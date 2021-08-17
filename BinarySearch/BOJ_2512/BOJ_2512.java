import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] wanted = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(wanted);
        int money = Integer.parseInt(br.readLine());
        int wantedSum = Arrays.stream(wanted).sum();

        int start = 1;
        int end = wanted[N - 1];

        int max = 0;

        while (start <= end) {

            int mid = (start + end) / 2;

            int _money = 0;

            for (int i = 0; i < N; i++) {
                _money += Math.min(mid, wanted[i]);
                if(_money > money){
                    break;
                }
            }

            if (_money <= money) {
                if (mid >= max) {
                    max = mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }

        System.out.println(max);


    }
}
