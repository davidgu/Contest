package Solved; /**
 * Created by david on 30/11/16.
 */



//SOLVED

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.*;

public class ccc00s3 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String site = br.readLine();
            String buffer = br.readLine();
            String content = "";
            while (!buffer.equals("</HTML>")) {
                content = content.concat(buffer);
                buffer = br.readLine();
            }

            map.put(site, new ArrayList<>());

            for (String x : findUrls(content)) {
                map.get(site).add(x);
                System.out.println("Link from " + site + " to " + x);
            }
        }

        String s1 = br.readLine();

        while(!s1.equals("The End")){
            String s2 = br.readLine();
            Queue<String> Q = new LinkedList<>();
            ArrayList<String> visited = new ArrayList<>();
            Q.add(s1);

            boolean found = false;

            while(!Q.isEmpty()){
                String cur = Q.poll();
                if(cur.equals(s2)){
                    found = true;
                }
                if(map.containsKey(cur)){
                    for(String x : map.get(cur)){
                        if(!visited.contains(x))
                            Q.add(x);
                        visited.add(x);
                    }
                }
            }
            if(found){
                System.out.println("Can surf from "+s1+" to "+s2+".");
            }
            else{
                System.out.println("Can't surf from "+s1+" to "+s2+".");
            }

            s1 = br.readLine();
        }
    }


    static ArrayList<String> findUrls(String toCheck) {
        ArrayList<String> urls = new ArrayList<>();

        Pattern p = Pattern.compile("<A HREF=\"+(\\S+)\"");
        Matcher m = p.matcher(toCheck);

        while (m.find()) {
            String url = m.group();
            urls.add(url.substring(9, url.length() - 1));
        }

        return urls;

    }
}

class Node{

    String url;
    ArrayList<Node> children;

    Node(String url, ArrayList<Node> children){
        this.url = url;
        this.children = children;
    }

}
