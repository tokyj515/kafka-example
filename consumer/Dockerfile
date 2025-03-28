# 1단계: Gradle로 빌드 (common 포함)
FROM gradle:8.4.0-jdk17 AS builder
WORKDIR /home/app

# 전체 프로젝트 복사 (멀티모듈 포함)
COPY . .

# consumer 모듈만 bootJar 생성
RUN gradle :consumer:bootJar -x test --no-daemon

# 2단계: 실행 환경
FROM openjdk:17-jdk-slim
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /home/app/consumer/build/libs/*.jar app.jar

EXPOSE 8080

# 실행 시 dev 프로파일 지정
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]
