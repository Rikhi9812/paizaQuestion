package B;

import java.util.Scanner;

public class Paiza {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String hw[] = str.split(" ");
        int h = Integer.parseInt(hw[0]);
        int w = Integer.parseInt(hw[1]);

        String str1 = scanner.nextLine();
        String LR[] = str1.split(" ");
        int L = Integer.parseInt(LR[0]);
        int R = Integer.parseInt(LR[1]);

        char grid[][] = new char[h][w];

        for (int i = 0; i < h; i++) {
            char inputArray[] = scanner.nextLine().toCharArray();
            for (int j = 0; j < w; j++) {
                grid[i][j] = inputArray[j];
            }
        }

        StringBuilder builder = new StringBuilder();
        boolean visited[][] = new boolean[h][w];
        boolean left = false, right = true, up = false, down = false;
        int total = h * w;
        int i = 0, k = 0, l = 0;
        while (i < total) {
            if (right) {
                if (isVisited(visited, k, l)) {
                    visited[k][l] = true;
                    builder.append(grid[k][l]);
                    l++;
                } else {
                    right = false;
                    down = true;
                    k++;
                    l--;
                    continue;
                }
            }
            if (down) {
                if (isVisited(visited, k, l)) {
                    visited[k][l] = true;
                    builder.append(grid[k][l]);
                    k++;
                } else {
                    down = false;
                    left = true;
                    k--;
                    l--;
                    continue;
                }
            }
            if (left) {
                if (isVisited(visited, k, l)) {
                    visited[k][l] = true;
                    builder.append(grid[k][l]);
                    l--;
                } else {
                    left = false;
                    up = true;
                    k--;
                    l++;
                    continue;
                }
            }
            if (up) {
                if (isVisited(visited, k, l)) {
                    visited[k][l] = true;
                    builder.append(grid[k][l]);
                    k--;
                } else {
                    up = false;
                    right = true;
                    k++;
                    l++;
                    continue;
                }
            }
            i++;
        }

        System.out.println(builder.toString().substring(L - 1, R));

        scanner.close();
    }

    private static boolean isVisited(boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= visited.length || col >= visited[0].length) {
            return false;
        }
        if (visited[row][col])
            return false;
        return true;
    }

    public static String spiralTraverse(String[][] boxArray) {
        if (boxArray == null || boxArray.length == 0) {
            return "";
        }

        int k = 0, l = 0; // Start row and column
        int h = boxArray.length; // End row
        int w = boxArray[0].length; // End column

        StringBuilder builder = new StringBuilder();

        while (k < h && l < w) {
            // Traverse from left to right
            for (int j = l; j < w; j++) {
                builder.append(boxArray[k][j]);
            }
            k++; // Move the top boundary down

            // Traverse from top to bottom
            for (int i = k; i < h; i++) {
                builder.append(boxArray[i][w - 1]);
            }
            w--; // Move the right boundary left

            // Traverse from right to left (if there are rows remaining)
            if (k < h) {
                for (int j = w - 1; j >= l; j--) {
                    builder.append(boxArray[h - 1][j]);
                }
                h--; // Move the bottom boundary up
            }

            // Traverse from bottom to top (if there are columns remaining)
            if (l < w) {
                for (int i = h - 1; i >= k; i--) {
                    builder.append(boxArray[i][l]);
                }
                l++; // Move the left boundary right
            }
        }

        return builder.toString();
    }

}
