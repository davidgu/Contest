package Solved;

import java.util.*;

/**
 * Created by david on 1/3/17.
 */

//SOLVED

public class ccc06j4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = -1;
        int b = -1;

        int vertex[] = new int[20];
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

        vertex[7] = 1;
        vertex[4] = 2;
        vertex[1] = 1;
        vertex[5] = 1;

        for (int i = 0; i < 8; i++) {
            nodes.add(new ArrayList<>());
        }

        nodes.get(1).add(7);
        nodes.get(1).add(4);
        nodes.get(2).add(1);
        nodes.get(3).add(4);
        nodes.get(3).add(5);

        while (true) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            nodes.get(a).add(b);
            vertex[b]++;
        }

        boolean found = true;
        boolean allgone = true;
        Queue Q = new LinkedList<Integer>();

        while (found) {
            found = false;
            SortedSet S = new TreeSet<Integer>();
            for (int i = 1; i < nodes.size(); i++) {
                if (vertex[i] == 0) {
                    vertex[i]--;
                    found = true;
                    S.add(i);
                    for (int x : nodes.get(i)) {
                        vertex[x]--;
                        nodes.get(x).remove((Integer) i);
                    }
                    break;
                }
            }

            Iterator I = S.iterator();
            while (I.hasNext()) {
                Q.add(I.next());
            }

            if (!found) {
                for (int i = 1; i < nodes.size(); i++) {
                    if (!(vertex[i] <= 0)) {
                        allgone = false;
                    }
                }

                if (!allgone) {
                    System.out.println("Cannot complete these tasks. Going to bed.");
                }
            else {
                while (!Q.isEmpty()) {
                    System.out.print(Q.poll() + " ");
                }
            }
            break;
        }

    }



    }

}
