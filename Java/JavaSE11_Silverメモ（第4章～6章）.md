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

- 問9をトレースする
  - 2次元配列ってどんな値の重合？（イメージ）  
    - 1次元配列の集合体
  ```
  int array[][] = new int[][] {{1,2},{2,3,4}};
  System.out.println(array[0][0]); // 1
  System.out.println(array[0][1]); // 2
  System.out.println(array[1][0]); // 2
  System.out.println(array[1][1]); // 3
  System.out.println(array[1][2]); // 4
  ```
 
 【ポイント】**初期化処理は一回だけ！**
  ```
  public class Main {
    public static void main(String[] args) throws Exception {
       int array[][] = new int[][] {{1,2},{2,3,4}};
       int total = 0;
       
       for(int i = 0; i < array.length; i++){
           for(int j = i; j < array[i].length; j++){
               total += array[i][j];
           }
       }
       System.out.println(total);　// 10
    }
}
  ```
  
  - 拡張for文
    - 構文：「一時変数の宣言： コレクション/配列」　←　一時変数にはすでに宣言している変数と同じものはつけられない（コンパイルエラー）  
    - 一時変数の参照を変更しても、集合には影響しない  
    
  - 後置インクリメントの実行タイミング:判定された後にインクリメントされる  
  ```
  int num = 10;
  while(num++ <= 10) { // 条件式を判定した後に+1している
    num++;
  }
  System.out.println(num); // 13
  ```
  
  ### 第5章：配列の操作 めちゃ重要！
  - 配列：値の集合を扱うための「インスタンス」
    - Javaにおける配列：「配列クラス」から作られた「インスタンス」であり、値の集合を扱うことを目的としている。（値：要素）  
    - 配列の特徴 > 同じ型、互換性のある型の値しか扱えない / 扱える要素数はインスタンス生成時に決める。後で要素数を変えることはできない。
  <img src= "https://github.com/kuro-channel/TIL/blob/master/Java/%E9%85%8D%E5%88%97%E3%81%A8%E3%81%AF.jpg" alt="配列" title="配列">
  
  ```
  int[] array = new int[3]; // 配列インスタンスを生成し、配列型変数には配列インスタンスの参照を代入する
  ```
  
  - 配列型変数の宣言方法
  ```
  配列型変数の宣言1,2
  int[] array;
  int array[];
  
  2次元配列、3次元配列の配列型変数の宣言1,2
  int[][] arrayA;
  int[] arrayA[];
  int arrayB [][][];
  int[][] arrayB[];
  ```
  
  - 配列型変数と配列
    - 配列型変数には、配列インスタンスへの参照を代入するだけ。配列型変数を宣言する時は、要素数を指定することはできない。  
    ```
    int[2] array; // コンパイルエラー
    ```
  <img src= "https://github.com/kuro-channel/TIL/blob/master/Java/%E9%85%8D%E5%88%97%E5%9E%8B%E5%A4%89%E6%95%B0%E3%81%A8%E9%85%8D%E5%88%97.jpg" alt="配列型変数と配列" title="配列型変数と配列">
  
  - 2次元配列のインスタンス  
  ```
  int[][] array = new int[3][3];
  ```
<img src= "https://github.com/kuro-channel/TIL/blob/master/Java/%E5%A4%9A%E6%AC%A1%E5%85%83%E9%85%8D%E5%88%97%E3%81%A8%E9%85%8D%E5%88%97%E3%81%AE%E8%A6%81%E7%B4%A0%E6%95%B0.jpg" alt="多次元配列と配列の要素数" title="多次元配列と配列の要素数">

- 配列インスタンスと要素
  - 配列インスタンスと配列の要素は異なるものであるため、配列インスタンス生成後、**要素に値を代入する必要がある。**
```
int[] array = new int[3];
System.out.println(array[0]); // 0
array[0] = 10;
array[1] = 20;
array[2] = 30;
System.out.println(array[0]); // 10
System.out.println(array[1]); // 20
System.out.println(array[2]); // 30
```
```
【Mainクラス】
public class Main {
    public static void main(String[] args) throws Exception {
        Item[] items = new Item[3];
        int total = 0;
        for(int i = 0; i < items.length; i++){
            total += items[i].price;　// java.lang.NullPointerException
            // 配列インスタンスは生成したが、Itemクラスのインスタンスは生成していない。デフォルト：null を参照してヌルぽ
        }
        System.out.println(total);
    }
}
【Itemクラス】
public class Item {
    String name;
    int price = 100;
}

```

- 配列インスタンスの生成・初期化と配列型変数の宣言と参照の代入
  - newと初期化子の両方を使って配列のインスタンス生成と初期化を同時に行う場合、要素数は自動算出される為、**大かっこの中に要素数は指定できない**  
```
int[] array = {2,3};
int[] array = new int[] {2,3};
× int[] array = new int[2] {2,3}; // コンパイルエラー
```


