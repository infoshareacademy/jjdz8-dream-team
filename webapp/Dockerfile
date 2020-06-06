FROM jboss/wildfly

MAINTAINER "infoShare Dream Team e-korepetycje"

RUN wildfly/bin/add-user.sh admin admin --silent

ADD /target/webapp.war wildfly/standalone/deployments/



CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]