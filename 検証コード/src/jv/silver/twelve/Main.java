package jv.silver.twelve;

import java.time.LocalDate;

public class Main {

    static String str;
    public void main(String[] args) {
        // 第12章 問7
        int data = 1;
        switch (data) {
            default: System.out.println("C");
            case 0: System.out.println("A");
                    break;
            case 10: System.out.println("B");
                    break;
        }

        // 第12章 問12
        String str = "abcd ef gh";
        int x = str.indexOf("ef");
        str.substring(x + 3); // x: 5 実行して受け取る変数がない！！strは変わらない。
        x = str.indexOf("ef");
        System.out.println(str + " " + x); // abcd ef gh 5

        // 第12章 問13
        switch (this.str) {
            case "10": str += "10";
            default: str += "def";
            case "20": str += "20";
        }
        System.out.println(this.str);
    }
}
