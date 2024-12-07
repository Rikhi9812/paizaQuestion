package A;

import java.util.Scanner;

public class Snake {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String hw[] = str.split(" ");
        int h = Integer.parseInt(hw[0]);
        int w = Integer.parseInt(hw[1]);

        String boxArray[][] = new String[h][w];

        for (int i = 0; i < h; i++) {
            String input = scanner.nextLine();
            String inputArray[] = input.split("");
            for (int j = 0; j < w; j++) {
                boxArray[i][j] = inputArray[j];
            }
        }

        int count = 0;
        count = recurisveCheck(boxArray, count, h, w);
        System.out.println(count);

    }

    public static int recurisveCheck(String[][] boxArray, int count, int h, int w) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (".".equals(boxArray[i][j]) && i < h && j < w) {
                    boxArray[i][j] = "O";
                    recurisveCheckLeft(boxArray, i, j - 1, h, w);
                    recurisveCheckRight(boxArray, i, j + 1, h, w);
                    recurisveCheckBottom(boxArray, i + 1, j, h, w);
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void recurisveCheckLeft(String[][] boxArray, int i, int j, int h, int w) {
        if (i < h && j < w && i > -1 && j > -1 && ".".equals(boxArray[i][j])) {
            boxArray[i][j] = "O";
            recurisveCheckLeft(boxArray, i, j - 1, h, w);
            recurisveCheckRight(boxArray, i, j + 1, h, w);
            recurisveCheckBottom(boxArray, i + 1, j, h, w);
        }
    }

    public static void recurisveCheckBottom(String[][] boxArray, int i, int j, int h, int w) {
        if (i < h && j < w && i > -1 && j > -1 && ".".equals(boxArray[i][j])) {
            boxArray[i][j] = "O";
            recurisveCheckLeft(boxArray, i, j - 1, h, w);
            recurisveCheckRight(boxArray, i, j + 1, h, w);
            recurisveCheckBottom(boxArray, i + 1, j, h, w);
        }
    }

    public static void recurisveCheckRight(String[][] boxArray, int i, int j, int h, int w) {
        if (i < h && j < w && i > -1 && j > -1 && ".".equals(boxArray[i][j])) {
            boxArray[i][j] = "O";
            recurisveCheckLeft(boxArray, i, j - 1, h, w);
            recurisveCheckRight(boxArray, i, j + 1, h, w);
            recurisveCheckBottom(boxArray, i + 1, j, h, w);
        }
    }

}
