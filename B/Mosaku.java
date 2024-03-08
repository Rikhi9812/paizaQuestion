package B;

import java.util.*;
public class Mosaku {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n, m, h, w;
        String nm = sc.nextLine();
        String hw = sc.nextLine();

        int nwspaceIndex = nm.indexOf(" ");
        n = Integer.parseInt(nm.substring(0, nwspaceIndex));
        m = Integer.parseInt(nm.substring(nwspaceIndex+1));

        int hwspaceIndex = hw.indexOf(" ");
        h = Integer.parseInt(hw.substring(0, hwspaceIndex));
        w = Integer.parseInt(hw.substring(hwspaceIndex+1));

        String[] mstr = new String[n];
        for(int i = 0; i < n; i++) {
            mstr[i] = sc.nextLine();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< m; i++) {
            map.put(i+1, 0);
        }

        String[][] setChar = new String[h][w];

        for(int i = 0; i < h; i++) {
            for(int j=0; j < w; j++) {
                setChar[i][j] = ".";
            }
        }

        for(int i = 0; i < n; i++) {
            String str = mstr[i];
            //first line 
            int fSpace = str.indexOf(" ");
            int fline = Integer.parseInt(str.substring(0, fSpace));
            //second line
            String strsline = str.substring(fSpace+1);
            int sSpace = strsline.indexOf(" ");
            int sline = Integer.parseInt(strsline.substring(0, sSpace));
            //first column
            String strfcolumn = strsline.substring(sSpace+1);
            int fcSpace = strfcolumn.indexOf(" ");
            int fcline = Integer.parseInt(strfcolumn.substring(0, fcSpace));
            //second column
            String strscolumn = strfcolumn.substring(fcSpace+1);
            int scSpace = strscolumn.indexOf(" ");
            int scline = Integer.parseInt(strscolumn.substring(0, scSpace));
            //value
            int value = Integer.parseInt(strscolumn.substring(scSpace+1));

            for(int a = fline-1; a < sline; a++) {
                for(int b = fcline-1; b < scline; b++){
                    
                        if(setChar[a][b] != "." && map.containsKey(Integer.parseInt(setChar[a][b]))){
                            map.replace(Integer.parseInt(setChar[a][b]), Integer.valueOf(map.get(Integer.parseInt(setChar[a][b]))+1));
                        }
                        setChar[a][b] = String.valueOf(value);
                }
            }

            
        }
        map.forEach((a, b) -> {
            System.out.println(map.get(a));
        });

        for(String[] i : setChar) {
            for(String j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        
    }
}