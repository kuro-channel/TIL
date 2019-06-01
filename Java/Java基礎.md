## 三項演算子
```String result = (str == "abc") ? "Samurai" : "Engineer";```
- 条件式 ? trueの場合の戻り値 : falseの場合の戻り値

## JavaにおけるequalsとhashCode - 同一性と同値性の違い
```
// オブジェクトの同一性
User user1 = new User(1, "田中");
User user2 = user1;
user1 == user2 // ⇒ true
```
↑ user1とuser2は同じ（同一）のオブジェクトを参照している。  
User1　▷ User id=1, name="田中" ◁ User2  
```
// ブジェクトの”同値性(等価性)”
User user3 = new User(1, "田中");
User user4 = new User(2, "鈴木");
User user5 = new User(1, "鈴木");
```
user3とuser5はIDの値において"同値"のオブジェクト。  
user4とuser5は名前の値において"同値"のオブジェクト。    
```
// オブジェクトの同値性の判定方法
// UserクラスのequalsメソッドがIDを比較条件として実装されている場合
user3.equals(user4) // ⇒ false
user3.equals(user5) // ⇒ true
user4.equals(user5) // ⇒ false

// Userクラスのequalsメソッドが名前を比較条件として実装されている場合
user3.equals(user4) // ⇒ false
user3.equals(user5) // ⇒ false
user4.equals(user5) // ⇒ true    
```
「**文字列の等値チェックは必ずequalsメソッドで！！**」

## staticと非static
- static = 静的、クラスに張り付く、インスタンスに応じて変動しない：「クラスメソッド」　インスタンスに依存しない、クラスが実行する。クラス固有。  
- 非static = インスタンス変数にアクセスして、インスタンス毎に結果の異なる処理を書く：「インスタンスメソッド」

```
// 配列の宣言
int [] arr;
arr = new int[3];

String [] arr2;
arr2 = new String[3];

```

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
