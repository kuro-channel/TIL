### クラウドとは？
- 仮想化技術  
 仮想化される側をゲスト、仮想化を提供する側をホストという  
 → 仮想化技術でサーバの占める場所を節約。仮想マシン間でリソース（CPUやメモリ、ディスク容量等）の利用効率を高めることができる。  
> ユーザーがインフラやソフトウェアを持たなくても、インターネットを通じて、サービスを必要な時に必要な分だけ利用する考え方」のこと。  
> クラウドは、クラウド・コンピューティングと呼ばれることもある。　※インフラ･･･サーバーやストレージ、ネットワークを指す 
> コンピューターの利用形態のひとつ。インターネットなどのネットワークに接続されたコンピューター（サーバー）が提供するサービスを、
> 利用者はネットワーク経由で手元のパソコンやスマートフォンで使う。 Gmail、Hotmail etc...
> クラウドとは？
> https://altus.gmocloud.com/suggest/cloud/  

- 「ハードウェアを購入したり、ソフトウェアをインストールしなくても利用できるサービス」が、**クラウドサービス**と呼ばれている

- 特徴  
　・従量課金（使った分だけ）  
　・拡張性  

### SaaS（Software as a Service）･･･　ソフトウェアを提供するクラウドサービス
- ソフトウェアをインターネットを通じて使えるサービス。オフィスソフトをWebブラウザ上で使えたり、データをクラウドに保存したり、共有したり出来る。  
- 提供するもの：ソフトウェア / 具体的なサービス：Google Docs, Office Online 
> salesforce.comやOffice 365などがあります。また、GoogleマップやGoogle Earth、乗り換え案内サービスなどもSaaS

### PaaS（Platform as a Service）･･･　開発環境を提供するクラウドサービス
- PHPやRuby,Javascript等で作ったアプリケーションを簡単に動かせるサービス。普通はWebサーバ立てたり、OSの設定したりと面倒くさい…  
→ 作ったアプリケーションをアップロードするだけで動く。
- 提供するもの：アプリケーション実行環境 / 具体的なサービス：**Heroku**,Google App Engine
> Monaca、Cloud9、Eclipse Orion、Google App Engine

### Herokuとは？
https://jp.heroku.com/
> Heroku はアプリの構築、提供、監視、スケールに役立つクラウドプラットフォームで、アイデアを出してから運用を開始するまでのプロセスを迅速に進めることが可能です。また、インフラストラクチャの管理の問題からも解放されます。
  
> ユーザーに価値を提供するうえで、必要なときに必要に応じてプログラムを使いこなしていくという場合に、Heroku というプラットフォームは手軽で、身動きがとりやすく早いです。
> 一言で言うなら、お客さんに「はい、作ってみました！ これでどーですか？」を叶えてくれる素敵なツールだと思いました。
> もし不都合が出てきたら Heroku から AWS に移行すれば良いと考えているので、初期の段階では安価に手軽にウェブサービスをローンチできる Heroku という選択肢を検討するのもアリかと思いました。

### IaaS （Infrastructure as a Service）･･･　サーバー（インフラ）を提供するクラウドサービス
- 仮想マシンや仮想ネットワーク等のインフラを提供するサービス。スペックやOSを自由に選べたり、ネットワークの構成を好きに変えられる等、自由度高い。  
※ ホスティングサービスやVPSの進化版！
- 提供するもの：サーバ、ネットワーク / 具体的なサービス：Amazon EC2、GCP Compute Engine
> クラウド上に大容量データを保存できるクラウドストレージサービスは、以前はHaaS（Hardware as a Service）と呼ばれていましたが、現在はIaaSとされています。これにはDropboxやGoogleドライブ、Yahoo!ボックス、iCloud Driveなどがあります。
