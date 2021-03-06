## 【用語集】
- ElasticIP：固定のグローバルIPアドレス。EC2インスタンスにEIPを適用する際は、主に外部からのアクセスを受けるために利用する。IPを固定  

- グローバルIPアドレスって？  
```
グローバルIPアドレスはパブリックIPアドレスとも呼ばれ、インターネットに接続されているコンピュータや通信機器を個々に特定するための一意で割り当てられたIPアドレスのことです。
インターネット上の住所にあたり、インターネットに接続する際に必ず必要です。
```

- Auto Scaling：インスタンスの数を増減出来る。Auto Scaling Groupを設定して、拡張性を持たせることが可能。
```
Amazon EC2 Auto Scaling によって、アプリケーションの負荷を処理するために適切な数の Amazon EC2 インスタンスを利用できるように準備することができます。
Auto Scalingグループと呼ばれるEC2インスタンスの集合を作成します。各AutoScalingグループ内のインスタンスの最小数を指定することができ、
Amazon EC2 Auto Scaling のグループはこのサイズよりも小さくなることはありません。各 Auto Scaling グループ内のインスタンスの最大数を指定することができ、Amazon EC2 Auto Scaling のグループはこのサイズよりも大きくなることはありません。
```

<li>フェイルオーバー：稼働中のシステムに障害が発生した際に、代替システムがその機能を自動的に引き継ぎ、処理を続行する仕組み。企業の情報システムなどで、サーバの信頼性を高めるためによく用いられる。
<li>ロードバランサ：複数のバックエンドサーバがあるときに、リクエストを分散させるための仕組み。
<p>【出来ること】<br>
・複数台webサーバーを複数台用意し、負荷を分散させることができる。 </br>
・メンテナンスや障害時には切り離しを行うことができる。</br>
<参考> https://qiita.com/rorensu2236/items/d7a51bd23325d262dee0

## S3とは？
> https://docs.aws.amazon.com/s3/index.html
>
- インターネットストレージ（平たく言うとgoogleドライブ、evernoteのようなwebブラウザから利用できるストレージ）
- S3はAPIまたはAWS CLIにてプログラムから操作（ファイルのアップロード、ダウンロード、削除）ができる
- 容量制限なし
- データはいつでもダウンロード可能
- 柔軟なアクセス制御ができる（IAM、アクセスコントロール、バケットポリシー）
- **Amazon Simple Storage Service (Amazon S3) はインターネット用のストレージ。Amazon S3 を使用すると、データの大きさにかかわらず、ウェブ上のどんな場所からでもいつでも保存、取得することができる。**
- S3のオブジェクト  
● オブジェクトキー：バケット内のオブジェクトは「一意」に識別される。（重複はなし）  
● フォルダ階層になっているとき：区切り記号（"/"）でフォルダ構造を表す。  
　```foo - bar.csv → foo/bar.csv```  
● Amazon S3 Java API： S3をJava APIで操作するAPI  参考リンク：http://www.ne.jp/asahi/hishidama/home/tech/aws/s3/api.html


## Elasticsearchとは？
- Elastic社が開発している、スケーラビリティに優れた全文検索エンジン
- リアルタイムデータ分析、ログ解析、全文検索など様々な分析が可能になる
- ログ集約のLogstashやfluentd、可視化ツールのkibanaと一緒に使われることが多い
- 複数のデータベースを横断して検索することが、ごく当たり前の用途として提供されている 
https://qiita.com/r548/items/3622048a622d9c0acc05  
https://aws.amazon.com/jp/elasticsearch-service/the-elk-stack/what-is-elasticsearch/
