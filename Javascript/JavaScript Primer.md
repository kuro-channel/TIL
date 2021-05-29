## JavaScriptを理解しよう
- 「オブジェクト」「関数」「クロージャー」の3つの概念が重要
- 第一のポイント: 「関数が第1級オブジェクト」である！

## オブジェクトの概念
- オブジェクトとは、名前と値をもつプロパティを格納する入れ物にすぎない
  - 「プロパティ」とはオブジェクトが持つデータ
  - 「関連のあるデータと機能の集合」

## 第1級オブジェクトとは？
- 関数も「**普通のオブジェクトと同じ**」!!

関数: def（文法として用意している）
専用の構文が必要！！


- 関数を整数型、文字列、配列型等の一般的なデータ型と同じように扱える
  - リテラルを介して生成できる
  - 変数や、配列の要素、他のオブジェクトのプロパティとして代入できる
  - **引数として関数に渡すことができる**（SetIntervalで検証）
  - 関数から値として渡すことができる
  - 動的に作成し、代入することが可能なプロパティを持つことができる

- ()をつけて呼ぶ: 関数の処理が実行
- ()をつけずに呼ぶ: 変数への代入、関数の引数として呼べる

- 引数として関数を渡せる
```javascript
const hoge = () => {
    return 1 + 1;
};
console.log(hoge());　// 2
```

- setInterval
```
setInterval() は、一定の遅延間隔を置いて関数を繰り返し実行する関数です。

最初の引数に関数オブジェクトを指定し、二つ目の引数に間隔をms単位で指定します(1.0秒=1000㍉秒)。戻り値はinterval ID と呼ばれるものです。
```

```javascript
let n = 0;
const func = ()=> {
    n += 1; // 1ずつ増やす
    console.log('hello!' + n);
}
const interval = setInterval(func, 200); // 200ミリ秒ずつ、関数が実行される
```

- 関数宣言と関数式
  - 関数宣言: 文
  - 関数式: **関数を値として扱う式のこと**
  - 関数式では、名前を持たない関数を変数に代入できる！

```javascript
// 関数式
// 匿名関数（無形関数）を変数に代入できる
const func = () => {
    console.log('test');
};

// 関数宣言
function func2 = ()=> {
    console.log('test2');
}

```
- アロー関数
  - 処理が1つだけの式である場合は、returnを省略できる
  - 仮引数が1つの場合は、()を省略できる

```javascript
const array = [1,2,3];
undefined
const doubleArray = array.map(value => value *2);
undefined
console.log(doubleArray);
VM877:1 (3) [2, 4, 6]
```


## callback / callback関数
- 関数に関数を渡せるので、ある関数の中で実行したい関数(callback関数)を定義することができる。

- forEachメソッド
  - コールバック関数を引数として受け取り、配列の各要素に対してコールバック関数を1度ずつ呼び出す
  - コールバック関数となる匿名関数（無形関数）をその場で定義して渡せる

```javascript
const array1 = [1,2,3,4];
const output = (value)=> {
    console.log(value);
}
const test = array1.forEach(output);
1
2
3
4
// foreachは引数にコールバック関数を受け取る

const array2 = [1,2,3,4];
array2.forEach((value) => {
    console.log(value);
});

const test5 = array2.map((value)=>{
    console.log(value);
    return value *2;
});

console.log(test5);
(4) [2, 4, 6, 8]
```


## Javascriptにおけるデータの集合体の表し方
- オブジェクトチェーン
```javascript
const object = {
    object1: 
    }
}
```

## テンプレートリテラル
```javascript
const test3 = "test\ntest\ntest";
console.log(test3);
test
test
test

```

## 分割代入
```javascript
const arrya = [1,2,3];
const [a,b] = arrya;
console.log(a);
1
console.log(b);
2

const [c,d,e] = arrya;
console.log(c);
1
undefined
console.log(d);
2
undefined
console.log(e);
3

const obj2 = {
    "key": "value"
};
const key = obj2.key;
{key: "value"}

```


## [ES2020] Nullish coalescing演算子(??)
```javascript
const test = null;
console.log(test ?? 'nullish');
nullish
```

## オブジェクト
- オブジェクトリテラルのプロパティ名（キー）はクォート（"や'）を省略できる
```javascript
const obj = {
    name: 'test',
};
```
- 分割代入
  - 代入のコードを何度も書くのはめんどくさい！オブジェクトのプロパティを変数として定義しなおすときに使う
```javascript
const obj3 = { id : 1, name: 'kuroiwa Takumi'};
const {id, name} = obj3;
console.log(id);
1
console.log(name);
kuroiwa Takumi
```

- プロパティの存在確認: in演算子
```javascript
const obj = { id : 1, name: 'kuroiwa Takumi'};
console.log("id" in obj);
true
```

- オブジェクトの列挙
  - Object.keys : オブジェクトのプロパティ名を配列にして返す
  - Object.values：オブジェクトの値を配列にして返す
  - Object.entries：オブジェクトのプロパティ名と値の配列の配列を返す

```javascript
const obj = { id : 1, name: 'kuroiwa Takumi'};
console.log(Object.keys(obj));
(2) ["id", "name"]

console.log(Object.values(obj));
(2) [1, "kuroiwa Takumi"]
console.log(Object.entries(obj));

(2) [Array(2), Array(2)]
0: (2) ["id", 1]
1: (2) ["name", "kuroiwa Takumi"]
length: 2

const key = Object.keys(obj);
key.forEach((value) => {
    console.log(value);
});

id
name
```
- スプレッド構文
```javascript
const objA = {a : 'a'};
const objB = {b : 'b'};

const merged = { ...objA, ...objB};
console.log(merged);
{a: "a", b: "b"}
```
