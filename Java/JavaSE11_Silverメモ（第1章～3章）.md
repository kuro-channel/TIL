### 第1章：簡単なJavaプログラムの作成
- パッケージの目的
1. 名前空間を提供し、名前の衝突を避ける
2. アクセス修飾子と組み合わせてアクセス制御機能を提供する
3. クラスの分類を可能にする  
※ パッケージ名に「**ドメインを逆にした文字列**」を使うのは**慣習**（決まりではない）  
**クラスは必ず何らかのパッケージに属する。**（パッケージ宣言がない場合は、「無名パッケージ」に属する）

- パッケージの指定
  - java.langパッケージに属するクラスは、インポートする必要なし
  - com.* : **comパッケージに属するクラスだけインポートされる**

- **エントリーポイント**  
処理を始めるためのメソッド。JVMは、Javaコマンドで指定されたクラスを読み込み、そのクラスに定義されているエントリーポイントから処理を始める。  
```
// Mainメソッド
public static void main(String[] args) {
  // any code
}
```

- Javaコマンド：以下を実行できる
1. mainメソッドを持つクラスファイル  
2. jarファイル内のメインクラス  
3. モジュールに含まれるメインクラス  
4. javacコマンドでコンパイルせずに、ソースファイルを直接実行できる（ソースファイルモード）  
```
java Test.java
```
※ javaコマンドは、**.javaファイルを直接実行できる**　⇔　コンパイル：javacコマンド 

- コンパイル → 実行するコマンド
```
javac -d build ~.java
java -cp build ~.Main
```

- 起動パラメータの指定
1. スペースが区切り記号として扱われる  
2. スペースを含む文字列は、"(ダブルクォテーション）で括ることで1つとして扱われる  
3. ダブルクォーテーションそのものは文字として扱われない

```
ex) > java Sample a ￥" a￥" "a "b c
```
1. a  
2. "  
3. a"  
4. a_b  
5. c  

- クラスは必ず何かしらのパッケージに属する。パッケージ宣言を省略したクラスは、デフォルトで無名パッケージに属するものと解釈される。

### 第2章：Javaの基本データ型と文字列操作  
- リテラル：**ソースコードに記述する値**のこと。Javaには、整数・浮動小数点・真偽・文字（文字列）の4つのリテラルがある。  
＜試験対策＞ 数値を10進数のほかに、2進数/8進数/16進数のリテラルで表記でき、それぞれ0b/0/0xで始める。  
```
'（シングルクォーテーション）：文字リテラル
"（ダブルクォーテーション）：文字列リテラル
```
- アンダースコア
1. リテラルの先頭と末尾には記述できない  
2. 記号の前後には記述できない  
※ 記号： 小数点を表す「.」 long型やfloat型リテラルを表す「L」や「F」 2進数を表す「0b」 16進数を表す「0x」  

- 識別子（Identifier）：**変数やメソッド、クラス等の名前のこと**
1. 予約語を識別子として使うことはできない 【参考】Javaの予約語：https://www.javadrive.jp/start/const/index7.html  
**What's 予約語？**：Javaの言語仕様として何らかの意味を持つ単語  
2. **識別子に使える記号はアンダースコア「_」とドル記号「$」のみ**  
3. 数字は2文字目以降からのみ使用可能（**変数名は数字から初めてはいけない**）

- varを使った型推論:**ローカル変数の型推論**　※フィールドの宣言にはvarを使った型類推はできない。  
・varを使った型推論：コンパイル時にコンパイラが代入演算子「=」の右辺から変数のデータ型を推論し、そのデータ型に置き換える機能。  
 → 変数が初期化されてなかったり、nullで初期化されていて、データ型を特定できないとエラーとなる。
```
var a = "test"; // String
```
・配列の初期化式：コンパイルエラー
```
int[] array = {1, 2, 3}; // 変数の型からint配列型のインスタンスを生成している
var a = {1, 2, 3}; // 型を特定できない
```

- ローカル変数
  - ローカル変数とは？：**ある関数内で宣言して、その関数内だけで使える。その関数内だけでの処理に使う変数**
  - ※宣言した変数を利用できる範囲のことをスコープという
  - ローカル変数が参照できる範囲はローカル変数を宣言したメソッド、コンストラクタの{　}内

- メンバ変数
  - クラスの"状態"を定義するものであり、そのクラスの状態を参照しようとする他のメソッド、コンストラクタからも参照できる
  - そのクラスのオブジェクトへの参照が存在する限り、メモリ上に保持される
  - メンバ変数は、オブジェクトとともに持続し続ける変数

