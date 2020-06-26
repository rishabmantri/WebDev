#!/bin/bash
set -m

/usr/local/tomcat/bin/catalina.sh start &

/usr/local/tomcat18081/bin/catalina.sh start &

/apache-activemq-5.14.3/bin/activemq start &

java -jar /home/Consumer.jar