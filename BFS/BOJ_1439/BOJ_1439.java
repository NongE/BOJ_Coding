import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String userInput = br.readLine();

        int[] userInt = new int[userInput.length()];

        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i<userInput.length(); i++){
            int tmp = userInput.charAt(i)-'0';
            userInt[i] = tmp;
            if (tmp == 0){
                zeroCnt ++;
            }else{
                oneCnt ++;
            }

        }

        int flipOneCnt = 0;
        int flipZeroCnt = 0;
        boolean flag = false;

        for (int i = 0; i < userInt.length; i++){
                if (userInt[i] == 1){
                    if (!flag){
                        flipOneCnt ++;
                    }
                    flag = true;
                }else{
                    flag = false;
                }
        }

        flag = false;
        for (int i = 0; i < userInt.length; i++){
            if (userInt[i] == 0){
                if (!flag){
                    flipZeroCnt ++;
                }
                flag = true;
            }else{
                flag = false;
            }
        }

        if (flipOneCnt > flipZeroCnt){
            System.out.println(flipZeroCnt);
        }else{
            System.out.println(flipOneCnt);
        }
    }
}
