FROM openjdk:11

VOLUME /tmp
ARG JAR_FILE
ADD ./target/${JAR_FILE} produtos-api.jar

ENTRYPOINT ["java",  "-jar", "produtos-api.jar"]