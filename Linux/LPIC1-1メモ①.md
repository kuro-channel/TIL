```dd if=boot.img of=/dev/sdc```

#### viにおけるコマンド
![画像](https://ping-t-data-tokyo.s3.ap-northeast-1.amazonaws.com/uploads/question_image/file/1488/k33911.jpg?X-Amz-Expires=600&X-Amz-Date=20220128T092837Z&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAZCJ2QHLF73X4YH6P%2F20220128%2Fap-northeast-1%2Fs3%2Faws4_request&X-Amz-SignedHeaders=host&X-Amz-Signature=bd2681e32f1d84bd556241ef43820720405305ae46401cde4c35f29ab06426a7)

#### パーミッション
![画像2](https://ping-t-data-tokyo.s3.ap-northeast-1.amazonaws.com/uploads/question_image/file/1372/k33739.jpg?X-Amz-Expires=600&X-Amz-Date=20220128T093659Z&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAZCJ2QHLF73X4YH6P%2F20220128%2Fap-northeast-1%2Fs3%2Faws4_request&X-Amz-SignedHeaders=host&X-Amz-Signature=6c62b125d8aada36711b40233f7a0be08ab9329a72fc1703dc424ba8ffd61181)
- 「/var」ディレクトリは書き込みが頻繁に発生するため、ルートパーティションとは別のパーティションとして構成する事が多いです。
- アプリケーションのログファイルや電子メールファイルが増えて容量オーバーしてしまうような場合も、「/var」ディレクトリを別のパーティションに設定しておくことで、他のディレクトリ（ルートディレクトリ等）への被害を最小限に抑える事ができます。


#### cutコマンド
```shell
$ cat test
test1:test2:test3/test4:test5:test6

$ cut -d : -f 1,5 test
test1:test6
```
