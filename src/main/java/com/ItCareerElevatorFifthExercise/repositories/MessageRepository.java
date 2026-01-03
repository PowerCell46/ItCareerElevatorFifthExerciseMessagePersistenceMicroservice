package com.ItCareerElevatorFifthExercise.repositories;

import com.ItCareerElevatorFifthExercise.entitities.Message;
import com.ItCareerElevatorFifthExercise.repositories.interfaces.LastMessageProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = """
            SELECT DISTINCT ON (other_user_id)
                   m.sender_id,
                   m.receiver_id,
                   m.content,
                   m.created_at
            FROM (
                SELECT  m.*,
                        m.receiver_id AS other_user_id
                FROM    messages m
                WHERE   m.sender_id = :currentUserId

                UNION ALL

                SELECT  m.*,
                        m.sender_id AS other_user_id
                FROM    messages m
                WHERE   m.receiver_id = :currentUserId
            ) AS m
            ORDER BY other_user_id, created_at DESC
            """,
            nativeQuery = true
    )
    List<LastMessageProjection> findLastMessagesPerConversation(@Param("currentUserId") String currentUserId);
}
