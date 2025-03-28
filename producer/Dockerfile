# 1단계: 빌드 이미지
FROM gradle:8.4.0-jdk17 AS builder
WORKDIR /home/app

# 멀티모듈 전체 복사
COPY . .

# 필요한 모듈만 빌드 (common 포함)
RUN gradle :producer:bootJar -x test --no-daemon

# 2단계: 실행 이미지
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=builder /home/app/producer/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]