- 第5章: 問9のトレース  
```
public interface A {}
public abstract class B implement A {}
public class C extends B {}
public class D extends C {}

public class Main {
  public static void main(String[] args){
    A[] array = {new C(), null, new D()};
    Object[] objArray = array;
  }
}
```
<img src= "https://github.com/kuro-channel/TIL/blob/master/Java/%E7%AC%AC5%E7%AB%A0_%E5%95%8F9%E3%81%AEUML.jpg" alt="/第5章_問9のUML" title="/第5章_問9のUML">

### 第6章：インスタンスとメソッド  
- クラスとインスタンス
  - クラスを定義し、クラスからインスタンスを生成して、インスタンスが動作することでプログラムを動作させる。  
  - **クラス：HDD上に保存されている単なるファイル** / **JVMが必要なクラスファイルを探して、メモリに展開（コピー）する。**（=このコピーのことを「インスタンス」という）
<img src= "https://github.com/kuro-channel/TIL/blob/master/Java/%E3%82%AF%E3%83%A9%E3%82%B9%E3%81%A8%E3%82%A4%E3%83%B3%E3%82%B9%E3%82%BF%E3%83%B3%E3%82%B9%E3%81%AE%E9%96%A2%E4%BF%82%E2%91%A0.jpg" alt="クラスとインスタンスの関係1" title="クラスとインスタンスの関係1">

複数のインスタンスを作れば、複数のコピーを作ることになる。（インスタンスごとの値を持てるようになる）  
<img src= "https://github.com/kuro-channel/TIL/blob/master/Java/%E3%82%AF%E3%83%A9%E3%82%B9%E3%81%A8%E3%82%A4%E3%83%B3%E3%82%B9%E3%82%BF%E3%83%B3%E3%82%B9%E3%81%AE%E9%96%A2%E4%BF%82%E2%91%A1.jpg" alt="クラスとインスタンスの関係2" title="クラスとインスタンスの関係2">

- 参照型変数がどのインスタンスの参照を持っているか？（問2)  
```
public class Item {
    String name;
    int price;
    
    public void printInfo(){
        System.out.println(name + ", " + price);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
       Item a = new Item();
       Item b = new Item();
       a.name = "apple";
       b.price = 100;
       a.price = 200;
       b.name = "banana";
       a = b; // bの参照をaに代入：aとb同じ参照を持っていることになる。変数内の参照が変わった瞬間。
       a.printInfo(); 
    }
}
```

- ガベージコレクション（GC）
  - インスタンスはメモリ上に作られる為、無制限に作るとメモリ空間を使い切ってしまう。
  - 限りあるメモリを有効に使う為にも、**利用していないインスタンスを削除し、空きスペースを作る必要がある**
  - Java：自動メモリ管理機能がある。利用されなくなったインスタンスを解放する: **ガベージコレクタ**の仕事
  - ガベージコレクションとは？： **ガベージコレクタが不要なインスタンスを探し、破棄すること**

- ガベージコレクションの対象
  - どこからも**参照されなくなったインスタンス**  
  - インスタンスへの参照がなくなった時点で、ガベージコレクションの対象になる。  
  ```
  - nullを代入しインスタンスの参照を外す
  Object obj = new Object();
  obj = null;
  
  - 新しいインスタンスへの参照で変数を上書き
  Object obj = new Object();
  obj = new Object();
  ```
  
- static領域とヒープ領域  
  - staticで修飾されたフィールドやメソッドはインスタンスを作るための領域とは別の領域に配置されている  
  - staticなメンバとそうでないメンバの分離はロード後すぐに行われる
  - **staticなフィールドはインスタンスを作らなくても使える**　→　**staticなフィールドはインスタンスとは別の領域にある変数**
<img src= "https://github.com/kuro-channel/TIL/blob/master/Java/static%E9%A0%98%E5%9F%9F%E3%81%A8%E3%83%92%E3%83%BC%E3%83%97%E9%A0%98%E5%9F%9F.jpg" alt="static領域とヒープ領域" title="static領域とヒープ領域">

- staticなフィールドは、**「クラス名.フィールド名」**、もしくはインスタンス生成後であれば「参照.フィールド名」でもアクセスできる。  
  - staticなメソッドも同様に**クラス名.メソッド名（引数）**
<img src="https://github.com/kuro-channel/TIL/blob/master/Java/static%E3%81%AA%E3%83%95%E3%82%A3%E3%83%BC%E3%83%AB%E3%83%89%E3%81%AE%E5%80%A4%E3%81%8C10%E3%81%AB%E7%BD%AE%E3%81%8D%E6%8F%9B%E3%82%8F%E3%81%A3%E3%81%9F%E7%8A%B6%E6%85%8B.jpg" alt="staticなフィールドの値が10に置き換わった状態" title="staticなフィールドの値が10に置き換わった状態">

```
設問5を例
public class Sample {
    static int num = 0;
}

public class Main {
    public static void main(String[] args) throws Exception {
       Sample.num = 10; // staticなメンバを書き換え1回目
       Sample s = new Sample();
       Sample s2 = new Sample();
       s.num += 10; // staticなメンバを書き換え2回目
       s2.num = 30; // staticなメンバを書き換え3回目
       System.out.println(Sample.num); // 30
    }
}
```
- staticなメソッドから、staticではないメンバにはアクセスできない
  - インスタンスがなくても使えるstaticメソッドから、staticではないメンバ（=インスタンス化しないとアクセスできない）にはアクセスできない  
