package jv.silver.nine.three;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 「3,2,1」と表示したい
        List<Integer> list1 = Arrays.asList(new Integer[]{1,2,3});
        List<Integer> list2 = Arrays.asList(new Integer[]{1,2,3});

        //　回答1
        list1.sort((a,b) -> a.compareTo(b));
        //　回答2
        list2.sort((a,b) -> -a.compareTo(b));

        for(Integer num: list1){
            System.out.println(num); // 1,2,3
        }

        for(Integer num: list2){
            System.out.println(num); // 3,2,1
        }

    }
}
