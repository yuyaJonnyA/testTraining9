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
