package B;

import java.util.Scanner;

public class Mato {

    static int dRow[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int dCol[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String hw[] = str.split(" ");
        int h = Integer.parseInt(hw[0]);
        int w = Integer.parseInt(hw[1]);

        int grid[][] = new int[h + 1][w + 1];

        int loopCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < loopCount; i++) {
            String inputArray[] = scanner.nextLine().split(" ");
            grid[Integer.parseInt(inputArray[0])][Integer.parseInt(inputArray[1])] = Integer
                    .parseInt(inputArray[2]);
            for (int j = 0; j < 8; j++) {
                int adjx = dRow[j] + Integer.parseInt(inputArray[0]);
                int adjy = dCol[j] + Integer.parseInt(inputArray[1]);
                if(adjx < 0 || adjy < 0 || adjx > h || adjy > w){
                    continue;
                }
                grid[adjx][adjy] = Integer.parseInt(inputArray[3]);
            }
        }

        int loopCount2 = Integer.parseInt(scanner.nextLine());
        int totalAdd = 0;
        for (int l = 0; l < loopCount2; l++) {
            String inputArray[] = scanner.nextLine().split(" ");
            int adjx = Integer.parseInt(inputArray[0]);
            int adjy = Integer.parseInt(inputArray[1]);
            totalAdd += grid[adjx][adjy];
        }

        System.out.println(totalAdd);
        scanner.close();
    }

}
