FROM jboss/wildfly:18.0.1.Final

MAINTAINER "infoShare Dream Team e-korepetycje"

EXPOSE 8080/tcp

ADD /target/webapp.war wildfly/standalone/deployments/

ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
USER root
RUN chmod +x /wait

CMD /wait && /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0
