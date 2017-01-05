package Solved;

import java.util.*;

/**
 * Created by david on 1/4/17.
 */

//SOLVED

public class ccc03s3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] rmov = {0, 1, 0, -1};
        int[] cmov = {1, 0, -1, 0};

        int F = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        ArrayList<Integer> rooms = new ArrayList<>();

        char[][] map = new char[r][c];
        boolean[][] vis = new boolean[r][c];

        sc.nextLine(); //buffer clear

        for(int i = 0; i<r; i++){
            String input = sc.nextLine();
            for(int j = 0; j<c; j++){
                map[i][j] = input.charAt(j);
                if(input.charAt(j)=='I'){
                    vis[i][j] = true;
                }
            }
        }

        boolean roomfound = true;

        while(roomfound){
            roomfound = false;
            int cursize = 1;
            Point found = null;

            pointfound:
            for(int i = 0; i<r; i++){
                for(int j = 0; j<c; j++){
                    if(!vis[i][j]){
                        vis[i][j] = true;
                        found = new Point(i,j);
                        roomfound = true;
                        break pointfound;
                    }
                }
            }

            if(!roomfound){
                break;
            }

            if(found != null) {

                Queue Q = new LinkedList<Point>();
                Q.add(found);

                while (!Q.isEmpty()) {
                    Point cur = (Point)Q.poll();
                    for(int l = 0; l<4; l++){
                            if(cur.x+rmov[l]>=0&&cur.x+rmov[l]<r&&cur.y+cmov[l]>=0&&cur.y+cmov[l]<c&&(map[cur.x+rmov[l]][cur.y+cmov[l]]=='.')&&!vis[cur.x+rmov[l]][cur.y+cmov[l]]){
                                Q.add(new Point(cur.x+rmov[l], cur.y+cmov[l]));
                                vis[cur.x+rmov[l]][cur.y+cmov[l]] = true;
                                cursize++;
                            }
                    }
                }

                rooms.add(cursize);
            }
        }

        Collections.sort(rooms);

        int roomCount = 0;

        while(rooms.size()>0&&F>=rooms.get(rooms.size()-1)){
            roomCount++;
            F-=rooms.get(rooms.size()-1);
            rooms.remove(rooms.size()-1);
        }

        if(roomCount==0||roomCount!=1){
            System.out.println(roomCount+" rooms, "+F+" square metre(s) left over");
        }
        else if(roomCount==1){
            System.out.println("1 room, "+F+" square metre(s) left over");
        }

    }
}

//class Point{
//
//    int x;
//    int y;
//
//    Point(int x, int y){
//        this.x = x;
//        this.y = y;
//    }
//
//
//}
