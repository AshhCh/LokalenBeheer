# OOP2 Student Management API (Spring Boot)

Deze applicatie is ontwikkeld voor het vak Object Oriented Programming 2 en dient als praktisch leerproject om moderne backend architectuur, Spring Boot en SOLID principes te begrijpen.

Studenten kunnen dit document voor de les gebruiken om:
- te begrijpen wat de applicatie doet
- het project lokaal te starten
- alle APIs te testen met curl
- de architectuur en flow te snappen

---

## Wat doet deze applicatie?

De applicatie beheert:
- Studenten
- Cijfers (GradeRecords) die gekoppeld zijn aan studenten

Functionaliteiten:
- Studenten aanmaken, ophalen, bijwerken en verwijderen
- Cijfers toevoegen aan een student
- Cijfers ophalen (globaal of per student)
- Cijfers verwijderen
- Data opslaan in een H2 in memory database

---

## Gebruikte technologieën

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Gradle

---

## Applicatie starten

### Vereisten
- Java 21 
- Gradle
- IDE zoals IntelliJ IDEA

### Starten
1. Clone of download het project
2. Open het project in IntelliJ
3. Run de main class met @SpringBootApplication
4. De applicatie draait op:
   http://localhost:8080

---

## H2 Database bekijken (UI)

Open in je browser:
http://localhost:8080/h2-console

Gebruik de volgende gegevens:
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: leeg

Hier kun je tabellen bekijken zoals:
- STUDENT
- GRADE_RECORD

---

## Architectuur overzicht

De applicatie volgt een gelaagde architectuur:
- Controller ontvangt HTTP requests en stuurt responses terug
- Service bevat business logica en regels
- Repository verzorgt database communicatie

Elke service heeft één verantwoordelijkheid:
- StudentService beheert studenten
- GradeRecordService beheert cijfers

---

## API Overzicht

### Studenten API

Student aanmaken
```bash
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
  }'
