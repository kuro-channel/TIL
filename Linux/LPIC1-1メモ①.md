#### ジャーナリングファイルシステム
- 更新履歴をジャーナル（ログ）に記録しておく機能
-- ジャーナルに記録されている情報を使用することで、障害時のデータ復旧を短時間で行うことができる

```dd if=boot.img of=/dev/sdc```

#### viにおけるコマンド


#### パーミッション
- 「/var」ディレクトリは書き込みが頻繁に発生するため、ルートパーティションとは別のパーティションとして構成する事が多いです。
- アプリケーションのログファイルや電子メールファイルが増えて容量オーバーしてしまうような場合も、「/var」ディレクトリを別のパーティションに設定しておくことで、他のディレクトリ（ルートディレクトリ等）への被害を最小限に抑える事ができます。


#### cutコマンド
```shell
$ cat test
test1:test2:test3/test4:test5:test6

$ cut -d : -f 1,5 test
test1:test6
```

#### gzipコマンド
```shell
$ gzip -d configure.gz
```

#### grepコマンド
- 「test.txt」ファイルから、「PINGT」または「pingt」という文字列を含む行を抽出したい
```shell
$ cat test.txt
pingt
tt
PINGT
PINGT
PINGT
PINGT
tt
tt
tt
PINGT
PINGT
PINGT

$ grep -E 'PINGT|pingt' test.txt
pingt
PINGT
PINGT
PINGT
PINGT
PINGT
PINGT
PINGT

$ egrep 'PINGT|pingt' test.txt
pingt
PINGT
PINGT
PINGT
PINGT
PINGT
PINGT
PINGT
```
