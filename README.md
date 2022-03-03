###It is my Pet project - Student accounting. 
####Here I Use Spring boot, mysql in docker container.

Start docker container use yml file in /docker/docker-compose.yml

Connect to database use this 
```url jdbc:mysql://localhost:3308/testdb```
```
Database credentials: 
login: root
password: sq
```

Run db_migration in Intellij, add to maven configuration command - ```clean flyway:migrate -Dflyway.configFiles=flywayConfig.conf```

