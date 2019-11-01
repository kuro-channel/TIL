<b>「httpd.conf」ファイルの末尾5行を表示したい。適切なコマンドは次のうちどれか。(全て選択)</b>

○ tail -n 5 httpd.conf  
 tail 5 httpd.conf  
 ○tail -5 httpd.conf  
 tail -c 5 httpd.conf  
 tail -l 5 httpd.conf  

解説
tailはファイルの末尾部分を指定して表示するコマンドです。
tailコマンドの書式と主なオプションは以下のとおりです。

tail [オプション] [ファイル名]

上表より正解は
・tail -n 5 httpd.conf
・tail -5 httpd.conf

共有ライブラリとは、複数のプログラムが共通して利用するライブラリの事です。
あるプログラム(コマンドなど)が必要としている共有ライブラリを表示するコマンドはlddです。

lddコマンドの書式は以下のとおりです。

ldd コマンドのパス

したがって正解は
・ldd /bin/bash
です。

環境変数は、変数を設定したシェル上と、そこから起動されるシェルやアプリケーション、コマンドで有効な変数です。これは設定が引き継がれる事を意味します。
環境変数はexportコマンドを使用して作成することができます。

export 環境変数=値　

また、exportコマンドはシェル変数（変数を設定したシェル上でのみ有効な変数）を環境変数に変更できます。

export シェル変数名

したがって正解は
・export
です。

例）シェル変数LPICを設定し、環境変数にする
$ LPIC=study_linux
$ export LPIC

https://ping-t.com/mondai3/mondais/init_practice/685
