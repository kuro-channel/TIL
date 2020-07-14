### Linuxコマンド 入力補助機能
- Ctrl + A : カーソルを行の先頭に移動  
- Ctrl + E : カーソルを行の最後に移動  

### helpコマンド
- help + コマンド名

### vi コマンド
- よく使うもの  
**gg** : 先頭行へ戻る  
**shift + G**: 最終行に戻る  
**dd**: 現在カーソルのある行を削除（カット） 

```shell
$vi ファイル
:set fenc? ファイルエンコード確認
:e ++enc=euc-jp 文字コードを指定して表示
:e ++enc=utf-8
```

### more コマンド  
  - 長いテキストを見るときはcatよりもmoreコマンドの方が有効だ。合わせて覚えておこう。

```shell
$less error_log
```
|コマンド|概要|
|--------|----|
|**スペース**|次のページに進む|  
|**b**|前の画面に戻る|  
|**f**|次の画面に進む|  
|**/単語** |単語検索、nで次の検索結果へジャンプ|  
|**q**|コマンド終了|  

### less コマンド  
  - 長いテキストを見るときはcatよりもlessコマンドの方が有効だ。合わせて覚えておこう。

```shell
$less error_log
```
|コマンド|概要|
|--------|----|
|**g**|先頭行へ戻る|  
|**shift + G**|最終行に戻る| 
|**shift + q**|lessコマンド終了|  
|**スペース**|次のページに進む|  
|**b**|前の画面に戻る|  
|**f**|次の画面に進む|  
|**/単語** |単語検索、nで次の検索結果へジャンプ|  
|**q**|コマンド終了|  

### which コマンド
- コマンドのパスを表示
```shell
$which less
/usr/bin/less
```

### tailコマンド
  - 最終行から数行を表示する
  
```shell
$tail -n 3 ファイル名
```
ファイル名の末尾3行を表示する  

### clear コマンド
- 端末の表示内容を消す（クリアする）コマンド
```shell
$cancel
```

### ls コマンド
- ファイルのコピー

|コマンド|概要|
|--------|----|
|**-a**|隠しファイル等もすべて出力|  
|**-l**|長（Long）形式で出力|  
|**-t**|最終更新時間によってソート|
|**-r**|逆順にソート|

- ?は1個につき何らかの1文字を示す

```shell
$ls -lat
$ls -lar
$ls hosts.????
$ls hosts.????w
```

### cpコマンド
- ファイルのコピー

|コマンド|概要|
|--------|----|
|**-i**|info: 問い合わせ|  
|**-r**|ディレクトリをコピー|  
|**-p**|元のファイルの情報を保存|

```shell
$cp -r work3 work4
$cp -p test.txt test2.txt
```

### mvコマンド
- ファイルの移動

|コマンド|概要|
|--------|----|
|**-i**|info: 問い合わせ|  
|**-f**|強制的に実行| 

```shell
$mv -f work.txt work4
```

### mkdir コマンド
- ディレクトリの作成

|コマンド|概要|
|--------|----|
|**-p**|上位ディレクトリも作成|  

```shell
$mkdir -p test/work.txt
```

### rmdir コマンド
- ディレクトリの削除

|コマンド|概要|
|--------|----|
|**-p**|上位ディレクトリを削除 ※ディレクトリ内が空の場合のみ|
|**-r**|上位ディレクトリを削除|

```shell
$rmdir -p test
```

### Linuxにおけるディレクトリ
- カレントディレクトリ: .
```shell
$cp test.txt ./
```
- 親ディレクトリ：..
```shell
$cd ../
```

- ホームディレクトリ:~
```shell
$cd ~/
```

- ルートディレクトリ:/
```shell
$cd /
```

### rmコマンド
- ファイルの削除

|コマンド|概要|
|--------|----|
|**-i**|info: 問い合わせ|  
|**-f**|強制的に実行| 
|**-r**|ディレクトリを対象にする| 
※ディレクトリを消すときは、rmdirを使う（一つずつファイルを削除できる）

