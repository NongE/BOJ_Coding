import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] TREE = br.readLine().split(" ");

        int end = 0;

        int[] tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(TREE[i]);
            if (tree[i] > end){
                end = tree[i];
            }
        }


        int start = 0;

        int cut = 0;

        while(start <= end){

            long sum = 0;
            int mid = (start + end)/2;

            for(int i =0; i< N; i++){
                if (tree[i] - mid > 0){
                    sum += (tree[i] - mid);
                }
            }

            if(sum >= M){
                if(mid > cut){
                    cut = mid;
                }
                start = mid + 1;
            }else{
                end = mid -1;
            }


        }

        System.out.println(cut);


    }
}
