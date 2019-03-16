## 即時関数
即時関数は、関数を定義すると同時に実行するための構文。 
  
**<ポイント>**
<p>「一回だけ必要な処理を、グローバルスコープを汚染せずに実行する方法」（カプセル化）</p>

<ul>
  <li>ページが読み込まれたときの初期化処理
  <li>オブジェクトの生成
  <li>DOM要素へのイベントハンドラの設定
</ul>

```
(function () {
    //処理
}());

// 引数をもたせられる
(function (param1, param2) {
    //処理
}('hoge', 'fuga'));

// 戻り値
var result = (function (param1, param2) {
    //処理
}('hoge', 'fuga'));
```

## 参照
>JavaScriptで即時関数を使う理由 https://qiita.com/katsukii/items/cfe9fd968ba0db603b1e  
>即時関数のちょっとした説明 https://qiita.com/kenju/items/d495503a1cd53320a2da
