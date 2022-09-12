FROM gradle:7.5-jdk11

RUN mkdir /app

COPY /gradle /app/gradle
COPY /src /app/src
COPY build.gradle /app/
COPY settings.gradle /app
COPY gradlew /app/
COPY gradlew.bat /app/

WORKDIR /app

RUN gradle clean build

ENV PATH_HOST_PRODUCER_DOCKER_INTERNAL=host.docker.internal:8082/api/v1/drones-monitor/
ENV RESOURCE_API_HOST_PRODUCER="drones/register/"

ENTRYPOINT ["java","-jar","/app/build/libs/drone-cluster-monitor-job-0.0.1-SNAPSHOT.jar"]