package B;

import java.util.Scanner;

public class CrossingTQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int grid[][] = new int[N][M];
        int gM[] = new int[M];
        int gA[] = new int[M];
        for(int i = 0; i < N; i++){
            String inStr = sc.nextLine();
            String[] ins = inStr.split(" ");
            for(int j = 0; j < M; j++) {
                int temp = isNumber(ins[j]) ? Integer.parseInt(ins[j]) : -1;
                if(temp < 0 || temp > 100){
                    grid[i][j] = -1;
                } else {
                    grid[i][j] = Integer.parseInt(ins[j]);
                }
            }
        }
        int k = 0;
        while(k < M) {
            for(int i = 0; i< N; i++) {
                if(grid[i][k] > -1) {
                    gA[k] += 1;
                gM[k] += grid[i][k];
                }
            }
            k++;
        }

        for(int i = 0; i< M; i++) {
            if(gA[i] == 0) {
                System.out.println(0);
            } else {
            System.out.println(gM[i]/gA[i]);
            }
    
        }
    }
    public static boolean isNumber(String st) {
        try {
            Integer.parseInt(st);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    } 
}
