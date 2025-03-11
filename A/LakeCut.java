package A;

import java.util.*;

public class LakeCut {

    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Direction vectors
    static int dRow[] = { -1, 0, 1, 0 };
    static int dCol[] = { 0, 1, 0, -1 };

    // Function to check if a cell
    // is be visited or not
    static boolean isValid(boolean vis[][],
            int row, int col) {

        // If cell lies out of bounds
        if (row < 0 || col < 0 ||
                row >= vis.length || col >= vis[0].length)
            return false;

        // If cell is already visited
        if (vis[row][col])
            return false;

        // Otherwise
        return true;
    }

    // Function to perform the BFS traversal
    static int BFS(char grid[][], boolean vis[][],
            int row, int col) {

        int toatdata = 1;
        // Stores indices of the matrix cells
        Queue<pair> q = new LinkedList<>();

        // Mark the starting cell as visited
        // and push it into the queue
        q.add(new pair(row, col));
        vis[row][col] = true;

        // Iterate while the queue
        // is not empty
        while (!q.isEmpty()) {
            pair cell = q.peek();
            int x = cell.first;
            int y = cell.second;

            q.remove();

            // Go to the adjacent cells
            for (int i = 0; i < 4; i++) {
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];

                if (isValid(vis, adjx, adjy) && grid[adjx][adjy] == '#') {
                    q.add(new pair(adjx, adjy));
                    vis[adjx][adjy] = true;
                    toatdata++;
                }
            }
        }
        return toatdata;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String hw[] = str.split(" ");
        int h = Integer.parseInt(hw[0]);
        int w = Integer.parseInt(hw[1]);

        char grid[][] = new char[h][w];

        for (int i = 0; i < h; i++) {
            String input = scanner.nextLine();
            char inputArray[] = input.toCharArray();
            for (int j = 0; j < w; j++) {
                grid[i][j] = inputArray[j];
            }
        }

        int totalLake = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '#') {
                    totalLake += 1;
                }
            }
        }
        totalLake--;
        int bfsdata = h * w;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '#') {
                    grid[i][j] = '.';
                    boolean vis[][] = new boolean[grid.length][grid[0].length];
                    for (int k = 0; k < h; k++) {
                        for (int l = 0; l < w; l++) {
                            if (grid[k][l] == '#') {
                                int lake = BFS(grid, vis, k, l);
                                if (lake != totalLake) {
                                    bfsdata--;
                                }
                                k = grid.length;
                                l = grid[0].length;
                            }
                        }
                    }
                    grid[i][j] = '#';
                }
            }
        }
        System.out.println(bfsdata);
    }

}

/*
 * ##..
 * .....
 * ###..
 * ###..
 * #####
 */
