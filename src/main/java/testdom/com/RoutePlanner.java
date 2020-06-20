package testdom.com;

import java.util.*;

public class RoutePlanner {

    public static boolean routeExists(int sr, int sc, int dr, int dc, boolean[][] map) {

        // check if point(sr;sc) and point(dr;dc) are true. True means valid
        if (!map[sr][sc] || !map[dr][dc]) return false;

        if (sr < dr){
            for(int i = sr, j = sc; i <= dr && j <= dc ;){
                if (i+1 != map.length && map[i][j] == map[i+1][j]){
                    i++;
                    System.out.println("--------"+i+" "+j);
                }else if (j+1 != map.length && map[i][j] == map[i][j+1]){
                    j++;
                    System.out.println("--------"+i+" "+j);
                }else if (i == dr && j == dc){
                    return  true;
                }else{
                    return false;
                }
            }
        }else{
            for(int i=sr, j=sc; dr<=i && dc<=j ;){
                if (i-1 >= 0 && map[i][j] == map[i-1][j]){
                    i--;
                    System.out.println("--------"+i+" "+j);
                }else if (j-1 >= 0 && map[i][j] == map[i][j-1]){
                    j--;
                    System.out.println("--------"+i+" "+j);
                }else if (i == dr && j == dc){
                    return  true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };
        System.out.println(routeExists(0, 0, 1, 1, mapMatrix));
    }

}