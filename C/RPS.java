package C;

import java.util.*;
public class RPS {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
       String[] str = new String[number+1];
        char[] aisa = new char[number];
        char[] babi = new char[number];
    for(int i = 0; i < number +1; i++) {
        str[i] = sc.nextLine(); 
    }
    
    for(int i = 0; i < number; i++) {
        aisa[i] = str[i+1].charAt(0);
        babi[i] = str[i+1].charAt(2);
    }
    
    int total = 0;
    for(int i = 0; i < number; i++) {
        if(aisa[i] == 'G' && babi[i] == 'C') {
             total += 1;
        }
        
        if(aisa[i] == 'C' && babi[i] == 'P') {
             total += 1;
        }
        
        if(aisa[i] == 'P' && babi[i] == 'G') {
             total += 1;
        }
    }  
     
        System.out.println(total);
    }
}
