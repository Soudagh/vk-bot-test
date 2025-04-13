# Бот ВКонтакте

Бот для ВКонтакте, который цитирует любое полученное сообщение.  
Технологии: Java, Spring Boot, CallbackAPI, ngrok.

Разработан на Java с использованием Spring Boot **без сторонних VK-библиотек**, через прямую работу с [VK Bot API](https://vk.com/dev/bots_docs).

## Установка и запуск

1. Склонируйте репозиторий:
   ```bash
   git clone https://github.com/Soudagh/vk-bot-test.git
   cd vk-bot-test
   ```
 2. Добавьте следующие переменные окружения: `VK_CONFIRMATION_CODE`, `VK_API_VERSION`, `VK_ACCESS_TOKEN`.
 3. Запустите приложение
```bash
  ./gradlew bootRun  # For macOS/Linux
  gradlew.bat bootRun  # For Windows
```
Или запустить VkBotApplication.java в IntelliJ IDEA.

## Пример работы:
![image](https://github.com/user-attachments/assets/2b38aa41-1e92-4c6f-acfc-5d02d8c327b2)

