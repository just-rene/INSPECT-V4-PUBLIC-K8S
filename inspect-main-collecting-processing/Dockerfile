FROM ubuntu:latest
LABEL maintainer="ft" 
EXPOSE 9001
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk;
COPY target/inspect-main-collecting-processing-0.0.1-SNAPSHOT.jar /home
ENTRYPOINT ["java","-jar","/home/inspect-main-collecting-processing-0.0.1-SNAPSHOT.jar", "9001"]