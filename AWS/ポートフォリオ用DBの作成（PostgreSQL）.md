## DBの概要
- [PHPの開発環境構築を構築する - 3. DBのインストール：今回は「PostgreSQL」](https://github.com/kuro-channel/TIL/blob/master/AWS/PHP%E9%96%8B%E7%99%BA%E7%92%B0%E5%A2%83%E6%A7%8B%E7%AF%89.md#3-db%E3%81%AE%E3%82%A4%E3%83%B3%E3%82%B9%E3%83%88%E3%83%BC%E3%83%AB%E4%BB%8A%E5%9B%9E%E3%81%AFpostgresql)
で作成したDBに作成したポートフォリオ用のスキーマ、テーブルの作成・データの投入を行う。

### 詳細手順
- 1. Linuxのユーザを作成

```shell
$useradd kuroiwa
$passwd kurowa
$passwd kuroiwa
Changing password for user kuroiwa.
New password:
Retype new password:
passwd: all authentication tokens updated successfully.
```

- 2. postgresユーザでDBスキーマを作成
```shell
$su - postgres
-bash-4.2$createuser -U postgres -d -P kuroiwa
Enter password for new role:
Enter it again:

$createdb -U postgres -E UTF-8 --locale=ja_JP.UTF-8 kuroiwa --template=template0
$psql -d kuroiwa
psql (9.2.24)
Type "help" for help.

kuroiwa=#
```

- 3. テーブルの作成・dumpの適用
  - あらかじめ取得していたdumpを作成したDBスキーマに適用する

```shell
kuroiwa=#\i /home/kuroiwa/dump_20200701.sql
```
