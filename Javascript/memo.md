#### 【初心者向け】GASを使ってSlackへ自動通知
- 【初心者向け】GASを使ってSlackへ自動通知 https://qiita.com/chihiro/items/c7b11abc78f5d806c3a8
  - やってみた
  - やったこと： slackに新規チャンネル作成 → Incoming Webhook設定 → Google Active Scriptを実装　→ 作成したスクリプトを毎日実行するようにトリガー設定
  
```javascript
var postUrl = 'https://hooks.slack.com/services/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';
var username = '朝活BOT';
var icon = [':ayaka', ':reni' , ':shiori', ':kanako'];
var message = 'おはよう！今日も朝活頑張ろう！'

function myFunction() {
  var jsonData = {
    "username": username,
    "icon_emoji": icon[Math.floor(Math.random() * 3)],
    "text": message
  };

  var payload = JSON.stringify(jsonData);

  var options = {
    "method": "post",
    "ContentType": "application/json",
    "payload": payload
  };

  UrlFetchApp.fetch(postUrl, options);
}
```
- Webhookとは？：やってることは「**ただのPOSTリクエスト**」
  - Webhookとは? https://qiita.com/soarflat/items/ed970f6dc59b2ab76169
  - 【アプリケーションの更新情報を他のアプリケーションへリアルタイム提供する仕組みや概念のこと。】
  - 【イベント（リポジトリにプッシュなど）発生時、指定したURLにPOSTリクエストする仕組みのこと】
  - 「SlackのWebhook使おうぜ！」といわれたら・・・「ユーザーが投稿などをした際に、Slackが指定したURLにPOSTリクエストしてくれるから、それ使おうぜ！」

- jsonペイロードとは？
  - Content-Typeが「application/json」の場合、フォームのデータはJSON形式で送信することになります。JSONペイロードとか言うこともあるみたいですが、これだと$_POSTに値が入ってきません。
  - payloadとは一般的にhttpリクエストのhttpヘッダーを除いたボディ部分。送信内容そのもの
  - Content-Typeをapplication/x-www-form-urlencodedで送信したものはFormDataとして送信
  - application/jsonで送信したものはpayloadとして送信される。
  - payloadを使うとJSONを送信するので、文字列以外にも**オブジェクトやブール値など多様なデータを送信できる**

````text
// FormData
Content-Type: application/x-www-form-urlencoded
foo=bar&name=John

// payload
Content-Type: application/json
{ "foo" : "bar", "name" : "John" }
````
