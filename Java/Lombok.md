## アノテーション辞典
- ```@Data```  
・ getterが使える  
・ setterが使える  
・ hashCodeがオーバーライドされている  
・ toStringがオーバーライドされている  
・ equalsがオーバーライドされている  

**＜ポイント＞**  
・ Lombokの@Valueや@Dataは他に明示的なコンストラクタが宣言されているとコンストラクタを生成しない
https://qiita.com/inabajunmr/items/33a10af1de3b95afdd7d

@Dataつけても、独自コンストラクタを定義すると、デフォルトコンストラクタが消えちゃう・・・  
Modelとして、ORマッパーと紐づける場合、デフォルトコンストラクタないとエラーになっちゃう・・・  
→ @NoArgsConstructor つける。

ex)

```
@Data
@NoArgsConstructor // ← つける
public class Sample {
  
  // 独自コンストラクタ定義
  public Sample(~） {
  
  }

}
```

- ```@NoArgsConstructor```  
・ 引数なしのコンストラクタを定義できる。
