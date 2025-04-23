FROM ubuntu:latest
LABEL maintainer="ft" 
EXPOSE 9003
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk;
COPY target/inspect-market-processing-0.0.1-SNAPSHOT.jar /home
ENTRYPOINT ["java","-jar","/home/inspect-market-processing-0.0.1-SNAPSHOT.jar", "9003"]