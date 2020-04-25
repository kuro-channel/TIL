### 第9章：API  
- java.util.Comparatorインターフェース その1
  - コレクション内のオブジェクトを並び替える際の並び順を決めるアルゴリズムを定義するためのもの
  - java.util.Comparatorインターフェースを実装したクラスを定義し、compareメソッドに並び順を決める為のアルゴリズムを実装し、並べ替える際に使う 
  - Comparatorインターフェース > compareメソッド
  - 1. 与えられた2つの引数のうち、第一引数の順番を前にするなら「-1」
  - 2. 与えられた2つの引数のうち、第二引数の順番を前にするなら「1」
  - 3. 2つの引数が同列で並び順を変更しないのなら「0」

【検証用コード】  
https://github.com/kuro-channel/TIL/tree/master/%E6%A4%9C%E8%A8%BC%E3%82%B3%E3%83%BC%E3%83%89/src/java/silver/nine/two

- java.util.Comparatorインターフェース その2
  - sortメソッド：コレクション内の要素を順番に並べる
  
【検証用コード】
https://github.com/kuro-channel/TIL/blob/master/%E6%A4%9C%E8%A8%BC%E3%82%B3%E3%83%BC%E3%83%89/src/java/silver/nine/three/Main.java

- Characterクラスのメソッド
  - charクラスの**ラッパークラス**（ラッパークラス：プリミティブ型に対応するクラス）
  - isAlphabeticメソッド：アルファベットかどうか
  - isDigitメソッド：数字かどうか
  - isLowerCaseメソッド：小文字かどうか
  
- LocalDate
  - 特徴：immutable（不変）であること
  - 同一のインスタンスは常に一定の値を保持していることが保証される  
 
- ArrayListクラス　その1
  - 特徴
  - オブジェクトであれば、どのような型でも扱える
  - 必要に応じて要素数を自動的に増やす
  - 追加した順に並ぶ
  - nullも値として追加できる
  - 重複した値も追加できる
  - スレッドセーフではない：スレッド＝処理の流れ
  - **ジェネリクスを指定していない場合は、混在するコレクションを扱える**
  ```
  【第9章 問8】
  ArrayList list = new ArrayList();
  list.add(new Object()); // Object
  list.add("test"); // String 
  list.add(new Integer(10)); // Integer
  ```
  ```
- ジェネリクス
  - **型を指定することで、コレクションが扱える型を制限する機能**
 ```
 ArrayList<String> list = new ArrayList<>();
 ```
 
- ArrayListクラス　その2
  - addメソッド：add(index,obj) > index: 追加する場所 / obj: 追加する値 **インデックスを使って、追加する場所を指定することができる**
  - setメソッド：set(index,obj) > index: 置き換える場所 / obj: 置き換える値
  - removeメソッド：リストから要素を削除。削除対象の要素が複数ある場合は、equalsメソッドがtrueを戻す最初の対象を削除する  
  - ↑**削除する要素を0から始まるインデックスで指定する**
  - removeメソッドは、**リストを要素から削除した場合、後ろの要素が繰り上げられる**
```
list.add(2,"B");
list.set(0,"B");
```

```
【removeメソッド】
 ArrayList<String> list = new ArrayList<>();
 list.add("A");
 list.add("B");
 list.add("C");
 
 for (String str: list){
    if("B".equals(str)){
      list.remove(str); // Bが削除されたら、要素が繰り上がる
    } else {
      System.out.println(str); // A
    }
 } 
 ```
 <img src="https://github.com/kuro-channel/TIL/blob/master/Java/remove%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E3%81%8C%E7%99%BA%E8%A1%8C%E3%81%95%E3%82%8C%E3%81%9F%E3%83%AA%E3%82%B9%E3%83%88%E3%81%AE%E8%A6%81%E7%B4%A0.jpg" alt="removeメソッドが発行されたリストの要素" title="removeメソッドが発行されたリストの要素">
 
【検証用コード】  
https://github.com/kuro-channel/TIL/tree/master/%E6%A4%9C%E8%A8%BC%E3%82%B3%E3%83%BC%E3%83%89/src/java/silver/nine/arrays

- 固定長リスト
```
【asListメソッド】配列からリストのインスタンスを生成する
var list = Arrays.asList(new Integer[] {1,2,3});
list.remove(1);
```
```
【ofメソッド】Listインターフェースのofメソッドを使う
var list = List.of(1,2,3);
list.add(9);
```

- ArrayListクラス　その3
  - mismatchメソッド：引数で渡された2つの配列の要素を先頭から順番に比較し、一致しない要素のインデックス（添字）を戻す
  - ↑すべて一致しなければ「-1」を返す
  - compareメソッド：2つの配列を辞書順に並べた時の並び順を比較する
  
【検証用コード】  
https://github.com/kuro-channel/TIL/blob/master/%E6%A4%9C%E8%A8%BC%E3%82%B3%E3%83%BC%E3%83%89/src/java/silver/nine/arrays/Main.java#L47-L55
