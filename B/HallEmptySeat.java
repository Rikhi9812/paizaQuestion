package B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HallEmptySeat {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        // System.out.println(str);

        int spaceN = str.indexOf(" ");
        int N = Integer.parseInt(str.substring(0, spaceN));

        String strH = str.substring(spaceN+1);
        int spaceH = strH.indexOf(" ");
        int H = Integer.parseInt(strH.substring(0, spaceH));

        String strW = strH.substring(spaceH+1);
        int spaceW = strW.indexOf(" ");
        int W = Integer.parseInt(strW.substring(0, spaceW));

        String strP = strW.substring(spaceW+1);
        int spaceP = strP.indexOf(" ");
        int P = Integer.parseInt(strP.substring(0, spaceP));

        int Q = Integer.parseInt(strP.substring(spaceP+1));

        ArrayList<Integer> findmin = new ArrayList<>();
        String[][] HW = new String[H][W];
        for(int i=0; i < H; i++){
            for(int j=0; j< W; j++) {
                HW[i][j] = "Empty";
            }
        }

        for(int i = 0; i < N; i++) {
            String pq = s.nextLine();
            int spacePQ= pq.indexOf(" ");
            int p = Integer.parseInt(pq.substring(0, spacePQ));
            int q = Integer.parseInt(pq.substring(spacePQ+1));
            HW[p][q] = "Not Empty";  
        }

        for(int i=0; i < H; i++){
            for(int j=0; j< W; j++) {
                if(HW[i][j] == "Empty"){
                    findmin.add((Math.abs(P-i)+Math.abs(Q-j)));
                }
            }
        }

        Collections.sort(findmin);

        int min = findmin.get(0);

        for(int i=0; i < H; i++){
            for(int j=0; j< W; j++) {
                if(HW[i][j] == "Empty" && ((Math.abs(P-i)+Math.abs(Q-j)) == min)){
                    System.out.println(i + " " +j);
                }
            }
        }


    }
}
