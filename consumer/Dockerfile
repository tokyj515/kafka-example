# 1단계: Gradle 빌드 (멀티모듈 포함)
FROM gradle:8.4.0-jdk17 AS builder
WORKDIR /home/app

# 전체 소스 복사
COPY . .

# 전체 프로젝트 빌드 (멀티모듈 포함)
RUN gradle :consumer:bootJar -x test --no-daemon

# 2단계: 실행 이미지
FROM openjdk:17-jdk-slim
WORKDIR /app

# 빌드된 JAR 복사 (경로는 프로젝트 구조에 맞게!)
COPY --from=builder /home/app/consumer/build/libs/*.jar app.jar

EXPOSE 8080

# 실행 시 dev 프로파일 적용
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]
