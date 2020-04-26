package jv.silver.nine.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 第9章 問9
        ArrayList<String> list9 = new ArrayList<>();
        list9.add("A");
        list9.add(2,"B");
        list9.add("C");
        list9.add("D");

        for (String str: list9){
            System.out.println(str); // 存在しない2番目に文字列を追加しようとしてエラー
            /** Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 2, Size: 1
             at java.base/java.util.ArrayList.rangeCheckForAdd(ArrayList.java:754)
             at java.base/java.util.ArrayList.add(ArrayList.java:479)
             at Main.main(Main.java:9) */
        }

        // 第9章 問10
        ArrayList<String> list10 = new ArrayList<>();
        list10.add("A");
        list10.set(0,"B");
        list10.add("C");
        list10.set(1,"D");

        for (String str: list10){
            System.out.println(str); // B,D
        }

        // 第9章 問11
        ArrayList<Item> list11 = new ArrayList<>();
        list11.add(new Item("A", 100)); // 条件に合致する最初の要素を削除する
        list11.add(new Item("B", 200));
        list11.add(new Item("C", 300));
        list11.add(new Item("A", 100)); // 削除されない
        list11.add(new Item("A", 500));

        for (Item item: list11){
            System.out.println(item.getName()); // B,C,A
        }

        // 第9章 問15
        String[] a = {"b", "c"};
        String[] b = {"a", "b", "c"};
        System.out.println(Arrays.mismatch(a,b)); // 0 : 0番目の値同士が一致していない

        // 第9章 問16
        String[] c = {"B", "A"};
        String[] d = {"A", "B"};
        System.out.println(Arrays.compare(c,d)); // 1 :
    }
}
