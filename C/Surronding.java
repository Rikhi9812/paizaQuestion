package C;

import java.util.*;
public class Surronding {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(returnbarcket(line));
    }
    
    public static String returnbarcket(String s) {
        int total = s.length() + 2;
        String top = "";
        String temp = "+"+s+"+";
        String bottom = "";
        for(int i = 1; i <= total; i++){
            top += "+";
            bottom += "+";
        }
        return top + "\n" + temp + "\n" + bottom;
    }
}