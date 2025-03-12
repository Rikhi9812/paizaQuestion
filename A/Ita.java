package A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Ita {
	static class pair {
        int first, second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int dRow[] = { 1, 1, 1 };
    static int dCol[] = { -1, 0, 1 };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int findIndex = line.indexOf(" ");
        int r = Integer.parseInt(line.substring(0, findIndex));
        int c = Integer.parseInt(line.substring(findIndex + 1));

        int grid[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            String array[] = sc.nextLine().split(" ");
            for (int j = 0; j < c; j++) {
                grid[i][j] = Integer.parseInt(array[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            list.add(grid[0][i]);
        }
        
        int data = list.stream().max((x, y) -> x.compareTo(y)).get();

        System.out.println(list.stream().max((x, y) -> x.compareTo(y)).get());

        sc.close();

    }

    private static Integer DFS(int[][] grid, int row, int col) {
        int collector = grid[row][col];
        Stack<pair> st = new Stack<>();
        st.push(new pair(row, col));
        while (!st.isEmpty()) {
            pair cell = st.pop();
            int left = 0, middle = 0, right = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0 && isValided(grid, cell.first + dRow[i], cell.second + dCol[i])) {
                    left = grid[cell.first + dRow[i]][cell.second + dCol[i]];
                }
                if (i == 1 && isValided(grid, cell.first + dRow[i], cell.second + dCol[i])) {
                    middle = grid[cell.first + dRow[i]][cell.second + dCol[i]];
                }
                if (i == 2 && isValided(grid, cell.first + dRow[i], cell.second + dCol[i])) {
                    right = grid[cell.first + dRow[i]][cell.second + dCol[i]];
                }
            }
            if(left > right && left > middle){
                collector += grid[cell.first + dRow[0]][cell.second + dCol[0]];
                st.push(new pair(cell.first + dRow[0], cell.second + dCol[0]));
            }
            if(middle > left && middle > right){
                collector += grid[cell.first + dRow[1]][cell.second + dCol[1]];
                st.push(new pair(cell.first + dRow[1], cell.second + dCol[1]));
            }
            if(right > left && right > middle){
                collector += grid[cell.first + dRow[2]][cell.second + dCol[2]];
                st.push(new pair(cell.first + dRow[2], cell.second + dCol[2]));
            }
        }
        return collector;
    }

    private static boolean isValided(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        return true;
    }
}