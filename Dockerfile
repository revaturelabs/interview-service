FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY pom.xml /
COPY src src/

RUN mvn package

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ENV JDBC_URL=jdbc:postgresql://postgresql-class.cks98gmxels6.us-west-1.rds.amazonaws.com:5432/interview_tracker_db
ENV JDBC_USERNAME=sep1909
ENV JDBC_PASSWORD=interview123

COPY --from=MAVEN_BUILD /target/Interview-Service-0.0.1-SNAPSHOT.jar /interview-service.jar
#ADD target/Interview-Service-0.0.1-SNAPSHOT.jar interview-service.jar
EXPOSE 50222
ENTRYPOINT exec java $JAVA_OPTS -jar interview-service.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar interview-service.jar
