/**
 * Created by david on 30/11/16.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.*;

public class ccc00s3 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;

        String s = br.readLine();
        n = Integer.parseInt(s);

//        sc.nextLine();  //Consume last newline char

        ArrayList<String> pages = new ArrayList<>();
        ArrayList<ArrayList<String>> urls = new ArrayList<>();

        Node[] nodes = new Node[n];
        HashMap<String, Node> toNode = new HashMap<>();

        ArrayList<ArrayList<String>> url = new ArrayList<>();



        for(int i = 0; i<n; i++){

                String site = br.readLine();
                nodes[i] = new Node("", new ArrayList<>());
                nodes[i].url = site;
                String buffer = br.readLine();
                url.add(new ArrayList<>());
                toNode.put(site, nodes[i]);
                while (!buffer.equals("</HTML>")) {
                    for (String x : findUrls(buffer)) {
                        if(!toNode.containsKey(x)){
                            toNode.put(x, new Node(x, new ArrayList<Node>()));
                        }
                        nodes[i].children.add(toNode.get(x));
                        System.out.println("Link from " + site + " to " + x);
                    }
                    buffer = br.readLine();
                }



        }

//        for(int i = 0; i<n; i++){
//            for(String x : url.get(i)){
//
//                nodes[i].children.add(findSite(nodes, x));
//            }
//        }


        Queue<Node> Q = new LinkedList<>();
        String buffer = "";

            buffer = br.readLine();

        while(!buffer.equals("The End")){
            Node url2=null;
                url2 = toNode.get(br.readLine());

            boolean found = false;
            Q.add(toNode.get(buffer));
            while(!Q.isEmpty()){
                Node cur = Q.poll();
                if(cur.children.contains(url2)){
                    found = true;
                    break;
                }
                else{
                    for(Node x : cur.children){
                        Q.add(x);
                    }
                }
            }


            if(found){
                System.out.println("Can surf from "+buffer+" to "+url2.url+".");
            }
            else{
                System.out.println("Can't surf from "+buffer+" to "+url2.url+".");
            }
                buffer = br.readLine();
        }

    }

    static ArrayList<String> findUrls(String toCheck){
        ArrayList<String> urls = new ArrayList<>();

        Pattern p = Pattern.compile("<A HREF=\"+(\\S+)\"");
        Matcher m = p.matcher(toCheck);

        while(m.find()){
            String url = m.group();
            urls.add(url.substring(9, url.length()-1));
        }

        return urls;

    }

    static Node findSite(Node[] nodes, String url){
        int pos = 0;

        for(Node n : nodes){
            if(n.url.equals(url)){
                return nodes[pos];
            }
            else{
                pos++;
            }
        }
        return null;
    }

    static int findPos(Node[] nodes, String url){
        int pos = 0;

        for(Node n : nodes){
            if(n.url.equals(url)){
                return pos;
            }
            else{
                pos++;
            }
        }
        return -1;
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