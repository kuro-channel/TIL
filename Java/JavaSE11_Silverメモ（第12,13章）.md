### 第12,13章：総復習問題  
- 型変換1
  - 13章 問3 型変換の問題
  - int : 整数型、 float,double: 浮動小数点型
  - 整数型についておさらい: https://github.com/kuro-channel/TIL/blob/master/Java/JavaSE11_Silver%E3%83%A1%E3%83%A2%EF%BC%88%E7%AC%AC1%E7%AB%A0%EF%BD%9E3%E7%AB%A0%EF%BC%89.md#%E3%83%97%E3%83%AA%E3%83%9F%E3%83%86%E3%82%A3%E3%83%96%E5%9E%8B%E6%95%B0%E5%80%A4%E9%96%A2%E9%80%A3
  
```
public class Main {

    public void main(String[] args) {
        int a = 10;
        float b = 10.0f;
        double c = 20;
        a = b;　// コンパイルエラー
        a = (int) b;
        b = a;
        c = b;
        c = a
    }
}
```

- 型変換2
  - 13章 問3 型変換の問題
  - 数値型は文字に変換することが可能
```
【数値型から文字への変換】
 char t = 97;
 int i = 97;
 char j = (char) i;
```

‐ アクセス修飾子
  - 13章 問6 アクセス修飾子の問題
  - 修飾子おさらい: https://github.com/kuro-channel/TIL/blob/master/Java/JavaSE11_Silver%E3%83%A1%E3%83%A2%EF%BC%88%E7%AC%AC4%E7%AB%A0%EF%BD%9E6%E7%AB%A0%EF%BC%89.md#%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9%E4%BF%AE%E9%A3%BE%E5%AD%90
  - 継承関係にある時、サブクラスからアクセスできるスーパークラスのメンバのアクセス修飾子は「**public**」 or 「**protected**」
  - ↑「protected」はサブクラスからスーパークラスのメンバにアクセスできるぞ～！
  - デフォルト：アクセス修飾子なし は、**同じパッケージ**でなければアクセスできない
 
```
public class A {
	String a = "A"; // 修飾子: デフォルト
	protected String b = "B"; // 修飾子: protected
	public String c = "C"; // 修飾子: public
}

public class B extends A {
	public void test(){
		String test1 = new B().a; // 'a' is not public in 'jv.silver.thirteen.ex6.a.A'. Cannot be accessed from outside package
		String test2 = new B().b;
		String test3 = new B().c;
	}
}
```

- static
  - staticで修飾されたメソッドからは、**staticで修飾されたもの以外にはアクセスできない**
  - なぜ？↓
  - **非staticフィールド、メソッド：オブジェクトの数だけ個別に用意されるもの**
  - **staticフィールド、メソッド：（特定のオブジェクトに属さず）クラスで一つしか存在しないもの**
  - A. 非staticなメンバというのは、インスタンス固有のメンバだということ
  - staticメソッドに「してもよい」：インスタンスの状態に依存しないもの
  - staticメソッドに「すべき」：引数とstaticフィールドだけで完結する処理で、かつクラス内外で頻繁に使う決まりきった内容の処理。いわゆる「関数」や「プロシージャ」的なもの
 
```
public class Main {
	int num;
	private static void test(){
		num++; // 非 static フィールド 'num' は static コンテキストから参照できません
		System.out.println(num);
	}
	public static void main(String[] args){
		Main.test();
		Main.test();
	}
}
```
