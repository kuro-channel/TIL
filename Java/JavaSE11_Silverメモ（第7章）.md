### 第7章：クラスの継承、インターフェース、抽象クラス  
- 継承
  - 共通処理をあるプログラムに定義し、それぞれのプログラムには差分を定義してあとで結合する = **差分プログラミング**  
  - **サブクラスのインスタンスは、スーパークラスのインスタンスと差分のインスタンスの両方**
  - 「コンストラクタ」と「privateなフィールドとメソッド」は継承できない  
 <img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E7%B6%99%E6%89%BF%E3%81%AE%E3%82%A4%E3%83%A1%E3%83%BC%E3%82%B8.jpg"
alt="継承のイメージ" title="継承のイメージ">  
- インターフェース ➀
  - クラスの「型」だけを取り出したもの。
  - **型 = 「そのものの"扱い方"を決めるための情報。変数を宣言する際、変数の扱い方を決める」**
  - **ポリモーフィズムの実現**：<a href="https://github.com/kuro-channel/TIL/blob/master/Java/%E3%82%A4%E3%83%B3%E3%82%BF%E3%83%BC%E3%83%95%E3%82%A7%E3%83%BC%E3%82%B9%E3%81%AB%E3%81%A4%E3%81%84%E3%81%A6.md">以前まとめたものを確認しよう</a>
  - 抽象メソッドの定義が可能。インターフェースを実装したクラスは、必ず抽象メソッドを実装しなければならない（コンパイルエラーになる）
  - finalを使って、動的に値が変更されないこと（定数）/ staticを使って、インスタンスが生成できなくても使えること
  - インターフェースはインスタンス化できない為、動的に変更する値は定義できない  
  - インターフェースは多重継承可能（extends）

- デフォルトメソッド
  - デフォルトメソッドが出る前は「抽象クラスに共通処理を定義する」方法がある（画像参照）
  - オーバーライドしたメソッドから元のデフォルトメソッドの呼び出しは、2つ以上の実現や継承の階層をまたぐことはできない
<img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E6%8A%BD%E8%B1%A1%E3%82%AF%E3%83%A9%E3%82%B9%E3%81%A7%E5%85%B1%E9%80%9A%E3%81%AE%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E3%82%92%E5%AE%9A%E7%BE%A9.jpg" alt="抽象クラスで共通メソッドを定義する" title="抽象クラスで共通メソッドを定義する">

```
【構文】
 default 戻り値型 メソッド名（引数の型 引数名）{
  // 処理内容
 }
```

```
【構文】デフォルトメソッドをオーバーライドしたメソッドから、元のデフォルトメソッドを呼び出す
インターフェース名.super.メソッド名();
```

- 抽象クラス
  - インターフェースとクラスの両方の性質を持ったクラス。
  - 実装を持つ具象メソッドと、実装を持たない抽象メソッドの両方を持つことができる。
  - インスタンス化できない（インターフェースの特徴）
  - 抽象クラスを継承したサブクラスのインスタンスは、抽象クラスのインスタンスが含まれる（画像参照）

```
public abstract class AbstractSample {
  // 具象メソッド（抽象クラスを継承したサブクラスが引き継ぐ）
  public void methodA(){
    // any code
  }
  // 抽象メソッド（サブクラスで実装する）
  public abstract void methodB();
}
```
<img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E3%82%B9%E3%83%BC%E3%83%91%E3%83%BC%E3%82%AF%E3%83%A9%E3%82%B9%E3%81%A8%E5%B7%AE%E5%88%86%E3%81%AE%E3%82%A4%E3%83%B3%E3%82%B9%E3%82%BF%E3%83%B3%E3%82%B9.jpg" alt="スーパークラスと差分のインスタンス" title="スーパークラスと差分のインスタンス">

- オーバーライド
  - サブクラスでスーパークラスに定義されたメソッドを「**再定義**」すること  
  - メソッドを再定義するには、**シグニチャ**（メソッド名、引数リストの型、数、順番）が同じである必要がある  
  - **共変戻り値**：同じ型かそのサブクラスであれば、オーバーライドしたメソッドの戻り値型に指定できる。  
  - サブクラスには、1. スーパークラスに定義したメソッド　と　2.サブクラスにオーバーライドされたメソッド両方が同時に存在する
  <img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E3%82%AA%E3%83%BC%E3%83%90%E3%83%BC%E3%83%A9%E3%82%A4%E3%83%89%E3%81%AE%E3%82%A4%E3%83%A1%E3%83%BC%E3%82%B8.jpg" alt="オーバーライドのイメージ" title="オーバーライドのイメージ">
  
