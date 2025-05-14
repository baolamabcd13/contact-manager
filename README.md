# 📌 Hướng dẫn chạy Contact Manager

## 🚀 1. Clone repository từ GitHub
```bash
git clone https://github.com/baolamabcd13/contact-manager.git
cd contact-manager

🏗️ 2. Build và chạy ứng dụng với Gradle
🔍 Kiểm tra Gradle đã cài đặt chưa
gradle --version


➡ Nếu Gradle chưa được cài, tải về từ gradle.org/install.
⚙️ Build ứng dụng với Gradle
./gradlew build


➡ Trên Windows, dùng:
.\gradlew.bat build


📂 Kiểm tra file .jar đã tạo
ls build/libs/


▶️ Chạy ứng dụng
java -jar build/libs/contact-manager-0.0.1-SNAPSHOT.jar



🐳 3. Chạy ứng dụng bằng Docker
🏗️ Build & chạy Docker
docker-compose up --build


🔍 Kiểm tra container đang chạy
docker ps


🌍 Truy cập API
GET /api/contacts/{id}
POST /api/contacts
PUT /api/contacts/{id}
DELETE /api/contacts/{id}


