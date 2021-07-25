import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] AN = br.readLine().split(" ");

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(AN[i]);
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());

        String[] MM = br.readLine().split(" ");

        int[] checkList = new int[M];

        for (int i = 0; i < M; i++) {
            checkList[i] = Integer.parseInt(MM[i]);
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {

            if(Arrays.binarySearch(A, checkList[i]) >= 0){
                answer.add(1);
            }else{
                answer.add(0);
            }
        }

        for (int i = 0; i < M; i++) {
            System.out.println(answer.get(i));
        }


    }
}