- 第7章 問13復習
```
interface Worker {
  void work();
}

class Employee {
  public void work() {
    System.out.println("work");
  }
}

class Engineer extends Employee implements Worker {}

public class Main {
  public static void main(String[] args){
    Worker worker = new Enginineer();
    worker.work(); // EngineerクラスはEmployeeクラスの特徴を引き継いでいる = workメソッドを持っている　結果："work"と表示される
  }
}
```
  <img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E7%AC%AC7%E7%AB%A0_%E5%95%8F13%E5%BE%A9%E7%BF%92.jpg" alt="第7章 問13復習" title="第7章 問13復習">
  
- 第7章 問14復習
  - ポリモーフィズムの注意点
  - 1. 継承関係や実現関係があり、ポリモーフィズムが成り立つ条件を備えているかどうか
  - 2. インスタンスを扱っている「型」に、呼び出しているメソッドが定義されているかどうか
  - **扱っている型で定義されているもの以外は使えない**：変数が何型かを意識する

```
public interface Worker {
  void work();
}

class Employee implements Worker {
  public void work() {
    System.out.println("work");
  }   
  public void report() {
    System.out.println("report");
  }
}

class Engineer extends Employee {
  public void create() {
    System.out.println("create future");
  }
}

public class Main {
  public static void main(String[] args){
    Worker a = new Enginner(); 
    Employee b = new Engineer(); 
    Engineer c = new Engineer();
    a.create(); // worker型には"create"メソッドは定義されていない：コンパイルエラー
    b.work(); // Employee型は"work"メソッドの定義を持っている
    c.report(); // Engineer型は"report"メソッドの定義を持っている（Employeeクラスから引き継いでいる）
  }
}
```
  <img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E7%AC%AC7%E7%AB%A0_%E5%95%8F14%E5%BE%A9%E7%BF%92.jpg" alt="第7章 問14復習" title="第7章 問14復習">

- 第7章 問15復習
  - ポリモーフィズムが成り立つかどうか
  - ポリモーフィズムとは：**実際に動作しているインスタンスを、インスタンスの元になった型とは「異なる型」で扱える仕組み**
  - 継承の関係 or 実現の関係があれば、ポリモーフィズムは成立する
  - インターフェースはインスタンス化できない

```
public interface A {}
public class B implements A {}
public class C extends B {}
public class D {}

public class Main {
  public static void main(String[] args){
    A[] array = {
      new B(),
      new C(), 
      new A(), // コンパイルエラー
      new D() // コンパイルエラー
      };
   }
  }
}
```
  <img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E7%AC%AC7%E7%AB%A0_%E5%95%8F15%E5%BE%A9%E7%BF%92.jpg" alt="第7章 問15復習" title="第7章 問15復習">
  
- 型変換：アップキャストとダウンキャスト
  - 継承関係にある場合、サブクラスのインスタンスをスーパークラス型の変数で扱うことができる
  - サブクラスをスーパークラス型に変換する：**アップキャスト** 
  - スーパークラス型で扱っていたインスタンスを、元の型に戻す：**ダウンキャスト**
<img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E3%82%A2%E3%83%83%E3%83%97%E3%82%AD%E3%83%A3%E3%82%B9%E3%83%88_%E3%83%80%E3%82%A6%E3%83%B3%E3%82%AD%E3%83%A3%E3%82%B9%E3%83%88.jpg" alt="型変換" title="型変換">

```
A a = new B(); // Aを継承したB：BのインスタンスをA型として扱う
B b = a; // コンパイルエラー
B b = (B) a; // キャスト式でダウンキャスト
```

- 第7章 問20復習
  - 継承関係にあるクラスのインスタンスを作成したときのコンストラクタ
  - 継承関係にあるクラスのインスタンスは、**スーパークラスと差分のインスタンス**で構成されている
  - スーパークラスのインスタンスが持つコンストラクタが先に実行されなければならない
  - サブクラスのコンストラクタには、スーパークラスのコンストラクタを呼び出す**「super();」**が、コンパイラによって先頭行に追加される
  - コンストラクタ内から、オーバーロードされた別のコンストラクタを呼び出す際は、**「this」**を使う。
  
```
class A {
  public A() {
    System.out.println("A");
  }
  public A(String val) {
    this();
    System.out.println(val);
  }
}

class B extends A {
  public B() {
    super(); // コンパイラによって自動で追加される
    System.out.println("B");
  }
}

public class Main {
  public static void main(String[] args){
    A a = new B();
  }
}
```


