package B;

import java.util.Scanner;

public class Buzzing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int T = Integer.parseInt(s[2]);
        int K = Integer.parseInt(s[3]);
        int grid[][] = new int[M][N];
        int gN[] = new int[N];

        for(int i = 0; i < M; i++){
            String inStr = sc.nextLine();
            String[] ins = inStr.split(" ");
            for(int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(ins[j]);
            }
        }

        int t = 0;
        while(t < N) {
            int data = 0;
            int times = 0;
            int  j= 0;
            for(int i = 0; i < M; i++) 
                {
                    data += grid[i][t];
                    if(times > T){
                        data -= grid[j][t];
                        j++;
                        times--;
                    }
                    if(data >= K) {
                        gN[t] = i+1;
                        break;
                    }
                    times += 1;
                }
                t++;
        }

        for(int i = 0; i < N; i++) {
            if(gN[i] > 0) {
                System.out.println("yes " + gN[i]);
            } else {
                System.out.println("no " + 0);
            }
        }

    }
}
