前回記事：  
[輪読会メモ：リーダブルコード（第1~3章）](https://qiita.com/takumi_links/items/34e98d7dbbe0532a69d1)  
[輪読会メモ：リーダブルコード（第4~6章）](https://qiita.com/takumi_links/items/1d85f91cbaf6ab1c03ec)  
[輪読会メモ：リーダブルコード（第7~9章）]([https://qiita.com/takumi_links/items/1d85f91cbaf6ab1c03ec](https://qiita.com/takumi_links/items/06a0217d2a7459a0c83d))  
の続きになります。

今回は第10章～第13章：第Ⅲ部を見ていきます。
10~13章は、**コードの再構成**がテーマ。

## 第10章：無関係の下位問題を抽出する
> **無関係の下位問題を積極的に見つけて抽出すること。**  
（「リーダブルコード」p.130より）

> **「無関係の」下位問題：完全に自己解決しているので、アプリケーションにどのように使われるか知らないのだ**  
（「リーダブルコード」p.132より）
- より汎用的な処理を抽出して、関数に切り出すとコードが読みやすくなる

> **「このライブラリにXVZ()関数があればなぁ」と思ったら、その関数を自分で書けばいいのだ！」（ただし、既存の関数がない場合に限る）**  
（「リーダブルコード」p.133より）
- 各言語に勉強な関数は用意されているので積極的に使用する。なければ積極的に作ろう
