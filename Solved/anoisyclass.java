package Solved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//SOLVED

/**
 * Created by David on 2016-12-10.
 */
public class anoisyclass {

    public static void main(String[] args)throws Exception{

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] vertex = new int[N];
        boolean[] vis = new boolean [N];
        int count = 0;

        for(int i = 0; i<N; i++){
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;

            nodes.get(a).add(b);
            vertex[b]++;
        }

        Queue<Integer> Q = new LinkedList<>();

        for(int i = 0; i<N; i++){
            if(vertex[i]==0){
                Q.add(i);
                vis[i] = true;
                break;
            }
        }

        while(!Q.isEmpty()){
            int a = Q.poll();
            for(int x : nodes.get(a)){
                vertex[x]--;
            }

            for(int i = 0; i<N; i++){
                if(vertex[i]==0&&!vis[i]){
                    Q.add(i);
                    vis[i] = true;
                    count++;
                    break;
                }
            }
        }

        if(count == N-1){
            System.out.println("Y");
        }
        else{
            System.out.println("N");
        }
    }
}
