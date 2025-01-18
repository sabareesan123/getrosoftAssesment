# getrosoftAssesment
software required to run this app
JDK 21
Mongo db latest
Maven 

in the app root folder
run
mvn clean install
java -jar target/tracking-number-generator-0.0.1-SNAPSHOT.jar

ElasticBeanStalk or EKS can be used for scalability
Since MongoDB is used as DB it provides fast response time and horizontal scaling.
optimistic or pessimistic locks can be used for concurrency

