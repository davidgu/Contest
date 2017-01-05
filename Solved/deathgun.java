package Solved;

import java.util.*;





//SOLVED
//Excellent problem to resolve sometime... Maybe a C++ or Python implementation?

/**
 * Created by David on 2016-12-17.
 */
public class deathgun {

    public static void main(String[] args){
        Map<String, Integer> stoi = new HashMap<>();
        Map<Integer, String> itos = new HashMap<>();
        int[] vertex = new int [900];
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<M; i++) {
            String buffer = sc.nextLine();
            String[] temp = buffer.split(" ");
            String name1 = temp[0];
            String name2 = temp[1];

            if (!stoi.containsKey(name1)) {
                nodes.add(new ArrayList<>());
                stoi.put(name1, count);
                itos.put(count, name1);
                count++;
            }

            if (!stoi.containsKey(name2)) {
                nodes.add(new ArrayList<>());
                stoi.put(name2, count);
                itos.put(count, name2);
                count++;
            }

            nodes.get(stoi.get(name2)).add(stoi.get(name1));
            vertex[stoi.get(name1)]++;
        }

//        Queue<Integer> Q = new LinkedList<>();
//        boolean[] vis = new boolean[nodes.size()];
//
//        for(int x = 0; x<nodes.size(); x++){
//            if(nodes.get(x).size()==0){
//                Q.add(x);
//                vis[x] = true;
//                }
//            }

//            while(true){
//                int cur = Q.poll();
//                System.out.println(itos.get(cur));
//                for(int x : nodes.get(cur)){
//                    vertex[x] --;
//                }
//
//                for(int j = 0; j<nodes.size(); j++){
//                    if(vertex[j]==0&&!vis[j]){
//                        Q.add(j);
//                        vis[j] = true;
//                        break;
//                    }
//                }
//            }
//
//
//
        while(true){
            boolean found = false;
            for(int i = 0; i<stoi.size(); i++){
                if(vertex[i]==0){
                    vertex[i]--;
                    found = true;
                    System.out.println(itos.get(i));
                    for(int x : nodes.get(i)){
                        vertex[x]--;
                    }
                    break;
                }
            }
            if(!found){
                break;
            }
        }

        }





}


