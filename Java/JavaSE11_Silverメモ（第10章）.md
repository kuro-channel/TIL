### 第10章：例外処理  
- try ~ catch ~ finally文：finallyは例外発生の有無にかかわらず実行される！
  - **try ~ catch ~ finallyの順番は変更できない**
  - catchブロックは複数記述できるが、**tryブロックとfinallyブロックは1つずつしか定義できない**

```
  try {
    // 例外が発生する可能性がある処理
  } catch (例外クラス型 変数） {
    // 例外が発生したときの処理
  } finally {
    // 例外発生の有無にかかわらず実行したい処理
  }
```

- catchブロック内でreturnされた時
  - finallyが先に実行される  
  
【検証用コード】  
https://github.com/kuro-channel/TIL/blob/master/%E6%A4%9C%E8%A8%BC%E3%82%B3%E3%83%BC%E3%83%89/src/jv/silver/ten/Main.java#L5-L20  


- 各種例外処理
  - ArrayIndexOutOfBoundsException：配列の要素外アクセスを示す
  - indexOutOfBoundsException:配列や文字列、コレクションの範囲外であることを示す

