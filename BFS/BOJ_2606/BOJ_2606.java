import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2606 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = br.readLine();
        int N = Integer.parseInt(tmp);

        tmp = br.readLine();
        int M = Integer.parseInt(tmp);

        Map<Integer, List<Integer>> com = new HashMap<>();

        for (int i = 0; i < M; i++) {

            String[] xy = br.readLine().split(" ");

            int tx = Integer.parseInt(xy[0]);
            int ty = Integer.parseInt(xy[1]);
            if (com.get(tx) != null){
                com.get(tx).add(ty);

                if(com.get(ty) != null){
                    com.get(ty).add(tx);
                }else{
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(tx);
                    com.put(ty, tmpList);
                }
            }else{
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(ty);
                com.put(tx, tmpList);

                if(com.get(ty) != null){
                    com.get(ty).add(tx);
                }else{
                    List<Integer> tt = new ArrayList<>();
                    tt.add(tx);
                    com.put(ty, tt);
                }

            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N+1];

        queue.offer(1);

        while(!queue.isEmpty()){

            int v = queue.poll();

            if(isVisited[v]){
                continue;
            }else {
                isVisited[v] = true;
                if(com.get(v) != null){
                    for (int i =0; i<com.get(v).size(); i++){
                        queue.offer(com.get(v).get(i));
                    }
                }
            }

        }

        int cnt = 0;
        for (int i =0; i<=N; i++){
            if(isVisited[i]){
                cnt++;
            }
        }
        System.out.println(cnt-1);

    }
}