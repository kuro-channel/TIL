# Java知恵袋/開発環境
- 内容: Javaの開発をする上での初めの一歩、開発環境回りの用語/開発環境構築手順をまとめました。

|No.|用語|説明|
|--|--|--|
|1|Java SE|Java Platform, Standard Editionの略。Java の機能やデータなどを利用するための呼び出し方を定義したもの。Java で使用される API をまとめたもの。デスクトップ・アプリケーション開発のための技術。https://www.oracle.com/jp/java/technologies/javase/documentation.html|
|2|Java EE|Java Platform, Enterprise Editionの略。企業のシステムなどより大規模な開発を行う場合にはJava EEを合わせて利用する。業務システムを作るための機能を追加したスーパーセットがJava EE。Java SE の拡張機能。|
|3|Java ME|Java Platform, Micro Edition の略。家電などの組み込み機器やモバイルデバイスで動作するアプリケーションを開発するために使用する API がまとめられている。Webアプリケーションではほとんど使用しない。|
|4|Java Virtual Machine（**JVM**）|Javaで作成したアプリケーションを様々なOSで動かす為に必要なアプリケーション。Java仮想マシン。Javaアプリケーションを実行したいOSにJVMをインストールしておくことで、そのOS用のJVMがJavaのクラスファイルを対象OSで変換して実行してくれる。事前にJVMをPCにインストールしておく必要あり。"Write once, run anywhere"|
|5|Java Runtime Enviroment（ **JRE**）|Javaを動かすための実行環境。Javaランタイム。JVMや対応するAPIがセットになっている。※各OSにJREをインストールすれば、Javaアプリケーションを動かす実行環境が構築できる。（現在はJRE単独でインストールすることが出来ないため、No.6 JDKをインストールする必要がある）|
|6|Java Development Kit（**JDK**）|Javaアプリケーションの開発・実行を行う上で必要なソフトウェアをまとめたパッケージ。Java開発環境。JREや、Javaで記述されたプログラムをコンパイルするプログラムやデバッグ用のプログラムも含まれる。JDKをインストールすることで、Javaを使ったアプリケーションの作成～実行まで一通り行うことが出来る。 **開発環境を構築するときは、JDKをインストールすればOK！** **※1**|
  
### JVM（Java仮想マシン）/ JRE（実行環境）/ JDK（Java開発環境）の関係

