package B;

import java.util.*;

public class BingoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String nk[] = str.split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        String data[] = new String[N];
        for(int i = 0; i < N; i++) {
            data[i] = scanner.nextLine();
        }

        //create 2d array
        int[][] myInt2Darray = new int[N][N];
        for(int i= 0; i< N; i++) {
            String[] s = data[i].split(" ");
            for(int j = 0; j <N; j++) {
                myInt2Darray[i][j] = Integer.parseInt(s[j]);
            } 
        }

        String[] KAraystr = scanner.nextLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String string : KAraystr) {
            list.add(Integer.parseInt(string));
        }
        list.add(0);

        //set o if it is equal to list
        for(int i= 0; i< N; i++) {
            for(int j = 0; j <N; j++) {
                if(list.contains(myInt2Darray[i][j]))
                    myInt2Darray[i][j] = -1;
            } 
        }

        int total = 0;
        for(int i = 0; i <N; i++) {
            //left
            if(true) {
                boolean isHave = false;
                for(int j = 0; j < N; j++){
                    if(myInt2Darray[i][j] == -1){
                        isHave = true;
                    }else {
                        isHave = false;
                        break;
                    }
                }
                total += isHave == true ? 1 : 0; 
            }

            if(true) {
                boolean isHave = false;
                for(int j = 0; j < N; j++){
                    if(myInt2Darray[j][i] == -1){
                        isHave = true;
                    }else {
                        isHave = false;
                        break;
                    }
                }
                total += isHave == true ? 1 : 0;
            }

            if(i == 0) {
                int z = i;
                boolean isHave = false;
                for(int j = 0; j < N && z < N; j++){
                    if(myInt2Darray[z][j] == -1){
                        isHave = true;
                    }else {
                        isHave = false;
                        break;
                    }
                    z++;
                }
                total += isHave == true ? 1 : 0; 

                
            }

            
            if(i == N-1) {
                int z = i;
                boolean isHave = false;
                for(int j = 0; j < N && z >= 0; j++){
                    if(myInt2Darray[z][j] == -1){
                        isHave = true;
                    }else {
                        isHave = false;
                        break;
                    }
                    z--;
                }
                total += isHave == true ? 1 : 0; 
            }
        }

        System.out.println(total);

    }
}
