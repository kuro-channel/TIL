package java.silver.nine.five.six;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // 第9章 問5
        LocalDate a = LocalDate.of(2015,0,1); // 構文が間違っていないので、コンパイルエラーにならない、実行時エラー
        LocalDate b = LocalDate.parse("2015-01-01");
        System.out.println(a.equals(b));
    }
}
