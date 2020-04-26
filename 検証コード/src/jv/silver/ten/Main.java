package jv.silver.ten;

public class Main {

    public static void main(String[] args) {
        // 第10章 第5問
        System.out.println(test(null)); // B,A
    }

    // 第10章 第5問
    private static String test(Object obj) {
        try{
            System.out.println(obj.toString());
        }catch (NullPointerException e){
            return "A";
        }finally {
            System.out.println("B"); // returnによって呼び出し元のメソッド制御に戻る前に、finallyブロックが実行される
        }
        return "C";
    }
}
