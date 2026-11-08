FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY target/classes /app/classes

EXPOSE 8080

CMD ["java", "-cp", "classes", "com.phoenix.PhoenixApplication"]
HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 CMD ["java", "-cp", "classes", "com.phoenix.HealthChecker"]