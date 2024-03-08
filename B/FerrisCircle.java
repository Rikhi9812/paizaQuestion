package B;

import java.util.*;
public class FerrisCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c, m;
        String cm = sc.nextLine();
        int nwspaceIndex = cm.indexOf(" ");
        c = Integer.parseInt(cm.substring(0, nwspaceIndex));
        m = Integer.parseInt(cm.substring(nwspaceIndex+1));

        Map<Integer, Integer> mapc = new HashMap<>();
        Map<Integer, Integer> mapg = new HashMap<>();
        Map<Integer, Integer> mapcm = new HashMap<>();
        for(int i=0; i< c; i++) {
            mapc.put(i, sc.nextInt());
            mapcm.put(i, 0);
        }
        int ppl = 0;

        for(int i=0; i< m; i++) {
            int a = sc.nextInt();
            ppl += a;
            mapg.put(i, a);
        }

        int i = 0; //group
        int j = 0; //circle

        System.out.println();
        mapcm.forEach((a,b) -> {
            System.out.println(mapcm.get(a));
        });
        System.out.println();
        mapg.forEach((a,b) -> {
            System.out.println(mapg.get(a));
        });
        System.out.println();
        mapc.forEach((a,b) -> {
            System.out.println(mapc.get(a));
        });
        System.out.println();
        
        while(ppl > 0) {


                if(mapg.get(i) <= mapc.get(j)){
                    mapcm.replace(j,  Integer.valueOf(mapg.get(i)) +  Integer.valueOf(mapcm.get(j)));
                    ppl = ppl - mapg.get(i);
                    i++;
                    j++;
                } else {
                    mapcm.replace(j,  Integer.valueOf(mapc.get(j)) +  Integer.valueOf(mapcm.get(j)));
                    ppl = ppl - mapc.get(j);
                    mapg.replace(i, Integer.valueOf(mapg.get(i)) -  Integer.valueOf(mapc.get(j)));
                    j++;
                }

                if(j > c-1){
                    j=0;
                }
            }

            mapcm.forEach((a,b) -> {
                System.out.println(mapcm.get(a));
            });

    }
    
}
