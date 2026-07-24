# Simple Homepage

このリポジトリは、スマホにも対応したシンプルなホームページを公開するためのものです。

## 概要

- `index.html` にシンプルでレスポンシブなホームページを配置
- Gitで管理して、公開も簡単にできるようにしています

## 公開方法

### 1. GitHub Pages を使う

1. このリポジトリをGitHubにプッシュします。
2. GitHubのリポジトリ設定で、Pagesの公開先を `gh-pages` ブランチの `/` に設定します。
3. 以下のようにコミットとプッシュを行います。

```bash
git add .
git commit -m "Add simple responsive homepage"
git push origin agents/simple-website-creation-git-integration
```

### 2. 自動デプロイ（GitHub Actions）

このリポジトリには、GitHub Actionsで静的ファイルをGitHub Pagesにデプロイするワークフローを追加しています。

- プッシュ先ブランチ: `agents/simple-website-creation-git-integration`
- 公開ファイル: ルートにある `index.html`

ワークフローは、GitHub Actionsの `Pages` を使って `gh-pages` ブランチにデプロイします。

## ローカルで確認する

ローカルでHTMLを確認するには、次のコマンドを使います。

```bash
python -m http.server 8000
```

ブラウザで `http://localhost:8000` を開くと、サイトをスマホ表示で確認できます。

## お問い合わせとデータベース

- 今の `index.html` は静的サイトなので、GitHub Pages上では直接データベースにはつながりません。
- 問い合わせを受けるだけなら、`mailto:` リンクや外部フォームサービス（Formspree、Formsubmit、Google Formsなど）を使うのが簡単です。
- データベースに保存したい場合は、Firebase、Supabase、Netlify/Vercelのサーバーレス、または自分で用意したサーバーを使う必要があります。

### すぐに問い合わせを受け取る方法

1. `index.html` の `mailto:YOUR_EMAIL_HERE` を自分のメールアドレスに変更する。
2. スマホでサイトを開くと「メールを送る」ボタンからメールアプリが開きます。

### データベースにつなげる方法

1. 外部サービスに登録してAPIキーを取得する。
2. サイトからそのサービスへ問い合わせデータを送る。
3. 受信した内容は外部サービスの管理画面やデータベースに保存されます。

例:
- Firebase / Firestore
- Supabase
- Netlify Functions + PostgreSQL
- Vercel Functions + MongoDB / MySQL
