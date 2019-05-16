## この記事は随時更新予定です。
## 0.初期準備
**＜関連サービス＞**
Route53 / CloudWatch / IAM / CloudTrail
- AWS無料枠でAWSアカウントを作成する。 https://aws.amazon.com/jp/free/  
※ AWSアカウント作成には、「クレジットカード」と「スマートフォン」が必要。 
- ネームサーバーとしてAWSの**Route53**を使う
- AWSマネージドコンソール（ダッシュボード）
- **CloudWatch**で請求アラートの設定 ：モニタリングサービス
- **IAM**でユーザーの権限管理 ルートユーザの普段使いはダメ！  
  IAMユーザーを作成しよう。 1) グループの作成 2) ユーザーの作成  
  **IAM:Identity and Access Manegement** AWSの利用者を管理するためのサービス
  >https://aws.amazon.com/jp/iam/
  >
- (MFA：多要素認証で不正利用からIAMユーザーを守る）→今回はやってない！
- リージョンの変更 近いリージョン選択してた方が通信速度早い！
- **CloudTrail**の設定：「いつ誰が何をしたのか？記録してくれるサービス」

## 1.AWSでサーバーを立てる
- サーバー：**Amazon Elastic Compute Cloud（EC2）** ※AWSではサーバーのことを「**インスタンス**」と呼ぶので注意
- AMI：Amazon マシーン イメージ…サーバーのもととなるテンプレート。Amazon AMIを入れよう。  
　**STEP1：AMIの選択**　※AMIにも種類がたくさんある  
 > Amazon マシンイメージ (AMI)について https://docs.aws.amazon.com/ja_jp/AWSEC2/latest/UserGuide/AMIs.html
   Amazon Linuxについて https://docs.aws.amazon.com/ja_jp/AWSEC2/latest/UserGuide/amazon-linux-ami-basics.html  
 >
　**STEP2：インスタンスタイプの選択**  
　無料枠の対象は「t2.micro」/小〜中規模：T2インスタンス、DBやキャッシュを処理/M5インスタンス（サーバーのスペック）  
　**STEP3：インスタンスの詳細の設定**　デフォルトでOK。  
　**STEP4：ストレージの追加**  EBS（Amazon Elastic Block Store） デフォルトでOK  
 > EBS（Amazon Elastic Block Store） https://aws.amazon.com/jp/ebs/?nc2=type_a  
>
　**STEP5：タグの追加** インスタンスにタグをつけて分類できる。（見やすいように）  
　ex） key: enviroment - value:production、key: enviroment - value:staging 本番とステージングで分かりやすくする  
　**STEP6：セキュリティグループの設定**  
　ファイアーウォール（自宅からアクセスは通すけど、それ以外からは通さない）:特定の通信のみを通してそれ以外は阻止する  
　**STEP7:起動、キーペアの作成→インスタンスの作成完了**  
　キーペアは無くさない所に保存すること。後から再ダウンロード出来ないので・・・。

## 2.SSHでサーバーに接続
- SSHとは：Secure Shellの略。**リモートコンピュータと通信するためのプロトコル。**  
認証部分を含めネットワーク上の通信がすべて暗号化されるため、安全に通信することができる。  
→ 先ほど作成した「キーペア」を使って、鍵認証でサーバーにログインする。  
```chmod 600 ~/Desktop/start-aws-keypair.pom```  
```ssh ec2-user@IPパブリックIP -i ~/Desktop/start-aws-keypair.pom```  
- chmodコマンド https://qiita.com/ntkgcj/items/6450e25c5564ccaa1b95  
　↑ファイル or ディレクトリに対する権限を設定するコマンド。
- EC2においてIPアドレスは動的：インスタンスが停止されると、そのインスタンスに紐づいたIPアドレスが解放されてしまい、新しいIPが紐づけられる  
- **ElasticIPの設定**:再起動しても変わらないElasticIPを設定する  
**手順**：「新しいアドレスの割り当て」→「アドレスの関連付け」  
※EC2のIPv4パブリックと作成したElasticIPを紐づける。
- 注意：ElasticIPは基本無料！しかし、条件が「**実行中のインスタンスに紐づいていれば（関連つけられていれば）**」  
　実行中のインスタンスに関連つけられてない（停止してたり…）すると、お金がかかる。    
　知らないとお金がかかってしまうので、起動しているインスタンスに紐づける以外の場合には、ElasticIPは解放しておくように！

## ３.ターミナルで作業：サーバーの設定
