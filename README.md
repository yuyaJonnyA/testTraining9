# Portfolio Project: Responsive Landing Page + Spring Boot Contact API

このリポジトリは、Javaエンジニアの実務クオリティを意識したポートフォリオ向けプロジェクトです。

## 何を示すか

- レスポンシブなランディングページ（LP）を GitHub Pages で公開
- Java / Spring Boot で問い合わせバックエンドを構築
- DB保存を伴う問い合わせフォーム処理
- CIとして GitHub Actions を使ったビルド・公開フロー
- VS Code で Java/Spring 開発ができるように構成

## 技術スタック

- フロントエンド: HTML / CSS / JavaScript
- ホスティング: GitHub Pages
- バックエンド: Spring Boot, Java 21
- DB: H2（ローカル開発用）
- CI: GitHub Actions

## ライブデモ

- `https://yuyaJonnyA.github.io/testTraining9`

## このリポジトリの構成

- `index.html` - レスポンシブなLPと問い合わせフォーム
- `script.js` - フロントからバックエンドへ問い合わせをPOST
- `backend/` - Spring Boot プロジェクト
- `.github/workflows/` - GitHub Actions設定
- `.vscode/extensions.json` - VS Code Java/Spring推奨拡張

## ローカルでの動かし方

### 1. フロントエンドを動かす

```bash
python -m http.server 8000
```

`http://localhost:8000` でサイトを確認します。

### 2. バックエンドを起動する

```bash
cd backend
mvn spring-boot:run
```

- API: `http://localhost:8080/api/contact`
- H2 コンソール: `http://localhost:8080/h2-console`

### 3. 問い合わせフォームを確認する

フロント画面からフォームを送信すると、バックエンドが受信して DB に保存します。

## バックエンド実装のポイント

- Spring Boot を使った REST API
- `ContactRequest` で入力バリデーション
- `ContactService` でビジネスロジックを分離
- `ContactMessage` エンティティに保存
- `RestExceptionHandler` でバリデーションエラーや例外を整形
- `spring-boot-starter-actuator` による運用・監視準備

## DBと本番構成

- ローカルでは H2 を使い、`backend/contactdb` に保存します。
- 本番では PostgreSQL / MySQL などに切り替え可能です。
- 本番運用時は `backend/src/main/resources/application.properties` の接続設定を書き換えます。

## GitHub Pages公開

このリポジトリには GitHub Actions で静的サイトを公開する設定があります。

- `main` ブランチへのプッシュで公開ワークフローが動きます
- フロントエンドは `index.html` を GitHub Pages で配信します

## 目指せるポートフォリオ品質

このプロジェクトは「ただのLP」ではなく、
Javaバックエンドと連携した実務寄りの構成になっています。

- 既存開発・保守運用の観点で、ログ・エラー処理・DB保存を持つ
- 障害対応の入り口として、Actuator/例外ハンドラを実装
- 28歳のJavaエンジニアとして自己紹介に使える土台

必要であれば、次のステップとして
- 本番DBの追加（PostgreSQL/MySQL）
- バックエンドのクラウドデプロイ
- 管理画面の追加
- ユーザー認証やアクセス制御

を加えて、さらに厚みを持たせられます。
