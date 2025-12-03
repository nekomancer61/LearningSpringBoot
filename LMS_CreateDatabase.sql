create database if not exists LibraryManagementSystem;

Use LibraryManagementSystem;

drop table if exists Books;
drop table if exists Publishers;
drop table if exists Authors;

drop table if exists Categories;
drop table if exists Students;
drop table if exists Classes;
drop table if exists Majors;

drop table if exists BorrowTickets;
drop table if exists BorrowDetails;

create table Publishers (
	ID int not null,
    name varchar(50) not null,
    primary key (ID)
);

create table Authors (
	ID int not null,
    name varchar(50) not null,
    primary key (ID) 
);

create table Categories (
	ID int not null,
    name varchar(50) not null,
    primary key (ID)
);

create table Classes (
	ID int not null,
    name varchar(50) not null,
    primary key (ID)
);

create table Majors (
	ID int not null,
    name varchar(50) not null,
    primary key (ID)
);

create table Books (
	ID int not null,
    Title varchar(50) not null,
    PublisherId int,
	AuthorId int not null,
    NumberOfPages int not null,
    NumberOfCopies int not null,
    Price decimal not null,
    ImportDate date not null,
    ShelfRow int default null,
	ShelfColumn int default null,
    CategoryId int not null,
    primary key (ID),
    foreign key (PublisherId) references Publishers (ID) on delete cascade,
    foreign key (AuthorId) references Authors (ID) on delete cascade,
    foreign key (CategoryId) references Categories (ID) on delete cascade,
    constraint CHK_NumberOfPages check (NumberOfPages > 5),
    constraint CHK_NumberOfCopies check (NumberOfCopies > 1),
    constraint CHK_Price check (Price>0)
);

create table Students (
	ID varchar(50) not null,
    FirstName varchar(50) not null,
    LastName varchar(50) not null,
    MajorId int not null,
    PhoneNumber varchar(10) not null,
    Email varchar(50) not null,
    StudentIdExprireDate date default null,
    ClassId int not null,
    primary key (ID),
    foreign key (MajorId) references Majors (ID) on delete cascade,
    foreign key (ClassId) references Classes (ID) on delete cascade
);

create table BorrowTickets (
	ID int not null,
    StudentId varchar(50) not null,
    BorrowDate date default null,
	primary key (ID),
    foreign key (StudentId) references Students (ID)
);

create table BorrowDetail (
	BorrowTicketId int,
    BookId int,
    note varchar(70),
    foreign key (BorrowTicketId) references BorrowTickets (ID),
    
    primary key (BorrowTicketId, BookId),
    foreign key (BookId) references Books (ID)
	
);

