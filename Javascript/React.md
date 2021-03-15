- Reactとは？
  - ReactはHTMLをJavaScriptでレンダリングするツール
  - ReactDOM.renderは、ReactElementオブジェクトを使って、何をレンダリングするかを説明し、指定されたDOM nodeに結果を追加
```
<script>
    ReactDOM.render(
        React.createElement("h1", null, "React works!"),
        document.getElementById('react-app')
    );
</script>
```

- JSX
  - JavaScript の拡張版。Javascript XML, 
  - {}: 式の埋め込みに使う。値を返す表現のみ。
  - JSX は HTML よりも JavaScript に近いものですので、React DOM は HTML の属性ではなくキャメルケース (camelCase) のプロパティ命名規則を使用

- props: 【Properties】（プロパティ）/ state（状態）
  - props : 親コンポーネントから子コンポーネントへ値を渡すための仕組み
  - state : 各コンポーネントごとに持つ、コンポーネントの状態を管理する仕組み

- React.FunctionComponent = React.FC

- React li＆key
  - https://ja.reactjs.org/docs/lists-and-keys.html
  - React の “差分” アルゴリズムの処理に利用されるからです。
