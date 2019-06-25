## List型とSet型
- よく使用されるList系コレクションは「同一の要素を重複して保持できる・順序を管理している」のに対し、  
Set系コレクションは「同一および等値の要素を保持できない・順序を管理していない」という大きな違いがある。  

## Javaでいう「等値」とは？
- 等値とは、equalsメソッドによる比較の結果がtrueを返し、かつ２つのオブジェクトのhashCodeメソッドの戻り値が同じ値を返すこと  
→ ハッシュコードとは、オブジェクトを識別するためのint型の数値のこと。equalsメソッドと同じく、hashCodeメソッドもObjectクラスに存在している。

## instanceof演算子
- instanceof演算子とは:あるオブジェクトの型を動的に判定するための演算子です。

```
以下のような用途で用います。

オブジェクトが、あるクラスのインスタンスか
オブジェクトが、あるクラスの子クラスのインスタンスか
オブジェクトが、特定のインターフェースを実装したインスタンスか

例：オブジェクト instanceof 型
Birds[] birds = {new Swallow(), new Penguin(), new Atthis()};
	for(Birds bird: birds) {
		// 食べる
        	bird.eat();
        	// 飛行可能な鳥の場合
        	if(bird instanceof Swimable) {
        	// 処理	
       　}

```

## 定数
```static final修飾子```
- 一度しか値を代入することができない変数をfinalを使うと宣言することができる。

## 抽象クラス
```
abstract class クラス名 {
    abstract 戻り値の型名 メソッド名(引数);
}
```
- 「**抽象メソッドの実装**」は「オーバーライド」に近いものだが、普通は「@Override」アノテーションを付けない。

## アクセス修飾子
- public
- protected
- 指定なし(デフォルト)
- private

|アクセス修飾子|同一クラス|同一パッケージ|サブクラス|すべて
----|----|----|----|----|
public|〇|〇|〇|〇
protected|〇|〇|〇|×
指定なし(デフォルト)|〇|〇|×|×
private|〇|×|×|×

## スーパークラスのコンストラクタを呼ぶ："super"で呼び出す
```
// Bookクラス
class Book{

    // タイトル
    private String title;

    // 価格
    private int price;

    // コンストラクタ
    public Book(String title, int price){
        this.title = title;
        this.price = price;
    }

    // タイトル取得メソッド
    public String getTitle(){
        return title;
    }

    // 価格取得メソッド
    public int getPrice(){
        return price;
    }
}

// Magazineクラス
class Magazine extends Book{
	// 表紙を飾る人
	String coverPersonName;

	// コンストラクタ
	public Magazine(String title, int price, String coverPersonName){
		super(title,price);
		this.coverPersonName = coverPersonName;
	}

	void show() {
		System.out.println(super.getTitle() + "絶賛発売中！！");
		System.out.println("定価" + super.getPrice() +"円");
		System.out.println("今回の表紙：" + this.coverPersonName + "さん");
	}

}

```

## staticキーワードの付くクラスフィールド・クラスメソッドは特殊なもの
- 「クラスで共通のフィールド・メソッド」:インスタンスごとに持つ必要のないクラス共通のデータなのでstaticありのクラスフィールドを定義する

## カプセル化？
- オブジェクトの状態（ステート）を場合に応じてきちんと変化させることは非常に大切なこと。

## オーバーロード
メソッドにおける「シグネチャ」とは、メソッド名＋引数の数と型の組み合わせのこと。  
メソッド名が同じでも引数の数と型の組み合わせが異なっていればシグネチャが異なることになるので、成立する。

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
