# やりたいこと：EC2にsshで入って、EC2にWebサーバの設定をする ※Amazon Linux1での設定

## ホスト名の変更

sudo vim /etc/sysconfig/network

====

HOSTNAME=XXXX

====

sudo vi /etc/hosts

====

127.0.0.1 に↑を追加する

====

## OS の言語設定

sudo vi /etc/sysconfig/i18n

====

前）LANG=en_US.UTF-8

後）LANG=ja_JP.UTF-8

====

## OS の時刻設定

sudo cp /usr/share/zoneinfo/Japan /etc/localtime

sudo vim /etc/sysconfig/clock

====

ZONE="Asia/Tokyo”

====

## 必要なパッケージの導入

sudo yum update -y

sudo yum install -y httpd24

sudo yum install -y php70 php70-mbstring php70-pdo php70-mysqlnd

sudo yum install -y mysql

sudo yum install -y git



- ホスト名の設定：

## Apache の設定

## DirectoryIndex の変更

sudo vim /etc/httpd/conf/httpd.conf

====

変更前）

<IfModule dir_module>

    DirectoryIndex index.html

</IfModule>

変更後）

<IfModule dir_module>

    DirectoryIndex index.php index.html

</IfModule>

====

====

ServerName もコメントアウトを外して、hostname に変更する

====

## httpd.conf の確認テスト

sudo /etc/init.d/httpd configtest

## EC2 インスタンス再起動時に、自動で httpd プロセスが上がるように設定
sudo chkconfig httpd on

## httpd の立ち上げ
sudo service httpd start

## PHP の設定
sudo vim /etc/php.ini

====

## Dynamic Extensions の下の方に

extension=mbstring

====

====

mbstring.language = Japanese

mbstring.internal_encoding = UTF-8

====

## サンプルリソース取ってくる

git clone https://github.com/ketancho/udemy-aws-14days.git

cd udemy-aws-14days/Day3/

sudo cp index.php /var/www/html/

sudo cp -r img /var/www/html/
