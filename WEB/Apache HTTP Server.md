## Apache HTTP Serverとは？
- Apache（アパッチ）とは世界中で使用されているWebサーバーソフトウェア(HTTPサーバー) OSS（オープンソフトウェア）
- アクセスログ > http://ossfan.net/setup/httpd-06.html  
→ Apache HTTP サーバのアクセスログ（/var/log/httpd/access_log）

```
アクセス元IP毎のアクセス数(Top30)
grep "日付" ログファイル名 | awk '{print $1}' | sort | uniq -c | sort -rn
例) grep "18/Dec/2016" /var/log/httpd/access_log | awk '{print $1}' | sort | uniq -c | sort -rn
1時間毎のアクセス数(Top30)
grep "日付" ログファイル名 | awk '{print $4}' | cut -b 2-15 | sort | uniq -c | sort -rn
例) grep "18/Dec/2016" /var/log/httpd/access_log | awk '{print $4}' | cut -b 2-15 | sort | uniq -c
アクセス先URL毎のアクセス数(Top30)
grep "日付" ログファイル名 | awk '{print $7}' | sort | uniq -c | sort -rn
例) grep "18/Dec/2016" /var/log/httpd/access_log | awk '{print $7}' | sort | uniq -c | sort -rn
```
> 参考：Apache ログを awk と uniq だけで集計する https://qiita.com/bezeklik/items/f5c292c4360cde140bef
