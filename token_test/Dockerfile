FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD /target/token_test-0.0.1-SNAPSHOT.jar token_test-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","token_test-0.0.1-SNAPSHOT.jar"]