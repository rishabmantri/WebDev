FROM ubuntu:latest
RUN apt-get -y update && apt-get -y upgrade
RUN apt-get -y install openjdk-8-jdk wget
RUN mkdir /usr/local/tomcat
RUN wget http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.30/bin/apache-tomcat-8.0.30.tar.gz -O /tmp/tomcat.tar.gz
RUN cd /tmp &&  tar -xzvf tomcat.tar.gz
RUN cp -Rv /tmp/apache-tomcat-8.0.30/* /usr/local/tomcat
COPY RestExampleAPI.war /usr/local/tomcat/webapps
RUN cp -R /usr/local/tomcat/ /usr/local/tomcat18081
COPY server.xml /usr/local/tomcat18081/conf/server.xml
RUN wget https://archive.apache.org/dist/activemq/5.14.3/apache-activemq-5.14.3-bin.tar.gz
RUN tar zxf apache-activemq-5.14.3-bin.tar.gz
COPY Consumer.jar /home/Consumer.jar
COPY lab4.sh lab4.sh
RUN chmod +x lab4.sh
EXPOSE 8080
EXPOSE 8081
EXPOSE 61616
ENTRYPOINT ["bash","lab4.sh"]