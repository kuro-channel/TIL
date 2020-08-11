## Windows10 HomeにDocker環境を構築した話

### 1. はじめに
これまでWindows10環境でDockerを使う場合は、Windows10 proでないと使えませんでした。  
（仮想環境（Hyper-V）を使ってDockerを動かすが、Windows10 homeではHyper-Vが使えない・・・）  

Windows10 proにアップグレードしようかと何度も悩みましたが、ついに・・・。Windows10 homeでも  
Dockerが使えるようになったというので、早速環境を構築してみます。  


### 2. 環境
・Windows 10 Home  
・CPU: AMD Ryzen7 3700U  
・RAM: 16GB  

### 手順（Dockerが使えるようになるまで）

#### 1.  Windows 10 Homeのバージョンを2004にアップデート
- 自分のPCのWindowsのバージョンを確認する

#### 2. Windows 上で WSL2 機能の有効化

【参考】WSL 2 の新機能 https://docs.microsoft.com/ja-jp/windows/wsl/wsl2-index  

- Power Shellを起動し、以下実行  
```
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
wsl --set-default-version 2
wsl -l -v
```

#### 3. Docker Desktop for Windowsインストール
- https://hub.docker.com/editions/community/docker-ce-desktop-windows  
安定版をインストール

