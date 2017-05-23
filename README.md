# bookity
Bookity is a Java EE web service. It allows users to sign up, log in, and change their passwords. After registering, the user receives a welcoming email. On the homepage, all users can browse through books that have already been added to the database. Users who are logged in can also add new books (i.e. basic book info and a corresponding cover photo) to the database, all of which appears later on the homepage. If no photo is included, the book is assigned a default cover.

**Technologies used**: Java EE (JSP, JSTL, EL, JDBC), Bootstrap, HTML, CSS, JavaMail, MySQL, Spring JDBC, Apache Tomcat

## Prerequisites
- JDK7+
- Eclipse Java EE IDE
- Tomcat 7
- MySQL Server and a MySQL client (e.g. MySQL Workbench) 

## Table schema
Run [this SQL script](https://github.com/schroedingers-katze/bookity/blob/master/sql.txt) to create the database for the application. 


