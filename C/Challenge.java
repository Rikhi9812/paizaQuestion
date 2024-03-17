 package C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Challenge {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int  num = s.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        String str = "";
        for(int i = 0; i < 2; i++) {

             str = s.nextLine();
        }

        for(int i= 0; i < num-1; i++){
            int indexSpace = str.indexOf(" ");
            list.add(Integer.parseInt(str.substring(0, indexSpace)));
            str = str.substring(indexSpace+1);
        }

        list.add(Integer.parseInt(str));
        Collections.sort(list);
        list.remove(0);
        list.remove(num-2);
        double d  =   list.stream().mapToInt(a -> a).sum();
        double size = list.size();
        Double avg = d/size;
        String st = new String(avg.toString());
        int stindex = st.indexOf(".");
         st = st.substring(0, stindex+2);
         System.out.println(st);
    


    }
    
}