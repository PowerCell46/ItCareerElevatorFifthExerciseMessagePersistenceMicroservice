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
            -- Last message per other user for the given current user
            SELECT DISTINCT ON (other_user_id) -- one row per other_user_id
                   m.sender_id,
                   m.receiver_id,
                   m.content,
                   m.created_at
            FROM (
                -- Messages sent by current user (other_user_id = receiver)
                SELECT  m.*,
                        m.receiver_id AS other_user_id
                FROM    messages m
                WHERE   m.sender_id = :currentUserId

                UNION ALL -- keep all in/out messages [web:102][web:110]
                
                -- Messages received by current user (other_user_id = sender)
                SELECT  m.*,
                        m.sender_id AS other_user_id
                FROM    messages m
                WHERE   m.receiver_id = :currentUserId
            ) AS m
            -- Order so DISTINCT ON keeps the latest message per other_user_id
            ORDER BY other_user_id, created_at DESC -- latest created_at wins in each group [web:97][web:99]
            """,
            nativeQuery = true
    )
    List<LastMessageProjection> findLastMessagesPerConversation(@Param("currentUserId") String currentUserId);
}
