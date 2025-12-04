use LibraryManagementSystem;
-- Delete all old record


Delete from Books;
Delete from BorrowDetails;
Delete from BorrowTickets;
Delete from Authors;
Delete from Categories;
Delete from Students;
Delete from Classes;
Delete from Publishers;
Delete from Majors;
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
(1,"A","A",1,"1111111111","11111@11111.1111",'2025-11-11',1),
(2,"B","B",2,"2222222222","22222@22222.2222",'2022-02-02',2),
(3,"C","C",3,"3333333333","33333@33333.3333",'2023-03-03',3),
(4,"D","D",4,"4444444444","44444@44444.4444",'2024-04-04',4),
(5,"E","E",5,"5555555555","55555@55555.5555",'2025-05-05',5);
insert into Books (ID, Title, PublisherId, AuthorId, NumberOfPages, NumberOfCopies, Price, ImportDate, ShelfRow, ShelfColumn, CategoryId) values
(1,"SQL",1,1,11,11,11,'2011-11-11',1,1,1),
(2,"B2",2,2,22,22,22,'2022-02-02',2,2,2),
(3,"B3",3,3,33,33,33,'2023-03-03',3,3,3),
(4,"B4",4,4,44,44,44,'2024-04-04',4,4,4),
(5,"B5",5,5,55,55,55,'2025-05-05',5,5,5)
;
insert into BorrowTickets (ID, StudentId, BorrowDate) values
(1,1,'2021-01-01'),
(2,2,'2022-02-02'),
(3,3,'2023-03-03'),
(4,4,'2024-04-04'),
(5,5,'2025-05-05');
insert into BorrowDetails (BorrowTicketId, BookId, note) values
(1,1,"first borrowing"),
(2,2,"second borrowing"),
(3,3,"3RD impact"),
(4,4,"4WRD"),
(5,5,"Faiz");
insert into BorrowDetails (BorrowTicketId, BookId, note) values
(5,1,"first borrowing");


-- Queries time baby
-- 1. Liệt kê tất cả thông tin của các đầu sách gồm tên sách, mã sách, giá tiền , tác giả
-- thuộc loại sách có mã “IT”

Select Books.ID as BookID, Books.Title as Title, Books.Price as Price, Authors.name as Author from Books inner join Categories on Books.CategoryId = Categories.ID
inner join Authors on Books.AuthorId = Authors.ID
where Categories.Name = 'IT';

-- 2. Liệt kê các phiếu mượn gồm các thông tin mã phiếu mượn, mã sách , ngày mượn,
-- mã sinh viên có ngày mượn trong tháng 02/2022.

Select BorrowTickets.ID, BorrowDetails.BookId, BorrowTickets.BorrowDate from BorrowDetails 
inner join BorrowTickets on BorrowDetails.BorrowTicketId = BorrowTickets.ID
where BorrowTickets.BorrowDate >= '2022-02-01' and BorrowTickets.BorrowDate <='2022-02-29';

-- 3. Liệt kê các phiếu mượn chưa trả sách cho thư viên theo thứ tự tăng dần của ngày
-- mượn sách.

Select * from BorrowTickets order by BorrowTickets.BorrowDate asc;

-- 4. Liệt kê tổng số đầu sách của mỗi loại sách ( gồm mã loại sách, tên loại sách, tổng số
-- lượng sách mỗi loại).

Select Categories.ID, Categories.name , count(*) from Categories inner join Books on Books.CategoryId = Categories.ID
group by Books.CategoryId;

-- 5. Đếm xem có bao nhiêu lượt sinh viên đã mượn sách. 6.6 Hiển thị tất cả các quyển
-- sách có tiêu đề chứa từ khoá “SQL”.

Select count(*) from BorrowTickets group by BorrowTickets.StudentId ;

Select * from Books where Books.Title like '%SQL%';

-- 6. Liệt kê các đầu sách có lượt mượn lớn hơn 20 lần

Select *, count(*)  from BorrowDetails inner join Books on Books.ID = BorrowDetails.BookId group by BorrowDetails.BookId having count(*) > 20;

-- 7. Viết câu lệnh cập nhật lại giá tiền của các quyển sách có ngày nhập kho trước năm
-- 2014 giảm 30%.

Update Books set Books.Price = Books.Price * 70 / 100 where Books.ImportDate < '2014-01-01';

