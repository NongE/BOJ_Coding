import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_1260 {

    public static void dfs(Map<Integer, List<Integer>> userEdges, boolean[] isVisited, int start) {

        if (!isVisited[start]) {
            System.out.print(start + " ");
            isVisited[start] = true;

            for (int i = 0; i < userEdges.get(start).size(); i++) {
                dfs(userEdges, isVisited, userEdges.get(start).get(i));
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        int V = Integer.parseInt(info[2]);

        Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();


        for (int i = 1; i < M + 1; i++) {

            String[] tmp = br.readLine().split(" ");
            int[] tmpInt = new int[2];
            tmpInt[0] = Integer.parseInt(tmp[0]);
            tmpInt[1] = Integer.parseInt(tmp[1]);

            if (edges.get(tmpInt[0]) != null) {
                edges.get(tmpInt[0]).add(tmpInt[1]);
            } else {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(tmpInt[1]);
                edges.put(tmpInt[0], tmpList);
            }

            if (edges.get(tmpInt[1]) != null) {
                edges.get(tmpInt[1]).add(tmpInt[0]);
            } else {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(tmpInt[0]);
                edges.put(tmpInt[1], tmpList);
            }

        }

        for (int i = 1; i < N + 1; i++) {
            if (edges.get(i) != null) {
                Collections.sort(edges.get(i));
            } else {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(i);
                edges.put(i, tmpList);
            }

        }

        boolean[] isVisitedDFS = new boolean[N + 1];

        dfs(edges, isVisitedDFS, V);

        System.out.println();
        // bfs
        Queue<Integer> bfsQueue = new LinkedList<>();

        boolean[] isVisited = new boolean[N + 1];

        bfsQueue.offer(V);

        while (true) {
            int tmp = bfsQueue.poll();
            if (!isVisited[tmp]) {
                System.out.print(tmp + " ");
                isVisited[tmp] = true;

                for (int j = 0; j < edges.get(tmp).size(); j++) {
                    bfsQueue.offer(edges.get(tmp).get(j));
                }

            }
            if (bfsQueue.isEmpty()) {
                break;
            }

        }


    }
}
