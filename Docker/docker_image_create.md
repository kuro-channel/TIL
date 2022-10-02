- docker初心者の後輩にdockerの雰囲気を掴んでもらう為のチュートリアルを作成した際のメモ書きをまとめました。

## 環境
- windows10
- docker 

## hello-worldのコンテナを稼働する
```shell
$docker run hello-world
```
```shell
Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/
```
- hello-worldのイメージを探す
  - PC上（ローカル）にイメージが見つかればPC上のイメージからコンテナを起動
  - ない場合は、Internetを経由して、Docker Hubからhello-worldイメージを取得してくる

- docker runコマンド：複数のコマンドを同時に行っている
  - `docker pull hello-world`：イメージの取得
  - `docker create hello-world`：コンテナの作成
  - `docker start hello-world`：コンテナの起動

- docker hubでイメージの詳細を見てみよう
https://hub.docker.com/_/hello-world


## whalesayのコンテナを稼働する
- whalesayイメージとは：docker社が提供しているチュートリアル用のイメージ

```shell
$docker run docker/whalesay cowsay hello!
```
```
Unable to find image 'docker/whalesay:latest' locally
latest: Pulling from docker/whalesay
Image docker.io/docker/whalesay:latest uses outdated schema1 manifest format. Please upgrade to a schema2 image for better future compatibility. More information at https://docs.docker.com/registry/spec/deprecated-schema-v1/
e190868d63f8: Pulling fs layer
909cd34c6fd7: Pulling fs layer
0b9bfabab7c1: Pulling fs layer
a3ed95caeb02: Pulling fs layer
00bf65475aba: Pulling fs layer
c57b6bcc83e3: Pulling fs layer
8978f6879e2f: Pulling fs layer
8eed3712d2cf: Pulling fs layer
c57b6bcc83e3: Waiting
8978f6879e2f: Waiting
8eed3712d2cf: Waiting
a3ed95caeb02: Waiting
00bf65475aba: Waiting
0b9bfabab7c1: Download complete
909cd34c6fd7: Verifying Checksum
909cd34c6fd7: Download complete
a3ed95caeb02: Verifying Checksum
a3ed95caeb02: Download complete
c57b6bcc83e3: Download complete
8978f6879e2f: Download complete
8eed3712d2cf: Verifying Checksum
8eed3712d2cf: Download complete
00bf65475aba: Verifying Checksum
00bf65475aba: Download complete
e190868d63f8: Verifying Checksum
e190868d63f8: Download complete
e190868d63f8: Pull complete
909cd34c6fd7: Pull complete
0b9bfabab7c1: Pull complete
a3ed95caeb02: Pull complete
00bf65475aba: Pull complete
c57b6bcc83e3: Pull complete
8978f6879e2f: Pull complete
8eed3712d2cf: Pull complete
Digest: sha256:178598e51a26abbc958b8a2e48825c90bc22e641de3d31e18aaf55f3258ba93b
Status: Downloaded newer image for docker/whalesay:latest
 ________
< hello! >
 --------
    \
     \
      \
                    ##        .
              ## ## ##       ==
           ## ## ## ##      ===
       /""""""""""""""""___/ ===
  ~~~ {~~ ~~~~ ~~~ ~~~~ ~~ ~ /  ===- ~~~
       \______ o          __/
        \    \        __/
          \____\______/

```
- コマンドの実行部分（`Hello`）を変えて遊んでみよう


```
$ docker run docker/whalesay cowsay OK!
 _____
< OK! >
 -----
    \
     \
      \
                    ##        .
              ## ## ##       ==
           ## ## ## ##      ===
       /""""""""""""""""___/ ===
  ~~~ {~~ ~~~~ ~~~ ~~~~ ~~ ~ /  ===- ~~~
       \______ o          __/
        \    \        __/
          \____\______/

```

## 基本的なコマンド
- イメージ情報の確認：`docker images`
- イメージをタグ付け：`docker tag docker/whalesay my_whalesay`
  - タグ付け：イメージは全く同じ
- イメージ詳細情報：`docker inspect docker/whalesay`
- イメージの削除：`docker rmi docker/whalesay`
  - 強制削除：`docker rmi -f docker/whalesay`
