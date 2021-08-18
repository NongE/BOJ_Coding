import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] water = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(water);

        int start = 0;
        int end = N - 1;

        int selectFirst = start;
        int selectSecond = end;

        // 1
        // -99 -2 -1 4 98
        long st = Integer.MAX_VALUE;

        while (start < end) {

            long result = water[start] + water[end];

            if (Math.abs(result) < st){
                selectFirst = water[start];
                selectSecond = water[end];
                st = Math.abs(result);
            }

            if(result > 0){
                end -= 1;
            }else{
                start += 1;
            }

        }

         System.out.println(selectFirst);
         System.out.println(selectSecond);
//        bw.write(Integer.toString(selectFirst));
//        bw.write(" ");
//        bw.write(Integer.toString(selectSecond));
//
//        bw.flush();
//        bw.close();
    }
}
