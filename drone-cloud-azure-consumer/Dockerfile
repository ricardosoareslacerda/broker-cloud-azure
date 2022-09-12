FROM gradle:7.5-jdk11

RUN mkdir /app

COPY ./gradle /app/gradle
COPY ./src /app/src
COPY build.gradle /app/
COPY settings.gradle /app
COPY gradlew /app/
COPY gradlew.bat /app/

WORKDIR /app

RUN gradle clean build

ENV CONFIG_GMAIL_USERNAME=ricardosoareslacerda@gmail.com
ENV CONFIG_GMAIL_APP_PASSWORD=bwzrltermsamneyy

ENV MAIL_ADDRESS_FROM=ricardosoareslacerda@gmail.com
ENV MAIL_ADDRESS_TO=ricardosoareslacerda@gmail.com

ENTRYPOINT ["java","-jar","/app/build/libs/drone-cluster-monitor-consumer-0.0.1-SNAPSHOT.jar"]