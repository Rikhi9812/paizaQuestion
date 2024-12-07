package B;


import java.util.*;

public class DrivingCar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalNumber = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0 ; i < totalNumber; i++) {
            int temp = sc.nextInt();
            list.add(temp);
            list2.add(temp);
        }

        Collections.sort(list2);
        int max = list2.get(list2.size()-1);
        int counter = 0;
        int  i = 0;
        int j = 0;
        while(list.size() != 0) {
            if(list.get(i) != list2.get(j)){
                if(list.get(i) == max){
                    counter += 1;
                }
                list.add(list.get(i));
                list.remove(i);
            } else{
                list.remove(i);
                j++;
            }
        }
        System.out.println(counter);
        
    }
    
}
