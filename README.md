How To Use

1. docker-compose up -d를 활용해 kafka를 실행
2. consumer와 producer에서 profile을 local로 지정 및 application-local.yml의 postgresql 설정을 local PC와 맞추기
3. consumer와 producer 실행
4. http://localhost:8080/swagger-ui/index.html 로 접속하여 /produce-message 메서드 실행(userId 1, 2, 3번 지정 가능)
5. 콘솔 창에 나오는 로그 확인
![Monosnap localPostgresqlDB – message 2025-03-23 21-58-46.png](../../../../Library/Containers/com.monosnap.monosnap/Data/tmp/Monosnap%20localPostgresqlDB%20%E2%80%93%20message%202025-03-23%2021-58-46.png)
