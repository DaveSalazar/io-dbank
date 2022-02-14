FROM gradle:7.3.0-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon --warning-mode all

FROM amazoncorretto:11.0.13-alpine
COPY --from=build /home/gradle/src/build/libs/administration-api.jar /app/administration-api.jar
RUN mkdir -p /app/apps/main/resources
COPY ./core /app/core
WORKDIR /app
