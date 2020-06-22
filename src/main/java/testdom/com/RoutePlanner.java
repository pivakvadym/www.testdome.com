package testdom.com;

import java.util.*;
//TODO not yet finished
public class RoutePlanner {

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };
        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }

    public static boolean routeExists(int sr, int sc, int dr, int dc, boolean[][] map) {

        // These arrays are used to get row and column numbers of 4 neighbours of a given cell
        int rowNum[] = {-1, 0, 0, 1};
        int colNum[] = {0, -1, 1, 0};
        Point src = new Point(sr,sc);
        Point dest = new Point(dr,dc);
        int ROW = map.length;
        int COL = map.length;

        // check if point(sr;sc) and point(dr;dc) are true. True means valid
        if (!map[src.x][src.y] || !map[dest.x][dest.y]) return false;

        boolean [][]visited = new boolean[ROW][COL];

        // Mark the source cell as visited
        visited[src.x][src.y] = true;

        // Create a queue for BFS
        Queue<QueueNode> q = new LinkedList<>();

        QueueNode s = new QueueNode(src);
        q.add(s); // Enqueue source cell

        // Si la queue n'est pas vide
        while (!q.isEmpty()) {
            QueueNode curr = q.peek();
            Point pt = curr.pt;

            // If we have reached the destination cell,
            if (pt.x == dest.x && pt.y == dest.y)return true;
            // Otherwise dequeue the front cella in the queue and enqueue its adjacent cells
            q.remove();

            for (int i = 0; i < 4; i++) {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                // if adjacent cell is valid, has path and not visited yet, enqueue it.
                if ( (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && map[row][col] == true && !visited[row][col]) {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    QueueNode adjcell = new QueueNode(new Point(row, col));
                    q.add(adjcell);
                }
            }
        }
        return true;
    }

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
    static class QueueNode
    {
        Point pt; // The cordinates of a cell

        public QueueNode(Point pt)
        {
            this.pt = pt;
        }
    };

}