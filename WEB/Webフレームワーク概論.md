### ルーティングとは？
- クライアントからのリクエストURLとそのURLに対応する処理を紐づけること（URLと処理のマッピング）
  - 処理は「Controller」で行う

```text
https://a.example.com/about
↑上記のようなリクエストがきた場合に、'AboutController'というコントローラーをマッピングして、リクエストをControllerに流す
```
  
- PHPで自作フレームワークを作ってみた
  - .htaccessの設定：原則としてすべてのアクセスをindex.phpにリライトさせる。
  - index.phpでリクエストURLを解析し、各Controllerに割り振る。
  - 「どんなアクセスでも、ひとまず受け止める」 > **フロントコントローラー**と呼ぶ。
  - やること! 1. 「.htaccessの設定」（WEBのルートディレクトリを配置） : .htaccessですべてのアクセスを「index.php」にリダイレクトする。
   