- mutable（可変）とimumutable（不変）  
**Stringオブジェクトはimmutable（不変）オブジェクト**  
・Stringはimmutableなオブジェクトであるため、文字列を変更するには新しくインスタンスを作らなければならない。  

- オブジェクトをimmutableにするためには
  - setterメソッドを提供しない（値を変更させない）
  - 参照型のフィールドの為のgetterメソッドで参照を渡さず、新しいコピーを作って戻す
  - フィールドの値を変更するメソッドは、フィールドの値を変更する代わりに、新しい値を持ったインスタンスを生成し、その参照を戻す
  - すべてのフィールドをfinalかつprivateにする
  - サブクラスによるメソッドのオーバーライドを許可しない

#### めちゃ重要!!Stringオブジェクトのメソッド  
- charAtメソッド：インスタンスが保持している文字列から、引数で指定した位置にある1文字を抜き出して返す。indexは0スタート。
```
String str = "abcde";
System.out.println(str.charAt(4)); // e
System.out.println(str.charAt(5)); // StringIndexOutOfBoundsException：文字列範囲外にアクセス
```
- indexOfメソッド：引数で指定された文字が文字列のどの位置に存在するかを調べるメソッド。indexは0スタート。
```
String str = "abcde";
System.out.println(str.indexOf('c')); // 2
System.out.println(str.indexOf("cd")); // 2
System.out.println(str.indexOf("abcdef")); // -1
```
```
// 第12章 問12
String str = "abcd ef gh";
int x = str.indexOf("ef");
str.substring(x + 3); // x: 5 実行して受け取る変数がない！！strは変わらない。
x = str.indexOf("ef");
System.out.println(str + " " + x); // abcd ef gh 5
```
- concatメソッド：インスタンスが保持する文字列を、引数として渡された文字列と連結し、新しい文字列を戻す。（＋演算子と一緒）  
※ **appendは「StringBuilderクラスのメソッド」**  

- substringメソッド：開始位置は0からスタート！
```
String str = "abcde";
System.out.println(str.substring(2,4)); // cd
```

- メソッドチェーン  
あるメソッドが戻すオブジェクトのメソッドをさらに呼びだすことができる。  
**Stringクラスの多くのメソッドは、新しいStringインスタンスを作って戻す。Stringはimmutableなクラスであるため、元の文字列が変更されることはない。**  

```
String str = "abcde";
String str2 = str.substring(1,3).replace("b","c");
System.out.println(str2); // cc
```

- 文字列と数値の結合
  - +演算子を使って数値と文字列を連結すると、**数値が文字列に変換される**
```
// 第12章 問59
int a = 4;
int b = 2;
System.out.println(a + b + "= (a + b) = " + a + b); // 6 = (a + b) + 42

```

### 第3章：演算子と判定構造   
- 型変換  
・大きな範囲の値を小さな変数に代入するときは、明示的なキャストが必要。
```
int a = 10;
short b = (short) a;
```

- 前置インクリメントと後置インクリメント
  - 前置：**演算結果が代入される** / 後置: **元の値のコピーが戻されてから、変数の値が加算される**
  ```
  int a = 10;
  int b = ++a; // 前置：int b = 1 + 10; と同じ
  int c = a++; // 後置：元の値である11が戻されてcに代入されてから、aが12になる  
  ```
  
#### プリミティブ型(数値関連）
|  データ型  |  値  |
| ---- | ---- |
|  byte  | 8ビット整数 -128 ~ 127|
|  short | 16ビット整数 -32768 ~ 32767|
|  int   | 32ビット整数 -2147483648 ~ 2147483647|
|  long  | 64ビット整数 -922372036854775808 ~ 922372036854775807|
|  float | 32ビット単精度浮動小数点数|
|  double | 64ビット単精度浮動小数点数|

### 数値型の値の範囲について
- 整数型の特徴
  - **違いは、表現できる値の範囲だけ。**
  - 使用頻度は「**int>long>short>byte**」となるので、基本はintを使って、intでまかなえない場合はlong、shortを使うという感じで覚えておけば大丈夫
  ‐　byteはデータの大きさを表すときに使う

