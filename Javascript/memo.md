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