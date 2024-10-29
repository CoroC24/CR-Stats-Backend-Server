FROM openjdk:19-slim

WORKDIR /app

COPY target/CRStatsBackendAPICommunication-1.0-SNAPSHOT.jar /app/CRStatsBackendAPICommunication.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/CRStatsBackendAPICommunication.jar"]