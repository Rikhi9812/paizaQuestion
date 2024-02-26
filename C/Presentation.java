package C;

import java.util.Scanner;

public class Presentation {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int findSpace1 = line.indexOf(" ");
        String line2 = line.substring(findSpace1 +1);
        int findSpace2 = line2.indexOf(" ");
        int totalPeople = Integer.parseInt(line.substring(0, findSpace1));
        int Aplayers = Integer.parseInt(line2.substring(0, findSpace2));
        int Bplayesrs = Integer.parseInt(line2.substring(findSpace2+1));

        String output[] = new String[totalPeople];
        
        output = returnAB(output, totalPeople, Aplayers, "A", Aplayers);
        output = returnAB(output, totalPeople, Bplayesrs, "B", Bplayesrs);

        for(int i = 0; i < output.length; i++) {
            if(output[i] == null) {
                output[i] = "N";
            }
        }
        for(String i : output) {
            
            System.out.println(i);
        }
    }

    public static String[] returnAB(String array[], int totalPeople, int number, String a, int addnumber) {
        if(array[number-1] != null) {
            array[number-1] = "AB";
        } else {
            array[number-1] = a;
        }
        if(totalPeople >= number + addnumber) {
           returnAB(array, totalPeople, number+addnumber, a, addnumber);
        }
        return array;
    } 
}
