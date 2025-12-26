package com.ItCareerElevatorFifthExercise.repositories;

import com.ItCareerElevatorFifthExercise.entitities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
