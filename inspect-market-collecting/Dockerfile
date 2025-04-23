FROM ubuntu:latest
LABEL maintainer="ft" 
EXPOSE 9005
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk;
COPY target/inspect-market-collecting-0.0.1-SNAPSHOT.jar /home
ENTRYPOINT ["java","-jar","/home/inspect-market-collecting-0.0.1-SNAPSHOT.jar", "9005"]