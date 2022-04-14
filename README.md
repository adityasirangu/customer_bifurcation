# customer_bifurcation
This  ia an Customer management application developed using spring boot,Thymeleaf ,MySQL database and redis.
First of all,I have create an CustomerInfo Form and collect their info store in Mysql database. 
before storing to the database check whether the customer already exists, if exists redirect invalid entry.
Then i have created an Scheduler module which runs once a day at mid night and bifurcate the  customerinfo  data into differrnt groups based on the criteria we set.
In this case, I have created 3 Criteria conditions to segregate into 3 different groups.
Criteria -1 : It bifurcates the Customer's on place of living (Mumbai) and stores the Customerinfo in group-1 database.
Criteria -2 : It bifurcates the Customer's on place of living (bangalore)& gender(male) and stores the Customerinfo in group-2 database.
Criteria -3 : It bifurcates the Customer's on place of living (bangalore)& gender(female)  and stores the Customerinfo in group-3 database.
I have also cretae an Admin login page ,in which Authorized people can login and can monitor the respective  bifurcated groups.

