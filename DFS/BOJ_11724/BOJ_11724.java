import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11724 {

    public static boolean dfs(Map<Integer, List<Integer>> userEdges, boolean[] isVisited, int start) {

        boolean isActivated = false;
        if (!isVisited[start]) {
            isVisited[start] = true;

            if (userEdges.get(start) != null) {
                for (int i = 0; i < userEdges.get(start).size(); i++) {
                    dfs(userEdges, isVisited, userEdges.get(start).get(i));
                    isActivated = true;

                }
            }

        }

        return isActivated;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i =1; i<N+1; i++){
            List<Integer> t = new ArrayList<>();
            t.add(i);
            graph.put(i, t);
        }

        for (int i = 0; i < M; i++) {

            String[] tmp = br.readLine().split(" ");

            int u = Integer.parseInt(tmp[0]);
            int v = Integer.parseInt(tmp[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);


        }

        boolean[] isVisited = new boolean[N + 1];
        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            boolean tmp = dfs(graph, isVisited, i);
            if (tmp) {
                cnt++;
            }
        }
        System.out.println(cnt);


    }
}