#### 超重要：Javaにおける2つの同じ
- 同一と同値  
1. 同一：**同じインスタンスを参照している**　オブジェクトの同一性は**比較演算子"=="で判定**
```
/* インスタンスを1つ作り、そのインスタンスへの参照を2つの変数で共有している **/
Object a = new Object();
Object b = a; // 変数aの参照をコピーして変数bを代入
```
http://education.yachinco.net/tips/java/01/CapD20080626_1.png

2. 同値：**同じ値を持っている。インスタンスは異なるけど、同じ値を持っていること**
```
public class Person {
  private String name;
  public Person (String name) {
    this.name = name;
  }
}

Person a = new Person("taro");
Person b = new Person("taro"); // aとbは同じ値を持っている：同値
```
**参照の先にあるインスタンスが同じ値を持っている**かどうかは、**equalsメソッド**で判定する。

重要！Objectクラスにequalsメソッドが定義されている。
```
public boolean equals(Object obj){
  return (this == obj); // 受け取った参照が自分自身かを確認
}
```
↑「同じ値を持っている」の定義は各クラスごとに違うため、**equalsメソッドをオーバーライド**して実装する。  
 ● **a instanceof b: aがbと同じクラスかbのサブクラスのインスタンスであればtrue**  

```
<Sampleクラス>
public class Sample {
  private int num;
  private String name;
  
  public Sample(int num, String name) {
    this.num = num;
    this.name = name;
  }
  
  @Override
  public boolean equals(Object obj) { 
    if(obj == null){
      return false;
    }
    if(obj instanceof Sample){
      Sample s = (Sample) obj;
      return s.num == this.num; // numだけ比較している
    }
    return false;
  }
}

<Mainクラス>
public class Main {
  public static void main(String[] args){
    Sample a = new Sample(10, "a");
    Sample a = new Sample(10, "a");
    System.out.println(a.equals(b)); // true: numはaとb同じ
  }
}
```

- equalsメソッドのルール  
・nullが渡された時は、常にfalseを返す  

- コンスタントプール：**コード中に同じ文字列リテラルが登場した場合、同じStringインスタンスへの参照が使い回される**  
 - 注意：**newを使ってStringのインスタンスを明示的に記述した場合は、新しいString型オブジェクトが生成される**
```
String a = "sample";
String b = "sample";
System.out.println(a == b); // 同一性：true 
```

- internメソッド：**コンスタントプールを含むメモリ内の同じ文字列を探して再利用するためのメソッド**  
```
String str1 = new String("def");
String str2 = new String("def");
System.out.println(str1.intern() == str2.intern()); // 同一性：true、internなしだとfalse
```

- 12章 問61復習
```
String s1 = new String("Java");
String s2 = "Java";
String s3 = s2.intern();
System.out.println(s1 == s2); // 別々のインスタンス false
System.out.println(s2 == s3); // 同一のインスタンス true
System.out.println(s1 == s3); // false
```

- switch文  
条件式で使える値は以下  
・char ・short ・Character ・short ・String ・byte ・int ・Byte ・Integer ・Enum  

  - int型以下の整数型とそのラッパークラス
  - 文字と文字列  
  - 列挙型  
  
 ※ **変数は、case値として使用できない。**

- switch文の「default」
  - **caseやdefault内にbreakキーワードが見つからない場合、見つかるまでcase内の文を実行し続ける（フォールスルー）**  
```
public class Main {

    public static void main(String[] args) {
        // 第12章 問7
        int data = 1;
        switch (data) {
            default: System.out.println("C"); // フォールスルー
            case 0: System.out.println("A");　// CA
                    break;
            case 10: System.out.println("B");
                    break;
        }
    }
}
```

```
// 第12章 問13

public class Main {
    static String str; // 初期化してない！
    public void main(String[] args) {
        switch (str) { // ヌルポでおちる！
            case "10": str += "10";
            default: str += "def";
            case "20": str += "20";
        }
        System.out.println(this.str);
    }
}
```
```
// 第12章 問34

public class Main {
    static String str; // 初期化してない！
    public void main(String[] args){ 
      char c = 'b';
      int i = 0;
      switch(c) {
        case 'a':
          i++;
          break;
        case 'b':
          i++; // breakがないので、次のcase文を実行
        case 'c':
          i++;
        case 'd':
          i++;
        case 'e':
          i++;
          break;
        default:
           System.out.println(c);
      }
      System.out.println(i); // 3 : caseやdefault内にbreakキーワードが見つからない場合、見つかるまでcase内の文を実行し続ける（フォールスルー）
    }
}
```

- 数値リテラルのデフォルト型
  - 整数：int型、浮動小数点数：double型
  
