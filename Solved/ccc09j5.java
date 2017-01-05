package Solved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//SOLVED


/**
 * Created by david on 1/4/17.
*/

public class ccc09j5 {

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<60; i++){
            nodes.add(new ArrayList<>());
        }

        nodes.get(1).add(6);
        nodes.get(6).add(1);

        nodes.get(2).add(6);
        nodes.get(6).add(2);

        nodes.get(3).add(6);
        nodes.get(6).add(3);

        nodes.get(3).add(4);
        nodes.get(4).add(3);

        nodes.get(3).add(5);
        nodes.get(5).add(3);

        nodes.get(3).add(15);
        nodes.get(15).add(3);

        nodes.get(4).add(6);
        nodes.get(6).add(4);

        nodes.get(4).add(5);
        nodes.get(5).add(4);

        nodes.get(5).add(6);
        nodes.get(6).add(5);

        nodes.get(6).add(7);
        nodes.get(7).add(6);

        nodes.get(7).add(8);
        nodes.get(8).add(7);

        nodes.get(8).add(9);
        nodes.get(9).add(8);

        nodes.get(9).add(10);
        nodes.get(10).add(9);

        nodes.get(9).add(12);
        nodes.get(12).add(9);

        nodes.get(10).add(11);
        nodes.get(11).add(10);

        nodes.get(11).add(12);
        nodes.get(12).add(11);

        nodes.get(12).add(13);
        nodes.get(13).add(12);

        nodes.get(13).add(14);
        nodes.get(14).add(13);

        nodes.get(13).add(15);
        nodes.get(15).add(13);

        nodes.get(16).add(17);
        nodes.get(17).add(16);

        nodes.get(16).add(18);
        nodes.get(18).add(16);

        nodes.get(17).add(18);
        nodes.get(18).add(17);


        progloop:
        while(true){
            String input = sc.nextLine();

            int a,b;

            switch(input){
                case "i":
                    a = sc.nextInt();
                    b = sc.nextInt();

                    if(!nodes.get(a).contains(b)){
                        nodes.get(a).add(b);
                        nodes.get(b).add(a);
                    }

                    break;
                case "d":
                    a = sc.nextInt();
                    b = sc.nextInt();

                    if(nodes.get(a).contains(b)){
                        nodes.get(a).remove((Integer)b);
                        nodes.get(b).remove((Integer)a);
                    }

                    break;
                case "n":
                    a = sc.nextInt();
                    System.out.println(nodes.get(a).size());

                    break;
                case "f":
                    int fr = 0;
                    a = sc.nextInt();
                    ArrayList<Integer> fof = new ArrayList<>();
                    ArrayList<Integer> friend = new ArrayList<>();
                    friend.add(a);
                    for(int x : nodes.get(a)){
                        friend.add(x);
                        for(int y : nodes.get(x)){
                            if(!fof.contains(y)){
                                fof.add(y);
                            }
                        }
                    }
                    for(int x : friend) {
                        if (fof.contains(x)) {
                            fof.remove((Integer)x);
                        }
                    }
                    System.out.println(fof.size());
                    break;
                case "s":
                    a = sc.nextInt();
                    b = sc.nextInt();

                    Queue Q = new LinkedList<Integer>();
                    boolean[] vis = new boolean[nodes.size()+1];
                    int[] dis = new int[nodes.size()+1];

                    Q.add(a);
                    vis[a] = true;
                    boolean found = false;

                    while(!Q.isEmpty()){
                        int cur = (int)Q.poll();
                        if(cur==b){
                            System.out.println(dis[cur]);
                            found = true;
                            break;
                        }

                        for(int x : nodes.get(cur)){
                            if(!vis[x]){
                                Q.add(x);
                                vis[x] = true;
                                dis[x] = dis[cur]+1;
                            }
                        }
                    }

                    if(!found){
                        System.out.println("Not connected");
                    }
                    break;

                case "q":
                    break progloop;
            }

        }
    }



}
