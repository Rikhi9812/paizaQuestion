package B;

import java.util.*;
public class Bakesake {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int h, w, saltTotal;
        String hw = "";
        for(int i = 1; i < 2; i++){
            hw = sc.nextLine();
        }
        int spaceIndex = hw.indexOf(" ");
        h = Integer.parseInt(hw.substring(0, spaceIndex));
        w = Integer.parseInt(hw.substring(spaceIndex+1));
        char[][] setChar = new char[h][w];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                setChar[i][j] = '0';
            }
        }

        saltTotal = sc.nextInt();
        String saltStr[] = new String[saltTotal+1];

        for(int i = 0; i < saltTotal+1; i++) {
            saltStr[i] = sc.nextLine();
        }

        for(int i = 0; i < saltTotal; i++) {
            int leftspace = saltStr[i+1].indexOf(" ");
            int left = Integer.parseInt(saltStr[i+1].substring(0, leftspace)) -1;
            int right = Integer.parseInt(saltStr[i+1].substring(leftspace+1)) -1;
            setChar[left][right] = 's';
        }


        int ans = 0;

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(setChar[i][j] == 's') {
                    //left middle
                    if(j-1 >= 0 && setChar[i][j-1] == '0'){
                        setChar[i][j-1] = 'l';
                    }
                    //left top
                    if(i-1 >= 0 && j-1 >= 0 && setChar[i-1][j-1] == '0'){
                        setChar[i-1][j-1] = 'l';
                    }
                    //left bottom
                    if(i+1 < h && j-1 >= 0 && setChar[i+1][j-1] == '0'){
                        setChar[i+1][j-1] = 'l';
                    }
                    //middle top
                    if(i-1 >= 0 && setChar[i-1][j] == '0'){
                        setChar[i-1][j] = 'l';
                    }
                    //middle bottom
                    if(i+1 < h && setChar[i+1][j] == '0'){
                        setChar[i+1][j] = 'l';
                    }

                    //right top
                    if(i-1 >= 0 && j+1 < w && setChar[i-1][j+1] == '0'){
                        setChar[i-1][j+1] = 'l';
                    }
                    //right middle
                    if(j+1 < w && setChar[i][j+1] == '0'){
                        setChar[i][j+1] = 'l';
                    }
                    //right bottom
                    if(i+1 < h && j+1 < w && setChar[i+1][j+1] == '0'){
                        setChar[i+1][j+1] = 'l';
                    }
                }
            }
        }



        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(setChar[i][j] == '0')
                    ans += 1;
            }
        }

        System.out.println(ans);

    }
    
}