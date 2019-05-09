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
- (MFA：多要素認証で不正利用からIAMユーザーを守る）→今回はやってない！
- リージョンの変更 近いリージョン選択してた方が通信速度早い！
- **CloudTrail**の設定：「いつ誰が何をしたのか？記録してくれるサービス」

## 1.AWSでサーバーを立てる
- サーバー：**Amazon Elastic Compute Cloud（EC2）** ※AWSではサーバーのことを「**インスタンス**」と呼ぶので注意
- AMI：Amazon マシーン イメージ…サーバーのもととなるテンプレート。Amazon AMIを入れよう。  
