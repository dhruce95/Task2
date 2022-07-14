# Task2
Centime Task2
Create 
Db Connection: 
Host a database in local or aws (postgres or mysql or inmemory db(H2)).
Configure your microservice to connect to db.
Create Hibernate Entity Class  based on the below table requirement to auto create tables in hosted db.
Populate the db from a post request with the below data or directly insert into db.

Expose endpoints to fetch requests based on Id and complete list of objects.
While getting the complete table, Modify the result set(arrays or list) to form nested object structure.
Below is the nested output in json.Associate color to each object according to table.

Create a table with fields ID, Name, Color, ParentId and populate with below data.
Don't use ORM to map or form parent child relationships. Write an algorithm to form the relationship after fetching the list from db, in an efficient way.


insert into alien (id,parentid,name,color) values (1,0,'Warrior','red');
insert into alien (id,parentid,name,color) values (2,0,'Wizard','green');
insert into alien (id,parentid,name,color) values (3,0,'Priest','white');
insert into alien (id,parentid,name,color) values (4,0,'Rogue','yellow');
insert into alien (id,parentid,name,color) values (5,1,'Fighter','blue');
insert into alien (id,parentid,name,color) values (6,1,'Paladin','lighblue');
insert into alien (id,parentid,name,color) values (7,1,'Ranger','lighgreen');
insert into alien (id,parentid,name,color) values (8,2,'Mage','grey');
insert into alien (id,parentid,name,color) values (9,2,'Specialist wizard','lightgrey');
insert into alien (id,parentid,name,color) values (10,3,'Cleric','red');
insert into alien (id,parentid,name,color) values (11,3,'Druid','green');
insert into alien (id,parentid,name,color) values (12,3,'Priest of specific mythos','white');
insert into alien (id,parentid,name,color) values (13,4,'Thief','yellow');
insert into alien (id,parentid,name,color) values (14,4,'Bard','blue');
insert into alien (id,parentid,name,color) values (15,13,'Assassin','lighblue');



Nested Json response. Ignore Dangling Branches Scenario.

[
  {
    "Name": "Wizard",
    "Sub Classes": [
      {
        "Name": "Mage"
      },
      {
        "Name": "Specialist wizard"
      }
    ]
  },
  {
    "Name": "Priest",
    "Sub Classes": [
      {
        "Name": "Cleric"
      },
      {
        "Name": "Druid"
      },
      {
        "Name": "Priest of specific mythos"
      }
    ]
  },
  {
    "Name": "Warrior",
    "Sub Classes": [
      {
        "Name": "Fighter"
      },
      {
        "Name": "Paladin"
      },
      {
        "Name": "Ranger"
      }
    ]
  },
  {
    "Name": "Rogue",
    "Sub Classes": [
      {
        "Name": "Thief",
        "Sub Classes": [
          {
            "Name": "Assassin"
          }
        ]
      },
      {
        "Name": "Bard"
      }
    ]
  }
]

    
Create a method level Annotation @LogMethodParam which logs parameters passed to method.