<img src="https://github.com/kuro-channel/TIL/blob/master/Java/static%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89_static.%E3%81%A7%E3%81%AF%E3%81%AA%E3%81%84%E3%83%A1%E3%83%B3%E3%83%90%E3%81%B8%E3%81%AE%E3%82%A2%E3%82%AF%E3%82%BB%E3%82%B9.jpg" alt="staticメソッド_static.ではないメンバへのアクセス" title="staticメソッド_static.ではないメンバへのアクセス">

- シグニチャ：**メソッド名と引数のリスト**のセットのこと。
  - シグニチャの違いが**オーバーロードの必須条件**：オーバーロードの条件は、シグニチャが異なること。
  - 上記条件に**アクセス修飾子**は含まれない
  
- 可変長引数
  - **引数の数を自由に変更できる引数**のこと。**引数の型の直後**に**ピリオド3つ（...）**をつけて宣言する  
  - 異なる型はまとめられない
  - **可変長引数以外の引数を受け取る必要がある**場合には、可変長引数を**最後**の引数にすること
 
 ```
 // 可変長引数は配列として扱われている
  void sample(int... num) {
    for(int i = 0; i < num.length; i++) {
      System.out.println(num[i]);
    }
  }
```
- return文の2つの意味
  - 呼び出し元のメソッドに値を戻す
  - **呼び出し元に制御を戻す**
```
public class Sample {
    public void method(int num){
        if(num < 0) return;
        System.out.println("A");
        return;
        System.out.println("B"); // 到達不可能なため、コンパイルエラー
    }
}

Sample.java:6: error: unreachable statement
        System.out.println("B");
```

- コンストラクタのルール
  - メソッド名をクラス名と同じにすること
  - 戻り値型は記述できない
  - newと一緒にしか使えない（=インスタンス生成時しか呼び出しできない）
  - **どんなアクセス修飾子**でも定義できる。 public / private：非公開なコンストラクタを定義 / protected
  - public:どのクラスからでもインスタンス化可能 / protectedとデフォルト: 継承関係にあるサブクラスやパッケージ内からOK
  
- コンストラクタと初期子化
  - クラスブロック直下にフィールドやメソッド、コンストラクタと並べて記述する。
  - 初期子化は「コンストラクタが実行する前」に実行される。  
  - 初期化子を使えば、オーバーロードされた全てのコンストラクタで共通の前処理を宣言できる。
  - オーバーロードされたコンストラクタから、別のコンストラクタを呼び出すには**this**を使う。  
  - スーパークラスのコンストラクタを呼び出す時は、**super**を使う。

```
public class Sample {
  {
    // 初期子化で行う共通処理
  }
}
```

- クラス変数、static初期化子
  - クラス変数を初期化するためには、**static初期化子**を使う。
  - staticなメンバはインスタンスごとに値を保持しない。よって、変更されれば変更される。  

```
public class Sample {
  static int num; // 変更可能
  static {
    num = 10;
  }
  public Sample() {
    num = 100;
}
```

- カプセル化
  - フィールドを非公開（private）にし、アクセスするためのメソッドを提供（public）する  
  - ほかのクラスに定義されているメソッドからフィールドを守る為に、アクセス修飾子を使って不用意な利用を禁じる（=データ隠蔽）と一緒に使う

- アクセス修飾子  

|修飾子| 説明|
| ---- | ---- |
| public|全てのクラスからアクセス可能|
| protected| 同じパッケージに属するか、継承しているサブクラスからのアクセスのみ可能|
| デフォルト| 同じパッケージに属するクラスからのみアクセス可能|
| private | クラス内からのみアクセス可能|


- ***超重要！値渡しと参照渡し***
  - 値渡し: プリミティブ型の値をメソッドに渡す時、その値はコピーされて渡される = 呼び出し元の値に影響なし・・・例1
  - 参照渡し: オブジェクト型の引数では、呼び出し元から呼び出し先のメソッドに参照値がコピーされて渡される=2つのメソッドから参照するインスタンスは同じ・・・例2  

<img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E5%80%A4%E6%B8%A1%E3%81%97.JPG" alt="値渡し" title="値渡し">
<img src="https://github.com/kuro-channel/TIL/blob/master/Java/%E5%8F%82%E7%85%A7%E6%B8%A1%E3%81%97.JPG" alt="参照渡し" title="参照渡し">

```
例1:
public class Sample {
  int num;
  public Sample(int num) {
    this.num = num;
  }
}

public class Main {
  public static void main(String[] args){
    Sample s = new sample(10);
    modify(s.num); // コピーされて渡される
    System.out.println(s.num); // 10
  }
  public static void modify(int num) {
    num *= 2;
  }
}
```


```
例2:
public class Sample {
  int num;
  public Sample(int num) {
    this.num = num;
  }    
}

public class Main {
  public static void main(String[] args){
    Sample s = new sample();
    modify(s.num); // 参照がコピーされて渡される
    System.out.println(s.num); // 20
  }
  public static void modify(Sample s) {
    s.num *= 2;
  }
}
```

