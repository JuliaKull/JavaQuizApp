-- liquibase formatted sql
-- changeset kull:liqubase run insert data into table question

insert into questions
    values (1,'Core','Easy','What is the size of float variable?','8 bit','16 bit','32 bit'),
     (2,'Core','Easy','Can constructor return a value?','Yes','No','Sometimes'),
     (3,'Core','Easy','Which data type is used to create a variable that store text?','String','txt','MyString'),
     (4,'Core','Medium','Which method can be used to find the length of a string?','len()','length()','getLength()'),
     (5,'Core','Medium','Array indexes start with:','2','1','0'),
     (6,'Core','Medium','Which method can find the highest value of x and y?','Math.max(x,y)','Math.largest(x,y)','Math.maxNum(x,y)'),
     (7,'Spring','Easy','Spring is a..','Web Framwork','Java Framework','MVC Framework'),
     (8,'Spring','Easy','Which of the following is used by Maven?','pom.xml','config.xml','META-INF'),
     (9,'Spring','Easy','Hibernate is a..','Query Executer','ORM framework','Database connectivity Tool'),
     (10,'Spring','Medium','Which of the annotation is not a Spring boot annotation?','@Controller','@Service','@Data'),
     (11,'Spring','Medium','What is the Annotation used to handle GET request?','@Getmapping','@PostMapping','@GetMapping');