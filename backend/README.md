# Spring Boot Backend

`backend/` には、このサイトの問い合わせAPIを提供する Spring Boot プロジェクトがあります。

## 実行方法

1. Java 21 をインストールする
2. Maven をインストールする
3. `cd backend`
4. `mvn spring-boot:run`

APIは `http://localhost:8080/api/contact` で起動します。

## データ保存

- デフォルトでは H2 データベースを `backend/contactdb` に作成します
- 本番環境では `src/main/resources/application.properties` を編集して PostgreSQL や MySQL に切り替えできます
