Task 1 

To create a jar file just navigate to the folder with pom.xml then enter the command 

mvn package

jar file named gs-spring-boot-0.1.0.jar will be created in target folder
run the jar file on terminal using this command

java -jar gs-spring-boot-0.1.0.jar

these are the endpoints for task 1.

http://localhost:8080/ftocservice/
http://localhost:8080/ftocservice/120?precision=5
http://localhost:8080/ftocservice/120
http://localhost:8080/ctofservice/
http://localhost:8080/ctofservice/120?precision=3
http://localhost:8080/ctofservice/120

by default precision is 2.
negative precision will return a badrequest and would not show any thing.

Task 2.

the task2 folder already has a jar file. You can also use the jar file created in the task 1. To use the jar file created in the first task the copy and paste that file in task2 folder.

now run the build image commmand


docker build -t imagename .;

to run the image

docker run -i -p 8080:8080 imagename:latest

the endpoints are same as they are in task1.