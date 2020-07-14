## 第1章：Linuxとは（章末問題）

(1) **基本ソフトウェアは？**  
  A . 3.Windows, 4.Linux（OS)  
  
(2) **応用ソフトウェアは？**  
  A. 1.Word, 2.Excel（応用ソフトウェア）  

(3) **Operating Systemの役割**  
  1. 資源を管理する（各ソフトへのコンピュータ資源の割り当て）  
  2. 必要な部品を提供する：ウィンドウ、メニュー、ツールバーアイコン、確認メッセージ等・・・

(4) Linuxについて正しく述べているものは？  
  3. Linuxはカーネルとユーザーランドによって成り立つ。
 
(5) パッケージを使って応用ソフトウェアを導入する利点  
1. ソースコードをビルドする手間が省ける  

## 第3章: 基本的なコマンド
(1) ファイルやディレクトリを参照するコマンド：ls

(2) /media/cdrom/ の中身を最新更新日時順に並べる: 3 
```shell
$ls -lt /media/cdrom/
```

(3) 今いるパスを表示するコマンド:pwd
(4) /home/user フォルダにある test ファイルを /root/backup フォルダに移動する

```shell
$cd /home/user /root/backup
$ls /root/backup
```

(5)パス： /etcの中で、ファイル名の一部に「resolv」という文字列が含まれるファイルを検索するコマンドは？
```shell
$find /etc -name resolv
```

## 第4章：正規表現とパイプ
(1) grepを利用し、行頭がa またはb で始まる行を抽出できる正規表現は？
4. 
```shell
$grep -e ^[ab]  -n test2.txt
1:aaaaaaa
2:bbbbbb
```

(2) 「ls /usr/bin | grep -e ^a..$」の実行結果は？  
A. /usr/bin 配下のファイルのうち、先頭にaがつき、かつaから後続の2文字で終了するファイル（後続の2文字は任意）

例： axb

```shell
$ls /usr/bin | grep -e ^a..$
```

(3) パス：/etc の中にあるファイルで、ファイル名がconfで終わるものをgrepとパイプを用いて
```shell
$ls /etc/* | grep conf$
```

(4) ls -lを実行した結果を「ls-result」ファイルに書き込むコマンド

```shell
$ls -l > ls-result
```

(5)chkconfig --listの実行結果から「iptables」だけを絞りこんで表示するコマンドをgrepで

```shell
$chkconfig --list | grep -e iptables
```

- chkconfig とは？
  - サービスのシステム起動時の挙動設定を行う。ステム起動時に自動起動するサービスの設定や不必要なサービスを停止するなどの設定を行う。例えば、サーバ起動時にApacheも同時に起動させたいとき、chkconfigで設定を行うことで実現できる。
  
## 第5章：基本的なコマンド その2
(1) sortコマンドの実行結果は？

```shell
$cat price
Digital Camera 9800
32-inch TV 49800
Blue-ray Recorder 59800

$sort -k 3 -n price
Digital Camera 9800
32-inch TV 49800
Blue-ray Recorder 59800

$sort -k 3 -n -r price
Blue-ray Recorder 59800
32-inch TV 49800
Digital Camera 9800
```

(2) uniqコマンドの実行結果

```shell
$cat uniq-sample
red
red
blue
red

$uniq uniq-sample
red
blue
red
blue

$sort uniq-sample | uniq
blue
red
```

(3) file1とfile2の内容の違いを比較する
```shell
$ls /etc/* | grep conf$
```

(4) A. file1とfile2が同一内容の為、何も結果が表示されなかった

```shell
$diff file1 file2 #変化なし
$
```

(5) /etc の lsコマンドの実行結果が保存されたファイル「ls-etc」の終わり8行分を表示するコマンド

```shell
$ls /etc/* > ls-etc
$tail -n 8 ls-etc
remi-php54.repo
remi-php70.repo
remi-php71.repo
remi-php72.repo
remi-php73.repo
remi-php74.repo
remi-safe.repo
remi.repo
```

## 第6章：viエディタ
(1) カレント行から3行コピーする A.3yy
(2) 文書内の"abc"という語句を検索
```shell
/abc
```
(3) 編集中のファイルを保存せずに強制終了
```shell
:q!
```
(4) 文書の100行目に移動する
```shell
100 → G + shirt
```
(5) 「高野豆腐」を「絹ごし豆腐」に置換
```shell
:%s /高野豆腐/絹ごし豆腐/g
```