![Java環境回りの図解](https://user-images.githubusercontent.com/23717681/205559249-d82e86a8-2bb4-4e95-895e-af6e51a22882.png)

【参照】Java SEとJDK、JRE、JVMの違いに関する解説
https://www.javadrive.jp/start/install/index5.html

### **※1 : JDKについて**
・JDKにはJavaの開発における必要なもの（Java API/JRE/コンパイラ/JavaVM等）がひとまとめになっており、JDKを導入することでJavaの開発ができるようになる。また、JDKには様々なディストリビューションがあり、どのJDKを使うかは各案件ごとに精査する必要がある。

![JDKについて](https://user-images.githubusercontent.com/23717681/205559453-b427a7ce-6969-4f39-9825-312f66c6b546.png)

【参照】Javaは今でも無償ですという話
https://speakerdeck.com/kishida/java-is-still-free

### Javaで作るWebアプリケーション（概要）
**例：Webサーバが【Apache】でAPサーバが【Tomcat】の例**

![Javaアプリの仕組み1](https://user-images.githubusercontent.com/23717681/205559296-d9cd5da0-378b-45ab-874b-8713a7974c19.png)

+ WebページをJavaで実装する場合、**アプリケーションサーバー**を用意する必要がある。
+  Javaのアプリケーションサーバーで有名なものとしては、**Tomcat**や**Jetty**, **GlassFish**がある。
+  Apacheには**mod_jk**と呼ばれる連携用モジュールが提供されており、これをApacheの拡張機能として組み込む → 連携用モジュール**mod_jk**が**ajp13**というプロトコルを使用し、Webサーバーとアプリケーション間でリクエスト＆レスポンスを連携している。アプリケーションサーバーはajp13を通してHTTPリクエストを受け、Webアプリケーションを実行、ajp13を通して処理結果（HTTPレスポンス）を返す

- **アプリケーションサーバー（APサーバ）**
1. アプリケーションサーバがServletやJSPを動かす
2. Servlet：HTTPリクエストを受け取り、アプリケーションの処理部分を実装
3. JSP: HTMLの中にJavaのプログラムを埋め込める技術、HTMLの表示

## Javaアプリケーションを動かすまで
-  **APサーバーソフトがTomcatの場合**
1. Javaのインストール
2. Tomcatのインストール
3. Maven, Gradle等、ビルドツールのインストール
4. Maven, Gradle等、各ツールを使用してWebアプリケーションの雛形作成
5. 4で作成した雛形を使用して、Javaコーディング（DBとの接続等も含む）
6. 作成したアプリケーションからwarファイルを生成
7. 6で作成したwarファイルをTomcatに配置、ブラウザにて該当アプリケーションURLにアクセス

## 開発環境構築手順(Visual Studio Code)
Javaの開発環境としては、eclipseやIntelliJ IDEA、NetBeans等がメジャーですが、普段PHPの開発環境で使用している「**Visual Studio Code**」でもJavaの開発環境が構築できます。本wikiでは「**Visual Studio Code**」での開発環境構築手順を明記します。

### 想定開発環境
OS: Windows10  
Visual Studio Code

### 手順（5ステップ）
1. JDKのインストール
2. Java Extension Packインストール
3. PATHの設定、環境変数JAVA_HOMEの設定
4. JDKの設定（Visual Studio Codeの設定）
5. Javaを動かしてみよう！

### 手順1: JDKのインストール
- ~~本手順書では、Oracleが提供するOpenJDKを使用　http://jdk.java.net/  ~~ 
~~使用するJDKのバージョンを選択し、Windows10用のzipファイルをダウンロード （例：  ~~ 
 ~~ダウンロードしたzipを解凍し、任意のフォルダに展開（例：C:\jdk-15.0.1）~~ 
 ~~https://www.javadrive.jp/start/install/index1.html~~ 
#### Amazon Corretto 11  ダウンロードサイト 
https://docs.aws.amazon.com/ja_jp/corretto/latest/corretto-11-ug/downloads-list.html

1. AWSのJDKダウンロードサイトから開発マシンのOSに対応しているJDKをダウンロード。本手順ではWindows版をダウンロードします。  
  例: amazon-corretto-11.0.3.7.1-1-windows-x64.msi

![Amazon Corretto11 ダウンロードサイト](https://user-images.githubusercontent.com/23717681/205559605-262b8f3b-9db8-44b8-a099-234e2cf807b5.png)

2. インストール後、Cドライブ > Program Files 直下にインストールしたJDKが配置されていることを確認  
```javaC:\Program Files\Amazon Corretto\jdk11.0.3_7```

3. コマンドプロンプトからJavaのバージョン確認  
java -version
```java
C:\Users\kuroiwa-t>java -version
openjdk version "11.0.3" 2019-04-16 LTS
OpenJDK Runtime Environment Corretto-11.0.3.7.1 (build 11.0.3+7-LTS)
OpenJDK 64-Bit Server VM Corretto-11.0.3.7.1 (build 11.0.3+7-LTS, mixed mode)
```
※ **PATHの設定、環境変数JAVA_HOMEの設定はいりません、インストーラーが勝手にやってくれます**

### 手順2: Java Extension Packインストール
- Visual Studio Codeを起動し、拡張機能：Java Extension Pack をインストール  
https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack

### 手順2 補足：Java開発でよく使う拡張機能（必要あればインストール）
- Maven for Java : https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven
- Spring Boot Extension Pack : https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack

 ~~### 手順3: PATHの設定、環境変数JAVA_HOMEの設定~~ 
 ~~- 環境変数 JAVA_HOMEを新規追加し、PATHを設定する~~ 
 ~~https://www.javadrive.jp/start/install/index4.html~~ 
 
**手順1: Amazon Corretto11インストールで勝手にやってくれるのでスキップ**

### 手順4: JDKの設定（Visual Studio Codeの設定）
- 拡張機能の設定にある「java.home」のパスを設定する  
https://qiita.com/takuma-jpn/items/b49785a314fb4db85775#%E6%9C%80%E5%BE%8C%E3%81%ABjavahome%E3%82%92%E8%A8%98%E8%BF%B0%E3%81%97%E3%81%A6jdk%E3%81%AB%E3%83%91%E3%82%B9%E3%82%92%E9%80%9A%E3%81%97%E3%81%BE%E3%81%99

### 手順5: Javaを動かしてみよう！
- Visual Studio Codeで「コマンドパレット」（Ctrl + Shift + p）を表示し、以下のコマンドを実行してJavaプロジェクトを作成する。
```java
>Java: Create Java Project
```
![Javaプロジェクトの作成_no1](https://user-images.githubusercontent.com/23717681/205559637-07c7523a-9b14-4134-8456-0535b81005b7.png)

```java
No build tools
```
![Javaプロジェクトの作成_no2](https://user-images.githubusercontent.com/23717681/205559653-eee11965-346e-4a9e-a97b-ebac3be83dee.png)

※作成するJavaプロジェクトの名前を入力→プロジェクトの作成完了

- 作成されるJavaプロジェクトのファイルとディレクトリ構成
```java
helloworld
├── lib
└── src
    └── App.java
```
デフォルトで作成される「App.java」をコンパイルし、生成されたクラスファイルを実行→ "Hello, World!"が表示される。
```java
$ javac App.java
$ java App
Hello, World!
```

### 所要時間
30~1時間、すでにJDKのインストールが完了している場合はもっと早くできると思います。

### 次のステップ
Tomcat上で動くJava Webアプリケーション開発環境構築（Visual Studio Code）
