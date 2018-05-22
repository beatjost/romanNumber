FROM java:openjdk-8-jre-alpine
VOLUME /tmp
ADD build/libs/romanNumber.jar app.jar
EXPOSE 8080

RUN /usr/sbin/groupadd -g 666 ruth && \
    /usr/sbin/useradd -r -u 666 -g ruth ruth
USER ruth

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]