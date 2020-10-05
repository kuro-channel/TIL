## docker × Laravel 開発環境構築

- 前提環境
  - Windows 10 Home
  - Dockerインストール済み
  - gitインストール済み
  
- 手順
  ### 1. **プロジェクトフォルダを作成** 
  ``` mkdir todo-list```  
  
  ### 2. **laradockをプロジェクトフォルダ直下にclone** 
  ```git clone https://github.com/laradock/laradock.git```
  
  ### 3. **作成したlaradockディレクトリに移動し、「.env」ファイルを作成、編集** ※「env-example」をリネームして作成する
  ```cp env-example .env ``` : サンプルファイルをリネームして、.envファイル（環境設定ファイル）を作成する。laradock直下  
  ◎ .envファイルの設定詳細→→ https://blog.proglearn.com/2019/11/21/%E3%80%902019%E5%B9%B411%E6%9C%88%E3%80%91laradock%E3%81%A7laravel%E3%82%92%E6%A7%8B%E7%AF%89%E3%81%99%E3%82%8B%E3%81%BE%E3%81%A7%E3%81%AE%E5%85%A8%E6%89%8B%E9%A0%86/
    - データの保存先をlaradock毎に分離したい場合は「DATA_PATH_HOST」を書き換える
    - APP_CODE_PATH_HOST: アプリケーションのディレクトリパスを指定する  
    
  ### 4. **docker-composeでコンテナを立ち上げる** nginx と　mysqlを立ち上げ
    - laradockディレクトリに移動し、コマンドを実行 ```docker-compose up -d nginx mysql``` ※初回起動は時間がかなり！かかる
    
  ### 5. **Laradock環境に入る**
    - コマンドを実行 ```winpty docker-compose exec --user=laradock workspace bash```
    - Laradockに入れた時の表示 ```laradock@78913d007822:/var/www$```
    
  ### 6. **Laravel一式をダウンロードしてくる**
    - コマンドを実行 ```composer create-project laravel/laravel to-do-list``` ※実行時間かかる

  ### 7. **Laravel内の「.env」ファイルを編集する**
    - Laradockではなく！Laravelプロジェクト配下の「.envファイルを編集」
    ‐ DBの設定を「Laradock」の.envに合わせて変更
    ```
    DB_CONNECTION=mysql
    DB_HOST=mysql
    DB_PORT=3306
    DB_DATABASE=default
    DB_USERNAME=default
    DB_PASSWORD=secret
    ```  
    - Laradockの「.env」のAPP_CODE_PATH_HOST で共有フォルダのマウント設定
    ```
    # Point to the path of your applications code on your host
    APP_CODE_PATH_HOST=../app/to-do-list
    ```
    
  ### 8. **設定の反映：コンテナを再起動**
    ```
    docker-compose stop
    docker-compose up -d nginx mysql
    ```
    
  ### 9. **アクセス確認**
    - ブラウザから「localhost」にアクセス
