import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BOJ_10816 {


    public static int loweBound(int[] data, int point) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (data[mid] >= point) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }


    public static int upperBound(int[] data, int point) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (data[mid] <= point) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int[] mCard = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = Integer.parseInt(br.readLine());
        int[] nCard = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(mCard);

        int[] answer = new int[N];

        for(int i =0; i<N; i++){
            answer[i] = upperBound(mCard, nCard[i]) - loweBound(mCard, nCard[i]);
        }


        for(int i =0; i<N; i++){
            bw.write(answer[i]+ " ");
        }
        bw.flush();
        bw.close();

    }
}