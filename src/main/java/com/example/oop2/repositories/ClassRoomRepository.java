//Talks directly to the database; It handles saving, finding and deleting data
// database assistant
package com.example.oop2.repositories;

import com.example.oop2.entities.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository; //this makes sure you dont have to write the code yourself
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

// Returns all classrooms that are not booked in the time slot given (Id's that are not in findBookedClassRoomIds list)
    @Query("SELECT c FROM ClassRoom c WHERE c.id NOT IN :bookedIds")
    List<ClassRoom> findAvailableClassRooms(@Param("bookedIds") List<Long> bookedIds);

}

