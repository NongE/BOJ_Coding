import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BOJ_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] mCard = new int[M];

        String[] _mCard = br.readLine().split(" ");

        int index = 0;
        for (String i : _mCard) {
            mCard[index] = Integer.parseInt(i);
            index++;
        }

        int N = Integer.parseInt(br.readLine());
        int[] nCard = new int[N];

        String[] _nCard = br.readLine().split(" ");

        index = 0;
        for (String i : _nCard) {
            nCard[index] = Integer.parseInt(i);
            index++;
        }

        Arrays.sort(mCard);

        int[] answer = new int[N];

        index = 0;
        for (int i : nCard) {
            if (Arrays.binarySearch(mCard, i) >= 0) {
                answer[index] = 1;
            } else {
                answer[index] = 0;
            }
            index++;
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }


    }
}
