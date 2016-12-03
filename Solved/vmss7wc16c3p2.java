package Solved;

import java.util.*;

/**
 * Created by david on 27/11/16.
 */

//SOLVED

public class vmss7wc16c3p2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

        for(int i = 0; i<N+1; i++){
            nodes.add(new ArrayList<Integer>());
        }

        for(int i = 0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(x>y){
                int temp = x;
                x=y;
                y=temp;
            }

            nodes.get(x).add(y);
            nodes.get(y).add(x);
        }

        if(A==B){
            System.out.println("GO SHAHIR!");
            System.exit(0);
        }
        else if(M==0){
            System.out.println("NO SHAHIR!");
            System.exit(0);
        }

        if(dfs(nodes, A, B)){
            System.out.println("GO SHAHIR!");
        }
        else{
            System.out.println("NO SHAHIR!");
        }

    }


    static boolean dfs(ArrayList<ArrayList<Integer>> nodes, int s, int toSearch){
        int n = nodes.size();
        boolean[] visited = new boolean[n];
        return dfs_rec(nodes, visited, s, toSearch);
    }

    static boolean dfs_rec(ArrayList<ArrayList<Integer>> nodes, boolean[] visited, int v, int toSearch){
        visited[v] = true;
//        System.out.println(v);
        if(v==toSearch){
            return true;
        }
        for(int x : nodes.get(v)) {
            if(!visited[x]){
                if(dfs_rec(nodes, visited, x, toSearch)) return true;
            }
        }
        return false;
    }

}
