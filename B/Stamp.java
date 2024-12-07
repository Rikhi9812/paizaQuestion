package B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stamp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String hw[] = str.split(" ");
        int h = Integer.parseInt(hw[0]);
        int w = Integer.parseInt(hw[1]);
        int N = Integer.parseInt(hw[2]);

        List<String[][]> list = new ArrayList<>();

        for (int k = 0; k < N; k++) {
            String boxArray[][] = new String[h][w];
            for (int i = 0; i < h; i++) {
                String input = scanner.nextLine();
                String inputArray[] = input.split("");
                for (int j = 0; j < w; j++) {
                    boxArray[i][j] = inputArray[j];
                }
            }
            list.add(boxArray);
        }

        String str1 = scanner.nextLine();
        String hw2[] = str1.split(" ");
        int h2 = Integer.parseInt(hw2[0]);
        int w2 = Integer.parseInt(hw2[1]);

        int boxArray1[][] = new int[h2][w2];

        for (int i = 0; i < h2; i++) {
            String input = scanner.nextLine();
            String inputArray[] = input.split(" ");
            for (int j = 0; j < w2; j++) {
                boxArray1[i][j] = Integer.parseInt(inputArray[j]);
            }
        }
        String boxArray2[][] = new String[h2 * h][w2 * w];
        int a =0;
        int b = 0;
        for (int i = 0; i < h2; i++) {
            a = i * h;
            for (int j = 0; j < w2; j++) {
                b = j * w;
                int data = boxArray1[i][j];
                String temp[][] = list.get(data - 1);
                for (int k = 0; k < temp.length; k++) {
                    for (int l = 0; l < temp[k].length; l++) {
                        boxArray2[a+k][b+l] = temp[k][l];
                    }
                }
            }
        }
        for (int i = 0; i < boxArray2.length; i++) {
            for (int j = 0; j < boxArray2[i].length; j++) {
                System.out.print(boxArray2[i][j]);
            }
            System.out.println();
        }

    }

}
