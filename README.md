# Simple Homepage

このリポジトリは、スマホにも対応したシンプルなホームページを公開するためのものです。

## 概要

- `index.html` にシンプルでレスポンシブなホームページを配置
- Gitで管理して、公開も簡単にできるようにしています

## 公開方法

### 1. GitHub Pages を使う

1. このリポジトリをGitHubにプッシュします。
2. GitHubのリポジトリ設定で、Pagesの公開ソースを GitHub Actions に設定します。
3. 以下のようにコミットとプッシュを行います。

```bash
git add .
git commit -m "Add simple responsive homepage"
git push origin main
```

### 2. 自動デプロイ（GitHub Actions）

このリポジトリには、GitHub Actionsで静的ファイルをGitHub Pagesにデプロイするワークフローを追加しています。

- プッシュ先ブランチ: `main` または `agents/simple-website-creation-git-integration`
- 公開ファイル: ルートにある `index.html`

ワークフローは、GitHub Actionsの `Pages` を使ってサイトを公開します。

## ローカルで確認する

ローカルでHTMLを確認するには、次のコマンドを使います。

```bash
python -m http.server 8000
```

ブラウザで `http://localhost:8000` を開くと、サイトをスマホ表示で確認できます。

## お問い合わせとバックエンド

- このサイトは静的なフロントエンドを GitHub Pages で公開しつつ、別途 Spring Boot バックエンドで問い合わせを受け取る構成にできます。
- `backend/` には Spring Boot の問い合わせAPIプロジェクトがあります。
- フロントエンドは `script.js` から `http://localhost:8080/api/contact` へ送信できます。

### フロントエンドの動作確認

1. `python -m http.server 8000` で静的サイトを起動します。
2. ブラウザで `http://localhost:8000` を開きます。
3. 事前にバックエンドを起動しておくと、フォーム送信がバックエンドへ送信されます。

### バックエンドを起動する

1. `cd backend`
2. `mvn spring-boot:run`
3. ブラウザで `http://localhost:8080/h2-console` を開くと、問い合わせ内容のデータを確認できます。

> もしバックエンドを別のサーバーにデプロイする場合は、`script.js` の `apiBaseUrl` を公開先URLに書き換えてください。

### DBと本番構成

- 現在は H2 データベースを `backend/contactdb` に保存します。
- 本番では PostgreSQL や MySQL を使う場合、`src/main/resources/application.properties` の設定を変更してください。
- GitHub Pages は静的ホスティングのため、バックエンドは別途クラウドにデプロイします。
