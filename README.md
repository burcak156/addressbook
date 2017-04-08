# addressbook

In this project, we will see integrate JSF, Spring and Hibernate in a simple web application.

## Getting Started

Multilayer Applications can be developed by using more than one frameworks such as JSF (Web Layer), 
Spring (Service and Business Layer) and Hibernate (Persistence Layer). 
### Why JSF ?
* JSF is a component-oriented, event-based framework.
* JSF Framework may be suitable for building rich web user interfaces with component-based UI support.
### Why Spring ?
* Spring provides about 20 modules which can be used based on an application requirement.
* Dependency Injection
* Spring enables developers to develop enterprise-class applications using POJOs.
* Spring can be used as middle tier for building server-side business logic.  The data support framework of Spring provides extensive utilities to integrate Hibernate.
### Why Hibernate ?
* Annotation support is the best feature for me.
* You already know the rest :)
### Why PrimeFaces ?
* I think best option for JSF-Spring Applications.
* Easy to integrate
* Ajax
* Made by Turkish Developers. :)


The easiest way is to use SpringBeanFacesELResolver class which allows to inject dependencies into JSF-Managed beans.

To use the class, define `SpringBeanFacesELResolver` in `faces-config.xml` as given below.
```
<faces-config>
  <application>
    <el-resolver>org.springframework.web.jsf.el.SpringBeanFacesELResolver</el-resolver>
    ...
  </application>
</faces-config>
```

## Prerequisites

### Technologies used
* JSF 2.2.14
* PrimeFaces 6.0
* Spring 4.1.5
* Hibernate 4.3.8
* PostgreSQL 9.6.2 - (https://www.postgresql.org/download/)
* Maven 3
* Eclipse 4.6.3 - (http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/neon3)
* JDK 1.8 - (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Tomcat 8.0 - (https://tomcat.apache.org/download-80.cgi)

### Database configuration 

Create a PostgreSQL database with the name `addressbook` and add the credentials to `/resources/application.properties`.  

The default ones are :
```
#Database related properties
database.driver=org.postgresql.Driver
database.url=jdbc:postgresql://localhost:5432/addressbook
database.user=postgres
database.password=
#Hibernate related properties
hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
hibernate.show_sql=true
hibernate.hbm2ddl.auto=update
hibernate.format_sql=true
hibernate.jdbc.batch_size=20
```

### Installing

1) In the command line
```
git clone https://github.com/burcak156/addressbook.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
```
