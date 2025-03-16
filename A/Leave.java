import java.util.Scanner;
import java.util.Stack;

public class Leave {

    static class pair {
		int first;
		int second;

		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static int dRow[] = { -1, 0, 1, 0 };
	static int dCol[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		
		int h = Integer.parseInt(line[0]);
		int w = Integer.parseInt(line[1]);

		char grid[][] = new char[h][w];
		for (int i = 0; i < h; i++) {
			char array[] = sc.nextLine().toCharArray();
			for (int j = 0; j < w; j++) {
				grid[i][j] = array[j];
			}
		}

		boolean yesno = false;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (grid[i][j] == 'S' || grid[i][j] == 's') {
					yesno = DFS(grid, i, j);
					i = h;
					j = w;
				}
			}
		}
		
		System.out.println(yesno ? "YES" : "NO");

		sc.close();
	}

	private static boolean DFS(char[][] grid, int r, int c) {
		boolean visited[][] = new boolean[grid.length][grid[0].length];
		Stack<pair> st = new Stack<>();
		st.push(new pair(r, c));
		while (!st.isEmpty()) {

			pair cell = st.pop();
			int first = cell.first;
			int second = cell.second;

			if (isVisitedAndValided(visited, grid, first, second)) {
				visited[first][second] = true;
				for (int i = 0; i < 4; i++) {
					int adjx = first + dRow[i];
					int adjy = second + dCol[i];
					if (isVisitedAndValided(visited, grid, adjx, adjy) && grid[adjx][adjy] == '.') {
						st.push(new pair(adjx, adjy));
						if (adjx == 0 || adjy == 0 || adjx == grid.length-1 || adjy == grid[0].length-1) {
							return true;
						}
					}

				}
			}

		}
		return false;
	}

	private static boolean isVisitedAndValided(boolean[][] visited, char[][] grid, int r, int c) {
		if (r < 0 || c < 0 || r >= visited.length || c >= visited[0].length) {
			return false;
		}
		if (visited[r][c] || grid[r][c] == '#') {
			return false;
		}
		return true;
	}

}
