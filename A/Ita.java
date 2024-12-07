package A;

import java.util.Scanner;

public class Ita {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int findIndex = line.indexOf(" ");
        int r = Integer.parseInt(line.substring(0, findIndex));
        int c = Integer.parseInt(line.substring(findIndex + 1));

        String array[] = new String[r];
        for (int i = 0; i < r; i++) {
            array[i] = sc.nextLine();
        }

        int[][] intdata = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = array[i];
            String myarr[] = s.split(" ");

            for (int j = 0; j < c; j++) {
                intdata[i][j] = Integer.parseInt(myarr[j]);

            }

        }

        int max = 0;
        int left = 0;
        int middle = 0;
        int right = 0;

        int data = 0;
        int temp = 0;
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {
                if (i == 0) {
                    if (intdata[i][j] > max) {
                        max = intdata[i][j];
                        temp = j;
                    }
                } else if (i < r && j < c) {
                    j = temp;
                    if (j - 1 > 0) {
                        left = intdata[i][j - 1];
                        if(left > max) {
                            max = left;
                            temp = j-1;
                        }
                    }
                    middle = intdata[i][j];
                    if(middle > max) {
                        max= middle;
                        temp = j;
                    }
                    if (j + 1 < c) {
                        right = intdata[i][j+1];
                        if(right > max) {
                            max = right;
                            temp = j+1;
                        }
                    }
                    j = c;

                }
            }
            data += max;
            max = 0;
        }

        System.out.println(data);
    }
}
