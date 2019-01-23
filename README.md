HelloWorld for App Engine Standard (Java 8)
This sample demonstrates how to deploy an application on Google App Engine.

See the Google App Engine standard environment documentation for more detailed instructions.

Java 8
Maven (at least 3.5)
Gradle (optional)
Google Cloud SDK (aka gcloud)
Setup
• Download and initialize the Cloud SDK

gcloud init
Create an App Engine app within the current Google Cloud Project

gcloud app create

Maven
Running locally
mvn appengine:run
To use vist: http://localhost:8080/

Deploying
mvn appengine:deploy
To use vist: https://YOUR-PROJECT-ID.appspot.com

Gradle
Running locally
gradle appengineRun
If you do not have gradle installed, you can run using ./gradlew appengineRun.

To use vist: http://localhost:8080/

Deploying
gradle appengineDeploy
If you do not have gradle installed, you can deploy using ./gradlew appengineDeploy.

To use vist: https://YOUR-PROJECT-ID.appspot.com

Testing
mvn verify
or

gradle test
As you add / modify the source code (src/main/java/...) it's very useful to add unit testing to (src/main/test/...). The following resources are quite useful:

Junit4
Mockito
Truth