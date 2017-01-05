package Solved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//SOLVED

/**
 * Created by david on 1/4/17.
 */

public class WCIPEGgraph2p2 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] matrix = new int[N][N];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        int[] vertex = new int[N];

        for(int i = 0; i<N; i++){
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(matrix[i][j] == 1){
                    nodes.get(i).add(j);
                    vertex[j]++;
                }
            }
        }

        Queue Q = new LinkedList<Integer>();
        int count = 0;

        for(int i = 0; i<N; i++){
            if(vertex[i]==0){
                Q.add(i);
            }
        }

        while(!Q.isEmpty()){
            int cur = (int)Q.poll();
            count ++;
            vertex[cur]--;
            for(int x : nodes.get(cur)){
                vertex[x]--;
                if(vertex[x]==0){
                    Q.add(x);
                }
            }
        }

        if(count!=N){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }
}
