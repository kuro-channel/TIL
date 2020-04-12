### 第4章：制御構造  
- Javaにおける繰り返し構文  
・while文/do-while文/for文/拡張for文

- while文
  - 条件式は、必ず**真偽値**を戻す必要がある。  

- do-while文
  - 条件に合致するかどうかに関係なく、最低1回は繰り返し処理が実行される。  
  - do-while文の条件式の後ろにはセミコロンが必要
```
  do {
    // 繰り返し処理
  
  } while （条件式）;
```
**while文やdo-while文では、中かっこを省略した場合、次の1文だけが繰り返しの対象になる。**  
```
int cnt = 0;
while(cnt++ < 5) 
  System.out.println("A"); // 繰り返しの対象
  System.out.println("A"); // 繰り返しの対象にならない
  
do 
  System.out.println("A"); // 繰り返しの対象
  // do-while文の場合、doとwhileの間は1文だけ記述できる（かっこを省略した場合）
while(cnt++ <5)
```

- for文
  - for文の初期化文では、同じ型の変数を複数宣言できる。  
  - for文の初期化文で宣言した変数は、for文のブロック外では使うことはできない。（コンパイルエラー）  
  - for文で複数記述できるのは、**初期化文と更新文**の2つ。
  - 更新文でメソッドを呼び出すことも可能！
  ```
  for(初期化文; 条件文; 更新文) {
    // 繰り返し処理
  }
  
  for (int i = 0, j = 0; i < 3 && j < 5; i++) {
    // 複数の条件文を記述するときは、論理演算子を使う。
  }
  ```
  #### 初期化文　→　条件文　→　繰り返し処理　→　更新文　（→　条件文）　の実行順 
  ```
  // 以下の例では、更新文でメソッドが呼ばれる。
  public class Main {
    public static void main (String[] args) {
      for(int i = 0; i < 3; i++ , period()) {
        System.out.println(i);
      }
    }
    
    private static void period() {
        System.out.println(",");
    }
  }
  // 0,1,2
  ```
