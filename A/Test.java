import java.util.*;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hw = "";
        for(int i = 0; i < 1; i++){
            hw = sc.nextLine();
        }
        int a_1 = 0;
        int a_2 = 0;
        int a_3 = 0;
        int a_4 = 0;
        int a_5 = 0;
        int a_6 = 0;
        int a_7 = 0;
        int a_8 = 0;
        int a_9 = 0;
        int[] array = new int[12];
        int j = 0;
        for(int i = 0; i < 12; i++) {
            array[i] = Integer.parseInt(hw.substring(j, 1+j));
            j += 2;
    }

        for(int i = 0;  i< 12; i++) {
            switch (array[i]) {
                case 1:
                    a_1 += 1;
                    break;
                    case 2:
                    a_2 += 1;
                    break;
                    case 3:
                    a_3 += 1;
                    break;
                    case 4:
                    a_4 += 1;
                    break;
                    case 5:
                    a_5 += 1;
                    break;
                    case 6:
                    a_6 += 1;
                    break;
                    case 7:
                    a_7 += 1;
                    break;
                    case 8:
                    a_8 += 1;
                    break;
                    case 9:
                    a_9 += 1;
                    break;    
            }
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if(a_1 >= 3){
            count += 2;
            a_1 = a_1-3;
            if(a_1 > 0) {
                for(int i = 0; i < a_1; i++) {
                    list.add(1);
                }
            }
        } else{
            if(a_1 > 0) {
                for(int i = 0; i < a_1; i++) {
                    list.add(1);
                }
            }
        }

        if(a_2 >= 3){
            count += 2;
            a_2 = a_2-3;
            if(a_2 > 0) {
                for(int i = 0; i < a_2; i++) {
                    list.add(2);
                }
            }
        }else {
            if(a_2 > 0) {
                for(int i = 0; i < a_2; i++) {
                    list.add(2);
                }
            }
        }
        if(a_3 >= 3){
            count += 2;
            a_3 = a_3-3;
            if(a_3 > 0) {
                for(int i = 0; i < a_3; i++) {
                    list.add(3);
                }
            }
        } else {
            if(a_3 > 0) {
                for(int i = 0; i < a_3; i++) {
                    list.add(3);
                }
            }
        }
        if(a_4 >= 3){
            count += 2;
            a_4 = a_4-3;
            if(a_4 > 0) {
                for(int i = 0; i < a_4; i++) {
                    list.add(4);
                }
            }
        } else {
            if(a_4 > 0) {
                for(int i = 0; i < a_4; i++) {
                    list.add(4);
                }
            }
        }
        if(a_5 >= 3){
            count += 2;
            a_5 = a_5-3;
            if(a_5 > 0) {
                for(int i = 0; i < a_5; i++) {
                    list.add(5);
                }
            }
        } else {
            if(a_5 > 0) {
                for(int i = 0; i < a_5; i++) {
                    list.add(5);
                }
            }
        }
        if(a_6 >= 3){
            count += 2;
            a_6 = a_6-3;
            if(a_6 > 0) {
                for(int i = 0; i < a_6; i++) {
                    list.add(6);
                }
            }
        } else {
            if(a_6 > 0) {
                for(int i = 0; i < a_6; i++) {
                    list.add(6);
                }
            }
        }
        if(a_7 >= 3){
            count += 2;
            a_7 = a_7-3;
            if(a_7 > 0) {
                for(int i = 0; i < a_7; i++) {
                    list.add(7);
                }
            }
        } else {
            if(a_7 > 0) {
                for(int i = 0; i < a_7; i++) {
                    list.add(7);
                }
            }
        }
        if(a_8 >= 3){
            count += 2;
            a_8 = a_8-3;
            if(a_8 > 0) {
                for(int i = 0; i < a_8; i++) {
                    list.add(8);
                }
            }
        } else {
            if(a_8 > 0) {
                for(int i = 0; i < a_8; i++) {
                    list.add(8);
                }
            }
        }
        if(a_9 >= 3){
            count += 2;
            a_9 = a_9-3;
            if(a_9 > 0) {
                for(int i = 0; i < a_9; i++) {
                    list.add(9);
                }
            }
        } else {
            if(a_9 > 0) {
                for(int i = 0; i < a_9; i++) {
                    list.add(9);
                }
            }
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++ ) {
            if(!list1.contains(list.get(i)) && list.get(i) != 0){
                list1.add(list.get(i));
                list.set(i, 0);
            }
        }

        for(int i = 0; i < list.size(); i++ ) {
            if(!list2.contains(list.get(i)) && list.get(i) != 0){
                list2.add(list.get(i));
                list.set(i, 0);
            }
        }

        if(list1.size() >= 3){
            for(int i = 0; i< list1.size(); i++){
                if(i+2 < list1.size()){
                    if((list1.get(i)+1 ==  list1.get(i+1)) && (list1.get(i+1)+1 == list1.get(i+2))){
                        count += 1;
                        list1.set(i, 0);
                        list1.set(i+1, 0);
                        list1.set(i+2, 0);
                    }
                }
            }
        }


        if(list2.size() >= 3){
            for(int i = 0; i< list2.size(); i++){
                if(i+2 < list2.size()){
                    if((list2.get(i)+1 ==  list2.get(i+1)) && (list2.get(i+1)+1 == list2.get(i+2))){
                        count += 1;
                        list2.set(i, 0);
                        list2.set(i+1, 0);
                        list2.set(i+2, 0);
                    }
                }
            }
        }

        System.out.println(count);
        
    }
}