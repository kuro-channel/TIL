```
import java.util.*;

// 剰余（割った数の余りは%）
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 均等する人の数
        int people = sc.nextInt();
        System.out.println(sc.nextInt() * sc.nextInt() % people);
    }
}
```

## 絶対値を求める(abs)
```
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int high = sc.nextInt();
        int low = sc.nextInt();
        
        // 最高・最低気温共にマイナスの場合
        if(high < 0 && low < 0){
            System.out.println(Math.abs(low) - Math.abs(high));
        } else if(high > 0 && low < 0){
            // 最低気温のみマイナスの場合
            System.out.println(Math.abs(high) + Math.abs(low));
        } else {
            System.out.println(Math.abs(high) - Math.abs(low));
        }
        
    }
}
```
## StringBufferとStringBuilderについて
```
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ゴールドメダル
        System.out.println(makeString("Gold ", sc.next()));
        // シルバーメダル
        System.out.println(makeString("Silver ", sc.next()));
        // ブロンズメダル
        System.out.println(makeString("Bronze ", sc.next()));
    }
    // 文字列生成メソッド
    public static String makeString(String medalColor, String country){
        StringBuffer bf = new StringBuffer();
        bf.append(medalColor);
        bf.append(country);
        return bf.toString();
    }
    
}
```
