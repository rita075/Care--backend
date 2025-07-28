# 🏥 Care+ 長照預約平台 – 後端系統

本系統為全端式照護預約平台的後端核心服務，使用 Spring Boot 3 架構，整合 JWT 認證、ECPay 金流、Email 通知、MySQL 資料庫與 RESTful API，支援前後端分離架構與多步驟預約流程。

由我（Rita Hung）負責主要後端模組開發與資料庫設計。

---

## 🚀 技術架構 Tech Stack

- **Spring Boot 3.2.4 + Java 21**
- **Spring Security** – JWT 認證與授權
- **Spring Data JPA** – ORM 與資料存取層
- **MySQL + AWS RDS** – 資料儲存與雲端服務
- **ECPay 金流整合** – 綠界支付模組
- **JavaMailSender** – Email 通知功能
- **RESTful API 設計** – 搭配 Vue 前端呼叫
- **Maven** – 專案管理

---

## 🔧 我的實作項目 Highlights

### 🗓️ 1. 預約流程 API 設計

- 多階段流程：建立需求單 → 看護確認 → 合約確認 → 付款完成
- 預約狀態轉換設計（Pending → Confirmed → Paid → Completed）
- 完整驗證機制：防止資料缺漏或不合法時間格式

### 💳 2. ECPay 金流整合

- 封裝 ECPay SDK，動態產生付款訂單
- 串接 Callback 回傳 API，自動更新付款狀態
- 金流整合對應合約與 Email 通知功能

### 📧 3. 自動 Email 通知系統

- 使用 JavaMailSender 設計信件模板系統
- 預約確認後寄送付款提醒信
- 付款成功後寄送合約與收據信件（含連結）

### 📁 4. 資料庫與 JPA 設計

- Entity 設計：使用多對多與選擇性欄位（疾病、服務、身體狀況）
- Schema 與業務流程強綁定，支援合約條款版本控管
- 自動計算預約時數與對應金額邏輯（TimeCalculationService）

---

---

### 📮 使用 Postman 測試 API

- 我使用 [Postman](https://www.postman.com/) 針對所有後端 API 進行驗證與測試。
- 測試內容包含：
  - 使用者註冊／登入並取得 JWT token
  - 建立預約流程：提交需求單 → 看護接受 → 合約確認 → 金流付款
  - 金流測試串接：呼叫 `/payment/ecpay` 模擬付款流程
  - Email 通知：確認付款完成後是否收到合約與收據通知
- 所有 API 都已設計為 RESTful 並支援 JSON 格式回傳
- 可在 Postman 中設置 Authorization Header 進行 token 測試

#### 🛠️ Authorization 設定範例
```http
GET /appointments
Authorization: Bearer <your-jwt-token>
