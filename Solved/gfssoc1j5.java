package Solved; /**
 * Created by David on 2016-11-26.
 */



//SOLVED

import java.util.*;

public class gfssoc1j5 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt(), T = sc.nextInt();

        for (int i = 0; i < N + 1; i++) {
            nodes.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            nodes.get(a).add(b);
        }

        int Q = sc.nextInt();

        for (int i = 0; i < Q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Queue<Integer> q = new LinkedList<>();
            q.add(a);
            boolean found = false;
            int[] dis = new int[N + 1];
            boolean vis[] = new boolean[N + 1];
            vis[a] = true;

            while (!q.isEmpty()) {
                int cur = q.poll();
                if (cur == b) {
                    found = true;
                    System.out.println(dis[cur] * T);
                    break;
                }
                for (int x : nodes.get(cur)) {
                    if (!vis[x]) {
                        dis[x] = dis[cur] + 1;
                        q.add(x);
                        vis[x] = true;  //MARK VISITED WHEN YOU PUSH, NOT WHEN YOU POP
                    }


                }
            }
            if (!found) {
                System.out.println("Not enough hallways!");
            }
        }
    }
}
