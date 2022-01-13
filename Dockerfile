FROM fabric8/java-centos-openjdk8-jdk:1.9.0
LABEL maintainer="ricardolopez.computing@gmail.com"
LABEL module="testing-namespace"
ENV TZ=America/Mexico_City
ENV JAVA_APP_JAR pokemon-convert-0.0.1-SNAPSHOT.jar
ENV AB_OFF true
ENV JAEGER_SERVICE_NAME=pokemon-convert-0.0.1-SNAPSHOT\
  JAEGER_ENDPOINT=http://jaeger-collector.istio-system.svc:14268/api/traces\
  JAEGER_PROPAGATION=b3\
  JAEGER_SAMPLER_TYPE=const\
  JAEGER_SAMPLER_PARAM=1
ADD build/libs/pokemon-convert-0.0.1-SNAPSHOT.jar /deployments/
EXPOSE 8081