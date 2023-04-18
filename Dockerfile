FROM openjdk:11

COPY  target/distribution-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#COPY ./scripts/ /bin



