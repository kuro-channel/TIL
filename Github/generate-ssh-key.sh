#!/bin/bash

# メールアドレスの入力を促す
read -p "GitHubのメールアドレスを入力してください: " email

# SSHキーの生成
ssh-keygen -t rsa -b 4096 -C "$email"

# ssh-agentを起動
eval "$(ssh-agent -s)"

# SSHキーをssh-agentに追加
ssh-add ~/.ssh/id_rsa

# 公開鍵をクリップボードにコピーする
# macOSの場合
pbcopy < ~/.ssh/id_rsa.pub
echo "公開鍵がクリップボードにコピーされました。GitHubに貼り付けてください。"

# Linuxの場合 (xclipが必要)
# xclip -sel clip < ~/.ssh/id_rsa.pub
# echo "公開鍵がクリップボードにコピーされました。GitHubに貼り付けてください。"

# Windows (Git Bashを使用)の場合
# cat ~/.ssh/id_rsa.pub | clip
# echo "公開鍵がクリップボードにコピーされました。GitHubに貼り付けてください。"
