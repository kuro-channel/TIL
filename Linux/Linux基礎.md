## uniq
- ファイルから重複する行を削除するコマンド  
```uniq -c 元ファイル名``` 重複した行数も表示する

## awk
- awkはテキストの各行に対して pattern { action } を実行する。  
- pattern にマッチする行に action を実行する。 **awkで1フィールド目を取り出すコマンドは、「print $1」です**  
- フィールド区切り文字=「,」とか「/」で区切ってあるfileの時、指定したフィールド区切り文字で認識してくれる。  
- **区切り文字を指定しない場合…awkのデフォルトの区切り文字はスペース（タブまたは半角スペース）**

```awk -F'[フィールド区切り文字(複数可能)]' -v '変数=xx' '{awkコマンド}' file```

```
> touch user.csv
id,name,age
1,佐藤,19
2,伊藤,20
3,加藤,21

> cat user.csv | awk -F ',' '{print $0}'
id,name,age
1,佐藤,19
2,伊藤,20
3,加藤,21

> cat user.csv | awk -F ',' '{print $1}'
id
1
2
3

> cat user.csv | awk -F ',' '{print $2}'
name
佐藤
伊藤
加藤

> cat user.csv | awk -F ',' '{print $3}'
age
19
20
21

```

## リダイレクト
```> 新規ファイル作成 >> ファイルに内容追加``` 

## コマンド 随時更新していくこと
- nslookup 「nslookup ドメイン名」で、対応するIPアドレスを調べる  
```nslookup google.co.jp```  
```nslookup www.google.co.jp 8.8.8.8``` 8.8.8.8（GoogleのパブリックDNSサーバーのIPアドレス）

- grep ファイル中の文字列を検索するコマンド
```grep -rn Main *``` 該当フォルダ内のファイルを検索して、"Main"という文字列を含むファイル名とファイル内の行数（行番号）を返す  
```grep -i -rn  Main *``` -i：大文字小文字を区別しない  
```grep -2 検索文字列 テキストファイル```テキストファイルから文字列を検索し、検索結果の前後2行も表示

- help コマンドのマニュアルを表示する
```help```　↓実行結果  
```
GNU bash, version 3.2.57(1)-release (x86_64-apple-darwin17)
These shell commands are defined internally.  Type `help' to see this list.
Type `help name' to find out more about the function `name'.
Use `info bash' to find out more about the shell in general.
Use `man -k' or `info' to find out more about commands not in this list.

A star (*) next to a name means that the command is disabled.

 JOB_SPEC [&]                       (( expression ))
 . filename [arguments]             :
 [ arg... ]                         [[ expression ]]
 alias [-p] [name[=value] ... ]     bg [job_spec ...]
 bind [-lpvsPVS] [-m keymap] [-f fi break [n]
 builtin [shell-builtin [arg ...]]  caller [EXPR]
 case WORD in [PATTERN [| PATTERN]. cd [-L|-P] [dir]
 command [-pVv] command [arg ...]   compgen [-abcdefgjksuv] [-o option
 complete [-abcdefgjksuv] [-pr] [-o continue [n]
 declare [-afFirtx] [-p] [name[=val dirs [-clpv] [+N] [-N]
 disown [-h] [-ar] [jobspec ...]    echo [-neE] [arg ...]
 enable [-pnds] [-a] [-f filename]  eval [arg ...]
 exec [-cl] [-a name] file [redirec exit [n]
 export [-nf] [name[=value] ...] or false
 fc [-e ename] [-nlr] [first] [last fg [job_spec]
 for NAME [in WORDS ... ;] do COMMA for (( exp1; exp2; exp3 )); do COM
 function NAME { COMMANDS ; } or NA getopts optstring name [arg]
 hash [-lr] [-p pathname] [-dt] [na help [-s] [pattern ...]
 history [-c] [-d offset] [n] or hi if COMMANDS; then COMMANDS; [ elif
 jobs [-lnprs] [jobspec ...] or job kill [-s sigspec | -n signum | -si
 let arg [arg ...]                  local name[=value] ...
 logout                             popd [+N | -N] [-n]
 printf [-v var] format [arguments] pushd [dir | +N | -N] [-n]
 pwd [-LP]                          read [-ers] [-u fd] [-t timeout] [
 readonly [-af] [name[=value] ...]  return [n]
 select NAME [in WORDS ... ;] do CO set [--abefhkmnptuvxBCHP] [-o opti
 shift [n]                          shopt [-pqsu] [-o long-option] opt
 source filename [arguments]        suspend [-f]
 test [expr]                        time [-p] PIPELINE
 times                              trap [-lp] [arg signal_spec ...]
 true                               type [-afptP] name [name ...]
 typeset [-afFirtx] [-p] name[=valu ulimit [-SHacdfilmnpqstuvx] [limit
 umask [-p] [-S] [mode]             unalias [-a] name [name ...]
 unset [-f] [-v] [name ...]         until COMMANDS; do COMMANDS; done
 variables - Some variable names an wait [n]
 while COMMANDS; do COMMANDS; done  { COMMANDS ; }
 ```


