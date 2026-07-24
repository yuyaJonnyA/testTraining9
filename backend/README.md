# Spring Boot Backend

`backend/` は Spring Boot で実装した問い合わせ API です。

## 仕組み

- フロントエンドの問い合わせフォームは `script.js` から POST 送信します。
- バックエンドは `ContactRequest` のバリデーションを行い、`ContactMessage` としてDBに保存します。
- `RestExceptionHandler` がバリデーションエラーとサーバーエラーを JSON で返します。
- `spring-boot-starter-actuator` により監視と運用の入り口を用意しています。

## 開発手順

```bash
cd backend
mvn spring-boot:run
```

## エンドポイント

- POST `/api/contact`
  - `name`, `email`, `message` を含む JSON を送信
  - 正常時は 201 Created を返す
- GET `/api/contact/messages`
  - 登録済み問い合わせの一覧を取得
- GET `/actuator/health`
  - アプリケーションの稼働確認

## DB と開発環境

- デフォルトでは H2 を使用し、`backend/contactdb` に保存します。
- H2 コンソールは `http://localhost:8080/h2-console` で確認できます。
- 本番では PostgreSQL / MySQL に切り替え可能です。
  - `src/main/resources/application.properties` の接続設定を変更してください。

## VS Code での開発

このリポジトリには `.vscode/extensions.json` があり、以下の拡張を推奨しています。

- `redhat.java`
- `vscjava.vscode-java-debug`
- `vscjava.vscode-java-test`
- `vscjava.vscode-maven`
- `vscjava.vscode-spring-boot`
- `GitHub.copilot`
