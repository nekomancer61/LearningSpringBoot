use LibraryManagementSystem;
-- 2. Insert records into the db
insert into Authors (ID,name) values 
(1, "Martin Luthor King"),(2, "Andersen"),(3, "Victor Hugo"),(4,"The Author"),(5, "Another Author");
insert into Categories (ID, name) values
(1,"Psychological Horor"),(2,"Literature"),(3,"IT"),(4,"Languages"),(5,"Magazines");
insert into Classes (ID, name) values
(1,"1"), (2,"2"), (3,"3"), (4,"4"), (5,"5");
insert into Publishers (ID, name) values
(1,"Kim Dong"), (2,"NXB Tre"), (3, "BCTT"), (4,"4wrd"), (5,"FIF");
insert into Majors (ID, name) values
(1,"IT"), (2,"Economic"), (3,"Psychology"), (4,"Doktor"), (5,"Management");
insert into Students (ID, FirstName, LastName, MajorId, PhoneNumber,Email, StudentIdExpireDate,ClassId) values
(1,"A","A",1,"11111111111","11111@11111.1111",'2025-11-11 11:11',1),
(2,"B","B",2,"22222222222","22222@22222.2222",'2022-02-02 22:22',2),
(3,"C","C",3,"33333333333","33333@33333.3333",'2023-03-03 03:03',3),
(4,"D","D",4,"44444444444","44444@44444.4444",'2024-04-04 04:04',4),
(5,"E","E",5,"55555555555","55555@55555.5555",'2025-05-05 05:05',5);