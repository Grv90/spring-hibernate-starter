# Spring-hibernate-starter

#### Maven Starter project with Spring and hibernate and mysql
Just clone the project and start marking db changes in config/application.properties files.

Steps :   

1. Clone https://github.com/Grv90/spring-hibernate-starter.git
2. go the project directory and run  
    mvn clean install
3. to run migration script (resource/db/changelog/db.changelog-master.xml is file contain all the migration scripts, a newly created script has to be present in this file.)    
    java -jar -Druntype=migration target/filename.jar
4. to run the project 
    java -jar target/filename.jar 

all set and you good to go..
    
