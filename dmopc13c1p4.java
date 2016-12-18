import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by David on 2016-12-10.
 */
public class dmopc13c1p4 {

    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int[] cM = {0, 1, 0, -1};
        int[] rM = {1, 0, -1, 0};

//        int t = Integer.parseInt(br.readLine());
        int t = sc.nextInt();

        for(int i = 0; i<t; i++){
//            int l = Integer.parseInt(br.readLine());
//            int w = Integer.parseInt(br.readLine());

            int l = sc.nextInt();
            int w = sc.nextInt();

            Point compCoord = new Point(0,0);

            char[][] map = new char[w][l];
            boolean[][] vis = new boolean[w][l];
            int[][] dis = new int[w][l];

            sc.nextLine(); //Consume EOL
            for(int r = 0; r<w; r++){
                String input = sc.nextLine();
                for(int c = 0; c<l; c++){
                    map[r][c] = input.charAt(c);
                    if(map[r][c]=='C'){
                        compCoord.x = c;
                        compCoord.y = r;
                    }
                }
//                br.read();  //Consume EOL
            }

            Queue<Point> Q = new LinkedList<>();

            Q.add(compCoord);
            vis[compCoord.y][compCoord.x] = true;

            int dist = 999999999;

            while(!Q.isEmpty()){
                Point cur = Q.poll();
//                System.out.println("Current Point: "+cur.x+","+cur.y);
                for(int j = 0; j<4; j++){
                    int c = cur.x;
                    int r = cur.y;

                    c+=cM[j];
                    r+=rM[j];

                    if ((c>=0)&&(r>=0)&&(c<l)&&(r<w)){
                        if (map[r][c] == 'O' && !vis[r][c]) {
                            Q.add(new Point(c, r));
                            vis[r][c] = true;
                            dis[r][c] = dis[cur.y][cur.x] + 1;
                        } else if (map[r][c] == 'W') {
                            if(dis[cur.y][cur.x]+1<dist){
                                dist = dis[cur.y][cur.x]+1;
                            }
                        }
                    }
                }
            }
            if (dist > 60) {
                System.out.println("#notworth");
            } else {
                System.out.println(dist);
            }
        }
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
