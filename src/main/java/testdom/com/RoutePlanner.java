package testdom.com;

import java.util.*;

public class RoutePlanner {

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };
        System.out.println(routeExists(0, 2, 0, 0, mapMatrix));
    }

    static int ROW = 3;
    static int COL = 3;

    public static boolean routeExists(int sr, int sc, int dr, int dc, boolean[][] map) {

        Point src = new Point(sr,sc);
        Point dest = new Point(dr,dc);

        // check if point(sr;sc) and point(dr;dc) are true. True means valid
        if (!map[src.x][src.y] || !map[dest.x][dest.y]) return false;

        boolean [][]visited = new boolean[ROW][COL];

        // Mark the source cell as visited
        visited[src.x][src.y] = true;

        // Create a queue for BFS
        Queue<queueNode> q = new LinkedList<>();

        // Distance of source cell is 0
        queueNode s = new queueNode(src);
        q.add(s); // Enqueue source cell

        // Do a BFS starting from source cell
        while (!q.isEmpty()) {
            queueNode curr = q.peek();
            Point pt = curr.pt;

            // If we have reached the destination cell,
            // we are done
            if (pt.x == dest.x && pt.y == dest.y)
                return true;

            // Otherwise dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            q.remove();

            for (int i = 0; i < 4; i++) {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.
                if (isValid(row, col) &&
                        map[row][col] == true &&
                        !visited[row][col]) {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    queueNode Adjcell = new queueNode(new Point(row, col));
                    q.add(Adjcell);
                }
            }
        }
        return true;
    }
    // check whether given cell (row, col)
    // is a valid cell or not.
    static boolean isValid(int row, int col)
    {
        // return true if row number and
        // column number is in range
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);
    }

    // These arrays are used to get row and column
// numbers of 4 neighbours of a given cell
    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};


    static class Point
    {
        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    };

    // A Data Structure for queue used in BFS
    static class queueNode
    {
        Point pt; // The cordinates of a cell

        public queueNode(Point pt)
        {
            this.pt = pt;
        }
    };

}