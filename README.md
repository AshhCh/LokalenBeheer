# OOP2 Lokalen Beheer API (Spring Boot)

Deze applicatie is ontwikkeld voor het vak Object Oriented Programming 2 

---

## Wat doet deze applicatie?

De applicatie beheert de beschikbaarheid van lokalen en reserveringen binnen een onderwijsinstelling.

Functionaliteiten:
- Lokalen aanmaken, ophalen en verwijderen
- Beschikbare lokalen ophalen op basis van tijdslot
- Reserveringen aanmaken en annuleren
- Conflictcontrole: een lokaal kan niet dubbel geboekt worden in hetzelfde tijdslot
- Data opslaan in een H2 in-memory database

---

## Gebruikte technologieën

- Java 21
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
3. Run de main class met `@SpringBootApplication`
4. De applicatie draait op:
   http://localhost:8081

---

## H2 Database bekijken (UI)

Open in je browser:
http://localhost:8081/h2-console

Gebruik de volgende gegevens:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: leeg

Tabellen:
- `CLASS_ROOM`
- `STUDENT`
- `RESERVATION`

---

## Architectuur overzicht

De applicatie volgt een gelaagde architectuur:
- **Controller** ontvangt HTTP requests en stuurt responses terug
- **Service** bevat business logica en regels
- **Repository** verzorgt database communicatie

Elke service heeft één verantwoordelijkheid (Single Responsibility Principle):
- `ClassRoomService` beheert lokalen
- `ReservationService` beheert reserveringen
- `StudentService` beheert studenten

Controllers zijn afhankelijk van interfaces (`IClassRoomService`, `IReservationService`) in plaats van concrete implementaties — dit volgt het Dependency Inversion principe (SOLID).

---

## API Overzicht

### Lokalen API

**Lokaal aanmaken**
```bash
curl -X POST http://localhost:8081/api/classrooms \
  -H "Content-Type: application/json" \
  -d '{
    "roomNumber": "A101",
    "type": "Lecture Hall",
    "size": 50,
    "available": true
  }'
```

**Alle lokalen ophalen**
```bash
curl http://localhost:8081/api/classrooms
```

**Lokaal ophalen op ID**
```bash
curl http://localhost:8081/api/classrooms/1
```

**Beschikbare lokalen ophalen op tijdslot**
```bash
curl "http://localhost:8081/api/classrooms/available?start=2026-05-01T09:00:00&end=2026-05-01T11:00:00"
```

**Lokaal verwijderen**
```bash
curl -X DELETE http://localhost:8081/api/classrooms/1
```

---

### Reserveringen API

**Reservering aanmaken**
```bash
curl -X POST http://localhost:8081/v1/reservations \
  -H "Content-Type: application/json" \
  -d '{
    "studentId": 1,
    "classRoomId": 1,
    "startTime": "2026-05-01T09:00:00",
    "endTime": "2026-05-01T11:00:00"
  }'
```

**Alle reserveringen ophalen**
```bash
curl http://localhost:8081/v1/reservations
```

**Reservering ophalen op ID**
```bash
curl http://localhost:8081/v1/reservations/1
```

**Reserveringen ophalen per student**
```bash
curl http://localhost:8081/v1/reservations/student/1
```

**Reserveringen ophalen per lokaal**
```bash
curl http://localhost:8081/v1/reservations/classroom/1
```

**Reservering annuleren**
```bash
curl -X PATCH http://localhost:8081/v1/reservations/1/cancel
```
