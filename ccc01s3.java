/**
 * Created by david on 01/12/16.
 */



//SOLVED

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ccc01s3 {

//      Dfs a path, remove a connection, dfs again.
//      if it fails, add paths to list of essential ones
//      else, put it back, remove another and dfs again

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

        ArrayList<String> ess = new ArrayList<>();

        for(int i = 0; i<26; i++){
            nodes.add(new ArrayList<>());
        }

        String buffer = br.readLine();

        ArrayList<String> used = new ArrayList<>();

        while(!buffer.equals("**")){
            char[] C= buffer.toCharArray();
            nodes.get(((int)C[0])-65).add(((int)C[1])-65);
            nodes.get(((int)C[1])-65).add(((int)C[0])-65);
            buffer = br.readLine();
        }

        for(int i = 0; i<26; i++){
            for(int j=0; j<nodes.get(i).size(); j++) {

                int temp = nodes.get(i).get(j);

                char a = (char) (i + 65);
                char b = (char) (temp + 65);
                String ba = Character.toString(b) + Character.toString(a);

                if (!used.contains(ba)) {

                    nodes.get(i).remove(j);
                    int place = nodes.get(temp).indexOf(i);
                    nodes.get(temp).remove((Integer) i);


                    if (!dfs(nodes, 0, 1)) {
                        String ab = Character.toString(a) + Character.toString(b);
                        ess.add(ab);
                        used.add(ab);
                    }

                    nodes.get(i).add(j, temp);
                    nodes.get(temp).add(place, i);
                }
            }
        }

        for(String x : ess){
            System.out.println(x);
        }

        if(ess.size()>0){
            System.out.println("There are "+ess.size()+" disconnecting roads.");
        }
        else{
            System.out.println("There are 0 disconnecting roads.");
        }



    }

    static boolean dfs(ArrayList<ArrayList<Integer>> nodes, int s, int e){
        boolean[] visited = new boolean[nodes.size()];
        boolean found = dfs_rec(nodes, visited, s, e);
        return found;
    }

    static boolean dfs_rec(ArrayList<ArrayList<Integer>> nodes, boolean[] visited, int v, int e){
        visited[v] = true;
        boolean found = false;
        if(v==e){
            found = true;
            return found;
        }
        for(int w : nodes.get(v)){
            if(!visited[w]){
                found = dfs_rec(nodes, visited, w, e);
                if(found){
                    return found;
                }
            }
        }
        return found;
    }
}
