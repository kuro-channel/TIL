### 第9章：API  
- java.util.Comparatorインターフェース その1
  - コレクション内のオブジェクトを並び替える際の並び順を決めるアルゴリズムを定義するためのもの
  - java.util.Comparatorインターフェースを実装したクラスを定義し、compareメソッドに並び順を決める為のアルゴリズムを実装し、並べ替える際に使う 
  - Comparatorインターフェース > compareメソッド
  - 1. 与えられた2つの引数のうち、第一引数の順番を前にするなら「-1」
  - 2. 与えられた2つの引数のうち、第二引数の順番を前にするなら「1」
  - 3. 2つの引数が同列で並び順を変更しないのなら「0」

検証用コード  
https://github.com/kuro-channel/TIL/tree/master/%E6%A4%9C%E8%A8%BC%E3%82%B3%E3%83%BC%E3%83%89/src/java/silver/nine/two

- java.util.Comparatorインターフェース その2
  - sortメソッド：コレクション内の要素を順番に並べる
検証用コード
https://github.com/kuro-channel/TIL/blob/master/%E6%A4%9C%E8%A8%BC%E3%82%B3%E3%83%BC%E3%83%89/src/java/silver/nine/three/Main.java
