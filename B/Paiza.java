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

        String boxArray[][] = new String[h][w];

        for (int i = 0; i < h; i++) {
            String input = scanner.nextLine();
            String inputArray[] = input.split("");
            for (int j = 0; j < w; j++) {
                boxArray[i][j] = inputArray[j];
            }
        }

        int i = 0;
        int j = 0;
        int k = -1;
        int l = -1;
        String lrtb = "l";
        StringBuilder builder = new StringBuilder();
        String answer = roundFunction(boxArray, i, j, k, l, h, w, lrtb, builder);
        System.out.println(answer.substring(L - 1, R));

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

    public static String roundFunction(String[][] boxArray, int i, int j, int k, int l, int h, int w, String lrtb,
            StringBuilder builder) {
        if (i > k && j > l && i < h && j < w) {
            builder.append(boxArray[i][j]);
            if (lrtb.equals("l")) {
                if (j + 1 == w) {
                    roundFunction(boxArray, i + 1, j, k + 1, l, h, w, "b", builder);
                } else {
                    roundFunction(boxArray, i, j + 1, k, l, h, w, "l", builder);
                }
            } else if (lrtb.equals("b")) {
                if (i + 1 == h) {
                    roundFunction(boxArray, i, j - 1, k, l, h, w - 1, "r", builder);
                } else {
                    roundFunction(boxArray, i + 1, j, k, l, h, w, "b", builder);
                }
            } else if (lrtb.equals("r")) {
                if (j == l + 1) {
                    roundFunction(boxArray, i - 1, j, k, l, h - 1, w, "t", builder);
                } else {
                    roundFunction(boxArray, i, j - 1, k, l, h, w, "r", builder);
                }
            } else if (lrtb.equals("t")) {
                if (i == k + 1) {
                    roundFunction(boxArray, i, j + 1, k, l + 1, h, w, "l", builder);
                } else {
                    roundFunction(boxArray, i - 1, j, k, l, h, w, "t", builder);
                }
            }
        }

        return builder.toString();
    }

}
