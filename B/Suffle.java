package B;

import java.util.*;

public class Suffle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String nk[] = str.split(" ");
        int N = Integer.parseInt(nk[0]);
        int M = Integer.parseInt(nk[1]);
        int K = Integer.parseInt(nk[2]);

        int array[] = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
        }

        List<List<Integer>> listList = new ArrayList<>();
        int x = 0;
        while (x < N) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < M && x < N; i++) {
                list.add(array[x]);
                x++;
            }
            listList.add(list);
        }

        for (int i = 0; i < K; i++) {
            List<List<Integer>> listList2 = new ArrayList<>();
            int y = listList.size() - 1;
            for (int j = y; j > -1; j--) {
                listList2.add(listList.get(j));
            }

            listList = listList2;
            int a = 0;
            for (int c = 0; c < listList.size(); c++) {
                for (int j = 0; j < listList.get(c).size(); j++) {
                    array[a] = listList.get(c).get(j);
                    a++;
                }
            }
            listList.clear();
            ;
            int e = 0;
            while (e < N) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int d = 0; d < M && e < N; d++) {
                    list.add(array[e]);
                    e++;
                }
                listList.add(list);
            }

        }

        for (int i : array) {
            System.out.println(i);
        }

    }

}
