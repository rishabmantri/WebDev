for task 2

I have commented the part with the database connectivity. If you want to run the code using db you can uncomment the code in Booktownservicefactory line 24 and then build the project.

Please change the required settings in build.properties file.

deploy the war file created

build a jar from consumer folder
add dependencies activemq and jms

run the jar file 
(I have aready created a consumer.jar file if you want to use that)

to run task 3

go to the folder task 3
build the docker file image.

docker build -t imagename .
docker run -i -p 8080:8080 imagename:latest