import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static String convertData(String s) {
        if (s.equals("0")) {
            return "1";
        } else {
            return "0";
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();
        String[] NM = userInput.split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        List<String[]> nToArray = new ArrayList<>();
        List<String[]> mToArray = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String matrix = br.readLine();
            String[] tmp = matrix.split("");
            nToArray.add(tmp);
        }


        for (int i = 0; i < N; i++) {
            String matrix = br.readLine();
            String[] tmp = matrix.split("");
            mToArray.add(tmp);
        }

        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (nToArray.get(i)[j].equals(mToArray.get(i)[j])) {
                    continue;
                } else {
                    // 다름
                    // 오른쪽으로 갈 수 있는지 탐색
                    if (M - j >= 3) {
                        // 아래쪽으로 갈 수 있는지 탐색
                        if (N - i >= 3) {
                            for (int v = i; v < i + 3; v++) {
                                for (int w = j; w < j + 3; w++) {
                                    nToArray.get(v)[w] = convertData(nToArray.get(v)[w]);
                                }
                            }
                            cnt++;
                            // 위쪽으로 진행
                        }
                    }

                }
            }

            boolean flagInner = true;
            for (int z = 0; z < N; z++) {
                if (Arrays.equals(nToArray.get(z), mToArray.get(z))) {
                    continue;
                } else {
                    flagInner = false;
                    break;
                }
            }
            if (flagInner) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println(cnt);
        } else {
            System.out.println("-1");
        }


    }
}