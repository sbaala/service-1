FROM openjdk:11.0.1-jre-slim-stretch
EXPOSE 8081
ARG JAR=service-1-0.0.1-SNAPSHOT.jar
COPY target/$JAR /app.jar
COPY opentelemetry-javaagent.jar /opentelemetry-javaagent.jar
ENTRYPOINT ["java","-jar","/app.jar"]