package B;

import java.util.*;
public class MatchingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int times = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);
        int w = Integer.parseInt(line[2]);

        String[][] array = new String[h][w];

        String r = "r";
        String b = "b";
        String o = "o";

        for(int n = 0; n < times; n++){
            //red
            String[] red = sc.nextLine().split(" ");
            for(int i = Integer.parseInt(red[1]); i < Integer.parseInt(red[2]) +  Integer.parseInt(red[1]); i++){
                for(int j = Integer.parseInt(red[0]); j < Integer.parseInt(red[2]) +Integer.parseInt(red[0]); j++){
                    if(i < h && j < w){
                        if(array[i][j] == null || array[i][j] == r){
                            array[i][j] = r;
                        } else {
                            array[i][j] = array[i][j] == b ? o : b;
                        }
                    }
                }
            }

            //red
            String[] blue = sc.nextLine().split(" ");
            for(int i = Integer.parseInt(blue[1]); i < Integer.parseInt(blue[2]) + Integer.parseInt(blue[1]); i++){
                for(int j = Integer.parseInt(blue[0]); j < Integer.parseInt(blue[2]) + Integer.parseInt(blue[0]); j++){
                    if(i < h && j < w){
                        if(array[i][j] == null || array[i][j] == b){
                            array[i][j] = b;
                        } else {
                            array[i][j] = array[i][j] == r ? o : r;
                        }
                    }
                }
            }

            //red
            String[] orange = sc.nextLine().split(" ");
            for(int i = Integer.parseInt(orange[1]); i < Integer.parseInt(orange[2]) + Integer.parseInt(orange[1]); i++){
                for(int j = Integer.parseInt(orange[0]); j < Integer.parseInt(orange[2]) + Integer.parseInt(orange[0]); j++){
                    if(i < h && j < w){
                        if(array[i][j] == null || array[i][j] == o ){
                            array[i][j] = o;
                        } else {
                            array[i][j] = array[i][j] == b ? r : b;
                        }
                    }
                }
            }
        }

        int redCount = 0;
        int blueCount = 0;
        int orangeCount = 0; 

        for(int i = 0; i< h; i++) {
            for(int j = 0; j< w; j++){
                if(array[i][j] == r) {
                    redCount += 1;
                }
                if(array[i][j] == b) {
                    blueCount += 1;
                }
                if(array[i][j] == o) {
                    orangeCount += 1;
                }
            }
        }

        System.out.println(redCount + " " + blueCount + " " + orangeCount);
    }
}