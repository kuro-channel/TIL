### 第8章：関数型インターフェース、ラムダ式  
- 関数型インターフェース
  - 『実装が必要なメソッドを１つだけ持つインターフェース』のこと。

```
// 関数型インターフェースの例
interface Greet {
	public void greeting();
}
```

- ラムダ式
  - (引数) -> { 処理; }
  ‐　ラムダ式外で宣言されたローカル変数にラムダ式内からアクセスするには、**実質的にfinalな変数（変更されない変数）でなくてはいけない**

```
import java.util.function.Supplier;

public class Sample {
	// 総仕上げ問題➀ 4問
	public void sample(){
		int i = 0;
		Supplier<Integer> foo = () -> i;
		i++;　// java: ラムダ式から参照されるローカル変数は、finalまたは事実上のfinalである必要があります
		System.out.println(foo.get());
	}
}
```
```
// (1) 引数と戻り値がある場合
(Integer number) -> {
    return Math.abs(number) >= 5;
}

// (2) 戻り値がない場合
(Integer number) -> {
    System.out.println(number);
}

// (3) 引数も戻り値もない場合
() -> {
    System.out.println("Hello!");
}
```

- 関数型インターフェースの特徴  

|関数型インターフェース| メソッド| 説明|
| ---- | ---- | ---- |
| Consumer<T>|void accept(T)|引数を受け取って処理をする。結果を戻さない、引数の「消費者」|
| Supplier<T>|T get()| 何も受け取らずに結果だけを戻す「供給者」|
| Predicate|boolean test(T)| 引数を受け取ってそれを評価する「断定」|
| Function<T,R> |R apply(T)| 引数を受け取って、指定された型(R)の結果を戻す「処理」|

- 参考文献リスト
  - 関数型インターフェース http://www.ne.jp/asahi/hishidama/home/tech/java/functionalinterface.html　
  - ラムダ式 http://www.ne.jp/asahi/hishidama/home/tech/java/lambda.html


