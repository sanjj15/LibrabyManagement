Library Management System built using Java Servlets and JDBC with Oracle Database.
The application allows users to add new books and view all available books.
Database operations are performed using JDBC connectivity with Oracle XE.
The project is deployed on Apache Tomcat and demonstrates basic CRUD (Create & Read) functionality.

DATABASE QUERY
CREATE TABLE Author_tbl (
    Author_code NUMBER(5) PRIMARY KEY,
    Author_name  VARCHAR2(20) NOT NULL,
    Contact_number NUMBER(10)
);

INSERT ALL
    INTO Author_tbl VALUES (1,'RobinSharma',987698534)
    INTO Author_tbl VALUES (2,'R.K.Narayanan',9789562391)
    INTO Author_tbl VALUES (3,'Paulo coelhea',9689753761)
SELECT * FROM dual;

CREATE TABLE Book_tbl (
    ISBN VARCHAR2(20) PRIMARY KEY,
    Book_title VARCHAR2(50) NOT NULL,
    Book_type CHAR(1) CHECK (Book_type IN ('G','T')),
    Author_code NUMBER(5) NOT NULL,
    Book_cost NUMBER(8,2) NOT NULL,
    CONSTRAINT fk_author FOREIGN KEY (Author_code) 
        REFERENCES Author_tbl(Author_code)
);


<img width="646" height="259" alt="image" src="https://github.com/user-attachments/assets/faba23ec-b25a-4400-b46e-1d3ffa93de0b" />

<img width="725" height="401" alt="image" src="https://github.com/user-attachments/assets/972c9ab6-bc9d-40fb-bdf9-711fbb3cee08" />

<img width="677" height="325" alt="image" src="https://github.com/user-attachments/assets/02fbc770-3239-4a98-b291-2811975acffd" />

<img width="732" height="363" alt="image" src="https://github.com/user-attachments/assets/214b8179-21e0-45bb-bf39-260feda71f18" />


