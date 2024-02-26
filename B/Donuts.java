package B;

import java.util.*;
public class Donuts {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        char[][] setChar = new char[height][width];

        for(int i = 0; i < height; i++) {
            String addchar = sc.next();
            for(int j = 0; j < width; j++) {
                setChar[i][j] = addchar.charAt(j);
            }
        }

        int ans = 0;

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(j+2 < width && i+2 < height){
                    if(setChar[i][j] == '#' && setChar[i][j+1] == '#' && setChar[i][j+2] == '#' && setChar[i+1][j] == '#' && setChar[i+1][j+1] == '.' && setChar[i+1][j+2] == '#' && setChar[i+2][j] == '#' && setChar[i+2][j+1] == '#' && setChar[i+2][j+2] == '#') {
                        ans  += 1;
                    }
                }
            }
        }

        System.out.println(ans);

    }
    
}