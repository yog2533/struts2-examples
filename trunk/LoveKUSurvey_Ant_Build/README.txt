LoveKUSurvey Setup Instructions

---Create Project Documentation---
Create the project's documentation by running
mvn site.  Then open refresh (F5) the target folder 
and open /target/site/index.html in a web browser.

The Spring configuration file is applicationContext.xml, 
found in src/main/resources.

---Test The Application---
To run the various test cases (see src/test/java) run mvn test.

---Add Maven Ant Tasks Jar to Ant---
In MyEclipse ensure you have previously added the maven-ant-tasks 
jar file to MyEclipse's version of Ant.  If you have not 
previously done that follow these steps:

1. Download the maven-ant-tasks jar file at 
http://maven.apache.org/ant-tasks/download.html 
   a.  As of Jan 2010 the current version is 2.1.0
2. Add the maven-ant-tasks jar file to Ant’s external jar's list
   a. In MyEclipse go to Window - Preferences – Ant – Runtime
   b. Click on Global Entries
   c. Click on the Add External Jars button
   d. Navigate to where you downloaded the maven-ant-tasks jar and select it
3. Click the OK button

Note if you use Ant from the command line you need to copy 
the maven-ant-tasks jar to the lib folder that is a sub-directory
of the Ant folder for the Ant version being used from the command line

---Build The Application---
Use the ant war target to create the war file.


---Deploy The Application---
Use the ant tomcat-war target to create the war file and copy it to your 
Tomcat webapps folder.  (Be sure to update the tomcat.home
property in build.xml to the location of Tomcat on your computer).

---Run The Application---
After deploying the application and starting your Tomcat server go to 
http://localhost:8080/LoveKUSurvey/index.html in your browser.