```shell
#work4はディレクトリ
$rm -r work4
rm: ディレクトリ `work4' 配下に入りますか?
[root@kuroiwa-t developer]# rm -r work4
rm: ディレクトリ `work4' 配下に入りますか? y
rm: ディレクトリ `work4/test' 配下に入りますか? y
rm: 通常ファイル `work4/test/work.tar.bz2' を削除しますか? y
rm: 通常ファイル `work4/test/test.txt' を削除しますか? y
```

### grepコマンド
- 文字列の検索
```shell
$grep -rl {検索対象の文字列} {検索対象のパス}
$grep abc /etc/*  #/etc ディレクトリ下で、abcという文字列を含むもの
$grep ^xy /etc/*  # /etc ディレクトリ下で、行の先頭がxyで始まっているもの
```

### grepコマンド 応用編
```shell
$grep -i hostname /etc/* # 大文字小文字を区別しない
$grep abc /etc/* | grep -v tcp #abcという文字列を含むが、tcpという文字列は含まない
$ls /usr/bin/ | grep -e d$ #　ファイル名がdで終わるファイルを/usr/binから検索
```

|コマンド|概要|
|--------|----|
|**-e**|文字列を検索パターンとして扱う|  
|**-i**|英大文字、小文字の区別を行わない|  
|**-v**|検索パターンとマッチしなかった行を選択する| 

### sedコマンド
- 文字列の置換

```shell
sed -i 's/ootsuka/kuroiwa-t/g' param_mail.conf
```

### findコマンド
- ファイルの検索
```shell
$find *.sql // 拡張子「sql」のファイルを確認する
$find ./ -name \*.conf
```

### tarコマンド
- ファイルの圧縮・展開
- 複数のファイルをまとめたい場合は、tarコマンドとgzip、bzip2コマンドを組み合わせる手法が一般的
```shell
# f ファイル名 tarファイルに含めたいファイルを列挙していく
# czf : gzipを使用して圧縮。複数ファイルを圧縮している。
$tar czf work2.tar.gz dump_0629.sql dump_0702.sql
$tar xvzf work2.tar.gz
```
```shell
# bzip2
$tar jcf work.tar.bz2 dump_0702.sql test.txt
$tar jvxf work.tar.bz2
```
```shell
# tar単体で使う
$tar cf work.tar dump_0629.sql dump_0702.sql
$tar xf work.tar
```

|コマンド|概要|
|--------|----|
|**-c**|create/作成|  
|**-x**|extract/展開|  
|**-r**|append/末尾に追加|  
|**-v**|verbose/詳細を表示|  
|**-j**|bzip2ファイルを扱う|  
|**-z**|gzipファイルを扱う|  

### gzipコマンド
- ファイルの圧縮・展開
```shell
f ファイル名 tarファイルに含めたいファイルを列挙していく
$gzip dump_0629.sql
$gzip -d dump_0702.sql.gz
```

|コマンド|概要|
|--------|----|
|**-a**|Windowsで利用する場合のために圧縮時に改行コードを「CR LF」から「LF」に、展開時に「LF」から「CR LF」に変更します。|  
|**-c**|圧縮結果を標準出力に表示|  
|**-d**|圧縮されたファイルを展開（解凍）|  
|**-f**|ファイルが既に存在する場合は上書き|  
|**-l**|圧縮されたファイルの情報（サイズ、圧縮率、ファイル名）を表示|  
|**-r**|指定したディレクトリ内のファイルを圧縮|  

### bzip2コマンド
- ファイルの圧縮・展開
```shell
# 圧縮された後、元のファイルは削除される
$bzip2 dump_0702.sql
# 展開された後、bz2ファイルは削除される
$bzip2 -d dump_0702.sql.bz2
```

|コマンド|概要|
|--------|----|
|**-c**|圧縮結果を標準出力に表示|  
|**-d**|圧縮されたファイルを展開|  
|**-f**|ファイルが既に存在する場合は上書き|  
|**-t**|圧縮テストを実行|  
|**-v**|圧縮率を表示|  

### xzコマンド
- ファイルの圧縮・展開
```shell
# 圧縮された後、元のファイルは削除される
$xz test2.txt
# 展開された後、bz2ファイルは削除される
$xz -d test2.txt.xz
```

### cpioコマンド
- 3つのモードがある。

1. コピーアウトモード
2. インサートモード
$3. コピーパスモード

```shell
# アーカイブの作成
# 1. コピーアウトモード
$ls > test.txt
$cpio -o < test.txt > files.cpio
$ls | cpio -o > test2.cpio
```
```shell
# アーカイブの展開
# 2. インサートモード
$cpio -i < test2.cpio
```
```shell
# アーカイブは作らない
# 3. コピーパスモード
$cpio -pd copyto < filelist.txt
```

### headコマンド
- ファイルの先頭を一部分のみ表示する。表示件数のデフォルトは10行。

|コマンド|概要|
|--------|----|
|**-n**|指定した分の行を表示|  
|**-c**|指定したバイト分を標準出力|

```shell
$head -n 15 test.txt
$head -c 200 test.txt
```

### tailコマンド
- ファイルの終わり部分を一部分のみ表示する。表示件数のデフォルトは10行。

|コマンド|概要|
|--------|----|
|**-n**|指定した分の行を表示|  
|**-c**|指定したバイト分を標準出力|
|**-f**|リアルタイムでファイルの変更が確認できる|

```shell
$tail -n 15 test.txt
$tail -c 200 test.txt
$tail -f test.txt
```

### sort コマンド
- テキストファイルの中身をソートする

|コマンド|概要|
|--------|----|
|**-r**|逆順でソート|  
|**-k n**|n列目のデータをソート|
|**-n**|数値としてソート|

```shell
$cat > score
kuroiwa 80
katou 90
kobayashi 70

$sort score #オプションをつけないとアルファベット順
katou 90
kobayashi 70
kuroiwa 80

$sort -k 2 -n -r  score #2列目のデータで逆（降順）ソート、数値としてソート
katou 90
kuroiwa 80
kobayashi 70
```

### uniq コマンド
- 直前の行と同じ行をひとまとめできる

```shell
$cat > uniq-sample
aaaaaa
aaaaaa
bbbbbb
cccccc
cccccc

$uniq uniq-sample
aaaaaa
bbbbbb
cccccc
```

- 行は離れているが、ユニークだった場合にひとまとめにしたい

```shell
$cat > uniq-sample
aaaaaa
bbbbbb
cccccc
bbbbbb
aaaaaa
cccccc
bbbbbb

#ソートした結果をユニークでまとめる
$sort uniq-sample | uniq
aaaaaa
bbbbbb
cccccc
```

### trコマンド
- 標準入力からのデータを文字毎に置き換える
  - パイプ(|)やリダイレクト(<)を使用してtrの標準入力にファイルの内容を渡す

```shell
$cat > translate
Android
iphone
Windows Phone
$cat translate | tr on ON
ANdrOid
iphONe
WiNdOws PhONe
```

### diffコマンド
- ファイルを比較する

|コマンド|概要|
|--------|----|
|**-c**|context diff形式で差分出力|  
|**-u**|unified diff形式で差分出力|

```shell
$diff file1 file2
3c3
< test2
---
> test22

$diff -c file1 file2
*** file1       2020-07-14 16:55:32.251990055 +0900
--- file2       2020-07-14 16:55:45.050926562 +0900
***************
*** 1,3 ****
  test
  test1t
! test2
--- 1,3 ----
  test
  test1t
! test22

$diff -u file1 file2
--- file1       2020-07-14 16:55:32.251990055 +0900
+++ file2       2020-07-14 16:55:45.050926562 +0900
@@ -1,3 +1,3 @@
 test
 test1t
-test2
+test22
```



