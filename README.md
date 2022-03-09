### It is my Pet project - Student accounting. 
#### Here I Use Spring boot, mysql in docker container.

Start docker container use yml file in /docker/docker-compose.yml

Connect to database use this url
```jdbc:mysql://localhost:3308/testdb```
```
Database credentials: 
login: root
password: sq
```

Run db_migration in Intellij, add to maven configuration command - ```flyway:clean flyway:migrate -Dflyway.configFiles=flywayConfig.conf```

### Implemented features (list will be updated) 

 1. Load of one student data (with payout of grant by months) to XLS file. All data are taken from the database  ![изображение](https://user-images.githubusercontent.com/26259636/157422466-5b9e9496-1ee3-464e-a0bf-51d91ff97309.png)
 2. Load List Student data (with payout of grant by months) to XLS file. All data are taken from the database  ![изображение](https://user-images.githubusercontent.com/26259636/157422707-1050b276-b37a-4846-8a8f-0dbe61bfee32.png)



