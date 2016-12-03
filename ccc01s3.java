/**
 * Created by david on 01/12/16.
 */

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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

        int roads = 0;

        while(!buffer.equals("**")){
            char[] C= buffer.toCharArray();
            nodes.get(((int)C[0])-65).add(((int)C[1])-65);
            nodes.get(((int)C[1])-65).add(((int)C[0])-65);
            roads++;
            buffer = br.readLine();
        }

        for(int i = 0; i<26; i++){
            for(int j=0; i<nodes.get(i).size(); i++){

                nodes.get(i).remove(j);
                nodes.get(j).remove(i);

                if(dfs(nodes, 0, 1)){
                    char a = (char)(i+39);
                    char b = (char)(j+39);
                    String ab = Character.toString(a)+Character.toString(b);
                    ess.add(ab);
                }

                nodes.get(i).add(j);
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
                return found = dfs_rec(nodes, visited, w, e);
            }
        }
        return found;
    }




}
