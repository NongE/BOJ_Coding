import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BOJ_2110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NC = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NC[0];
        int C = NC[1];

        int[] house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);


        int start = 0;
        int end = house[N-1] - house[0];

        int dist = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int point = house[0];
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (house[i] - point >= mid) {
                    cnt++;
                    point = house[i];
                }
            }

            if (cnt >= C) {
                dist = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(dist);


    }
}
