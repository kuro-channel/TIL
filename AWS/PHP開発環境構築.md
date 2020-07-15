## PHPの開発環境構築を構築する

### 必要なミドルウェアのインストール

#### 1. まずはyum update  
```shell
$yum update -y
```

#### 2. PHPとApacheのインストール
- PHPはApacheのモジュール（部品）扱い：PHPをインストールすると、Apacheもインストールされる
- Apacheをインストールした際には、自動起動の設定をONにしておく

```shell
$amazon-linux-extras #利用できる拡張パッケージを確認する

$amazon-linux-extras enable php7.4 #php7.4を有効にする
php7.4=latest            enabled      [ =stable ]

$yum clean metadata

$yum install php #PHP7.4インストール

$php -v　#PHPのバージョン確認
PHP 7.4.5 (cli) (built: Apr 23 2020 00:10:21) ( NTS )
Copyright (c) The PHP Group
Zend Engine v3.4.0, Copyright (c) Zend Technologies

$httpd -v #Apacheのバージョン確認
Server version: Apache/2.4.43 ()
Server built:   May  8 2020 17:02:41

$systemctl enable httpd.service #自動起動設定
Created symlink from /etc/systemd/system/multi-user.target.wants/httpd.service to /usr/lib/systemd/system/httpd.service.

$systemctl status httpd.service #Apacheのステータス確認
● httpd.service - The Apache HTTP Server
   Loaded: loaded (/usr/lib/systemd/system/httpd.service; enabled; vendor preset: disabled)
   Active: inactive (dead)
     Docs: man:httpd.service(8)
```

#### 3. DBのインストール：今回は「PostgreSQL」
- yumでインストールする（Amazon Linux2系でのPostgreSQLのバージョンは9系）
```shell
$yum install postgresql-server postgresql-devel postgresql-contrib #postgresqlをインストール

$postgresql-setup initdb　#初期設定
Initializing database ... OK 

$systemctl start postgresql.service  #postgresqlを起動

$ps -ef | grep postgres #プロセスの確認
postgres 22121     1  0 22:54 ?        00:00:00 /usr/bin/postgres -D /var/lib/pgsql/data -p 5432
postgres 22122 22121  0 22:54 ?        00:00:00 postgres: logger process
postgres 22124 22121  0 22:54 ?        00:00:00 postgres: checkpointer process  
postgres 22125 22121  0 22:54 ?        00:00:00 postgres: writer process
postgres 22126 22121  0 22:54 ?        00:00:00 postgres: wal writer process
postgres 22127 22121  0 22:54 ?        00:00:00 postgres: autovacuum launcher process
postgres 22128 22121  0 22:54 ?        00:00:00 postgres: stats collector process
root     22131  3425  0 22:54 pts/0    00:00:00 grep --color=auto postgres

$systemctl enable postgresql.service #postgresqlを自動起動設定

$su - postgres #DBに接続してみる

-bash-4.2$ psql #接続OK
psql (9.2.24)
Type "help" for help.

postgres=# psql
```
 

#### 4. OSの基本設定：タイムゾーンの設定、locale（言語）の設定
```shell
$date #サーバ時間の確認

$vi /etc/sysconfig/clock #設定ファイル変更
ZONE="Asia/Tokyo"
UTC=true

$ln -sf /usr/share/zoneinfo/Asia/Tokyo /etc/localtime #シンボリックリンク作成

$ls -l /etc/localtime #確認
lrwxrwxrwx 1 root root 30 Jul 14 22:45 /etc/localtime -> /usr/share/zoneinfo/Asia/Tokyo

$vi /etc/sysconfig/i18n #言語の設定（日本語）

$cat /etc/sysconfig/i18n
LANG="ja_JP.UTF-8"
```

