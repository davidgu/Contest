package Solved;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//SOLVED

/**
 * Created by David on 2016-12-10.
 */
public class ccc07s3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nodes = new int[10000];

        for(int i = 0; i<n; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                nodes[a]=b;
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        while(a!=0&&b!=0){

            Queue<Integer> Q = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            boolean found = false;
            int[] dist = new int[10000];

            Q.add(a);

            while(!Q.isEmpty()){
                int j = Q.poll();
                if(j==b){
                    System.out.println("Yes"+" "+(dist[j]-1));
                    found = true;
                    break;
                }
                if(!visited[j]){
                    visited[j] = true;
                    int x = nodes[j];
                    Q.add(x);
                    dist[x] = dist[j]+1;
                }
            }
            if(!found){
                System.out.println("No");
            }

            a = sc.nextInt();
            b = sc.nextInt();
        }

    }
}
