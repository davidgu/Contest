package Solved; /**
 * Created by david on 29/11/16.
 */



//SOLVED

import java.util.*;

public class ccc08s3 {

    static int[] movR = {0, 1, 0, -1};
    static int[] movC = {1, 0, -1, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i<t; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();

            char[][] grid = new char[r][c];

            for(int j = 0; j<r; j++){
                char[] input = sc.next().toCharArray();
                for(int k = 0; k<c; k++){
                    grid[j][k] = input[k];
                }
            }

            Point pos = new Point(0,0, null);   //X, Y

            Queue<Point> Q = new LinkedList<Point>();
            Q.add(pos);
            boolean vis[][] = new boolean[r][c];
            boolean solved = false;

            while(!Q.isEmpty()){
                Point cur = Q.poll();
                if(cur.r == r-1 && cur.c ==c-1){

                    solved = true;
                    int count = 0;

                    while (cur.pre!=null){
                        cur = cur.pre;
                        count++;
                    }

                    System.out.println(count+1);
                }
                if(grid[cur.r][cur.c]=='+'){
                    for(int l = 0; l<4; l++){
                        int pr = cur.r + movR[l];
                        int pc = cur.c + movC[l];

                        if((pr>=0&&pr<r)&&(pc>=0&&pc<c)&&(grid[pr][pc]!='*')&&!(vis[pr][pc])){
                            Q.add(new Point(pr, pc, cur));
                            vis[pr][pc] = true;

                        }
                    }
                }
                if(grid[cur.r][cur.c]=='-'){
                    for(int m = 0; m<3; m+=2){
                        int px = cur.r + movR[m];
                        int py = cur.c + movC[m];

                        if((px>=0&&px<r)&&(py>=0&&py<c)&&(grid[px][py]!='*')&&!(vis[px][py])){
                            Q.add(new Point(px, py, cur));
                            vis[px][py] = true;
                        }
                    }
                }
                if(grid[cur.r][cur.c]=='|'){
                    for(int n = 1; n<4; n+=2){
                        int px = cur.r + movR[n];
                        int py = cur.c + movC[n];

                        if((px>=0&&px<r)&&(py>=0&&py<c)&&(grid[px][py]!='*')&&!(vis[px][py])){
                            Q.add(new Point(px, py, cur));
                            vis[px][py] = true;
                        }
                    }
                }
            }
            if(!solved) {
                System.out.println("-1");
            }
        }
    }

    static class Point{
        int r, c;
        Point pre;

        Point(int r, int c, Point pre){
            this.r = r;
            this.c = c;
            this.pre = pre;
        }
    }

}
