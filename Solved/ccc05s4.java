package Solved;

import java.util.*;

/**
 * Created by David on 2016-12-10.
 */

//SOLVED

public class ccc05s4 {


    //Tree has N nodes, therefore N-1 edges, Therefore, to visit all nodes, it requires (N-1)*2 edge traversals...
    //...as it is required to cross each path and come back.
    //New strategy results in distance of longest path * 2
    //Use BFS to find longest path
    //Then calculate the new strategy time and old strategy time
    //Subtract them to realize the time efficiency gained.

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();

        for(int i = 0; i<L; i++){
            ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
            ArrayList<String> input = new ArrayList<>();
            Map nameToInteger = new HashMap<String, Integer>();

            int n = sc.nextInt();
            sc.nextLine(); //clear eol
            for(int j = 0; j<n; j++){
                input.add(sc.nextLine());
            }
            for(int j = 0; j<n; j++){
                String currentName = input.get(input.size()-j-1);
                if(!nameToInteger.containsKey(currentName)){
                    nameToInteger.put(currentName, j);
                }
            }

            for(int j = 0; j<n; j++){
                nodes.add(new ArrayList<>());
            }

            for(int j = 0; j<n-1; j++){
                String name1= input.get(input.size()-j-1);
                String name2 = input.get(input.size()-j-2);
                nodes.get((int)nameToInteger.get(name1)).add((int)nameToInteger.get(name2));

            }

            int old = (nameToInteger.size()-1)*10*2;

            Queue<Integer> Q = new LinkedList<>();
            int[] dist = new int[nodes.size()];
            boolean[] vis = new boolean[nodes.size()];
            int cur = 0;
            Q.add(0);
            vis[0] = true;

            while(!Q.isEmpty()){
                cur = Q.poll();
                for(int x : nodes.get(cur)){
                    if(!vis[x]){
                        Q.add(x);
                        vis[x] = true;
                        dist[x] = dist[cur] +1;
                    }
                }
            }

            int newMethod = dist[cur]*10*2;
            System.out.println(old - newMethod);
        }
    }
}
