//Talks directly to the database; It handles saving, finding and deleting data
// database assistant
package com.example.oop2.repositories;

import com.example.oop2.entities.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository; //this makes sure you dont have to write the code yourself
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    
}

