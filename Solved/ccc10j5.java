package Solved;

import java.util.*;



//SOLVED

/**
 * Created by david on 02/12/16.
 */
public class ccc10j5 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Queue<Point> Q = new LinkedList();
        int dist[][] = new int[8][8];
        boolean vis[][] = new boolean[8][8];
        int mov[][] = {{2,1}, {1,2}, {2,-1}, {-1,-2}, {-1,-2}, {-2,-1}, {-2,1}, {-1,2}};

        int x1 = sc.nextInt()-1, y1 = sc.nextInt()-1, x2 = sc.nextInt()-1, y2 = sc.nextInt()-1;

        Q.add(new Point(x1, y1));
        vis[x1][y1] = true;

        if(x1 == x2 && y1 == y2){
            System.out.println(0);
        }

        while(!Q.isEmpty()){
            int r = Q.peek().x;
            int c = Q.peek().y;

            Q.poll();

            for(int i = 0; i<8; i++){
                int movR = r+mov[i][0];
                int movC = c+mov[i][1];

                if(movR>-1&&movR<8&&movC>-1&&movC<8&&!vis[movR][movC]){
                    dist[movR][movC] = dist[r][c] +1;
                    vis[movR][movC] = true;
                    if(movR==x2&&movC==y2){
                        System.out.println(dist[movR][movC]);
                        break;
                    }
                    Q.add(new Point(movR, movC));
                }


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


